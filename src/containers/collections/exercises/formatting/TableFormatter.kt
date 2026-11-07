package containers.collections.exercises.formatting

class TableFormatter<T>(
    vararg columns: ColumnInfo<in T>
) {

    companion object {

        const val COLUMN_DELIMITER = " "

        private fun <T> T.toCellContent(columnInfo: ColumnInfo<T>) =
            columnInfo.formatContent(this)
    }


    private val columns = columns.toList()

    val header = columns.joinToString(separator = COLUMN_DELIMITER) {
        it.toColumnHeader()
    }

    val headerLineSeparator = "-".repeat(header.length)


    /**
     * Convierte un elemento de tipo T
     * en su representacion String con sus propiedades en fila
     * a partir de la información de las columnas
     */
    fun T.toRow() = columns.joinToString(separator = COLUMN_DELIMITER) {
        it.formatContent(this)
        with(it) { toContent() }
        //toCellContent(it)
    }

    fun T.asRow() = columns.map { columnInfo ->
        this.toCellContent(columnInfo)
    }.let {
        Row(it)
    }


    fun Iterable<T>.toRows() = joinToString(separator = System.lineSeparator()) { item ->
        item.toRow()
    }

    fun Iterable<T>.asRows(): List<Row> = map { item ->
        item.asRow()
    }

    fun Array<T>.asRows(): List<Row> = asIterable().asRows()


    /**
     * Convierte una coleccion de elementos de tipo T
     * en una representacion String en forma de tabla
     * a partir de la informacion aportada por las columnas
     */
    fun Iterable<T>.toTable(withHeader: Boolean = true) = buildString {
        if (withHeader) {
            appendLine(header)
            appendLine(headerLineSeparator)
        }
        append(toRows())
    }

    /**
     * Para poder usar arrays directamente
     */
    fun Array<T>.toTable() = asIterable().toTable()


}
