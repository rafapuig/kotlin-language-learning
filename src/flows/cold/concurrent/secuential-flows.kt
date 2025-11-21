package flows.cold.concurrent

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

/**
 * El código del flow y del recolector se ejecutan en la misma corrutina
 */

private suspend fun getRandomNumber(): Int {
    delay(500.milliseconds)
    return Random.nextInt()
}

private val randomNumbers = flow {
    repeat(10) {
        emit(getRandomNumber())
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
