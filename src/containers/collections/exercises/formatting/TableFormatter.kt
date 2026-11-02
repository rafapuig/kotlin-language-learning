package containers.collections.exercises.formatting

class TableFormatter<T>(
    vararg columns: ColumnInfo<in T>
) {

    companion object {

        const val DELIMITER = " "

        private fun <T> T.toCellContent(columnInfo: ColumnInfo<T>) =
            columnInfo.toContent(this)
    }


    private val columns = columns.toList()

    val header =
        columns.joinToString(separator = DELIMITER) {
            it.toColumnHeader()
        }

    val headerLineSeparator = "-".repeat(header.length)


    fun Iterable<T>.toTable() =
        buildString {
            appendLine(header)
            appendLine(headerLineSeparator)
            append(toRows())
        }

    /**
     * Para poder usar arrays directamente
     */
    fun Array<T>.toTable() = asIterable().toTable()


    fun Iterable<T>.toRows() =
        joinToString(separator = System.lineSeparator()) { it.toRow() }

    fun Iterable<T>.asRows(): List<Row> =
        map {
            it.asRow()
        }

    fun Array<T>.asRows(): List<Row> = asIterable().asRows()


    fun T.toRow() =
        columns.joinToString(separator = DELIMITER) {
            it.toContent(this)
            //toCellContent(it)
        }

    fun T.asRow() =
        columns.map { columnInfo ->
            this.toCellContent(columnInfo)
        }.let { Row(it) }


}
