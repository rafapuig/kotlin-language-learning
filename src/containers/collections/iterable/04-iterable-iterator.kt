package containers.collections.iterable

import org.junit.jupiter.api.Test

fun testIterableIterator() {
    //Obtenemos un iterador
    val iterator = NAMES.iterator()

    //Repetimos el bucle mientras el iterador diga que hay elemento siguiente
    while (iterator.hasNext()) {
        val name = iterator.next() //Obtenemos el siguiente elemento
        println(name)
    }
    // Hemos consumido el iterador
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


fun main() {
    testIterableIterator()
    testIterableIteratorWithIndex()
    testIterableIteratorForEachRemaining()
}