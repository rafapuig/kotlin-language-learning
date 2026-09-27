package generics.runtime

/**
 * De una instancia de una clase genérica
 * no podemos averiguar el valor del argumento de tipo
 * usado cuando se creó la instancia
 *
 * Ni de una función genérica podemos saber dentro del cuerpo de la función el valor del argumento de tipo
 * usado cuando se llamó a la función
 */

// fun <T> isA(value: Any) = value is T // ERROR, descomentar para ver la información del error

/**
 * Caso especial, si la función es inline
 * Los parámetros de tipo de las funciones inline se pueden recrear (reified)
 * Podemos conocer el valor del argumento de tipo en tiempo de ejecución
 *
 * Sí declaramos una función como inline,
 * podemos marcar el parámetro de tipo para que sea revivido mediante la palabra clave reified seguida del nombre
 * del parámetro de tipo
 */

inline fun <reified T> isA(value: Any) = value is T

fun testIsA() {
    println(isA<String>("Kotlin")) // true
    println(isA<String>(123)) // false
    println(isA<Number>(123.456)) // true
}


inline fun <reified T> Iterable<*>.myFilterIsInstance() : List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if(item is T) result += item
    }
    return result
}

fun testFilterInstance() {
    val elems = listOf("uno", 2, "tres", 4, "cinco", 6)
    // filterIsInstance selecciona los elementos de una lista que sean instancias
    // del tipo especificado como argumento de tipo en la llamada, en este caso String
    val strings = elems.filterIsInstance<String>()
    println(strings)

    println(elems.myFilterIsInstance<Int>())
}

fun main() {
    testIsA()
    testFilterInstance()
}

