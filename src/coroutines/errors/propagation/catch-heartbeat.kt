package coroutines.errors.propagation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * La concurrencia estructurada solo afecta a excepciones lanzadas a traves de
 * las fronteras de las corrutinas *
 */

/**
 * La forma más fácil de evitar esto es no permitir que la excepción salga
 * de los límites de la corrutina mediante un try-catch confinado a
 * la corrutina hija (dentro del cuerpo de una función suspendida)
 */


fun main(): Unit = runBlocking {

    launch {
        try {
            while (true) {
                println("Latido!")
                delay(500.milliseconds)
            }
        } catch (e: Exception) {
            println("Latidos terminados: $e")
            throw e
        }
    }
    /**
     * Esta corrutina hermana controla ella misma la excepción
     */
    launch {
        try {
            delay(1.seconds)
            throw UnsupportedOperationException("Oh!")
        } catch (e: UnsupportedOperationException) {
            println("Controlada $e")
        }
    }
}