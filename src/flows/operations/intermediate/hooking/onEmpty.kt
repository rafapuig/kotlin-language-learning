package flows.operations.intermediate.hooking

import coroutines.log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking

suspend fun process(flow: Flow<Int>) {
    flow
        .onStart { log("Comenzando a emitir") }
        .onEmpty {
            log("Flow vacio")
            emit(0)
        }
        .onEach { log("Emitido $it") }
        .onEach { log("Al cuadrado es ${it * it}") }
        .onCompletion { log("Terminado") }
        .onCompletion { log("Completado") }
        .collect {
            log(it)
        }
}

fun main() = runBlocking<Unit> {
    val numbers = flowOf(1, 2, 3)
    process(numbers)
    val empty = flowOf<Int>()
    process(empty)
}
