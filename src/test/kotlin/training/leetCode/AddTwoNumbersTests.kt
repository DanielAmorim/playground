package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.addTwoNumbers.ListNode
import training.leetCode.addTwoNumbers.Solution
import java.util.stream.Stream

class AddTwoNumbersTests {

    companion object {
        @JvmStatic
        fun addTwoNumbersCases() = Stream.of(
            Arguments.of(342, 465, 807),
            Arguments.of(0, 0 , 0),
            Arguments.of(9999999, 9999, 10009998),
        )
    }

    @ParameterizedTest
    @MethodSource("addTwoNumbersCases")
    fun `should return the sum of two numbers represented in ListNode's structures`(
        input1: UInt,
        input2: UInt,
        expected: UInt
    ) {
        // assert
        val l1 = input1.toListNode()
        val l2 = input2.toListNode()

        // act
        val actual = Solution().addTwoNumbers(l1, l2)

        // assert
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(expected).isEqualTo(actual!!.toUInt())
    }
}

private fun UInt.toListNode(): ListNode? = this.toString().let { it ->
    var node: ListNode? = null
    for (value in it) {
        node = ListNode(value.digitToInt()).apply { next = node }
    }
    node
}

private fun ListNode.toUInt(): UInt {
    if (this.next == null) {
        return this.`val`.toUInt()
    }

    var result = 0
    var multiplier = 1
    var node: ListNode? = this

    do  {
        result = result + node!!.`val` * multiplier
        multiplier *= 10
        node = node.next
    } while (node != null)

    return result.toUInt()
}