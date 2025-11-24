package flows.cold

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds

/**
 * Crear un cold flow es directo
 *
 *
 * flow
 *
 * Existe una función builder (flow) que permite crear un nuevo flow
 * Declara un bloque con el modificador suspend, lo que permite llamar dentro del bloque
 * a funciones suspendibles
 *
 * emit (función suspendible)
 *
 * Dentro del bloque (lambda) de la función builder se puede llamar a la función
 * especial emit, que
 * - ofrece un valor al recolector del flow
 * - suspende la ejecución del builder hasta que el valor se haya procesado por el colector
 */

fun main() {
    /**
     * El flow generado es inerte
     * No se ejecuta hasta que se invoque a un operador terminal en el flow
     * que de inicio a la computación definida en el builder
     * Por eso se llama cold flow (interte por defecto hasta que es recolectado)
     */
    val letters = flow {
        log("Emitiendo A!")
        emit("A") // Ofrece un valor al recolector del flow
        delay(200.milliseconds)
        log("Emitiendo B!")
        emit("B")
    }
}

/**
 * Dado que llamar al builder flow no inicia ninguna actividad
 * podemos construir un flow en código regular (no suspendible)
 * Las funciones suspendibles se llaman dentro del bloque (argumento de la función flow)
 */

fun getNamesFromNetwork(): Flow<String> = flow {
    // aquí la llamada suspendible para conectar a la red
}

/**
 * Dado que el código dentro del bloque solo se ejecuta una vez esta siendo recolectado
 * es posible definir un flow que devuelva un numero infinito de elementos
 * (como en las secuencias)
 */

private val counterFlow = flow {
    var x = 0
    while (true) {
        emit(x++)
        delay(200.milliseconds)
    }
}
