package flows.hot.state.updating

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
         * Hay que proporcionarle una lambda que diga como dado un valor previo
         * se calcula el nuevo valor
         * Si dos actualizaciones se producen en paralelo se ejecuta cada vez la
         * función update pero con el nuevo valor actualizado
         */
        //_count.update { it + 1 }
        /**
         * Dado que la propiedad value es de lectura y escritura
         * podemos estar tentados a incrementarla directamente mediante el operador++
         * (pero eso no es una operación atómica, tiene varios pasos:
         * 1. leer el valor actual
         * 2. calcular el nuevo valor incrementado
         * 3. escribir el nuevo valor
         * si dos hilos leen el valor actual al mismo tiempo una de los incrementos se pierde)
         */
        _count.value++
    }
}

fun main() {
    val counter = Counter()

    /**
     * Utilizamos el dispatcher por defecto y lanzamos
     * 10.000 corrutinas que heredan este dispatcher en el contexto
     * para que los incrementos del valor del estado se distribuyan
     * entre multiples hilos
     */
    runBlocking(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                counter.increment()
            }
        }
    }

    /**
     * Podemos comprobar si usamos la versión que incrementa directamente el
     * valor del estado mediante el operador ++ que el resultado es mucho menor que 10.000
     * Pero si usamos la función update entonces obtenemos el resultado esperado de 10.000
     */
    println(counter.count.value)
}