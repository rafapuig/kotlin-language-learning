package flows.hot.state

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Un caso especial en los sistemas concurrentes es seguir la pista
 * de algún valor que puede cambiar a largo del tiempo (estado de un valor)
 *
 * Para estos casos Kotlin proporciona los state flow
 *
 * Un state flow es una version especial de un shared flow que facilita
 * seguir la pista a los cambios de estado de una variable a lo largo del tiempo
 */

/**
 * Consideraciones a tratar:
 * - Como se crea un state flow y se expone a los subscriptores
 * - Como se actualiza el valor del state flow de forma segura (incluso con acceso paralelo)
 * - El concepto de conflation basada en igualdad (solo emitir cuando el valor realmente cambia)
 * - Como convertir un cold flow en un state flow
 */


class Counter {
    /**
     * Para crear un state flow creamos un MutableStateFlow como propiedad privada
     * y exponemos la variante de solo lectura de este
     * Proporcionamos el valor inicial en el constructor
     */
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increment() {
        /**
         * El lugar de emitir usamos la función update
         * La función update Actualiza el valor del estado de manera atómica
         */
        _count.update { it + 1 }
    }
}

fun main() {
    val counter = Counter()
    counter.increment()

    /**
     * Podemos acceder al valor actual del estado representado por el StateFlow
     * mediante la propiedad value
     */
    println(counter.count.value)
}