package flows.cold

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

/**
 * Cuando se invoca collect en un flow se ejecuta la lógica del Flow
 *
 * La función collect proporciona el código responsable de re recolectar elementos
 * del flow mediante una lambda que es llamada con cada emisión del flow.
 * La propia función collect se suspende hasta que todos los elementos emitidos
 * por el flow has sido recolectados y procesados
 *
 * Como recolectar un flow supone ejecutar el código del flow (que es suspendible)
 * la función collect es una función suspendible
 * Además el bloque proporcionado como argumento a la función collect
 * también puede suspenderse, lo que le permite llamar a funciones suspendibles.
 */

private val letters = flow {
    log("Emitiendo A!")
    emit("A") // Ofrece un valor al recolector del flow
    delay(200.milliseconds)
    log("Emitiendo B!")
    emit("B")
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */
fun main() = runBlocking {
    letters.collect {
        log("Recolectando $it!")
        delay(500.milliseconds)
    }
}

/**
 * En este ejemplo, todo corre en el misma corrutina!!!! la creada por runBlocking
 * y por tanto, en el mismo hilo!!!
 */

/**
 *      Flow builder            Collector
 *      log("Emitiendo A!")
 *      emit("A")
 *                              log("Recolectando A!")
 *                              delay(500.milliseconds)
 *      delay(200.milliseconds)
 *      log("Emitiendo B!")
 *      emit("B")
 *                              log("Recolectando B!")
 *                              delay(500.milliseconds)
 *
 */