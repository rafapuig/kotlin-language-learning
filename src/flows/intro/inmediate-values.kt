package flows.intro

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

/**
 * Un flow te permite trabajar con los elementos a medida que son emitidos
 */

/**
 * La función devuelve un Flow de Ints
 */
private fun createValues(): Flow<Int> {
    /**
     * Usamos la función builder flow
     */
    return flow {
        log("Emitting 1...")
        /**
         * Para añadir elementos llamamos a emit
         * Cada elemento emitido se pasa inmediatamente al recolector
         */
        emit(1) // El primer elemento esta disponible al instante
        delay(1.seconds)
        log("Emitting 2...")
        emit(2) // El segundo está disponible después de un segundo
        delay(1.seconds)
        log("Emitting 3...")
        emit(3) // El tercero está disponible a los 2 segundos
        delay(1.seconds)
    } // La función retorna a los 3 segundos
}

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

fun main() = runBlocking {
    val flow = createValues()
    /**
     * Usamos collect para iterar ("recolectar") sobre los elementos que emite el flow
     * (los valores son logeados tan pronto como son emitidos
     * Ya no hace falta esperar a que estén todos los valores para iterarlos)
     */
    flow.collect { log(it) }
}