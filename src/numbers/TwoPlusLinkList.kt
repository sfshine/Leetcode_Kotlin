package numbers

import java.lang.StringBuilder

fun main(args: Array<String>) {
    var l1 = createList(intArrayOf(1, 8))
    var l2 = createList(intArrayOf(9))

    printNodeList(l1)
    printNodeList(l2)

    printNodeList(Solution().addTwoNumbers(l1, l2))
}


class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummyHead = ListNode(0)
        var cur = dummyHead
        var carry = 0
        var curL1: ListNode? = l1
        var curL2: ListNode? = l2

        //1.遍历两个链表, 如果 > 10  就取10的余数, 并记录进位值
        while (curL1 != null || curL2 != null) {
            val x = if (curL1 == null) 0 else curL1.`val`
            val y = if (curL2 == null) 0 else curL2.`val`
            var sum = x + y + carry
            if (sum >= 10) {
                sum = sum % 10
                carry = 1
            } else {
                carry = 0
            }
            cur.next = ListNode(sum)
            cur = cur.next!!
            if (curL1 != null) curL1 = curL1.next
            if (curL2 != null) curL2 = curL2.next
        }
        if (carry > 0) {
            cur.next = ListNode(carry)
            cur = cur.next!!
        }
        return dummyHead.next
    }
}

//  Definition for singly-linked list.
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

/**
 * 创建List
 */
fun createList(array: IntArray): ListNode? {
    var head: ListNode? = null;
    lateinit var cur: ListNode
    for (i in array) {
        //head为null, 就创建一个node, 赋值给他
        if (head == null) {
            head = ListNode(i)
            cur = head
        }
        //head不是null,说明链表不是空, 就创建一个新节点, 添加到cur的next上, 然后cur往前移动
        else {
            cur.next = ListNode(i)
            cur = cur.next!!
        }
    }
    return head
}

/**
 * 打印链表
 */
fun printNodeList(list: ListNode?) {
    if (list == null)
        println("list  = null")
    else {
        var result = StringBuilder("printNodeList:")
        var cur: ListNode? = list
        while (cur != null) {
            result.append("${cur.`val`},")
            cur = cur.next
        }
        println(result)
    }
}
