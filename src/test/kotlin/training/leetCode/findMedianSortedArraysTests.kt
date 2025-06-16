package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.findMedianSortedArrays.Solution
import java.util.stream.Stream

class findMedianSortedArraysTests {

    companion object {
        @JvmStatic
        fun findMedianSortedArrayCases() = Stream.of(
            Arguments.of(intArrayOf(1, 2), intArrayOf(3, 4), 2.50000),
            Arguments.of(intArrayOf(1, 3), intArrayOf(2), 2.00000),
            Arguments.of(intArrayOf(), intArrayOf(2, 4, 6, 8, 10), 6.0000),
            Arguments.of(intArrayOf(1, 3, 5, 7), intArrayOf(), 4.00000),
            Arguments.of(intArrayOf(1, 3, 5), intArrayOf(1, 3, 5), 3.00000),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), intArrayOf(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17), 9.00000),
        )
    }

    @ParameterizedTest
    @MethodSource("findMedianSortedArrayCases")
    fun `should return the median of the two sorted arrays`(nums1: IntArray, nums2: IntArray, expected: Double) {
        // act
        val actual = Solution().findMedianSortedArrays(nums1, nums2)

        // assert
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}