package flows.cold

import kotlinx.coroutines.flow.FlowCollector

/**
 * Los cold flows de Kotlin son una astuta combinación de
 * funciones suspendibles y lambdas con receptor
 *
 * Solo requiere de dos interfaces:
 * - Flow
 * - FlowCollector
 */

interface Flow<out T> {
    suspend fun collect(collector: FlowCollector<T>)
}

interface FlowCollector<in T> {
    suspend fun emit(value: T)
}

/**
 * La función builder flow tiene como parámetro un objeto función de extensión para
 * un receptor de tipo FlowCollector
 * (lo que permite pasar como argumento una lambda con receptor implícito de tipo FlowCollector)
 * y llamar dentro de la lambda a this.emit porque el receptor implícito es un FlowCollector
 *
 * La función emit llama a la lambda pasada a la función collect
 *
 * Al final, lo que tenemos son dos lambdas llamándose la una a la otra
 * - Llamar a collect invoca la lambda de la función flow
 * - cuando el código de la lambda de la función flow llama a emit, este llama a la
 *   lambda pasada a la función collect
 * - y cuando la lambda de collect termina su ejecución se retoma la lambda de la función flow
 */