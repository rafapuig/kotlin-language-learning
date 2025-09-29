package collections.functional

import collections.model.Person
import collections.model.people


/**
 * Las operaciones de agregado devuelven un valor simple
 * basado en el contenido de la colección
 *
 * Tenemos: *
 * - minOrNull y maxOrNull que devuelven el mínimo y maximo, null si vacía
 * - average devuelve la media de una colección de Number
 * - sum devuelve la suma de los elementos de una colección de Number
 * - count devuelve el número de elementos
 */

val numbers = listOf(56, 78, 45, 32, 9, 90, 14)

/**
 * Estas operaciones no son funciones de orden superior
 * No reciben como argumento una función (lambda)
 */
fun testAggregateOperations() {
    val min = numbers.minOrNull()
    val max = numbers.maxOrNull()
    val average = numbers.average()
    val sum = numbers.sum()
    val count = numbers.count()
    println("min: $min, max: $max")
}

fun testAverage() {
    val averageAge = people.map { it.age }.average()
    println("Average age: $averageAge")
}

/**
 * Otro grupo de operadores de agregado devuelven
 * el maximo o mínimo a partir de una función de selección
 * o de un comparador
 *
 * Devuelven el elemento:
 * - maxByOrNull (minByOrNull) mediante una función selector devuelven el max (min) elemento
 * - maxWithOrNull (minWithOrNull) mediante un comparador devuelven el máximo (min) elemento
 * Devuelven en valor:
 * - maxOfOrNull (minOfOrNull) mediante selector devuelven el valor max o min
 * - maxOfWithOrNull (maxOfWithOrNull) mediante comparador devuelven el valor max o min
 *
 * Todas devuelven null en colecciones vacías
 *
 * Si lo que queremos es que lancen una excepción NoSuchElementException
 * usamos los mismos nombres pero sin el sufijo OrNull
 */

fun testMax() {
    val oldest1 = people.maxBy { it.age }
    val oldest2 = people.maxWith(compareBy { it.age })

    val maxAge1 = people.maxOf { it.age }
    val maxAge2 = people.maxWith(compareBy { it.age })
}

/**
 * Además, tenemos la suma a partir de un selector
 *
 * sumOf
 */

fun testSumOf() {
    val result = people.sumOf { it.age }
    println(result)
    people.map { it.age }.average()
}