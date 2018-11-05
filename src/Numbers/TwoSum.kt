package Numbers

/**
 * Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
fun main(array: Array<String>) {
    var arr = arrayOf(2, 11, 15, 7)
    var target = 9
    println("find two sum ${findTwoSum(arr, target)}")
}

fun findTwoSum(arr: Array<Int>, target: Int): String {
    val map = HashMap<Int, Int>()
    for (num in arr) {
        if (map.containsKey(num)) {
            return "[${map[num]}, $num]"
        } else {
            //现在就吧结果放进去, (9-2)->2, 下次循环如果遇到7了, 通过map[7]就可以取到, 动态规划: 记住求过的解来节省时间
            map[target - num] = num
        }
    }
    return "not find"
}
