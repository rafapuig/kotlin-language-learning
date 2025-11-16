package coroutines.`thread-safety`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

/**
 * En este ejemplo tenemos a varias corrutinas incrementando el contador
 * algunas operaciones ocurren en paralelo dado que se están ejecutando en diferentes hilos
 */
fun main() {
    runBlocking {
        var x  = 0
        repeat(10_000) {
            /**
             * Lanzamos 10.000 corrutinas (en el dispatcher multihilo default)
             * que incrementan el contador una vez cada una
             */
            launch(Dispatchers.Default) {
                x++
            }
        }
        delay(1.seconds)
        println(x) // el resultado sera inferior a 10.000
    }
}