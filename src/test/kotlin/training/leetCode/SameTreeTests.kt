package training.leetCode

import crosscutting.trees.fromCompactedListRepresentation
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.crosscutting.trees.TreeNode
import training.leetCode.sameTree.Solution
import java.util.stream.Stream

class SameTreeTests {

    companion object {
        @JvmStatic
        fun sameTreeCases() = Stream.of(
            Arguments.of(listOf(1,2,3), listOf(1,2,3), true),
            Arguments.of(listOf(1,2), listOf(1,null,2), false),
            Arguments.of(listOf(1,2,1), listOf(1,1,3), false),
        )
    }

    @ParameterizedTest
    @MethodSource("sameTreeCases")
    fun `should compare two trees and return if it are equal`(list1: List<Int?>, list2: List<Int?>, expected: Boolean) {
        // arrange
        val treeNode1 = TreeNode.fromCompactedListRepresentation(list1)
        val treeNode2 = TreeNode.fromCompactedListRepresentation(list2)

        // act
        val actual = Solution().isSameTree(treeNode1, treeNode2)

        // assert
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}