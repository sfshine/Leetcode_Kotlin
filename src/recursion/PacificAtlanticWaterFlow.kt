package recursion

class PacificAtlanticWaterFlow {
    class Solution {
        fun pacificAtlantic(table: Array<IntArray>): List<IntArray> {
            if (table.size == 0) return emptyList()
            var result = findDots(table)
            return result
        }

        private fun findDots(table: Array<IntArray>): List<IntArray> {
            var pNextSteps = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))
            var aNextSteps = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

            var res = mutableListOf<IntArray>()
            for (i in 0 until table.size) {
                for (j in 0 until table[i].size) {
                    var visited = Array(table.size) { BooleanArray(table[0].size) { false } }
                    var pacificResult = findDotsRecursion(table[i][j], table, i, j, pNextSteps, visited, 0, 0)
                    visited = Array(table.size) { BooleanArray(table[0].size) { false } }
                    var atlanticResult = findDotsRecursion(table[i][j], table, i, j, aNextSteps, visited, table.size - 1, table[0].size - 1)
                    if (pacificResult && atlanticResult) res.add(intArrayOf(i, j))
                }
            }
            return res
        }

        private fun findDotsRecursion(currentValue: Int, table: Array<IntArray>, startI: Int, startJ: Int,
                                      nextStep: Array<IntArray>,
                                      visited: Array<BooleanArray>,
                                      borderI: Int,
                                      borderJ: Int): Boolean {
            if (startI == borderI || startJ == borderJ)
                return true
            for (intArr in nextStep) {
                val nextI = startI + intArr[0]
                var nextJ = startJ + intArr[1]
                if (inArea(nextI, nextJ, table) && currentValue >= table[nextI][nextJ] && !visited[nextI][nextJ]) {
                    // println("currentValue = ${currentValue}, checking table[${nextI}][${nextJ}] = ${table[nextI][nextJ]}")
                    if (nextI == borderI || nextJ == borderJ) {
                        return true
                    } else {
                        visited[nextI][nextJ] = true
                        var findResult = findDotsRecursion(table[nextI][nextJ], table, nextI, nextJ, nextStep, visited, borderI, borderJ)
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