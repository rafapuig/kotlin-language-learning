package flows.cold

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * Llamar a collect variar veces sobre un flow
 * dispara la ejecución del código del flow cada vez que se llama a collect para ese flow
 */

private val letters = flow {
    log("Emitiendo A!")
    emit("A") // Ofrece un valor al recolector del flow
    delay(200.milliseconds)
    log("Emitiendo B!")
    emit("B")
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */
fun main() = runBlocking {

    letters.collect {
        log("(1) Recolectando $it!")
        delay(500.milliseconds)
    }

    letters.collect {
        log("(2) Recolectando $it!")
        delay(500.milliseconds)
    }
}