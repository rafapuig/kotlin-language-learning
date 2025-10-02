package collections

import collections.model.people

/**
 * filter
 *
 * Crea una nueva colección
 * con los elementos que pasan el filtro predicado
 * no transforma los elementos
 * si los elementos son de tipo T ...
 * ... los de la lista resultante son de tipo T
 */

fun testFilter1() {
    val list = listOf(1, 2, 3, 4, 5)
    val result = list.filter { it % 2 == 0 }
    println(result)
}

fun testFilter2() {
    val result = people.filter { it.age > 18 }
    println(result)
}

/**
 * map
 * Transforma los elementos de la colección
 * aplicando la función de transformación a cada elemento
 * y devuelve una lista con la misma cantidad de elementos
 * que la original
 * Corolario:
 * La lista resultante puede ser de distinto tipo de elementos
 */

fun testMap1() {
    val list = listOf(1, 2, 3, 4, 5)
    val result = list.map { it * it }
    println(result)
}

fun testMap2() {
    val result = people.map { it.name }
    println(result)
}

fun testMaxByOrNull() {
    // Edad de la persona más vieja
    val maxAge = people.maxByOrNull { it.age }?.age

    val maxAge1 = people.map { it.age }.max()
    val maxAge2 = people.maxOfOrNull { it.age }

    //Personas que tienen la misma edad que la persona más vieja
    val result = people.filter { it.age == maxAge }
    println(result)
}

/**
 * Si el filtrado o transformación depende del índice (posición)
 * en la lista, la funciones hermanas son:
 * - filterIndexed
 * - mapIndexed
 */

fun testFilterIndexed() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val filtered = numbers.filterIndexed { index, element ->
        index % 2 == 0 && element > 5
    }
    println(filtered) // 7,9
}

fun testMapIndexed() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val mapped = numbers.mapIndexed { index, element ->
        index + element
    }
    println(mapped)
}

/**
 * En el caso de mapas
 * podemos filtrar por claves (filterKeys) y valores (filterValues)
 * y transformar claves (mapKeys) y valores (mapValues)
 */

fun testMapValues() {
    val numbers = mapOf(0 to "cero", 1 to "uno", 2 to "dos")
    val result = numbers.mapValues { it.value.uppercase() }
    println(result)
}

fun main() {
    testFilter1()
    testFilter2()
    testMap1()
    testMap2()
    testMaxByOrNull()
    testFilterIndexed()
    testMapIndexed()
}
