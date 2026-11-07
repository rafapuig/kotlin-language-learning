package containers.collections.exercises.formatting.builders

import containers.collections.exercises.formatting.ColumnAlignment
import containers.collections.exercises.formatting.ColumnInfo
import java.text.Format

class ColumnInfoBuilder<T> {
    /**
     * Si no se especifica longitud de la columna,
     * el tamaño de la etiqueta se toma por defecto como el de la longitud del texto
     */
    var label: String = ""
        set(value) {
            field = value
            width = value.length
        }

    var width: Int = 0
    var alignment: ColumnAlignment = ColumnAlignment.Default
    var format: Format? = null
    var value: ((T) -> Any?)? = null

    /**
     * Fabrica el objeto ColumnInfo
     * mediante una llamada al constructor
     * pasándole toda la información recopilada
     */
    fun build(): ColumnInfo<T> = ColumnInfo(
        name = label,
        width = width,
        columnAlignment = alignment,
        formatter = format,
        fieldValueExtractor = value!!
    )

}

fun <T> buildColumnInfo(
    block: ColumnInfoBuilder<T>.() -> Unit
): ColumnInfo<T> = ColumnInfoBuilder<T>().apply(block).build()