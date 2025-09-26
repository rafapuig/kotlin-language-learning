package collections

import collections.model.*

/**
 * all, any, none
 *
 * Comprobar si todos, alguno o ninguno de los elementos de una colección
 * cumplen una condición predicado
 */

val isAdult = { person: Person -> person.age > 18 }

fun testAllPeopleAreAdult() {
    val allThePeople = people.all(isAdult)
    println(allThePeople)
}

fun testAnyPersonIsAdult() {
    val anyPerson = people.any(isAdult)
    println(anyPerson)

    /**
     * Que exista algún elemento que cumple la condición
     * es lo mismo que no la cumpla ninguno (que todos no la cumplan)
     */
    val notAll = !people.all { !isAdult(it) }
    println(notAll)
}

fun testNone() {
    /**
     * none es lo mismo que !any
     */
    val noneIsOlderThan65 = people.none { it.age > 65 }
    println(noneIsOlderThan65)

    val notAnyIsOlderThan65 = people.any { it.age > 65 }
    println(notAnyIsOlderThan65)
}

/**
 * Con colecciones vacías
 */

fun testOnEmptyCollections() {
    println(emptyList<Int>().any { it == 0 }) // false
    println(emptyList<Int>().none { it == 0 }) // true, lo contrario que any
    println(listOf(0, 1).all { it == 0 }) // true, si esta vacía "todos" cumplen
}

/**
 * count
 *
 * Cuenta cuantos elementos satisfacen el predicado
 */

fun testCount() {
    val numPersons = people.count()
    val numAdults = people.count(isAdult)
    val numSeniors = people.count { it.age >= 65 }
    val numMen = people.count { it.gender == Gender.MALE }

    // Ineficiente
    val numFemale = people.filter { it.gender == Gender.FEMALE }.size
}


/**
 * find
 *
 * Devuelve el primer elemento que cumple el predicado
 */

fun testFind() {
    // Primer menor de edad o null
    val firstNotAdult = people.find { !isAdult(it) }
    println(firstNotAdult)

    val firstOrException = try {
        people.first { it.age > 1000 }
    } catch (e: NoSuchElementException) {
        Person("Perico Palotes", 55, Gender.MALE)
    }
    println(firstOrException)

    // find es sinónimo de firstOrNull
    val firstOrNull = people.firstOrNull { it.age > 1000 }
    println(firstOrNull)
}

fun main() {
    testFind()
}