package DSL.buildString.regular.lambda

/**
 * La función buildString declara
 * un parámetro (builderAction) de tipo función
 * el tipo de function es de tipo función regular que recibe un parámetro de
 * entrada que será una referencia a un objeto StringBuilder
 * y devuelve un Unit (void de Java)
 */
fun buildString(builderAction: (StringBuilder) -> Unit): String {
    val stringBuilder = StringBuilder() // Creamos la instancia StringBuilder
    builderAction(stringBuilder) // La usamos como ARGUMENTO al invocar al objeto función
    return stringBuilder.toString() // LLamamos al método del StringBuilder que fabrica el String
}

fun main() {
    val string = buildString {
        it.append("Hola, ")     // it es el StringBuilder con el que invoca
        it.append("Kotlin!")    // al builderAction dentro de la función buildString
    }
    println(string)
}