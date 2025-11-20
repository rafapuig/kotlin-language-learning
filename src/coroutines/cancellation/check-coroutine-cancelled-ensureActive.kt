package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Para determinar si una corrutina ha sido cancelada
 * podemos comprobar la propiedad de tipo Boolean isActive del scope
 * si es false indica que ya no está activa.
 *
 * Podemos, al comprobar que ya no está activa terminar el trabajo que consideremos
 * oportuno, cerrar recursos, etc antes de retornar.
 *
 * También podemos usar la función ensureActive()
 */

private suspend fun doCpuHeavyWork(): Int {
    log("Estoy trabajando!")
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
    }
    log("Trabajo terminado!")
    return counter
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */


fun main() {
    runBlocking {

        val job = launch(Dispatchers.Default) {
            repeat(5) {
                doCpuHeavyWork()
                /**
                 * La función ensureActive lanza una CancellationException
                 * si la corrutina ya no está activa
                 * lo cual cancela la corrutina de manera síncrona (en ese mismo instante)
                 * ensureActive es un punto de verificación síncrono del
                 * estado de una corrutina (no hace falta esperar a un punto de suspensión)
                 */
                ensureActive()
                /**
                 * Equivale a
                 */
                /*if(!isActive) {
                    throw CancellationException()
                }*/
            }
        }

        delay(600.milliseconds)
        log("Cancelando la corrutina hija...")
        job.cancel()
    }
}