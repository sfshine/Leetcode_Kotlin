const lengthOfLIS = function (nums) {
    if (!nums || nums.length == 0) return 0
    let mem = Array(nums.length).fill(1)
    let result = 1
    //   定义:当前元素的下标为curIndex, 定义需要和*当前元素*对比的*当前元素之前的元素*下标为indexBeforeCurrent
    for (let curIndex = 1; curIndex < nums.length; curIndex++) {
        for (let indexBeforeCurrent = 0; indexBeforeCurrent < curIndex; indexBeforeCurrent++) {
            if (nums[indexBeforeCurrent] < nums[curIndex]) {
                mem[curIndex] = Math.max(1 + mem[indexBeforeCurrent], mem[curIndex])
            }
        }
        result = Math.max(mem[curIndex], result)
    }
    return result
};

// 输入: [10,9,2,5,3,7,101,18]
// 输出: 4
// 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
// 方案:
// 1.数据中从index = 1 开始的每个元素距离10这个元素的LIS都是1,也就是说先假定都比第一个元素小
// 2.使用for循环考察*当前元素之前的元素*是否比*当前元素*小, 如果是,则将*当前元素*的LIS取 所考察元素+1 和 当前元素LIS中的最大值
// 3.从所有元素的LIS中寻找最大值

const array = [10, 9, 2, 5, 3, 7, 101, 18]
console.log(lengthOfLIS(array))





