package containers.collections.exercises.operations

import imperative.controlflow.loops.for_iterate.map

/**
 * teeing
 *
 * Procesamos la misma colección en dos ramas
 * en cada una realizamos una operación distinta con la misma colección
 * y finalmente podemos combinar los resultados con la operación merge
 * T - tipo de los elementos de la colección
 * A - tipo del resultado de la operación sobre la colección en la rama 1
 * B - tipo del resultado de la operación sobre la colección en la rama 2
 * R - tipo del resultado de la operación de combinación de los resultados A y B
 */
inline fun <T, A, B, R> Iterable<T>.teeing(
    f1: (Iterable<T>) -> A,
    f2: (Iterable<T>) -> B,
    merge: (A, B) -> R
): R = merge(f1(this), f2(this))


fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val average = numbers.teeing(
        {
            it.sum()
        },
        {
            it.count()
        }
    ) { sum, count -> sum / count }
}