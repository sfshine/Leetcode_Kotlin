package stack

import java.util.*

fun main(args: Array<String>) {

}

class MyQueue() {

    /** Initialize your data structure here. */
    val stack2 = Stack<Int>()
    val stack1 = Stack<Int>()

    fun push(node: Int) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop())
        }
        stack2.push(node)
        while (!stack1.empty()) {
            stack2.push(stack1.pop())
        }
    }
    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        return stack2.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        return stack2.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return stack2.isEmpty()
    }
}
