package training.leetCode.twoSum

fun twoSum(nums: IntArray, target: Int): IntArray {
    val valuePositions = mutableMapOf<Int, Int>()
    for(idx in nums.indices) {
        val curr = nums[idx]
        if(valuePositions[target-curr] != null) {
            return intArrayOf(valuePositions[target-curr]!!, idx)
        }
        valuePositions[curr] = idx
    }
    throw IllegalArgumentException("Invalid array sequence")
}