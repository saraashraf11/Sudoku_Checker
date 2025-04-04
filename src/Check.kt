fun main() {
    test(
        name = "should return true, when sudoku has some dash",
        result = isValidSudoku(
            board = arrayOf(
                charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = true
    )

    test(
        name = "should return true, when sudoku has full numbers",
        result = isValidSudoku(
            board = arrayOf(
                charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
            )
        ),
        correctResult = true
    )

    test(
        name = "should return true, when sudoku has a dash",
        result = isValidSudoku(
            board = Array(9) { CharArray(9) { '-' } }
        ),
        correctResult = true
    )

    test(
        name = "should return false, when sudoku has a row duplicate",
        result = isValidSudoku(
            board = arrayOf(
                charArrayOf('5', '3', '-', '3', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    test(
        name = "should return false, when sudoku has a column duplicate",
        result = isValidSudoku(
            board = arrayOf(
                charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('5', '6', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    test(
        name = "should return false, when sudoku has a subgrid duplicate",
        result = isValidSudoku(
            board = arrayOf(
                charArrayOf('5', '3', '6', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '9', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    test(
        name = "should return false, when sudoku has invalid characters except digits and dash",
        result = isValidSudoku(
            board = arrayOf(
                charArrayOf('5', '3', 'A', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '8', '-', '-', '7', 'X')
            )
        ),
        correctResult = false
    )

    test(
        name = "should return false, when sudoku has incorrect size",
        result = isValidSudoku(
            board = arrayOf(
                charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '6', '-', '-', '-', '-', '2', '8', '-')
            )
        ),
        correctResult = false
    )
}

fun test(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}
