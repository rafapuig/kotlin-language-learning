package containers.collections.iterable


/**
 * Version casera del forEach de la biblioteca estándar de Kotlin
 */
inline fun <T> Iterable<T>.myForEach(action: (T) -> Unit) {
    for (element in this) {
        action(element)
    }
}

/**
 * Version casera del forEachIndexed de la biblioteca estándar de Kotlin
 */
inline fun <T> Iterable<T>.myForEachIndexed(action: (Int, T) -> Unit) {
    var index = 0
    for (element in this) {
        action(index++, element)
    }
}

fun testMyForEach() {
    NAMES.myForEach { println(it) }
}

fun testMyForEachIndexed() {
    NAMES.myForEachIndexed { index, name ->
        println("$index: $name")
    }
}

fun main() {
    testMyForEach()
    testMyForEachIndexed()
}