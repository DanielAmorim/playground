package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.twoSum.twoSum
import java.util.stream.Stream

class TwoSumTests {

    companion object {
        @JvmStatic
        fun twoSumCases() = Stream.of(
            Arguments.of(intArrayOf(2,7,11,15), 9, Pair(0,1)),
            Arguments.of(intArrayOf(3,2,4), 6, Pair(1,2)),
            Arguments.of(intArrayOf(3,3), 6, Pair(0,1)),
        )
    }

    @ParameterizedTest
    @MethodSource("twoSumCases")
    fun `should return the positions in the array of values whose sum is equal to the target`(
        nums: IntArray,
        target: Int,
        expected: Pair<Int, Int>
    ) {
        // act
        val actual = twoSum(nums, target)

        // assert
        Assertions.assertThat(expected.first).isEqualTo(actual[0])
        Assertions.assertThat(expected.second).isEqualTo(actual[1])
    }
}