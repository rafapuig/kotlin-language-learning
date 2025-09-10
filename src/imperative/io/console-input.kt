package imperative.io


fun readName() {
    return with(readln()) {
        if (isNotBlank()) this else "Anonimo"
    }
}

fun readSurname() = readln().ifBlank { "Nothing" }


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
