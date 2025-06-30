package training.leetCode

import crosscutting.trees.fromCompactedListRepresentation
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import training.leetCode.crosscutting.trees.TreeNode
import training.leetCode.symmetricTree.Solution
import java.util.stream.Stream

class SymmetricTreeTests {

    companion object {
        @JvmStatic
        fun symmetricTreeCases() = Stream.of(
            Arguments.of(listOf(1,2,3), false),
            Arguments.of(listOf(1,2,2,3,4,4,3), true),
            Arguments.of(listOf(1,2,2,null,3,null,3), false),
        )
    }

    @ParameterizedTest
    @MethodSource("symmetricTreeCases")
    fun `Given the root of a binary tree should return if it is symmetric`(list1: List<Int?>, expected: Boolean) {
        // arrange
        val root = TreeNode.fromCompactedListRepresentation(list1)

        // act
        val actual = Solution().isSymmetric(root)

        // assert
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}