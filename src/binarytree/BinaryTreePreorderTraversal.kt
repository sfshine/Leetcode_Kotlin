package binarytree

import java.util.*

class BinaryTreePreorderTraversal {

    private class Command(var op: Int, var node: TreeNode) {
        companion object {
            const val OP_PRINT = 1
            const val OP_TRAVERSAL = 2
        }
    }

    class Solution {
        fun preorderTraversal(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            var result = mutableListOf<Int>()
            var commandStack = Stack<Command>()
            commandStack.push(Command(Command.OP_TRAVERSAL, root))
            while (!commandStack.isEmpty()) {
                var command = commandStack.pop()
                if (command.op == Command.OP_PRINT) {
                    result.add(command.node.`val`)
                } else if (command.op == Command.OP_TRAVERSAL) {
                    if (command.node.right != null) commandStack.push(Command(Command.OP_TRAVERSAL, command.node.right!!))
                    if (command.node.left != null) commandStack.push(Command(Command.OP_TRAVERSAL, command.node.left!!))
                    commandStack.push(Command(Command.OP_PRINT, command.node))
                }
            }
            return result
        }
    }
}