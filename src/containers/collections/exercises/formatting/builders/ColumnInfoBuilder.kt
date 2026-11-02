package containers.collections.exercises.formatting.builders

import containers.collections.exercises.formatting.ColumnAlignment
import containers.collections.exercises.formatting.ColumnInfo
import java.text.Format

class ColumnInfoBuilder<T> {
    /**
     * Si no se especifica longitud de la columna, el tamaño de la etiqueta se toma por defecto
     */
    var label: String = ""
        set(value) {
            field = value
            length = value.length
        }

    var length: Int = 0
    var alignment: ColumnAlignment = ColumnAlignment.Default
    var format: Format? = null
    var value: ((T) -> Any?)? = null

    fun build(): ColumnInfo<T> {
        return ColumnInfo(label, length, alignment, format, value!!)
    }
}