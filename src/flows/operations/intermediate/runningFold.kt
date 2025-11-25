package flows.operations.intermediate

import coroutines.log
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.html.Entities

fun main() {
    /**
     * El valor será la media entre el valor emitido y el anterior
     */
    val alpha = 0.5f
    val temperatures = getTemperatures()
    runBlocking {
        temperatures
            .onEach { log("Valor emitido $it") }
            .runningFold(
                0f,
                { old, new ->
                    new * alpha + old * (1 - alpha)
                }
            )
            .take(5)
            .collect { log(it) }
    }
}