import java.util.HashSet

fun main() {
    val rows = readNumber( "Введите количество строк ")
    val columns = readNumber( "Введите количество столбцов ")

    val matrix = Array(rows) { Array(columns) {0}}

    for (i in 0 until rows) {
        for (j in 0 until columns) {
            matrix[i][j] = readNumber("Введите элемент ", 100, 999)
        }
    }

    val uniqueDigits = countiqueDigits(matrix)

    printMatrix(matrix)
    print("В массиве использовано $uniqueDigits различных цифр")
}

fun readNumber(prompt: String): Int{
    print(prompt)
    return readLine()!!.toInt()
}

fun readNumber(prompt: String, minValue: Int, maxValue: Int):Int{
    var number: Int
    do {
        number = readNumber(prompt)
    }while (number < minValue || number > maxValue)
    return number
}

fun countiqueDigits(matrix: Array<Array<Int>>):Int{
    val digits = HashSet<Int>()
    var count = 0

    for (row in matrix) {
        for (number in row){
            val hundresDigit = number / 100
            val tensDigit = (number % 100) / 10
            val onesDigit = number % 10

            digits.add(hundresDigit)
            digits.add(tensDigit)
            digits.add(onesDigit)
        }
    }
    return digits.size
}

fun printMatrix(matrix: Array<Array<Int>>){
    for (row in matrix){
        for (number in row) {
            print("$number\t")
        }
        println()
    }
}