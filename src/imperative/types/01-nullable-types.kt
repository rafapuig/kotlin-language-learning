package imperative.types

import imperative.greet

/**
 * Una clase, interface, etc define dos tipos de datos
 * - un tipo nullable
 * - un tipo no nullable
 *
 * Type? = Type + null
 */

/**
 * ?. Safe call operator operador de llamada seguro
 * Combina la comprobación de valor nulo y la llamada a un método
 *
 * ?: Elvis operator
 * Proporciona un valor por defecto cuando un valor es nulo
 *
 * !! non-null assertion operator
 * Convierte un valor de tipo nullable a no-nullable (si el valor es null se lanza la excepción NullPointerException)
 */



fun strLen(str: String): Int = str.length

// Error
//fun strLenWithNull(str: String?): Int = str.length

fun strLenWithNull(str: String?): Int = if (str != null) str.length /* se infiere que str ya no es nulo */ else 0

fun strLenWithNullSafe(str: String?): Int {
    val length = if (str != null) str.length else null /* se infiere que str ya no es nulo */
    return if (length != null) length else 0
}

fun strLenWithNullSafeCallOperator(str: String?): Int {
    val length = str?.length /* se infiere que str ya no es nulo */
    return if (length != null) length else 0
}

fun strLenWithNullSafeElvis(str: String?): Int {
    val length = if (str != null) str.length else null /* se infiere que str ya no es nulo */
    return length ?: 0
}

fun strLenWithNullSafeCallOperatorElvis(str: String?): Int {
    val length = str?.length /* se infiere que str ya no es nulo */
    return length ?: 0
}

fun strLenWithNullElvis(str: String?): Int = str?.length ?: 0



fun greet(name: String?) {
    val recipient = name ?: "desconocido"
    println("Hola $recipient")
}

fun greetThrowsException(name: String?) {
    val recipient = name ?: throw IllegalArgumentException()
    println("Hola $recipient")
}

// Variable del tipo no anulable String
// (no puede guardar el valor null, porque el valor null no pertenece al conjunto de valores del tipo)
var nonNullableString: String = "Hola Kotlin"

// Variable del tipo anulable String (al añadir el signo ?, se permite el valor nulo, como posible valor)
var nullableString: String? = null


fun main() {

    // nonNullableString = null // no puede tomar el valor null

    // Correcto: Una variable de tipo String? puede recibir un valor de tipo String
    nullableString = "Hola Kotlin"

    // Es correcto el tipo no nullable es un subtipo del nullable
    nullableString = nonNullableString

    // No es posible, porque la variable nullableString es de tipo String? y podría contener el valor null
    //nonNullableString = nullableString

    if (nullableString != null) {
        nonNullableString =
            nullableString!! // Operador !! para indicar al compilador que estamos seguros que no contiene null
    }

    // No se puede pasar null
    //strLen(null)

    // No se puede pasar un argumento cuyo tipo sea un tipo nullable (pq podría contener el valor null)
    //strLen(nullableString)

    if (nullableString != null) {
        strLen(nullableString!!)
    }

    // Llamadas a la función greet
    greet("Rafa")
    greet(null)
}