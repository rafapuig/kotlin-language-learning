package containers.collections.operations.testing

import containers.collections.model.Person
import containers.collections.model.people


/**
 * all, any, none
 *
 * Comprobar si todos, alguno o ninguno de los elementos de una colección
 * cumplen una condición predicada
 */

val isAdult = { person: Person -> person.age > 18 }

fun testAllPeopleAreAdult() {
    val allThePeople = people.all(isAdult)
    println(allThePeople)
}

fun testAnyPersonIsAdult() {
    val anyAdult = people.any(isAdult)
    println(anyAdult)

    /**
     * Que exista algún elemento que cumple la condición
     * es lo mismo que no cumpla ninguno la contraria
     * Que sea falso que todas las personas no son adultas es porque al menos una lo es
     */
    val notAllAreNotAdults = !people.all { !isAdult(it) }
    println(notAllAreNotAdults)
}

fun testNone() {
    /**
     * none es lo mismo que !any
     */
    val noneIsOlderThan65 = people.none { it.age > 65 }
    println(noneIsOlderThan65)

    val notAnyIsOlderThan65 = !people.any { it.age > 65 }
    println(notAnyIsOlderThan65)
}

/**
 * Con colecciones vacías
 */

fun testOnEmptyCollections() {
    println(emptyList<Int>().any { it == 0 }) // false
    println(emptyList<Int>().none { it == 0 }) // true, lo contrario que any
    println(listOf(0, 1).all { it == 0 }) // true, si está vacía "todos" cumplen
}

fun main() {
    testAllPeopleAreAdult()
    testAnyPersonIsAdult()
    testNone()
}