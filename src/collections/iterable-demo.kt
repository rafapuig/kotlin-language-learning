package collections.iterabledemo

import java.util.function.Consumer

val NAMES: Iterable<String> =
    listOf("Rafa", "Raul", "Rodrigo", "Ruben", "Ramon")

/**
 * Bucle for-each estilo programación imperativa
 */
fun testForEachLoop() {
    for (name in NAMES) {
        println(name)
    }
}

/**
 * Operación foreach
 *
 * Estilo programación funcional
 * Mediante la función de orden superior foreach
 * Es una función de extensión para un receptor de tipo Iterable<T> genérico
 */
fun testForEachFunction() {
    NAMES.forEach { name ->
        println(name)
    }
}

fun testForEachFunctionWithConsumerInterface() {
    val action: Consumer<String> = object : Consumer<String> {
        override fun accept(t: String) {
            println(t)
        }
    }

    // Este foreach no es un metodo de extensión (pertenece a la interfaz original de Java)
    NAMES.forEach(action)

    // Otra forma, si el interface no fuera funcional (habría que especificar el metodo)
    NAMES.forEach(action::accept)

    NAMES.forEach { name -> action.accept(name) }
    NAMES.forEach { action.accept(it) }

}

fun testForEachFunctionWithConsumerSAM() {
    val action: Consumer<String> = Consumer<String> { t -> println(t) }
    NAMES.forEach(action)
    NAMES.forEach(action::accept)
    NAMES.forEach { name -> action.accept(name) }
    NAMES.forEach { action.accept(it) }
}

fun testForEachFunctionWithFunctionTypeVariable() {
    val action: (String) -> Unit = { t -> println(t) }
    NAMES.forEach(action)
    NAMES.forEach { name -> action.invoke(name) }
    NAMES.forEach { name -> action(name) }
    NAMES.forEach { action(it) }
}

fun testForEachFunctionWithLambda() {
    NAMES.forEach { name -> println(name) }
    NAMES.forEach { println(it) }
}

/**
 * Bucle for-each estilo programación imperativa
 * En este caso obtenemos tanto el valor del elemento como su índice
 */
fun testForEachLoopWithIndex() {
    for ((index, name) in NAMES.withIndex()) {
        println("[$index] -> $name")
    }
}

/**
 * Operación forEachIndexed (funcional)
 * Espera un argumento de tipo función (Int, T) -> Unit
 */
fun testForEachIndexedFunction() {
    NAMES.forEachIndexed { index, name ->
        println("[$index] -> $name")
    }
}

fun testIterableIterator() {
    //Obtenemos un iterador
    val iterator = NAMES.iterator()

    //Repetimos el bucle mientras el iterador diga que hay elemento siguiente
    while (iterator.hasNext()) {
        val name = iterator.next() //Obtenemos el siguiente elemento
        println(name)
    }
}

fun testIterableIteratorWithIndex() {
    val iterator = NAMES.iterator().withIndex()

    while (iterator.hasNext()) {
        val (index, name) = iterator.next()
        println("[$index] -> $name")
    }
}

fun testIterableIteratorForEachRemaining() {
    val iterator = NAMES.iterator()
    var count = 0
    while (iterator.hasNext() && count < 2) {
        val name = iterator.next()
        println("nombre = $name")
        count++
    }

    iterator.forEachRemaining { name -> println("otro nombre = $name") }
}


inline fun <T> Iterable<T>.myForEach(action: (T) -> Unit) {
    for (element in this) {
        action(element)
    }
}


inline fun <T> Iterable<T>.myForEachIndexed(action: (Int, T) -> Unit) {
    var index = 0
    for (element in this) {
        action(index++, element)
    }
}

fun main() {
    testForEachLoop()
    testForEachFunction()
    testForEachLoopWithIndex()
    testForEachIndexedFunction()
    testIterableIterator()
    testIterableIteratorWithIndex()
    testIterableIteratorForEachRemaining()
}

