package imperative.functions

/**
 * Sintaxis

fun nombreFuncion(parametro1: Tipo, parametro2: Tipo, ...) : TipoRetorno {
// cuerpo de la función (function body)
}

 */

/**
 * Empieza por la keyword fun
 * seguida del nombre de la función y unos paréntesis
 * dentro de los paréntesis se declara la lista de parámetros, separados por (,)
 *
 * Un parámetro se declara con nombre : tipo
 * Los parámetros son inmutables (RO)
 *
 * nombre de función + lista de parámetros = firma (signature) de la función
 *
 * La firma se usa para determinar que función llamar en caso de sobrecarga
 *
 * Después de la lista de parámetros se continua con un : seguido del tipo de retorno de la función
 * Si la función no devuelve nada se omite el : y el tipo de retorno
 * - se entiende tipo devuelvo Unit implícitamente (equivale al tipo void)
 */

fun calc(a: Int, b: Int): Int {
    // No se pueden mutar las variables parámetros de entrada de la función
    //a++
    //b++
    //a = 0

    return a * 3 + b / 2
}

/**
 * Función con expression-body
 */
fun calc2(a: Int, b: Int) = a * b

