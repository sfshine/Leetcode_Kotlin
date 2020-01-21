package strings

import kotlin.math.max

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
fun main(args: Array<String>) {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("abba"))
    println(lengthOfLongestSubstring("dvdf"))
}

/**
 *   1.使用一个Map存储char和它对应的index
 *   2.缓存一个subStrStartIndex来记录当前不重复子串的起始位置, 最大长度 = index - subStrStartIndex +1
 *   3.遍历数组,如果数组中的元素已经在Map中了, 说明从subStrStartIndex到index这一段中已经存在重复字符了,那就把subStrStartIndex赋值给这个重复字符的所在index+1的位置,
 *     同时需要注意:subStrStartIndex需要往前不能回退!
 *   4.定义maxSubStrLength, 通过index - subStrStartIndex +1 求字符串长度,并赋值给maxSubStrLength
 */
fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    var subStrStart = 0
    var maxSubStrLength = 0
    var charMap = HashMap<Char, Int>()
    for ((index, char) in s.withIndex()) {
        if (charMap.containsKey(char)) {
            subStrStart = Math.max(subStrStart, charMap[char]!! + 1)
        }
        charMap.put(char, index)
        maxSubStrLength = Math.max(maxSubStrLength, index - subStrStart + 1)
    }
    return maxSubStrLength
}

///**
// * 滑动窗口
// * 使用set缓存访问的值
// * 遍历数组的时候,
// * 如果set中已经存在相同的元素了,就把其前面的元素移除,继续判断新的set有没有重复的
// * 否则,更新max
// */
//fun longestNoRepeatStrSet(str: strings): Int {
//    var maxSet = HashSet<Char>()
//    var charArray = str.toCharArray()
//    var maxLength = 0
//    var maxSetIndexStart = 0
//
//    for ((index, char) in charArray.withIndex()) {
//        //没有重复的,更新maxLength, 更新标准是 当前index - 最大index的开始位置 +1
//        if (!maxSet.contains(char)) {
//            maxSet.add(char)
//        } else {
//            maxSet.remove(charArray[maxSetIndexStart])
//            maxSetIndexStart++
//        }
//        maxLength = Math.max(maxLength, index - maxSetIndexStart + 1)
//    }
//    return maxLength
//}

/**
 * 暴力法
 */
fun longestNoRepeatStr1(str: String): Int {
    var longestStr = StringBuilder()
    var charArray = str.toCharArray()
    //1.从字符串的第一个ch开始往后尝试拼接最长的Str, 找到最长的
    for ((index, char) in charArray.withIndex()) {
        var currentLongestStr = StringBuilder()
        currentLongestStr.append(char)
        //从idex +1 往后查找该字符开头最长的字符串
        for (i in index + 1..charArray.size - 1) {
            if (currentLongestStr.contains(charArray[i])) {
                break
            } else {
                currentLongestStr.append(charArray[i])
            }
        }
        longestStr = if (longestStr.length < currentLongestStr.length) currentLongestStr else longestStr
    }
    return longestStr.length
}
