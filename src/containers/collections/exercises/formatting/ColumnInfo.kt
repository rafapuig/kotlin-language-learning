package containers.collections.exercises.formatting

import java.text.Format
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class ColumnInfo<T>(
    val name: String, // Nombre de la columna, etiqueta para el encabezado
    val width: Int, // Espacio en caracteres que ocupará el contenido de una celda de esa columna
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
        val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    }


    private val Any?.formatted: String
        get() = when (this) {
            null -> ""
            is LocalDate -> dateTimeFormatter.format(this)
            else -> formatter?.format(this) ?: toString()
        }

    /*private fun format(value: Any?): String =
        when (value) {
            null -> ""
            is LocalDate -> dateTimeFormatter.format(value)
            else -> formatter?.format(value) ?: value.toString()
        }*/

    operator fun invoke(item: T): Any? = fieldValueExtractor(item)


    fun formatContent(item: T): String =
        fieldValueExtractor(item).let { fieldValue ->
            columnAlignment.toPaddingOperation(fieldValue).let { padding ->
                fieldValue.formatted.padding(width, ' ')
            }
        }

    fun T.toContent() : String = formatContent(this)
}


fun <T> ColumnAlignment.toPaddingOperation(value: T?) = when (this) {
    ColumnAlignment.Default -> if (value is Number) String::padStart else String::padEnd
    ColumnAlignment.Start -> String::padEnd
    ColumnAlignment.Center -> String::padCenter
    ColumnAlignment.End -> String::padStart
}


fun <T> ColumnInfo<T>.toColumnHeader(
    format: String.() -> String = { uppercase().padCenter(width) }
) = name.format()


val <T> ColumnInfo<T>.header
    get() = name.uppercase().padCenter(width)
