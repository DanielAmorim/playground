package training.leetCode.lengthOfLongestSubstring

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0

        val chars = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var result = 0
        while (right < s.length) {
            val char = s[right]
            val charIdx = chars[char]
            chars[char] = right
            if (charIdx != null) {
                left = maxOf(left, charIdx)
                while (left != chars[s[left]]!!) {
                    left++
                }
            }
            result = maxOf(result, right - left +1)
            right++
        }

        return result
    }
}