package flows.operations.terminal

import coroutines.log
import flows.operations.intermediate.getTemperatures
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val firstReadTemp =
        getTemperatures()
            .first()

    log(firstReadTemp)
}