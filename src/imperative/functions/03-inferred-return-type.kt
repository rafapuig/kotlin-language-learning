package func.omit.returned.type

/**
 * Omisión del tipo de retorno de una función
 *
 * Solamente para funciones con expression body
 * El compilador analiza el tipo de datos de la expresión (INFERENCIA DE TIPOS)
 * y usa ese tipo como el tipo de retorno de la función
 */

fun max(a: Int, b: Int) = if (a > b) a else b

/**
 * Habilitar y deshabilitar Inlay Type Hints Settings -> Editor -> Inlay hints -> Types -> Kotlin
 */

fun main() {
    println(max(1, 2))
}
