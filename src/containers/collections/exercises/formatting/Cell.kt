package containers.collections.exercises.formatting

import containers.collections.exercises.formatting.ColumnInfo.Companion.dateTimeFormatter
import java.text.Format
import java.time.LocalDate

@JvmInline
value class Cell(val fieldValue : Any?) {

    private fun format(formatter: Format?): String {
        if (fieldValue == null) return ""

        return if (fieldValue is LocalDate)
            dateTimeFormatter.format(fieldValue)
        else
            formatter?.format(fieldValue) ?: fieldValue.toString()
    }

}