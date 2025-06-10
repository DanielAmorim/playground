package interviews

import interviews.longestSignAlternateSequence.longestSignAlternateSequenceFunctional
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LongestSignAlternateSequenceTests {

    companion object {
        @JvmStatic
        fun longestSignAlternateSequenceCases() = Stream.of(
            Arguments.of(intArrayOf(5, -1, 6), 3),
            Arguments.of(intArrayOf(3, 0, 4), 3),
            Arguments.of(intArrayOf(2, 1, 0, 3, 0, 0, 3), 5),
            Arguments.of(intArrayOf(5), 1),
            Arguments.of(intArrayOf(5, 4), 1),
            Arguments.of(intArrayOf(5, -1), 2),
            Arguments.of(intArrayOf(5, -2, -4), 2),
            Arguments.of(intArrayOf(5, 0, 6), 3),
            Arguments.of(intArrayOf(5, 4, -3, 2), 3),
            Arguments.of(intArrayOf(5, 4, -3, 2, 0, 1, -1, 0, 2, -3, 4, -5), 7),
            Arguments.of(intArrayOf(5, 4, -3, 2, 0, 1, 1, 0, 2, -3, 4, -5), 6),
            Arguments.of(intArrayOf(1, -1, 0, 0, -1, 1, -1, 1), 6),
            Arguments.of(intArrayOf(5, 4, -3, 2, 0, 0, -1, 0, 2, -3, 4, -5), 7),
            Arguments.of(intArrayOf(0, 0, 0, 0, 0, 0, 0), 7),
            Arguments.of(intArrayOf(4, 0, -1), 2)
        )
    }

    @ParameterizedTest
    @MethodSource("longestSignAlternateSequenceCases")
    fun `should return the longest sign alternate sequence in the integer array`(nums: IntArray, expected: Int) {
        // act
        val actual = longestSignAlternateSequenceFunctional(nums)

        // assert
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}