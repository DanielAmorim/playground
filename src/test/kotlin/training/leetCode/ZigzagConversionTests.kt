package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.zigzagConversion.Solution
import java.util.stream.Stream

class ZigzagConversionTests {

    companion object {
        @JvmStatic
        fun zigzagConversionCases() = Stream.of(
            Arguments.of(3, "PAYPALISHIRING", "PAHNAPLSIIGYIR"),
            Arguments.of(1, "AB", "AB"),
            Arguments.of(4, "PAYPALISHIRING", "PINALSIGYAHRPI"),
            Arguments.of(1, "A", "A"),
            Arguments.of(5, "PAYPALISHIRING", "PHASIYIRPLIGAN"),
        )
    }

    @ParameterizedTest
    @MethodSource("zigzagConversionCases")
    fun `given a number of rows should return the input string written in zigzag pattern`(rows: Int, input: String, expected: String) {
        // act
        val actual = Solution().convert(input, rows)

        // assert
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}