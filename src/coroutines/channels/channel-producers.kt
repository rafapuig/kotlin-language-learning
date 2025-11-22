package coroutines.channels

import coroutines.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import kotlinx.html.Entities

/**
 * El patrón donde una corrutina produce una secuencia de elementos
 * es bastante común.
 * Es parte del patrón productor-consumidor que vemos con frecuencia en código concurrente.
 *
 * Podemos abstraer el productor en forma de una función que recibe como argumento el canal,
 * pero tenemos una función builder
 *
 * - produce
 *
 * Esta función facilita la creación del productor, ¡Es una función builder de corrutinas!
 * El scope de esta corrutina creada por produce es ProducerScope
 * Un ProducerScope implementa tanto la interface CoroutineScope como la SendChannel
 * Gracias a esto la corrutina puede llamar directamente a la función send
 * El builder produce devuelve un ReceiveChannel en el que recibir los envíos
 * y que queda cerrado en cuanto termina la corrutina
 *
 * Y una función de extensión:
 *
 * - consumeEach que reemplaza el bucle for en el lado consumidor
 *
 */


/**
 * Si hacemos que una función que cree corrutinas esté definida como una
 * función de extension de CoroutineScope podemos confiar en la concurrencia
 * estructurada y que no tenemos corrutinas globales (en el GlobalScope)
 */
@OptIn(ExperimentalCoroutinesApi::class)
private fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) send(x * x)
}

fun main() = runBlocking<Unit> {
    val numbers = produceSquares()

    numbers.consumeEach {
        log("Recibido $it")
    }

    log("Completado!")
}
