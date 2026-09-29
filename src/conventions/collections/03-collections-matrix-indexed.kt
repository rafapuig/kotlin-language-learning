package conventions.collections

class Matrix(numRows: Int, numCols: Int) {

    private val data = Array(numRows) { IntArray(numCols) }

    operator fun get(i: Int, j: Int) = data[i][j]

    operator fun set(i: Int, j: Int, v: Int) {
        data[i][j] = v
    }

    override fun toString() = buildString {
        for (row in data.indices) {
            append("|")
            for (col in data[row].indices) {
                append(data[row][col])
                if (col != data[row].lastIndex) append(' ')
            }
            appendLine("|")
        }
    }
}


fun main() {
    val matrix = Matrix(2, 3)
    println(matrix)

    matrix[0, 0] = 1
    matrix[0, 1] = 2
    matrix[0, 2] = 3
    matrix[1, 0] = 4
    matrix[1, 1] = 5
    matrix[1, 2] = 6

    println(matrix)
}