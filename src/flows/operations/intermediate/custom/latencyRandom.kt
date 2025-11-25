package flows.operations.intermediate.custom

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlin.time.Duration.Companion.milliseconds

fun <T> Flow<T>.latencyRandom(min: Int, max: Int) = flow {
    collect { value ->
        val latency = (min..max).random()
        //log("Esperando para emitir: $latency")
        delay(latency.milliseconds)
        emit(value)
    }
}

fun <T> Flow<T>.latencyRandom2(min: Int, max: Int) = transform {
    val latency = (min..max).random()
    //log("Esperando para emitir: $latency")
    delay(latency.milliseconds)
    emit(it)
}




fun <T> Flow<T>.latency1(generator: () -> Long) = flow {
    collect { value ->
        val latency = generator()
        //log("Esperando para emitir: $latency")
        delay(latency)
        emit(value)
    }
}

fun <T> Flow<T>.latency2(generator: () -> Long) = map {
        val latency = generator()
        //log("Esperando para emitir: $latency")
        delay(latency)
        it
}

fun <T> Flow<T>.latency(generator: () -> Long) = transform {
    val latency = generator()
    //log("Esperando para emitir: $latency")
    delay(latency)
    emit(it)
}

