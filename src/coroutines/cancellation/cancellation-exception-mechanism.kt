package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.coroutines.cancellation.CancellationException
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * El mecanismo general para cancelar corrutinas funciona
 * mediante el lanzamiento de un un tipo de exception especial: CancellationException
 * en lugares especiales. Estos lugares son principalmente los puntos de suspensión
 *
 * Una corrutina cancelada lanza una CancellationException en un punto donde se suspenda
 * la ejecución (donde se pause).
 */

/**
 * Como ejemplo, esta función solamente se puede suspender donde se pausa,
 * por tanto, solamente podría dar como resultado A o ABC,
 * pero nunca AB porque entre B y C no hay punto donde se pueda suspender
 */
suspend fun demo() {
    coroutineScope {
        log("A")
        delay(100.milliseconds)
        log("B")
        log("C")
    }
}

/**
 * Hay que tener cuidado de no "tragarse" accidentalemente las excepciones de cancelación *
 */

suspend fun doWork() {
    delay(500.milliseconds)
    throw UnsupportedOperationException("No funciona!")
}

fun main() = runBlocking<Unit> {
    /**
     * Después de 2 segundos la funcion withTimeoutOrNull solicita la cancelacion
     * de su scope de corrutina hija
     * La siguiente vez que se ejecuta delay dentro de doWork se lanza
     * la excepcion CancellationException..
     */
    withTimeoutOrNull(2.seconds) {
        while (true) {
            try {
                doWork()
            }
            /**
             * Sin embargo, dado que el bloque catch se traga todo tipo de excepción
             * el código continua infinitamente por el bucle while
             * Podemos arreglarlo de varias maneras:
             * 1) relanzando la excepción
             * 2) no capturando la excepción
             * (cuidado con usar Exception, IllegalStateException, RuntimeException, Exception o Throwable)
             */
            // Arreglo 2, cambia Exception por UnsupportedOperationException
            catch (e: Exception) {// Se traga todo tipo de excepción (incluso la de cancelación)
                println("Error: ${e.message}")
                // Arreglo 1, relanzar la excepción (descomentar)
                //if (e is CancellationException) throw e
            }
        }
    }
}
