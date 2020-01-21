package strings

fun main(args: Array<String>) {
    var test = "babad"
    println("babad[bab]: ${Solution().longestPalindrome(test)}")
    test = "cbbd"
    println("cbbd [bb]: ${Solution().longestPalindrome(test)}")
    test = "a"
    println("a[a]: ${Solution().longestPalindrome(test)}")
}

class Solution {
    /**
     * 通过for两次循环取出所有子串
     * 判断每个子串是不是palindromic
     */
    fun longestPalindrome(s: String): String {
        var maxLengthToStartIndexPair = 0 to 0
        var charArray = s.toCharArray()
        for (it in charArray.withIndex()) {
            for (j in it.index until charArray.size) {
                var index = it.index
                if (isPalindromic(charArray, index, j)) {
                    if (maxLengthToStartIndexPair.second < j - index + 1) {
                        maxLengthToStartIndexPair = index to (j - index + 1)
                    }
                }
            }
        }
        return s.substring(maxLengthToStartIndexPair.first, maxLengthToStartIndexPair.first + maxLengthToStartIndexPair.second)
    }

    /**
     * 给定一个字符数组, 判断其[from->to]是否是回文
     * 具体算法两个指针前后向中间逼近,判断值是否都相等,结束条件是 from >= to
     */
    fun isPalindromic(charArray: CharArray, from: Int, to: Int): Boolean {
        var i = from
        var j = to
        while (i <= j) {
            if (charArray[i] == charArray[j]) {
                i++
                j--
            } else {
                return false
            }
        }
        return true
    }

}
