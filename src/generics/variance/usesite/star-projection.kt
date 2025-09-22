package generics.variance.usesite

import kotlin.random.Random

/**
 * La sintaxis especial proyección estrella (star-projection) <*>
 *
 * Se usa para indicar que no tenemos information del argumento genérico
 *
 * Por ejemplo,
 * una lista de elementos de tipo desconocido
 * List<*>
 *
 * Nota:
 * MutableList<Any?> no es lo mismo que MutableList<*>
 * MutableList<Any?> es una lista que puede contener elementos de cualquier tipo
 * MutableList<*> es una lista de la que no sabemos el tipo de los elementos que contiene
 *
 * En la primera lista podríamos añadir cualquier elemento adicional
 * En la segunda no podemos añadir ninguno porque no sabemos de qué tipo son
 *
 * De la segunda aún podemos leer sus elementos
 * porque sean lo que sean seguro que los podemos tratar como Any?
 * (Any? es el supertipo de todos los tipos de Kotlin)
 *
 * La proyección estrella equivale a la proyección de salida out Any?
 *
 * Y equivale a la wildcard sin límites de Java <?>
 * Producer<*> equivale a Producer<?> en Java
 *
 * Nota: si el parámetro es contravariante
 * Consumer<in T>
 * la proyección estrella equivale entonces a Consumer<in Nothing>
 *

 */

fun main() {
    val list: MutableList<Any?> = mutableListOf('r', 10, "Kotlin")
    val chars: MutableList<Char> = mutableListOf('a', 'b', 'c')

    val unknownItems: MutableList<*> =
        if(Random.nextBoolean()) list else chars

    /**
     * Cuando no conocemos el tipo de los elementos
     * Podemos obtener los elementos como valores de tipo Any?
     * Es por eso que la proyección estrella
     * se puede considerar como una out projection
     * concretamente out Any?
     * MutableList<*> actúa como si fuera MutableList<out Any?>
     */
    val first = unknownItems.first()
    println(first)
    //unknownItems.add(45) // Prohibido por el compilador
}

/**
* Se usa la proyección estrella cuando la información sobre el tipo del argumento no importa
* - solamente se leen datos sin importar de qué tipo son
* - no se usan métodos que refieran al parámetro de tipo en su firma
*/

/**
 * La función printFirst NO es una función generica
 * A printFirst se le puede pasar cualquier lista
 */
fun printFirst(list: List<*>) {
    // el metodo isNotEmpty no usa el parámetro genérico en su firma
    if (list.isNotEmpty()) {
        // first devuelve un Any? pero no importa, es suficiente
        // para pasarlo al println y mostrarlo por consola
        println(list.first())
    }
}

/**
 * Tenemos la alternativa de crear una version generica de la función
 */

fun <T> printFirstGeneric(list: List<T>) {
    if (list.isNotEmpty()) {
        println(list.first()) // Aquí first devuelve un valor de tipo T
    }
}