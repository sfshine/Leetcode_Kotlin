package recursion

import java.util.*

class PacificAtlanticWaterFlow {


    class Solution {
        fun pacificAtlantic(table: Array<IntArray>): List<IntArray> {
            if (table.size == 0) return emptyList()
            var aNextSteps = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
            var pNextSteps = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))

            var pacificResult = findDots(table, 0, 0, pNextSteps)
            var atlanticResult = findDots(table, table.size - 1, table[0].size - 1, aNextSteps)

//            println("pacific result---------")
//            printResult(pacificResult)

//            println("atlanticResult result---------")
//            printResult(atlanticResult)

            var result = mutableListOf<IntArray>()

            for (res in pacificResult) {
                if (resultExists(res, atlanticResult)) {
                    result.add(res)
                }
            }
            return result
        }

        private fun resultExists(ele: IntArray, result: List<IntArray>): Boolean {
            if (ele.size < 2) return false
            for (res in result) {
                if (res.size < 2) continue
                if (res[0] == ele[0] && res[1] == ele[1]) return true
            }
            return false
        }

        private fun findDots(table: Array<IntArray>, borderI: Int, borderJ: Int, nextStep: Array<IntArray>): List<IntArray> {
            var res = mutableListOf<IntArray>()
            for (i in 0 until table.size) {
                for (j in 0 until table[i].size) {
                    if (i == borderI || j == borderJ) {
                        println("adding border: table[$i][$j]: ${table[i][j]}")
                        res.add(intArrayOf(i, j))
                    } else {
                        var visited = Array(table.size) { BooleanArray(table[0].size) { false } }
                        findDotsRecursion(table[i][j], table, i, j, nextStep, visited, borderI, borderJ, i, j, res)
                    }
                }
            }
            return res
        }

        private fun findDotsRecursion(currentValue: Int, table: Array<IntArray>, startI: Int, startJ: Int,
                                      nextStep: Array<IntArray>,
                                      visited: Array<BooleanArray>,
                                      borderI: Int,
                                      borderJ: Int,
                                      originI: Int,
                                      originJ: Int,
                                      res: MutableList<IntArray>): Boolean {
            for (intArr in nextStep) {
                val nextI = startI + intArr[0]
                var nextJ = startJ + intArr[1]
                if (inArea(nextI, nextJ, table) && currentValue >= table[nextI][nextJ] && !visited[nextI][nextJ]) {
                    println("currentValue = ${currentValue}, checking table[${nextI}][${nextJ}] = ${table[nextI][nextJ]}")
                    if (nextI == borderI || nextJ == borderJ) {
                        res.add(intArrayOf(originI, originJ))
                        println("dotfind : adding border of Parcific:  table[${originI}][${originJ}] = ${table[originI][originJ]}")
                        return true
                    } else {
                        visited[nextI][nextJ] = true
                        var findResult = findDotsRecursion(table[nextI][nextJ], table, nextI, nextJ, nextStep, visited, borderI, borderJ, originI, originJ, res)
                        if (findResult) {
                            return true
                        }
                    }
                }
            }
            return false
        }

        private fun inArea(nextI: Int, nextJ: Int, table: Array<IntArray>): Boolean {
            return nextI >= 0 && nextI < table.size && nextJ >= 0 && nextJ < table[0].size
        }
    }
}

fun main(args: Array<String>) {
    var table = arrayOf(
            intArrayOf(1, 2, 2, 3, 5),
            intArrayOf(3, 2, 3, 4, 4),
            intArrayOf(2, 4, 5, 3, 1),
            intArrayOf(6, 7, 1, 4, 5),
            intArrayOf(5, 1, 1, 2, 4))

    println("---------------input----------------")

    table.forEach {
        it.forEach {
            print("${it},")
        }
        println("")
    }

    println("---------------result----------------")
    printResult(PacificAtlanticWaterFlow.Solution().pacificAtlantic(table))
}

fun printResult(result: List<IntArray>) {
    result.forEach {
        print("(")
        it.forEach {
            print("${it},")
        }
        print(")")
    }
    println("")
}