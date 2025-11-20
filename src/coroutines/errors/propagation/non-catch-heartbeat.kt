package coroutines.errors.propagation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

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
     * Esta corrutina termina con una excepción no controlada
     */
    launch {
        delay(1.seconds)
        /**
         * En el momento en que una corrutina hermana lanza una excepcion
         * la corrutina que "late" también se cancela
         */
        throw UnsupportedOperationException("Oh!")
    }
}