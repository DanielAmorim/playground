package training.leetCode.symmetricTree

import training.leetCode.crosscutting.trees.TreeNode

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return false
        if(root.left == null && root.right == null) return true
        return if(root.left == null || root.right == null) false else isSymmetric(root.left!!,root.right!!)
    }

    private fun isSymmetric(t1: TreeNode, t2: TreeNode): Boolean {
        val x = if(t1.left == null && t2.right == null) true else
            if(t1.left != null && t2.right != null) isSymmetric(t1.left!!, t2.right!!) else false
        val y = if(t1.right == null && t2.left == null) true else
            if(t1.right != null && t2.left != null) isSymmetric(t1.right!!, t2.left!!) else false

        return x && y && t1.`val` == t2.`val`
    }
}