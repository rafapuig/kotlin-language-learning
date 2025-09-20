package generics.runtime

/**
 * De una instancia de una clase generica
 * no podemos averiguar el argumento de tipo usado
 * cuando se creó la instancia
 *
 * Ni de una función generica podemos saber el argumento de tipo
 * usando cuando se llamó a la función
 */

// fun <T> isA(value: Any) = value is T // ERROR

/**
 * Excepción, si la función es inline
 * Los parámetros de tipo de las funciones inline se pueden recrear (reified)
 * Podemos conocer el valor del argumento de tipo en tiempo de ejecución
 */

inline fun <reified T> isOfType(value: Any) = value is T

private fun testIsA() {
    println(isOfType<String>("Kotlin")) // true
    println(isOfType<String>(123)) // false
}

fun testFilterInstance() {
    val elems = listOf("uno", 2, "tres")
    val strings = elems.filterIsInstance<String>()
    println(strings)
}

fun main() {
    testIsA()
    testFilterInstance()
}

