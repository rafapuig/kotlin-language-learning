package coroutines.cancellation

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Las funciones
 *
 * - withTimeout
 * - withTimeoutOrNull
 *
 * permiten aplicar restricciones de tiempo maximo que puede llevar un calculo
 *
 * Si se excede el tiempo
 * - withTimeout lanza una excepción TimeoutCancellationException
 * - withTimeoutOrNull devuelve null
 */

/**
 * La función calculateSomething tarda 3 segundos en realizar el calculo
 * y devolver el resultado
 */
suspend fun calculateSomething(): Int {
    delay(3.seconds)
    return 2 + 4
}

fun main() = runBlocking {
    val quickResult = withTimeoutOrNull(500.milliseconds) {
        calculateSomething()
    }
    println("Resultado con prisa: $quickResult") //null

    val slowResult = withTimeoutOrNull(5.seconds) {
        calculateSomething()
    }
    println("Resultado con tranquilidad: $slowResult")

    try {
        withTimeout(500.milliseconds) {
            val result = calculateSomething()
            println("Resultado: $result")
        }
    } catch (e: TimeoutCancellationException) {
        println("Se agotó el tiempo máximo!")
    }

}
