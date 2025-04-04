fun main() {
    val board = arrayOf(
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

    println("Is the Sudoku board valid? ${isValidSudoku(board)}")
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val size = 9

    // Check if the board size is valid (should be 9x9)
    if (board.size != size) return false
    for (row in board) {
        if (row.size != size) return false
    }



    // Check if the board has any invalid characters
    if (hasInvalidCharacters(board)) {
        return false
    }

    // Check rows
    for (row in board) {
        if (hasDuplicates(row.toList())) return false
    }

    // Check columns
    for (col in 0 until size) {
        val columnValues = List(size) { row -> board[row][col] }
        if (hasDuplicates(columnValues)) return false
    }

    // Check 3x3 subgrids
    for (boxRow in 0 until size step 3) {
        for (boxCol in 0 until size step 3) {
            val subgrid = mutableListOf<Char>()
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    subgrid.add(board[boxRow + i][boxCol + j])
                }
            }
            if (hasDuplicates(subgrid)) return false
        }
    }

    return true
}


fun hasDuplicates(values: List<Char>): Boolean {
    val seen = mutableSetOf<Char>()
    for (char in values) {
        if (char != '-' && char in seen) return true
        seen.add(char)
    }
    return false
}

fun hasInvalidCharacters(board: Array<CharArray>): Boolean {
    for (row in board) {
        for (cell in row) {
            if (cell !in '1'..'9' && cell != '-') {
                return true
            }
        }
    }
    return false
}
