package containers.collections.exercises.formatting.builders

import containers.collections.exercises.formatting.ColumnInfo
import containers.collections.exercises.formatting.TableFormatter

class TableFormatterBuilder<T> {

    private val columns =
        mutableListOf<ColumnInfo<T>>()

    /**
     * Añadir una columna para el TableFormatter
     * a partir de un ColumnInfo
     */
    fun column(column: ColumnInfo<T>) =
        columns.add(column)

    /**
     * Añadir una columna
     * a partir del código que debe aplicarse a un ColumInfoBuilder
     */
    fun column(block: ColumnInfoBuilder<T>.() -> Unit) {
        columns +=
            ColumnInfoBuilder<T>()
                .apply { block(this) }
                .build()
    }

    /**
     * Fabrica el TableFormatter para elementos de tipo T
     */
    fun build(): TableFormatter<T> =
        TableFormatter(*columns.toTypedArray())
}