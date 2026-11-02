package containers.collections.iterable

/**
 * Bucle for-each cin índices estilo programación imperativa
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

fun main() {
    testForEachLoopWithIndex()
    testForEachIndexedFunction()
}