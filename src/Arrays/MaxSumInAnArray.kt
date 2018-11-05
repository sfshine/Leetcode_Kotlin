package Arrays

fun main(args: Array<String>) {
    //求一个数组中局部元素的最大和
    val arr = arrayOf(-1, 2, 3, 8, 5, 6, 58, -85)
    var tempSum = 0
    var maxSum = arr[0]

    for (v in arr) {
        tempSum = v + if (tempSum <= 0) 0 else tempSum
        //动态规划: 记住求过的解(maxSum)来节省时间
        maxSum = maxOf(tempSum, maxSum)
    }

    println("maxSum is the array is ${maxSum}")
}