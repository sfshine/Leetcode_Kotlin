package strings

fun main(array: Array<String>) {
    val test = "Hello World "
    println("getLengthOfLastWord: ${getLengthOfLastWord(test)}")
}

fun getLengthOfLastWord(str: String): Int {
    val length = str.length
    for (i in length - 1 downTo 0) {
        val ch = str[i]
        println(ch)
        if (ch == ' ') {
            return length - 1 - i
        }
    }
    return -1
}
