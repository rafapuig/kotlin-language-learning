package collections.operations.filtering.partition

import collections.model.people

/**
 * Con la operación partition podemos obtener la lista
 * de los elementos que cumplen el predicado,
 * pero además obtenemos una lista con los que no lo cumplen
 */

fun <T> Iterable<T>.particion(predicate: (T) -> Boolean): Pair<List<T>, List<T>> {
    val pass = mutableListOf<T>()
    val rest = mutableListOf<T>()
    forEach {elem ->
        with(if (predicate(elem)) pass else rest) {
            add(elem)
        }
    }
    return pass.toList() to rest.toList()
}

fun testPartition() {
    val numbers = listOf(56, 69, 34, 11, 73, 90, 5)
    val partition = numbers.partition { it % 2 == 0 }
    println(partition.first) // Números pares (cumplen el predicado)
    println(partition.second) // Resto de números de la lista
}

fun partitionDemo() {
    /**
     * Partition devuelve un Pair
     * que podemos desestructurar (deconstruir) en sus dos componentes
     * El primero contiene la lista de los elementos que cumplen el predicado
     * El segundo el resto
     */
    val (adults, notAdults) = people.partition {
        it.age >= 18
    }
    println(adults)
    println(notAdults)
}

fun main() {
    testPartition()
    partitionDemo()
}