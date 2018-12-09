package String

fun main(args: Array<String>) {
//    println("123: ${StringToInteger.Solution().myAtoi("123")}")
//    println("  -42: ${StringToInteger.Solution().myAtoi("  -42")}")
//    println("4193 with words: ${StringToInteger.Solution().myAtoi("4193 with words")}")
//    println("words and 987 expect:[0]: ${StringToInteger.Solution().myAtoi("words and 987")}")
//    println("-91283472332 expect[-2147483648]: ${StringToInteger.Solution().myAtoi("-91283472332")}")
//    println("+1 expect[1]: ${StringToInteger.Solution().myAtoi("+1")}")
//    println("+-1 expect[1]: ${StringToInteger.Solution().myAtoi("+-1")}")
    println("9223372036854775808 expect[1]: ${StringToInteger.Solution().myAtoi("9223372036854775808")}")
}

class StringToInteger {
    class Solution {
        /**
         * from循环字符串数组,res = res*10 + (ch-'0')
         * 如果是"-"则 isNegative = true
         * 如果是空格,往后找
         * 如果是非数字,非空格,非"-" 返回0
         * 如果 ch -'0' >= INT_MAX - res*10 , res = INTMAX, break
         * 处理isNegative
         */
        fun myAtoi(str: String): Int {
            var res = Long.MIN_VALUE
            var containsNegative = false
            var containsPositive = false

            for (ch in str.toCharArray()) {
                //数字前面空格,继续往下走, 后面有空格直接跳出
                if (ch == ' ') {
                    if (res == Long.MIN_VALUE) {
                        continue
                    } else {
                        break
                    }
                }
                if (ch == '-' && res == Long.MIN_VALUE) {
                    containsNegative = true
                    continue
                }
                if (ch == '+' && res == Long.MIN_VALUE) {
                    containsPositive = true
                    continue
                }
                if (containsNegative && containsPositive) {
                    return 0
                }
                var curInt = ch - '0'

                if (curInt < 0 || curInt > 9) {
                    break
                }

                res = res * 10 + curInt
            }
            if (containsNegative) {
                res *= -1
            }

            res = if (res == Long.MIN_VALUE) 0 else res

            var resInt: Int
            if (res <= Int.MIN_VALUE) {
                resInt = Int.MIN_VALUE
            } else if (res >= Int.MAX_VALUE) {
                resInt = Int.MAX_VALUE
            } else {
                resInt = res.toInt()
            }
            return resInt
        }
    }
}