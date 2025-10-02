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

fun createAnotherTable() = createHTML()
    .table {
        val numbers = mapOf(1 to "uno", 2 to "dos")
        for (number in numbers) {
            tr {
                td { +"${number.key}" }
                td { +number.value }
            }
        }
    }

@OptIn(ExperimentalTime::class)
fun main() {
    println(yesterday)
    println(createSimpleTable())
    println(createAnotherTable())
}

