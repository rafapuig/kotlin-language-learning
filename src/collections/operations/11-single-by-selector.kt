package collections.operations

import collections.model.people

/**
 * Si necesitamos mapear antes de recuperar el elemento que cumple
 * el predicado
 *
 * - firstNotNullOf
 */

fun testFirstNotNullOf() {
    /**
     * Obtener la edad de la primera persona adulta
     */
    val firstAdultAge = people.firstNotNullOf { person ->
        person.age.takeIf { age ->
            age >= 18
        } // Mapea a la edad si >=18 si no mapea a valor null
    }
    println(firstAdultAge)
}

fun testFirstNotNullOfOrNull() {
    /**
     * Obtener la edad de la primera persona senior
     * Si no encuentra ninguna devuelve null no lanza excepción
     */
    val firstSeniorAge = people.firstNotNullOfOrNull { person ->
        person.age.takeIf { age ->
            age >= 65
        } // Mapea a la edad si >=18 si no mapea a valor null
    }
    println(firstSeniorAge ?: "No hay edades de senior")
}

fun main() {
    testFirstNotNullOf()
    testFirstNotNullOfOrNull()
}