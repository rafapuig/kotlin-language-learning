package flows.operations.intermediate

import coroutines.log
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds


private fun readTemperatures() = flow {
    while (currentCoroutineContext().isActive) {
        delay(300.milliseconds)
        emit(readTemperature())
    }
}

fun main() = runBlocking {
    val temperatures = readTemperatures()
    val job = launch {
        temperatures
            .onStart { log("Comenzando a leer temperaturas del sensor") }
            .onEach { log("Leida temp: ${it} desde el sensor") }
            //.conflate() // Equivale a:
            .buffer(capacity = 0, onBufferOverflow = BufferOverflow.DROP_OLDEST)
            .collect {
                log("Recolectada la temperatura de ${it}ºC")
                delay(1.seconds)
            }
    }
    delay(3.seconds)
    coroutineContext.cancelChildren()
}