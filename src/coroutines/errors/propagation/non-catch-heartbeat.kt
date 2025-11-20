package coroutines.errors.propagation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Una corrutina cancela todas sus corrutinas hijas cuando una de sus hijas falla
 * (de manera predeterminada a no ser que use un Job de tipo Supervisor)
 */
/**
 * Cuando se produce una excepción no controlada por una corrutina hija
 * se propaga a la corrutina padre
 * El padre hace lo siguiente:
 * - cancela todos sus corrutinas hijas (para evitar trabajo innecesario)
 * - completa su propia ejecución con la misma excepción
 * - la propaga hacia arriba en la jerarquía
 *
 * Comportamiento util para corrutinas agrupadas en el mismo scope
 * Cuando una falla se evita trabajo innecesario cancelando el resto de corrutinas
 * en el mismo scope
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