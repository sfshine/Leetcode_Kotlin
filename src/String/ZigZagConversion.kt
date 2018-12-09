package String

import java.lang.StringBuilder

fun main(args: Array<String>) {
    println("A: ${ZigZagConversion.Solution().convert("A", 1)}")
    println("LDREOEIIECIHNTSG: ${ZigZagConversion.Solution().convert("LEETCODEISHIRING", 4)}")
    println("LCIRETOESIIGEDHN: ${ZigZagConversion.Solution().convert("LEETCODEISHIRING", 3)}")

}

class ZigZagConversion {
    /**
     * 根据numRows的个数创建数组
     * 画图求出每行数组的规律, 公式是((i - row) % n == 0 || (i - (n - row)) % n == 0)
     * 拼接四个数组返回
     */
    class Solution {
        fun convert(s: String, numRows: Int): String {
            var n = (numRows - 1) * 2
            if (n == 0) {
                return s
            }
            var allLists = ArrayList<StringBuilder>(numRows - 1)
            for ((i, ch) in s.toCharArray().withIndex()) {
                for (row in 0 until numRows) {
                    if ((i - row) % n == 0 || (i - (n - row)) % n == 0) {
                        if (row >= allLists.size) {
                            allLists.add(StringBuilder())
                        }
                        allLists[row].append(ch)
                    }
                }
            }
            var res = StringBuffer()
            for (sb in allLists) {
                res.append(sb)
            }
            return res.toString()
        }
    }
}

