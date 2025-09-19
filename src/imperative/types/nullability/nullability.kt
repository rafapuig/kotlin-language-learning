package imperative.types.nullability

/**
 * La anulabilidad es una característica del sistema de tipos de Kotlin
 * que nos ayudará a evitar los errores en tiempo de ejecución debido a
 * que la ejecución de una instrucción provoque la excepción NullPointerException
 *
 * La idea es convertir estos errores en tiempo de ejecución en errores de compilación
 * para que puedan ser detectados por el compilador
 *
 * Si una variable o propiedad puede contener el valor null
 * no es seguro llamar a un metodo usando como receiver la variable o propiedad
 * ya que si en lugar de almacenar una referencia a un objeto contiene un null
 * entonces se producirá la excepción NullPointerException al ejecutar la llamada
 *
 * Ejemplo en Java
 *
 * int strlen(String s) {
 *  return s.length();
 * }
 *
 * Si llamamos a esta función pasando null como argumento
 * strlen(null);
 *
 * o declaramos una variable String para guardar una referencia a un objeto String
 * pero le asignamos el valor null
 * String text = null;
 * strlen(text)
 *
 * Lanzará la excepción NullPointerException al ejecutar la instrucción s.length();
 */

/** En kotlin */
/**
 * El parámetro s está declarado usando el tipo String
 * Esto quiere decir que siempre tendrá una referencia a un objeto String (nunca a null)
 */
fun strlen(s: String) = s.length

fun testCallStrlenWithNullArgument() {
    //strlen(null) // Se detecta como un error de compilación
}

/**
 * Si queremos que también se puede usar null como argumento en la llamada para el parámetro s
 * Lo tenemos que indicar explícitamente añadiendo un ? después del nombre del tipo
 *
 * Las variables (locales, parámetros de entrada, propiedades, etc) del tipo anulable: String?, Int?, etc
 * permiten almacenar cualquier referencia a un objeto del tipo y ademas el valor null
 *
 * Tipo? = Tipo + null
 */
fun strlenUnsafe(s: String?) {
    /** Pero entonces el compilador no nos deja usar simplemente la sintaxis receiver.miembro */
    // return s.length // ERROR de compilación
}

/**
 * No podemos pasar un valor de tipo anulable como argumento a la función que espera
 * un valor de tipo no anulable como para inicializar su parámetro de entrada
 */

fun passingNullableArgumentToNonNullableFunctionParameter() {
    val text: String? = "Hola Kotlin"
    //strlen(text) // Error, esperaba valor String y recibe uno de tipo String?
}

/**
 * Entonces que hacemos con una expresión de tipo anulable
 * Compararla con el valor null
 * El compilador tiene en cuenta que se ha realizado la comprobación
 * y trata el valor como no anulable dentro del ámbito donde se ha realizado la comprobación
 *
 * El if comprueba si el valor de la expresión s es nula o no
 * Si se cumple la condición entonces dentro de la rama principal del if se puede considerar
 * que la expresión no es nula y tratarla como si fuera String de tipo no anulable
 */
fun strlenNullSafe(s: String?): Int = if (s != null) s.length else 0

/**
 * Si la unique manera de tratar la anulabilidad fuera comprobarla mediante if
 * el código sería muy verboso
 */

/**
 * Podemos combinar la comprobación de que la expresión es null y la llamada al miembro
 * mediante el operador de llamada seguro ?.
 *
 * Por ejemplo:
 * str?.uppercase() es equivalente a if(str != null) str.uppercase() else null
 *
 * Es decir, solamente se invoca al miembro si la referencia no es null, si no se evita la llamada
 * y se usa el valor null como resultado
 */

fun printAllCapsVerbose(s: String?) {
    val allCaps: String? = if (s != null) s.uppercase() else null
    println(allCaps)
}

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.uppercase()
    println(allCaps)
}

fun testPrintAllCaps() {
    printAllCaps("Hola Kotlin")
    printAllCaps(null)
}

/**
 * El operador Elvis ?:
 * Proporcionar un valor por defecto en el caso de que la expresión sea null
 */
fun greetVerbose(name: String?) {
    val recipient = if (name != null) name else "anonimo"
    println("Hello $recipient!")
}

fun greet(name: String?) {
    val recipient = name ?: "anonimo"
    println("Hello $recipient!")
}

fun testGreet() {
    greet("Perico")
    greet(null)
    greetVerbose("Perico")
    greetVerbose(null)
}

/**
 * El operador Elvis se usa a menudo junto con el operador de llamadas seguras
 * para sustituir el valor nulo por otro cuando la expresión hace referencia a null
 * en lugar de referenciar un objeto
 */

fun srtLenSafeVerbose(s: String?) = if (s != null) s.length else 0

fun srtLenSafe(s: String?) = s?.length ?: 0

fun testStrLenSafe() {
    println(srtLenSafe("Hola Kotlin"))
    println(srtLenSafe(null))
}


fun main() {
    testCallStrlenWithNullArgument()
    passingNullableArgumentToNonNullableFunctionParameter()
    testPrintAllCaps()
    testGreet()
    testStrLenSafe()
}
