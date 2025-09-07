package imperative.functions

/**
 * Parámetros con valor por defecto como argumento
 */
fun greet(name: String, greeting: String = "Hola") {
    println("$greeting $name")
}

fun main() {
    greet("Rafa")
    greet("Rafa", "Buenos dias")
}