package flows.operations.intermediate.hooking

import coroutines.log
import flows.operations.intermediate.getTemperatures
import flows.operations.intermediate.readTemperature
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

fun main() {
    val temperatures = getTemperatures()

    runBlocking {
        temperatures
            .onEach { log("Emitida la temperatura $it") }
            .take(5)
            .collect { temperature ->
                log("${temperature}ºC")
            }
    }
}