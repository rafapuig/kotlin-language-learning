package imperative.functions

/**
 * Parámetros con valor por defecto como argumento
 *
 * Kotlin permite evitar que tengamos que sobrecargar funciones porque podemos especificar valores por defecto
 * para los parámetros en la declaración de la función.
 */

/**
 * El parámetro greeting tiene asociado un valor por defecto
 * Si una llamada a la función no proporciona ningún argumento asociado a este parámetro
 * se usará como valor el valor por defecto
 */
fun greet(name: String, greeting: String = "Hola") {
    println("$greeting $name")
}

fun main() {
    // En la llamada a la función podemos no proporcionar un argumento
    // para un parámetro que tenga definido un valor por defecto
    greet("Rafa")
    greet("Rafa", "Buenos días")
}