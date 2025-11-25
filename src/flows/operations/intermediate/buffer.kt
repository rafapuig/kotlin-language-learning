package flows.operations.intermediate

import coroutines.log
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

private fun getAllUserIds() = flow {
    repeat(5) {
        delay(200.milliseconds) // Simular la latencia de la base de datos
        log("Emitiendo el ID: $it")
        emit(it)
    }
}

suspend fun getProfileFromNetwork(id: Int) = run {
    delay(1.seconds)
    "Profile[$id]"
}

fun main() {
    val ids = getAllUserIds()
    runBlocking {
        ids
            .onStart { log("Obteniendo perfiles de usuarios...") }
            .buffer(
                1,
                onBufferOverflow = BufferOverflow.DROP_OLDEST
            )
            .map { getProfileFromNetwork(it) }
            .collect { log("Obtenido perfil $it") }
    }
}