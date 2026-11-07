package containers.collections.exercises.formatting

import java.text.Format
import java.time.LocalDate

@JvmInline
value class Cell(val fieldValue: Any?) {

    private fun format(formatter: Format?): String = when (fieldValue) {
        null -> ""
        is LocalDate -> ColumnInfo.dateTimeFormatter.format(fieldValue)
        else -> formatter?.format(fieldValue) ?: fieldValue.toString()
    }

}