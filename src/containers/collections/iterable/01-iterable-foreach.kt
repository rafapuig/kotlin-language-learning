package containers.collections.iterable

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

fun main() {
    testForEachLoop()
    testForEachFunction()
}