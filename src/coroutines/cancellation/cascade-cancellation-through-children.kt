package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * Cuando se cancela una corrutina todas sus corrutinas hijas también son canceladas
 * (y a su vez las hijas de las hijas ...)
 */

fun main() = runBlocking {
    val job = launch {
        launch {// Corrutina hija
            launch {// Corrutina nieta
                launch { // Corrutina bisnieta
                    log("Corrutina iniciada")
                    delay(500.milliseconds)
                    log("Corrutina completada") // No se llegará a completar!!
                }
            }
        }
    }
    delay(200.milliseconds)
    /**
     * Cancelamos la corrutina padre gestionada mediante la referencia al objeto job
     * Lo que cancelará todas las corrutinas descendentes en la jerarquía
     */
    job.cancel()
}