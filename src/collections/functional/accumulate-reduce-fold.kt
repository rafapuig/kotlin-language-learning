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
 *
 * Tenemos varias versiones:
 * - reduce
 * - reduceRight (va desde el último hasta el primer elemento)
 * - reduceIndexed (con información de la posición o índice)
 * - reduceIndexedRight (desde el último y con índice)
 *
 * Y las correspondientes añadiendo el sufijo OrNull al nombre de la función
 * para que devuelvan null si la colección está vacía
 */

fun testReduce() {
    val list = listOf(1, 2, 3, 4, 5)
    val summed = list.reduce { acc, elem -> acc + elem }
    println(summed)

    val multiplied = list.reduce { acc, elem -> acc * elem }
    println(multiplied)
}

fun testReduceOldestPerson() {
    val oldest = people.reduce { oldest, person ->
        if(person.age > oldest.age) person else oldest
    }
    println(oldest)
}

fun testReduceIndexed() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenPositionSum = numbers.reduceIndexed { index, acc, elem ->
        if(index % 2 == 0) acc + elem else acc
    }
    println(evenPositionSum)
}


/**
 * fold
 *
 * Como valor inicial del acumulador podemos elegir un valor arbitrario
 * La lambda empieza invocándose desde el primer elemento
 *
 * Tenemos las versiones:
 * - foldRight
 * - foldIndexed
 * - foldRightIndexed
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