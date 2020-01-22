package strings

/**
LeetCode : 43. 字符串相乘（Multiply Strings
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

 */
fun main(args: Array<String>) {
    println(multiply("123", "456"))
    println(multiply("2", "3"))
}

/**
 * 1.创建结果数组 valueArray[num1.length + num2.length -1], 从 99*9 = 891可以证明,结果最大位数为num1.length + num2.length
 * 2.计算num1*num2,在不进位的情况下,把值填入valueArray
 * 3.处理valueArray的进位情况
 * 4.去掉valueArray前的0
 * 5.生成字符串
 * 参考https://blog.csdn.net/afei__/article/details/83891547
 */
fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"
    var valueArray = IntArray(num1.length + num2.length)

    var i = num2.length - 1
    while (i >= 0) {
        //这里num2是被乘数,把num2每个值拆出来和num1的每个值相乘,将值放到valueArray中.这里其实用一个[行数为num2.length的二维数组]更直白,
        // 但是这个二维数组还要按照num2所在的位数将值合并, 处于性能优化和代码简洁,将同维度的值进行了相加
        var k = num1.length - 1
        while (k >= 0) {
            valueArray[i + k + 1] += (num2[i] - '0') * (num1[k] - '0')
            k--
        }
        i--
    }

    var valueIndex = valueArray.size - 1
    var carry = 0
    while (valueIndex >= 0) {
        var value = valueArray[valueIndex] + carry
        carry = value / 10
        valueArray[valueIndex] = value % 10
        valueIndex--
    }

    var subIndex = 0
    while (valueArray[subIndex] == 0) {
        subIndex++
    }
    if (subIndex > 0) {
        var destArray = IntArray(valueArray.size - subIndex)
        System.arraycopy(valueArray, subIndex, destArray, 0, destArray.size)
        valueArray = destArray
    }
    return valueArray.joinToString("")
}
