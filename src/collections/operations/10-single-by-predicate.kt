package collections.operations.testing.aggregate

import collections.model.*

/**
 * Disponemos de funciones que nos devuelven un elemento de la lista
 * que cumple un predicado
 * - first (el primero que lo cumple)
 * - last  (el último que lo cumple)
 *
 * Si no encuentran ningún elemento que cumpla el predicado lanzar una excepción
 */

fun Person.isAdult() = age > 18


fun testFirst() {
    val firstAdult = people.first { it.isAdult() }
    println(firstAdult.name)

    try {
        val firstSenior = people.first { it.age >= 65 }
    } catch (e: NoSuchElementException) {
        println(e.message)
    }
}

fun testLast() {
    val lastAdult = people.first { it.isAdult() }
    println(lastAdult.name)
}

/**
 * Si no queremos que se lance una excepción podemos usar
 * las versiones que devuelven null si no encuentran ningún
 * elemento que cumpla el predicado
 * - firstOrNull
 * - lastOrNull
 */

fun testFirstOrNull() {
    val firstMale = people.firstOrNull { it.gender == Gender.MALE }
    /**
     * Al devolver un tipo anulable Person?
     * tenemos que utilizar el operador de llamada seguro
     */
    println(firstMale?.name ?: "Ninguno encontrado")
}

fun testLastOrNull() {
    val lastSenior = people.lastOrNull { it.age >= 65}
    println(lastSenior?.name ?: "Ningún Senior encontrado")
}




/**
 * find
 *
 * Devuelve el primer elemento que cumple el predicado o null
 * Es un alias de firstOrNull
 *
 * findLast es sinónimo de lastOrNull
 */

fun testFind() {
    // Primer menor de edad o null
    val firstNotAdult = people.find { !it.isAdult() }
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
    testFirst()
    testLast()
    testFirstOrNull()
    testLastOrNull()
    testFind()
}