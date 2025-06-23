package training.leetCode.reverseInteger

class Solution {
    fun reverse(x: Int): Int {
        if (x == 0 || x * -1 == x) return 0
        if (x < 0) return -1 * reverse(x * -1)
        var currentValue = x
        var idx = 8
        var result = 0
        while (currentValue >= 10) {
            val reminder = currentValue % 10
            currentValue /= 10
            result += reminder * 10.pow(idx)
            idx--
        }
        return if (idx >= 0) {
            // remove right landing zeros
            result /= 10.pow(idx)
            // return the result plus the remainder of current value
            result + (currentValue % 10)
        } else if(Int.MAX_VALUE / 10 < result) {
            0
        } else {
            (result * 10) + currentValue
        }
    }

    private fun Int.pow(x: Int): Int {
        val base = this
        var exponent = x
        var result = 1

        while (exponent != 0) {
            result *= base
            --exponent
        }
        return result
    }
}