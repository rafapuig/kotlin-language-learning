package DSL

import kotlinx.html.stream.createHTML
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.tr
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.ExperimentalTime


@OptIn(ExperimentalTime::class)
val yesterday = Clock.System.now() - 1.days


fun createSimpleTable() = createHTML()
    .table {
        tr {
            td { +"celda" }
        }
    }

