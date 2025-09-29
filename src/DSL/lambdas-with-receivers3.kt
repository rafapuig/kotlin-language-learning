package DSL.buildString.lambda.receiver.demo

/**
 * La variable appendExclamation almacena
 * un valor de tipo función de extensión
 *
 * La expresión lambda accede al valor del parámetro receiver
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
     * Podemos pasar appendExclamation como argumento de llamada
     * a la función buildString
     */
    val string = buildString(appendExclamation)
    println(string)

    // Llamada al metodo buildString de la biblioteca estandar
    val text = buildString {
        append("Hola, ")
        append("Kotlin!")
    }
    println(text)
}

