package coroutines.errors.propagation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun main(): Unit = runBlocking {
    /**
     * El supervisor previene que el hijo cancele la corrutina padre
     */
    supervisorScope {
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
        launch {
            delay(1.seconds)
            throw UnsupportedOperationException("Oh!")
        }
    }
}