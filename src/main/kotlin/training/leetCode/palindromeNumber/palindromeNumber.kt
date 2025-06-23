package training.leetCode.palindromeNumber

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        if (x < 10) return true
        var result = 0
        var currentValue = x
        while (currentValue > 0) {
            result = result * 10 + currentValue % 10
            currentValue /= 10
        }
        return x == result
    }
}