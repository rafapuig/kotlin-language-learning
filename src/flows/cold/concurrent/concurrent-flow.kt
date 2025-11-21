package flows.cold.concurrent

import coroutines.log
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

private suspend fun getRandomNumber(): Int {
    log("Generando un numero aleatorio...")
    delay(500.milliseconds)
    return Random.nextInt()
}

private val randomNumbers = channelFlow {
    repeat(5) {
        this@channelFlow.launch {
            this@channelFlow.send(getRandomNumber())
        }
    }
}
/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */
fun main() = runBlocking {
    randomNumbers.collect {
        log(it)
    }
}