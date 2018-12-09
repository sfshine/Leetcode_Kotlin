package recursion


class Solution {
    var nextSteps = arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1))

    fun exist(board: Array<CharArray>, word: String): Boolean {
        var wordCharArray = word.toCharArray()
        for ((i, arr) in board.withIndex()) {
            for ((j, ch) in arr.withIndex()) {
                println("search start ${ch}")
                var visited = Array(board.size) { Array(board[0].size) { false } }
                var res = search(board, i, j, wordCharArray, 0, visited)
                if (res) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * startI : 当前行
     * startJ : 当前列
     * 寻找顺序：上(i-1)右(j+1)下左
     */
    fun search(table: Array<CharArray>, startI: Int, startJ: Int, word: CharArray, wordIndex: Int, visited: Array<Array<Boolean>>): Boolean {
        if (visited[startI][startJ]) {
            println("(${startI},${startJ} has been visited)")
            return false
        }
        visited[startI][startJ] = true
        println("check match: char ${word[wordIndex]}, table[${startI}][${startJ}] = ${table[startI][startJ]}")
        if (word[wordIndex] == table[startI][startJ]) {
            if (wordIndex == word.size - 1) {
                return true
            }
            for (arr in nextSteps) {
                var nextI = startI + arr[0]
                var nextJ = startJ + arr[1]
                println("next step: nextI = $nextI , nextJ = $nextJ")
                if (inArea(table, nextI, nextJ) && search(table, nextI, nextJ, word, wordIndex + 1, visited)) {
                    return true
                }
            }
        }
        visited[startI][startJ] = false
        return false
    }

    private fun inArea(table: Array<CharArray>, startI: Int, startJ: Int): Boolean {
        return startI >= 0 && startI < table.size && startJ >= 0 && startJ < table[startI].size
    }

}


fun main(args: Array<String>) {
    var wordSearch = Solution()

    var table = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
    )

    var word = "ABCCED"

    table = arrayOf(
            charArrayOf('A', 'B')
    )
    word = "BA"

//    table = arrayOf(
//            charArrayOf('a', 'b'),
//            charArrayOf('c', 'd'))
//    word = "acdb"


    println(wordSearch.exist(table, word))

}


