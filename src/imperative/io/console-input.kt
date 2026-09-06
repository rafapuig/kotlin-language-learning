package imperative.io

/**
 * Primera version de readName
 * La variable result puede ser declarada con val y ser readonly
 * aunque su valor inicial dependa de la ejecución de una rama if o la else de una instrucción de control if
 */
fun readName1(): String {
    val input = readln()

    val result: String

    if (input.isEmpty())
        result = input
    else
        result = "Anónimo" // Equivale a operador ternario

    return result
}

/**
 * Version 2 de readName
 *
 * En las dos ramas del if estábamos asignando un valor a la misma variable
 * Como if se considera una expresión, podemos elevar el resultado de la rama que se ejecute del if
 * y usarlo como valor resultado de evaluar la expresión if
 * para asignarlo a la variable result
 */
fun readName2(): String {
    val input = readln()
    val result = if (input.isEmpty()) input else "Anónimo" // Equivale a operador ternario
    return result
}


/**
 * Version 3
 * Nos ahorramos la variable result y que directamente el resultado de la expresión if sea el
 * resultado devuelto por la función mediante una instrucción return
 */
fun readName3(): String {
    val input = readln()
    return if (input.isEmpty()) input else "Anónimo" // Equivale a operador ternario
}

/**
 * Version 4 usando la scope function run
 * La función readName tiene dos instrucciones
 * y por eso no podemos convertirla directamente en una función con expresión body,
 * ya que para ello tendría que tener solamente una.
 *
 * Podemos usar la scope function run
 * para poder hacer uso de funciones con expresión como cuerpo (cuerpo expresión),
 * ya que permite agrupar todas las instrucciones en su bloque
 */
fun readName4() = run {
    val input = readln()
    if (input.isNotBlank()) input else "Anonimo" // Equivale a operador ternario
}

/**
 * Version usando la scope function let *
 */
fun readName5(): String {
    return readln().let {
        if (it.isNotBlank()) it else "Anonimo"
    }
}

/**
 * Version usando la scope function let *
 * y aplicando cuerpo de expresión en la función
 */
fun readName6() =
    readln().let {
        if (it.isNotBlank()) it else "Anonimo"
    }


/**
 * Version usando la scope function with
 */
fun readName(): String {
    return with(readln()) {
        if (isNotBlank()) this else "Anonimo"
    }
}

/**
 * Version más concisa posible
 * usando la función miembro ifBlack de la clase String
 */

fun readLastname() = readln().ifBlank { "Nothing" }

//-------------------------------------------------------------------------------

/**
 * En este código se repite la referencia input en el if
 * El operador elvis ?: devuelve el valor de su operando izquierdo a menos que sea null,
 * ya que entonces usara el valor de su operando derecho como resultado
 */
fun readAge1(): Int {
    val input = readln()
    return if (input.isNotBlank()) input.toIntOrNull() ?: 0 else 0
}

/**
 * Para DRY (don't repeat yourself)
 * se puede aplicar una de las scope functions
 * por ejemplo, with y luego usar this para referirse a input
 */
fun readAge2(): Int {
    val input = readln()
    with(input) {
        return if (this.isNotBlank()) this.toIntOrNull() ?: 0 else 0
    }
}

/**
 * Eliminamos this (ya que sabemos que this no siempre es obligatorio usarlo)
 * y obtenemos un código más conciso
 */
fun readAge3(): Int {
    val input = readln()
    with(input) {
        return if (isNotBlank()) toIntOrNull() ?: 0 else 0
    }
}

/**
 * No hace falta declarar la variable input
 * y ya no se repite la referencia con el uso de with
 * (de esta manera tampoco tenemos que pensar que nombre queremos darle al valor que nos devuelva readln)
 */
fun readAge4(): Int {
    val age = with(readln()) {
        if (isNotBlank()) toIntOrNull() ?: 0 else 0
    }
    return age
}

/**
 * Si eliminamos la variable age intermedia y devolvemos directamente el resultado de with
 * entonces...
 */
fun readAge5(): Int {
    return with(readln()) {
        if (isNotBlank()) toIntOrNull() ?: 0 else 0
    }
}

/**
 * Como solamente hay una expresión en el cuerpo de la función
 * la convertimos en una expresión body
 */
fun readAge6() =
    with(readln()) {
        if (isNotBlank()) toIntOrNull() ?: 0 else 0
    }



fun readAge7() = readln().toIntOrNull() ?: 0
