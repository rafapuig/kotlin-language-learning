package containers.collections.exercises.formatting

import java.text.Format
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class ColumnInfo<T>(
    val name: String,
    val length: Int,
    val columnAlignment: ColumnAlignment = ColumnAlignment.Default,
    val formatter: Format?,
    val fieldValueExtractor: (T) -> Any?
) {
    /**
     * Este constructor secundario permite omitir el argumento
     * para el formatter cuando se vaya a proporcionar
     * una referencia a metodo (o propiedad) en lugar de una
     * trailing lambda.
     */
    constructor(
        name: String,
        length: Int,
        fieldValueExtractor: (T) -> Any?
    ) : this(name, length, ColumnAlignment.Default, null, fieldValueExtractor)

    companion object {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    }


    private fun format(fieldValue: Any?): String {
        if (fieldValue == null) return ""

        return if (fieldValue is LocalDate)
            dateTimeFormatter.format(fieldValue)
        else
            formatter?.format(fieldValue) ?: fieldValue.toString()
    }

    fun toContent(value: T): String {

        val fieldValue = fieldValueExtractor(value)

        val formattedValue = format(fieldValue)

        val padOperation =
            when(columnAlignment) {
                ColumnAlignment.Default -> if (fieldValue is Number) String::padStart else String::padEnd
                ColumnAlignment.Start -> String::padEnd
                ColumnAlignment.Center -> String::padCenter
                ColumnAlignment.End -> String::padStart
            }

        return formattedValue.padOperation(length, ' ')
    }

}

fun <T> ColumnInfo<T>.toColumnHeader() =
    name.uppercase().padCenter(length)

val <T> ColumnInfo<T>.header
    get() = name.uppercase().padCenter(length)
