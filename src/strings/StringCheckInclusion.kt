package strings

/**
字符串的排列
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").


示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False

注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间

输入:
"hello"
"ooolleoooleh"

输出:
false

输入:
"abc"
"cccccbabbbaaaa"

输出:
true
 */


fun main(args: Array<String>) {
    println("checkInclusion: ${StringCheckInclusion().checkInclusion("ab", "eidbaooo")}")
    println("checkInclusion: ${StringCheckInclusion().checkInclusion("ab", "eidboaoo")}")
    println("checkInclusion: ${StringCheckInclusion().checkInclusion("hello", "ooolleoooleh")}")
    println("checkInclusion: ${StringCheckInclusion().checkInclusion("abc", "cccccbabbbaaaa")}")
    println("checkInclusion: ${StringCheckInclusion().checkInclusion("a", "ab")}")
    println("checkInclusion: ${StringCheckInclusion().checkInclusion("ab", "eidboaoo")}")
}

class StringCheckInclusion {
    /**
     * 1.统计s1中各字母的数量分布
     * 2.在s2中以s1的长度进行滑动
     * 3.考察s2中滑动的快是否和s1中统计的值相同
     */
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        var countS1 = IntArray(26)
        var countS2 = IntArray(26)

        for ((index, char) in s1.withIndex()) {
            countS1[char - 'a']++
            countS2[s2[index] - 'a']++
        }

        if (isSame(countS1, countS2)) {//以开始就符合,直接返回.
            return true
        } else {
            var i = 1
            var j = i + s1.length - 1
            while (j < s2.length) {
                countS2[s2[i - 1] - 'a']--//滑块往前滑动,最前面的字母不在滑块中了,需要-1
                countS2[s2[j] - 'a']++//滑块往前滑动,后面有新的字母加入滑块中,需要+1
                if (isSame(countS1, countS2)) {
                    return true
                }
                i++
                j++
            }
        }
        return false
    }

    fun isSame(countS1: IntArray, countS2: IntArray): Boolean {
        for ((countIndex, count) in countS1.withIndex()) {
            if (count != countS2[countIndex]) {
                return false
            }
        }
        return true
    }
}
