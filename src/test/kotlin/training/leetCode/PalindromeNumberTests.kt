package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.palindromeNumber.Solution
import java.util.stream.Stream

class PalindromeNumberTests {
    companion object {
        @JvmStatic
        fun longestPalindromeCases() = Stream.of(
            Arguments.of(121, true),
            Arguments.of(-121, false),
            Arguments.of(10, false),
        )
    }

    @ParameterizedTest
    @MethodSource("longestPalindromeCases")
    fun `should check if the  the longest palindromic substring in string`(input: Int, expected: Boolean) {
        // act
        val actual = Solution().isPalindrome(input)

        // assert
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}