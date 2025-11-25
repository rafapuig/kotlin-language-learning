package flows.operations.intermediate

import coroutines.log
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun readTemperature() = (-10..35).random()

fun getTemperatures() = generateSequence { readTemperature() }.asFlow()


/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */
fun main() {
    val temperatures = getTemperatures()

    runBlocking {
        temperatures
            .take(5)
            .collect { temperature ->
                log("${temperature}ºC")
            }
        log("Tarea de lectura terminada")
    }
}