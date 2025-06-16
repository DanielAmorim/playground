package training.leetCode.findMedianSortedArrays

class Solution {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.isEmpty()) {
            return if(nums2.size % 2 == 0) {
                (nums2[(nums2.size / 2) - 1] + nums2[nums2.size / 2]) / 2.0
            } else {
                nums2[nums2.size / 2].toDouble()
            }
        }

        if (nums2.isEmpty()) {
            return if(nums1.size % 2 == 0) {
                (nums1[(nums1.size / 2) - 1] + nums1[nums1.size / 2]) / 2.0
            }  else {
                nums1[nums1.size / 2].toDouble()
            }
        }

        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val totalLength = nums1.size + nums2.size
        var lowIndex = 0
        var highIndex = nums1.size

        while (lowIndex <= highIndex) {
            val partitionX = (lowIndex + highIndex) / 2
            val partitionY = (totalLength + 1) / 2 - partitionX

            val highestValueInLeftSideOfPartitionX = maxOf(nums1, partitionX)
            val lowestValueInRightSideOfPartitionX = minOf(nums1, partitionX)

            val highestValueInLeftSideOfPartitionY = maxOf(nums2, partitionY)
            val lowestValueInRightSideOfPartitionY = minOf(nums2, partitionY)

            if (highestValueInLeftSideOfPartitionX <= lowestValueInRightSideOfPartitionY &&
                highestValueInLeftSideOfPartitionY <= lowestValueInRightSideOfPartitionX)
            {
                return if(totalLength % 2 == 0)
                        (
                            maxOf(highestValueInLeftSideOfPartitionX, highestValueInLeftSideOfPartitionY) +
                            minOf(lowestValueInRightSideOfPartitionX, lowestValueInRightSideOfPartitionY)
                        ) / 2.0
                else maxOf(highestValueInLeftSideOfPartitionX, highestValueInLeftSideOfPartitionY).toDouble()
            }

            if (highestValueInLeftSideOfPartitionX > lowestValueInRightSideOfPartitionY) {
                highIndex = partitionX - 1
            } else {
                lowIndex = partitionX + 1
            }
        }

        return Double.NaN
    }

    private fun maxOf(nums: IntArray, partition: Int) =
        if (partition == 0) Int.MIN_VALUE else nums[partition - 1]

    private fun minOf(nums: IntArray, partition: Int) =
        if (partition == nums.size) Int.MAX_VALUE else nums[partition]
}