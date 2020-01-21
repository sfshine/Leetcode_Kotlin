package integer

fun main(args: Array<String>) {
//    println("${ReverseInteger.Solution().reverse(123)}")
//    println("${ReverseInteger.Solution().reverse(-123)}")

    println("${ReverseInteger.Solution().reverse(1534236469)}")

}

class ReverseInteger {
    class Solution {
        fun reverse(x: Int): Int {
            var num = x
            var res = 0
            var isNegative = num < 0
            if (num < 0) num *= -1
            while (num != 0) {
                var tmp = num % 10
                if (res > (Int.MAX_VALUE - tmp) / 10) {
                    return 0
                }
                res = tmp + res * 10
                num /= 10
            }
            if (isNegative) res *= -1
            return res
        }
    }
}
