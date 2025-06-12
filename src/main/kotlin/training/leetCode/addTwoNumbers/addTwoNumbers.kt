package training.leetCode.addTwoNumbers

class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?) = addTwoNumbersRecursive(l1, l2)

    private fun addTwoNumbersRecursive(l1: ListNode?, l2: ListNode?, l3: ListNode? = null): ListNode? {
        if (l1 == null && l2 == null && l3 == null) {
            return null
        }

        val sum = sumListNodesValues(l1, l2, l3)
        return if (sum < 10) {
            ListNode(sum).apply { next = addTwoNumbersRecursive(l1?.next, l2?.next, null) }
        } else {
            ListNode(sum % 10).apply { next = addTwoNumbersRecursive(l1?.next, l2?.next, ListNode(1)) }
        }
    }

    private fun sumListNodesValues(l1: ListNode?, l2: ListNode?, l3: ListNode?): Int {
        val value1 = l1?.`val` ?: 0
        val value2 = l2?.`val` ?: 0
        val value3 = l3?.`val` ?: 0

        return value1 + value2 + value3
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}