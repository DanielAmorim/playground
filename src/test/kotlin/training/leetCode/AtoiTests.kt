package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.atoi.Solution
import java.util.stream.Stream

class AtoiTests {

    companion object {
        @JvmStatic
        fun atoiCases() = Stream.of(
            Arguments.of("+", 0),
            Arguments.of("42", 42),
            Arguments.of(" -042", -42),
            Arguments.of("1337c0d3", 1337),
            Arguments.of("0-1", 0),
            Arguments.of("words and 987", 0),
            Arguments.of("-91283472332", Int.MIN_VALUE),
            Arguments.of("91283472332", Int.MAX_VALUE),
            Arguments.of("", 0),
            Arguments.of("21474836460", Int.MAX_VALUE),
            Arguments.of("  0000000000012345678", 12345678),
        )
    }

    @ParameterizedTest
    @MethodSource("atoiCases")
    fun `should convert a string to a 32-bit signed integer and return it`(input: String, expected: Int) {
        // act
        val actual = Solution().myAtoi(input)

        // assert
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}