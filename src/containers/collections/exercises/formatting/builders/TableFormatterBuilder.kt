package containers.collections.exercises.formatting.builders

import containers.collections.exercises.formatting.ColumnInfo
import containers.collections.exercises.formatting.TableFormatter

class TableFormatterBuilder<T> {

    private val columns =
        mutableListOf<ColumnInfo<T>>()

    fun column(column: ColumnInfo<T>) =
        columns.add(column)

    fun column(block: ColumnInfoBuilder<T>.() -> Unit) {
        columns +=
            ColumnInfoBuilder<T>()
                .apply { block(this) }
                .build()
    }

    fun build(): TableFormatter<T> =
        TableFormatter(*columns.toTypedArray())
}