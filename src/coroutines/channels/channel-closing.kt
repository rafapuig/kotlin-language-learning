package coroutines.channels

import coroutines.log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlinx.html.Entities

private val channel = Channel<Int>()

fun main() {

    runBlocking {

        launch {
            (1..5).forEach { n ->
                val square = n * n
                log("Enviado $square")
                channel.send(square)
            }
            channel.close() // Cierra para indicar que ya esta todo enviado
        }

        /**
         * El bucle for itera sobre el canal hasta que se cierre
         */
        for(number in channel) {
            log("Recibido $number")
        }
        log("Completado!")

        //channel.receiveAsFlow().collect { println(it) }
         //   println("Recibido ${channel.receive()}")
        //}
    }

}
