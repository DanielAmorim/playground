package crosscutting.trees

import training.leetCode.crosscutting.trees.TreeNode

fun TreeNode.Companion.fromCompactedListRepresentation(values: List<Int?>, start: Int = 0): TreeNode? {
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