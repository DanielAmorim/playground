package training.leetCode.atoi

class Solution {
    fun myAtoi(s: String): Int {
        if (s.isEmpty()) return 0
        val result = StringBuilder()
        var idx = 0
        while (idx < s.length && s[idx] == ' ') {
            idx++
        }
        if (idx == s.length) return 0
        val signal = if (s[idx] == '-') {
            idx++
            -1
        } else if (s[idx] == '+') {
            idx++
            1
        } else 1
        while (idx < s.length && s[idx] == '0') {
            idx++
        }
        while (idx < s.length) {
            val code = s[idx].code
            if(code in 48..57) {
                result.append(code - 48)
            } else break
            idx++
        }

        return if(result.isEmpty()) 0 else {
            result.toString().let { str ->
                if(str.length < 10) {
                    result.toString().toInt() * signal
                } else if (signal == -1) {
                    val minValueStr = Int.MIN_VALUE.toString().substring(1)
                    if (minValueStr.length >= str.length && minValueStr > str) {
                        result.toString().toInt() * signal
                    } else Int.MIN_VALUE
                } else {
                    val maxValueStr = Int.MAX_VALUE.toString()
                    if (maxValueStr.length >= str.length && maxValueStr >= str) {
                        result.toString().toInt()
                    } else Int.MAX_VALUE
                }
            }
        }
    }
}