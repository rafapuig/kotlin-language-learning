package coroutines.errors.propagation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Los supervisores previenen que el padre y las hermanas sean canceladas
 *
 * Los supervisores sobreviven al fallo de alguno de sus hijos
 * - no cancelan a sus otras corrutinas hijas
 * - y no propagan la excepción más hacia arriba en la jerarquía de concurrencia estructurada
 */

fun main(): Unit = runBlocking {
    /**
     * El supervisor previene que el hijo cancele la corrutina padre
     */
    supervisorScope {//#1
        launch {
            try {
                while(true) {
                    println("Latido!")
                    delay(500.milliseconds)
                }
            } catch (e: Exception) {
                println("Latido terminado $e")
                throw e
            }
        }
        launch {//#2
            delay(1.seconds)
            /**
             * Lanzamos una excepción no controlada en la corrutina hija 2
             */
            throw UnsupportedOperationException("Oh!")
        }
    }
}