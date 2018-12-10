package binarytree


class InvertBinaryTree {
    class Solution {
        fun invertTree(root: TreeNode?): TreeNode? {
            invertTreeInner(root)
            return root
        }
        private fun invertTreeInner(node: TreeNode?) {
            if (node == null) return
            invertTreeInner(node.left)
            invertTreeInner(node.right)
            var tmp = node.left
            node.left = node.right
            node.right = tmp
        }
    }
}