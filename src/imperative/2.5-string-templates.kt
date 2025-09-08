fun main() {
    val input = readln()
    val name = if (input.isBlank()) "Kotlin" else input

    // Usamos una string template
    // El $ sirve para indicar nombres de variables y expresiones
    println("Hola $name!")

    //Para imprimir el símbolo del $ usar el escape
    println("\$<--")

    // Para expresiones se ponen dentro de {} después del $
    println("Tu nombre tiene ${name.length} letras")
}