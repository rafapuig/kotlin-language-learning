package collections

import collections.model.people

/**
 * Agregar información de una colección
 * A partir de una colección de valores devolver uno solo
 *
 * Se llega al valor final gradualmente a base de acumular los resultados intermedios
 * en un acumulador
 * La lambda se invoca para cada elemento y el acumulador
 * y devuelve el acumulador actualizado
 * teniendo en cuanta lo que aporta ese elemento al resultado final
 */

/**
 * reduce
 *
 * Empieza con el primer valor en el acumulador
 * La lambda empieza invocándose para el segundo elemento
 */

fun testReduce() {
    val list = listOf(1, 2, 3, 4, 5)
    val summed = list.reduce { acc, elem -> acc + elem }
    println(summed)

    val multiplied = list.reduce { acc, elem -> acc * elem }
    println(multiplied)
}

/**
 * fold
 *
 * Como valor inicial del acumulador podemos elegir un valor arbitrario
 * La lambda empieza invocándose desde el primer elemento
 */

fun testFold() {
    val sumAges = people.fold(0) { acc, elem -> acc + elem.age }
    println(sumAges)
}

/**
 * Para obtener la lista de resultados intermedios
 * - runningReduce
 * - runningFold
 */

fun testRunningReduce() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val summed = numbers.runningReduce { acc, elem -> acc + elem }
    println(summed)
}

fun testRunningFold() {
    val accAges = people.runningFold(0) { acc, elem -> acc + elem.age }
    println(accAges)
}


fun main() {
    testReduce()
    testFold()
    testRunningReduce()
    testRunningFold()
}