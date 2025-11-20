package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

private suspend fun doCpuHeavyWork(): Int {
    log("Estoy trabajando...")
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
            /**
             * Este bucle se repetirá indefinidamente hasta
             * que se cancele la corrutina
             */
            while (isActive) {
                doCpuHeavyWork()
            }
        }

        delay(600.milliseconds)
        /**
         * Al cancelar la tarea (corrutina) la propiedad isActive del contexto de la corrutina
         * pasa a valer true, lo que permitirá decidir si parar o seguir
         * (lo normal sería liberar los recursos y parar)
         */
        log("Cancelando la corrutina hija...")
        job.cancel()
    }
}