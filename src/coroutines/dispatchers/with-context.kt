package coroutines.dispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.math.PI
import kotlin.time.Duration.Companion.milliseconds

/**
 * En lugar de cambiar el dispatcher para la corrutina completa
 * podemos ser más precisos al referirnos donde queremos que se ejecute
 * alguna parte específica de una corrutina mediante el uso de la
 * funcion withContext
 */

/**
 * La función withContext
 * Permite cambiar el dispatcher dentro de una corrutina
 */

/**
 * En este ejemplo lanzamos una corrutina que realiza una tarea en background
 * que podría suspenderse. Cuando el resultado esté disponible, le decimos a
 * la corrutina que cambie al hilo de la UI mediante Dispatchers.Main
 * y realice una hipotética operación específica de la UI.
 */

suspend fun performBackgroundOperation(): Double {
    delay(1000.milliseconds)
    return PI
}

fun updateUI(value: Double) {
    println("Resultado: $value")
}

fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            val result = performBackgroundOperation()
            /**
             * El dispatcher Main es proporcionado por la dependencia
             * kotlinx-coroutines-android u otras
             * No está implementada en kotlinx-coroutines-core
             */
            withContext(Dispatchers.Main) {
                updateUI(result)
            }
        }
    }
}
