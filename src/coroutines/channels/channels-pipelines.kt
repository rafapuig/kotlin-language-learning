@file:OptIn(ExperimentalCoroutinesApi::class)

package coroutines.channels

import coroutines.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.isActive
import kotlinx.coroutines.runBlocking

/**
 * PIPELINES
 *
 * Un pipeline es un patrón donde una corrutina está produciendo
 * un flujo de valores (posiblemente infinito)
 */

private fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce {
    var x = 1
    while (isActive) send(x++)
}

/** Y mientras otra corrutina está consumiendo estos valores
 * (realizando algún procesamiento de estos) y produciendo los resultados
 */

fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (x in numbers) send(x * x)
}

fun main() = runBlocking {
    val numbers = produceNumbers()
    val squares = square(numbers)

    repeat(5) {
        log("Recibido: ${squares.receive()}")
    }
    log("Completado!")

    // cancelamos todas las corrutinas hijas de la runBlocking
    coroutineContext.cancelChildren()
    /**
     * Equivale a cancelarlas una a una
     */
    //numbers.cancel()
    //squares.cancel()
}