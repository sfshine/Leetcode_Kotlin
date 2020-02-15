package binarytree

import java.util.*

class BinaryTreePreorderTraversal {

    /**
     * 前遍历方式:
     * 使用一个Stack储存临时任务,如果有两种类型:1打印 2访问
     *
     * 1.如果是打印命令,则直接把任务中的节点值打印之
     * 2.如果访问的节点还有子节点,则生成"访问任务"压栈,最后将自己节点生成"打印任务"压栈
     *
     * 从stack取出栈顶任务,进行上面的处理,直到stack为空为止
     */
    class Solution {
        private class Command(var op: Int, var node: TreeNode) {
            companion object {
                const val OP_PRINT = 1
                const val OP_TRAVERSAL = 2
            }
        }

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
