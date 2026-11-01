package containers.collections.exercises.formatting.builders

import containers.collections.exercises.formatting.TableFormatter


fun <T> buildTableFormatter(
    block: TableFormatterBuilder<T>.() -> Unit
): TableFormatter<T> {
    return TableFormatterBuilder<T>().apply(block).build()
}


fun <T> Iterable<T>.toTable(formatter: TableFormatter<T>) =
    with(formatter) {
        this@toTable.toTable()
    }


fun <T> Array<T>.toTable(formatter: TableFormatter<T>) =
    asIterable().toTable(formatter)



fun <T> Iterable<T>.asTable(block: TableFormatterBuilder<T>.() -> Unit) =
    toTable(buildTableFormatter(block))


fun <T> Array<T>.asTable(block: TableFormatterBuilder<T>.() -> Unit) =
    asIterable().asTable(block)


