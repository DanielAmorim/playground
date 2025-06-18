package training.leetCode.longestPalindrome

class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""

        var start = 0
        var end = 0

        for (i in s.indices) {
            val oddLength = expandOddFromMiddle(s, i)
            val evenLength = expandEvenFromMiddle(s, i)
            val highLength = maxOf(oddLength, evenLength)
            if(highLength > end - start) {
                start = i - ((highLength - 1) / 2)
                end = i + (highLength / 2)
            }
        }

        return s.substring(start, end + 1)
    }

    private fun expandOddFromMiddle(s: String, i: Int) = expandFromMiddle(s, i, i)

    private fun expandEvenFromMiddle(s: String, i: Int) = expandFromMiddle(s, i, i + 1)

    private fun expandFromMiddle(s: String, left: Int, right: Int): Int {
        if(left > right) return 0
        var leftBound = left
        var rightBound = right
        while (leftBound >= 0 && rightBound < s.length && s[leftBound] == s[rightBound]) {
            leftBound--
            rightBound++
        }

        return rightBound - leftBound - 1
    }
}