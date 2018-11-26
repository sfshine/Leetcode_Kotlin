package String

import java.lang.StringBuilder

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
fun main(args: Array<String>) {
//    println(lengthOfLongestSubstring("abcabcbb"))
//    println(lengthOfLongestSubstring("bbbbb"))
//    println(lengthOfLongestSubstring("pwwkew"))
//    println(lengthOfLongestSubstring("aab"))
//    println(lengthOfLongestSubstring("a"))
    println(lengthOfLongestSubstring("tmmzuxt"))

}

/**
 *   1.map存储char和他对应的index
 *   2.缓存一个subStrStartIndex来记录当前不重复子串的起始位置
 *   3.遍历数组
 *   如果元素已经在Map了, 也就是有重复字符了, 那就要考察是否需要更新subStrStartIndex了
 *   把当前重复字符的index >= 当前的subStrStartIndex, 更新 subStrStartIndex 为 当前重复字符的index +1
 *   4.通过index - subStrStartIndex +1 求字符串长度
 *   5.想mapOfCharToIndex增加当前的char值和索引
 */
fun lengthOfLongestSubstring(s: String): Int {
    var mapOfCharToIndex = HashMap<Char, Int>()
    var subStrStartIndex = 0
    var charArray = s.toCharArray()
    var maxLength = 0
    for ((index, char) in charArray.withIndex()) {
        //有重复字符并且这个字符的位置比当前的preIndex靠前,需要将preIndex从已经存在的元素的index往前移动一位继续试,后面还会更新这个char的index
        if (mapOfCharToIndex.containsKey(char)) {
            if (mapOfCharToIndex.get(char)!! >= subStrStartIndex) {
                subStrStartIndex = mapOfCharToIndex.get(char)!! + 1
            }
        }
        maxLength = Math.max(maxLength, index - subStrStartIndex + 1)
        mapOfCharToIndex.put(char, index)
    }
    return maxLength
}

///**
// * 滑动窗口
// * 使用set缓存访问的值
// * 遍历数组的时候,
// * 如果set中已经存在相同的元素了,就把其前面的元素移除,继续判断新的set有没有重复的
// * 否则,更新max
// */
//fun longestNoRepeatStrSet(str: String): Int {
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
