package coroutines.channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

private val channel = Channel<Int>()

fun main() {

    runBlocking {

        launch {
            (1..5).forEach { n ->
                val square = n * n
                println("Enviado $square")
                channel.send(square)
            }
        }

        repeat(5) {
            println("Recibido ${channel.receive()}")
        }
    }

}
