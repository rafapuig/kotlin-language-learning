package flows.cold

import coroutines.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Como hemos dicho anteriormente
 * La función collect se suspende hasta que todos los elementos emitidos
 * por el flow has sido recolectados
 * y procesados (ejecutado el bloque pasado como argumento a collect)
 *
 * Un flow puede emitir infinitos elementos, lo que podría dejar a la función collect
 * suspendida indefinidamente
 *
 * Para detener la recolección de elementos del flow antes de que todos los elementos
 * hayan sido procesados podemos cancelarlo
 *
 * Para cancelar un flow se usan los mecanismos de cancelación de las corrutinas,
 * para cancelar el flow se cancela la corrutina del recolector.
 * La recolección se detendrá en el siguiente punto de suspension / cancelación
 */
private val counterFlow = flow {
    var x = 0
    while (true) {
        x++
        log("Emitiendo  $x!")
        emit(x) // Posible punto de suspensión / cancelación
        delay(200.milliseconds)
    }
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */
fun main() = runBlocking {
    val collector = launch(CoroutineName("collector")) {
        counterFlow.collect {
            log("Recolectado $it")
        }
    }
    delay(3.seconds)
    collector.cancel()
}