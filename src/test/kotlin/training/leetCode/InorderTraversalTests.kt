package training.leetCode

import crosscutting.trees.fromCompactedListRepresentation
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.crosscutting.trees.TreeNode
import training.leetCode.inorderTraversal.Solution
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
        val treeNode = TreeNode.fromCompactedListRepresentation(input)

        // act
        val actual = Solution().inorderTraversal(treeNode)

        // assert
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}