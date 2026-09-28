package imperative.types

/**
 * Para algunas funciones el concepto de valor de retorno carece de sentido
 * puesto que estan escritas de forma que nunca van a terminar con éxito.
 * - funciones con un bucle infinito
 * - funciones que lo que hacen es lanzar una excepción
 *
 * Resulta util para el código llamador, saber que la función nunca terminará de forma normal.
 * Para expresarlo se usa un tipo de retorno especial llamado Nothing.
 */

fun fail(message: String): Nothing = throw Exception(message)

fun testFail() {
    fail("Ocurrió un error")
}

/**
 * El tipo Nothing NO tiene ningún valor (como si pasaba con Unit, que tiene uno)
 * Por eso, solo tiene sentido usarlo como tipo de valor de retorno
 * (o argumento de tipo en genéricos que tengan una función que devuelve un valor del tipo del parámetro de tipo)
 */

/**
 * Las funciones que devuelven Nothing se pueden usar en el lado derecho del operador Elvis ?:
 * para llevar a cabo una comprobación de una precondición.
 */

fun testNothingElvis() {
    val n = listOf(2, null).random() ?: fail("No era el numero, era null")
    println(n)
}

fun main() {
    //testFail()
    testNothingElvis()
}