package binarytree

/**
 * 树的最大深度
 * 让孩子去计算,他的最大深度,退出节点是 节点为null
 */
fun maxDepth(root: TreeNode?): Int {
    return if (root == null) 0 else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
}
