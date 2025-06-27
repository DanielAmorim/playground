package training.leetCode

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.inorderTraversal.Solution
import training.leetCode.inorderTraversal.TreeNode
import java.util.stream.Stream

class InorderTraversalTests {

    companion object {
        @JvmStatic
        fun inorderTraversalCases() = Stream.of(
            Arguments.of(listOf(1,2,3,4,5,null,8,null,null,6,7,9), listOf(4,2,6,5,7,1,3,9,8)),
            Arguments.of(listOf(1,null,2,3), listOf(1,3,2)),
            Arguments.of(emptyList<Int?>(), emptyList<Int>()),
            Arguments.of(listOf(1), listOf(1)),
        )
    }

    @ParameterizedTest
    @MethodSource("inorderTraversalCases")
    fun `Given the root of a binary tree return the inorder traversal of its nodes values`(input: List<Int?>, expected: List<Int>) {
        // arrange
        val treeNode = TreeNode.from(input)

        // act
        val actual = Solution().inorderTraversal(treeNode)

        // assert
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

fun TreeNode.Companion.from(values: List<Int?>, start: Int = 0): TreeNode? {
    if(values.isEmpty()) return null
    val root = TreeNode(values[start]!!)
    val nodes= ArrayDeque<TreeNode>()
    nodes.add(root)
    var index = start + 1
    while (index < values.size) {
        val currNode = nodes.removeFirst()
        if(values[index] != null) {
            currNode.left = TreeNode(values[index]!!)
            nodes.add(currNode.left!!)
        }
        index++
        if(index < values.size && values[index] != null) {
            currNode.right = TreeNode(values[index]!!)
            nodes.add(currNode.right!!)
        }
        index++
    }

    return root
}