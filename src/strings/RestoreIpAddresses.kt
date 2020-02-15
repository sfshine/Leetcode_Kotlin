package strings

/**

给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]

 */
fun main(args: Array<String>) {
    println(restoreIpAddresses("25525511135"))
}

fun restoreIpAddresses(s: String): List<String> {
    var results = mutableListOf<String>()
    restoreIpAddressRecursive(s, 0, results)
    return results;
}

/**
 * s :输入的字符串
 * position: 当前是第几个Ip段,共:0 - 4 段
 *
 *
 */
fun restoreIpAddressRecursive(s: String, position: Int, results: MutableList<String>) {
    if (position == 3) return

}
