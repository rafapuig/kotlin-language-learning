package imperative.functions

/**
 * Sintaxis

fun nombreFuncion(nombre_parámetro1: Tipo, nombre_parámetro2: Tipo, ...) : TipoRetorno {
// cuerpo de la función (function body)
}

 */

/**
 * Empieza por la keyword fun
 * seguida del nombre de la función y unos paréntesis
 * dentro de los paréntesis se declara la lista de parámetros, separados por `,`
 *
 * Un parámetro se declara mediante nombre : tipo
 *
 * Los parámetros son inmutables (RO) --> (equivalente a poner `final` delante del parámetro si fuera Java)
 *
 * nombre de función + lista de parámetros = firma (signature) de la función
 *
 * La firma se usa para determinar que versión de sobrecarga de la función llamar en caso de sobrecarga
 *
 * Después de la lista de parámetros se continúa con un `:` seguido del tipo de retorno de la función
 * Si la función no devuelve nada se omiten tanto los  `:` como el tipo de retorno
 * - se entiende Unit como tipo devuelto implícitamente (equivale al tipo void de Java)
 */

fun calc(a: Int, b: Int): Int {
    // No se pueden mutar las variables que son parámetros de entrada de la función (son finales)
    //a++
    //b++
    //a = 0

    return a * 3 + b / 2
}

/**
 * Función con expression-body
 */
fun calc2(a: Int, b: Int) = a * b

fun max(a: Int, b: Int) : Int {
    /**
     * En Kotlin if es una expresión (que devuelve un resultado) lo que equivale al operador ternario de Java
     */
    return if (a > b) a else b // Return (a > b) ? a : b en Java
}


fun main() {
    // Llamada a la función mediante el nombre y proporcionado los argumentos entre paréntesis
    println(max(3, 2))
}
