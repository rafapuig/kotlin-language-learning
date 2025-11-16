package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.time.Duration.Companion.milliseconds

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
        /**
         * La función yield es una funcion suspendible que introduce
         * un punto en el codigo donde se puede lanzar una CancellationException y cancelar
         * y además permite al dispatcher cambiar y ejecutar otra corrutina
         * (si hay alguna esperando)
         */
        yield()
    }
    return counter
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */


fun main() {
    runBlocking {
        val job1 = launch {
            repeat(5) {
                doCpuHeavyWork()
                if(!isActive) return@launch
            }
        }

        val job2 = launch {
            repeat(5) {
                doCpuHeavyWork()
                /**
                 * La función ensureActive lanza una CancellationException
                 * si la corrutina no está activa
                 */
                ensureActive()
            }
        }
    }
}