package imperative.functions

/**
 * Cuando una función se llama por los efectos colaterales que produce
 * y no devuelve ningún valor al llamador, el tipo de retorno que se usa es Unit
 */

fun greet(name: String) : Unit {
    println("Hola, $name!")
}

/**
 * Se puede omitir el tipo de retorno si es Unit
 */
fun greet2(name: String) {
    println("Hola $name")
}

/**
 * función con expression body (en lugar de block body)
 */
fun greet3(name: String) = println("Hola $name")