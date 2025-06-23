package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.reverseInteger.Solution
import java.util.stream.Stream

class ReverseIntegerTests {

    companion object {
        @JvmStatic
        fun reverseIntegerCases() = Stream.of(
            Arguments.of(10, 1),
            Arguments.of(123, 321),
            Arguments.of(-123, -321),
            Arguments.of(120, 21),
            Arguments.of(1534236469, 0),
            Arguments.of(-2147483412, -2143847412),
            Arguments.of(Int.MIN_VALUE, 0),
        )
    }

    @ParameterizedTest
    @MethodSource("reverseIntegerCases")
    fun `Should reverse a signed 32-bit integer and return it`(input: Int, expected: Int) {
        // act
        val actual = Solution().reverse(input)

        // assert
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}