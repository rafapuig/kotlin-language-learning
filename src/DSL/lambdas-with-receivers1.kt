package DSL.buildString.regular.lambda

/**
 * La función buildString declara
 * un parámetro (builderAction) de tipo función
 * el tipo de function
 *
 */
fun buildString(builderAction: (StringBuilder) -> Unit): String {
    val stringBuilder = StringBuilder()
    builderAction(stringBuilder)
    return stringBuilder.toString()
}

fun main() {
    val string = buildString {
        it.append("Hola, ")
        it.append("Kotlin!")
    }
    println(string)
}