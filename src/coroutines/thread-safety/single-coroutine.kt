package coroutines.`thread-safety`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        /**
         * Inicia una única corrutina en el dispatcher default (que es multihilo)
         * Corre en un hilo arbitrario
         * La lógica (instrucciones) se ejecutan secuencialmente
         */
        launch(Dispatchers.Default) {
            var x = 0
            repeat(10_000) {
                x++
            }
            println(x)
        }
    }
}