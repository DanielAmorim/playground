package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.lengthOfLongestSubstring.Solution
import java.util.stream.Stream

class lengthOfLongestSubstringTests {

    companion object {
        @JvmStatic
        fun lengthOfLongestSubstringCases() = Stream.of(
            Arguments.of("abcabcbb", 3),
            Arguments.of("bbbbb", 1),
            Arguments.of("pwwkew", 3),
            Arguments.of("", 0),
            Arguments.of("aab", 2),
            Arguments.of("abba", 2),
            Arguments.of("dvdf", 3),
            Arguments.of("uqinntq", 4),
        )
    }

    @ParameterizedTest
    @MethodSource("lengthOfLongestSubstringCases")
    fun `should return the longest substring length without repeating characters`(input: String, expectedLength: Int) {
        // act
        val actual = Solution().lengthOfLongestSubstring(input)

        // assert
        Assertions.assertThat(actual).isEqualTo(expectedLength)
    }
}