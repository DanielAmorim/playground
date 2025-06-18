package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.longestPalindrome.Solution
import java.util.stream.Stream

class longestPalindromeTests {    companion object {
    @JvmStatic
    fun longestPalindromeCases() = Stream.of(
        Arguments.of("babad", "aba"),
        Arguments.of("cbbd", "bb"),
    )
}

    @ParameterizedTest
    @MethodSource("longestPalindromeCases")
    fun `should return the longest palindromic substring in string`(input: String, expected: String) {
        // act
        val actual = Solution().longestPalindrome(input)

        // assert
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}