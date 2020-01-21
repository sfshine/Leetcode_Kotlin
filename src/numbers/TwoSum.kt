package numbers


fun main(args: Array<String>) {
    var arr = intArrayOf(2, 11, 15, 7)
    var target = 9
    twoSum(arr, target)?.forEach {
        print("${it},")
    }
}

//使用map记录某个值是否访问过,key为这个值,value为对应的index
var visitedMap = HashMap<Int, Int>()

fun twoSum(nums: IntArray, target: Int): IntArray? {
    for ((index, value) in nums.withIndex()) {
        //检查target和当前值的差是否在visitedMap中
        val visitedValue = target - value
        if (visitedMap.containsKey(visitedValue)) {
            return intArrayOf(visitedMap.get(visitedValue)!!, index)
        } else {
            visitedMap.put(value, index)
        }
    }
    return null
}

