package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.time.Duration.Companion.milliseconds

/**
 * La cancelación el Kotlin es cooperativa
 * las funciones suspendibles tienen que proporcionar la lógica que las
 * hace cancelables a sí mismas (tienen que cooperar)
 *
 * Cuando el código de una función hace una llamada a una función suspendible
 * automáticamente introduce en el lugar de esa llamada un punto de suspensión
 * y, por tanto, de cancelación
 */

/**
 * Simulamos un cálculo que hace un uso intensivo de la CPU mediante el incremento
 * de un contador durante 500 milisegundos
 *
 * ¡Esta función, aunque declarada como suspendable, no contiene ningún punto de suspensión!!
 *
 * Como no contiene ningún punto de suspensión no se puede cancelar, no hya ningún
 * punto en el que lanzar la CancellationException
 */
private suspend fun doCpuHeavyWork(): Int {
    log("Estoy trabajando!")
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
        /**
         * Si introducimos un punto de suspension en la función (cooperamos)
         * la función podrá ser cancelada
         */
        //delay(100.milliseconds)
        /**
         * Aunque obviamente, no vamos a querer introducir un retraso artificial
         * en la computación solamente para dar soporte de cancelación
         * Existen otras formas de introducir puntos de suspensión (cancelación)
         * las funciones ensureActive y yield, asi como la propiedad isActive
         */
        yield()
    }
    return counter
}

fun main() {
    runBlocking {
        val job = launch {
            repeat(5) {
                doCpuHeavyWork()
            }
        }
        /**
         * Al esperar 600 milisegundos antes de intentar cancelar la corrutina
         * podríamos pensar que veremos solamente 2 veces "Estoy trabajando"
         * una a los 0 segundos (nada más iniciar)
         * y otra a los 500 ms (segunda llamada tras terminar la primera a doHeavyWork)
         * y ya no una tercera porque sería a los 500 + 500 = 1000 ms
         * y supuestamente cancelamos a los 600 ms
         *
         * ¡Sin embargo, vemos las 5 repeticiones!!!
         */
        delay(600.milliseconds) // 500 + 100
        job.cancel()
    }
}