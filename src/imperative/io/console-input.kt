package imperative.io

fun readName1(): String {
    val input = readln()

    var result: String

    if (input.isEmpty())
        result = input
    else
        result = "Anonimo" // Equivale a operador ternario

    return result
}

fun readName2(): String {
    val input = readln()
    val result = if (input.isEmpty()) input else "Anonimo" // Equivale a operador ternario
    return result
}

fun readName3(): String {
    val input = readln()
    return if (input.isEmpty()) input else "Anonimo" // Equivale a operador ternario
}

/**
 * Version usando la scope function run
 * para poder hacer uso de funciones con expresión como cuerpo (cuerpo expresión)
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

fun readLastname() = readln().ifBlank { "Nothing" }


/**
 * Se repite la referencia input en el if
 */
fun readAge1(): Int {
    val input = readln()
    return if (input.isNotBlank()) input.toIntOrNull() ?: 0 else 0
}

fun readAge2(): Int {
    val input = readln()
    with(input) {
        return if (this.isNotBlank()) this.toIntOrNull() ?: 0 else 0
    }
}

/**
 * Eliminamos this
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
 */
fun readAge4(): Int {
    val age = with(readln()) {
        if (isNotBlank()) toIntOrNull() ?: 0 else 0
    }
    return age
}

/**
 * Como solamente hay una expresión en el cuerpo de la función
 * la convertimos en una expresión body
 */
fun readAge5() =
    with(readln()) {
        if (isNotBlank()) toIntOrNull() ?: 0 else 0
    }

fun readAge6() = readln().toIntOrNull() ?: 0
