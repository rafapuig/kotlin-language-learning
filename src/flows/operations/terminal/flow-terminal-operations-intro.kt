package flows.operations.terminal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch

/**
 * collect
 * collectIndexed
 * collectLatest
 * fold
 * reduce
 * first
 * firstOrNull
 * last
 * lastOrNull
 * single
 * singleOrNull
 * toList
 * toSet
 * toCollection
 * any
 * all
 * none
 * count
 * count(predicate)
 * launchIn(scope)
 * toMap / toMutableMap (para Flows de pairs)
 */

val flow = flowOf(1, 2, 3, 4, 5)
/**
 * 🟦 1. Colección y consumo
 *
 * Estos son los más comunes:
 *
 * ✔ collect { }
 *
 * Consume el Flow y ejecuta una acción por cada valor.
 *
 */

private suspend fun collectDemo() {
    flow.collect { println(it) }
}

/**
 * ✔ collectIndexed { index, value -> }
 *
 * Igual que collect pero con índice.
 *
 *
 * ✔ collectLatest { }
 *
 * Cancela el bloque previo si llega un valor nuevo.
 */

/**
 * 🟩 2. Conversión a estructuras
 * ✔ toList()
 * ✔ toSet()
 * ✔ toCollection()
 *
 * Convierte un Flow en una colección.
 *
 */

/**
 * 🟧 3. Reducción
 *
 * Operadores que producen un solo valor:
 *
 * ✔ reduce
 *
 * Acumula valores usando el primero como inicial.
 */

suspend fun reduceDemo() {
    flow.reduce { acc, value -> acc + value }
}

/**
 * ✔ fold(initial)
 *
 * Acumula valores usando un valor inicial.
 */

suspend fun foldDemo(initial: Int = 0) {
    flow.fold(initial) { acc, value -> acc + value }
}

/**
 * ✔ first()
 *
 * Toma el primer valor y cancela el Flow.
 *
 * ✔ firstOrNull()
 *
 *
 * ✔ last()
 *
 * Recolecta todo y devuelve el último valor.
 *
 * ✔ lastOrNull()
 */


/**
 * 🟨 4. Recolección condicional
 * ✔ single()
 *
 * Espera exactamente un valor.
 *
 * ✔ singleOrNull()
 *
 * Devuelve null si no hay ninguno.
 */

/**
 * 🟫 5. Comprobación / booleanos
 * ✔ any(predicate)
 *
 * ¿Algún elemento cumple?
 *
 * ✔ all(predicate)
 *
 * ¿Todos cumplen?
 *
 * ✔ none(predicate)
 *
 * ¿Ninguno cumple?
 */

/**
 * 🟥 6. Contadores
 * ✔ count()
 *
 * Cuenta cuántos elementos hay.
 *
 * ✔ count { predicate }
 *
 * Cuenta cuántos cumplen.
 */

/**
 * 🟪 7. Acciones finales
 *
 * ✔ launchIn(scope)
 *
 * Inicia la recolección del Flow pero sin bloquear.
 */

fun launchInDemo() {
    val scope =
        CoroutineScope(SupervisorJob() + Dispatchers.Default)

    flow.launchIn(scope)

    /**
     * es un atajo de:
     */

    scope.launch {
        flow.collect()
    }
}