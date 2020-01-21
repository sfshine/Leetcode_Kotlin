package strings

/**
 *最长公共前缀
 *编写一个函数来查找字符串数组中的最长公共前缀。
 *如果不存在公共前缀，返回空字符串 ""。
 *示例 1:
 *输入: ["flower","flow","flight"]
 *输出: "fl"
 *示例 2:
 *输入: ["dog","racecar","car"]
 *输出: ""
 *解释: 输入不存在公共前缀。
 *说明:
 *所有输入只包含小写字母 a-z 。
 *
 */
fun main(args: Array<String>) {
    var array1 = arrayOf("flower", "flow", "flight")
    println("${longestCommonPrefix(array1)}")

    var array2 = arrayOf("dog", "racecar", "car")
    println("${longestCommonPrefix(array2)}")
}

/**
 * 使用做短的字符串的size 循环条件,横向对比每个字符串的字符是否都是同一个
 */
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var minStrLength = Int.MAX_VALUE
    for (str in strs) {
        minStrLength = Math.min(minStrLength, str.length)
    }
    var prefix = ""
    for (i in 0 until minStrLength) {
        var tmpPrefix: Char = strs[0][i]
        for (k in 1 until strs.size) {
            if (tmpPrefix != strs[k][i]) {
                tmpPrefix = ' '
                break
            }
        }
        if (tmpPrefix == ' ') {
            break
        } else {
            prefix += tmpPrefix
        }
    }
    return prefix
}
