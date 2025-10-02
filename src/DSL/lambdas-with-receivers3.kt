package DSL.buildString.lambda.receiver.demo

/**
 * La variable appendExclamation almacena
 * un valor de tipo función de extensión
 *
 * La expresión lambda accede al valor del receiver
 * mediante this
 */
val appendExclamation: StringBuilder.() -> Unit =
    { this.append("!") }

fun main() {
    val stringBuilder = StringBuilder("Hola")

    // Llamada a appendExclamation como una función de extension
    stringBuilder.appendExclamation()
    println(stringBuilder)

    /**
     * Como appendExclamation contiene una referencia a un objeto
     * de tipo función con receptor StringBuilder y cero parámetros de entrada
     * y devuelve un Unit
     * Podemos pasar appendExclamation como argumento de llamada
     * a la función buildString
     */
    val string = buildString(appendExclamation)
    println(string)

    // Llamada al método buildString de la biblioteca estándar
    val text = buildString {
        append("Hola, ")
        append("Kotlin!")
    }
    println(text)
}

