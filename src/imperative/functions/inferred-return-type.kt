package func.omit.returned.type

/**
 * Para funciones con expression body solamente
 * El compilador analiza el tipo de datos de la expresión
 * y usa ese tipo como el tipo de retorno de la función
 * INFERENCIA DE TIPOS
 */

fun max(a: Int, b: Int) = if (a > b) a else b

/**
 * Habilitar y deshabilitar Inlay Type Hints Settings -> Editor -> Inlay hints -> Types -> Kotlin
 */

fun main() {
    println(max(1, 2))
}
