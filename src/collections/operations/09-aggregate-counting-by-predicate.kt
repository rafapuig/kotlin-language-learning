package collections.operations

import collections.model.*

val isAdult = { person: Person -> person.age > 18 }

/**
 * count
 *
 * Cuenta cuantos elementos satisfacen el predicado
 */

fun testCount() {
    // Count sin argumentos cuenta todos los elementos de la colección
    val numPersons = people.count()
    println("Numero de personas: $numPersons")

    // Con un argumento objeto de tipo función predicado (T) -> Boolean
    // Cuenta solamente aquellos que pasar el filtro del predicado
    val numAdults = people.count(isAdult)
    val numAdults2 = people.count { isAdult(it) } // otra forma de llamar a count pero pasando una lambda
    println("Numero de personas adultas: $numAdults")

    // Contar cuantas personas de la colecciñon tiene 65 o más años
    val numSeniors = people.count { it.age >= 65 }
    println("Numero de personas seniors: $numSeniors")

    // Contar cuantos son hombres
    val numMen = people.count { it.gender == Gender.MALE }
    println("Numero de hombres: $numMen")

    // Ineficiente (porque crea una lista filtrada en memoria para luego obtener su tamaño)
    val numFemale = people.filter { it.gender == Gender.FEMALE }.size
    println("Numero de mujeres: $numFemale")
}

fun main() {
    testCount()
}