package DSL.buildString.lambda.receiver

/**
 * Podemos dar a uno de los parameters de una lambda el status especial
 * de objeto receptor
 *
 * Tipo de función extensión
 *
 * El tipo de function de una lambda con receptor
 * saca el tipo del parámetro que queremos convertir en receptor
 * de los paréntesis donde se indican los parámetros de la función
 * y lo colocamos antes de los paréntesis y un punto
 */

/**
 * La función buildString declara
 * un parámetro (builderAction) de tipo función con un receptor
 * o dicho de otro modo, un tipo función de extensión
 * Lo que quiere decir que sacamos uno de los parámetros fuera de los paréntesis
 * y los ponemos delante separado de los demás por un punto
 * Hemos reemplazado: (StringBuilder) -> Unit
 * Por: StringBuilder.() -> Unit
 * Ahora StringBuilder es el tipo receptor (receiver) especial
 * El argumento de este tipo StringBuilder se pasará como objeto receptor
 */
fun buildString(builderAction: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.builderAction() // pasamos el stringBuilder como RECEPTOR al invocar al objeto función
    return stringBuilder.toString()
}

fun main() {
    val string = buildString {
        this.append("Hola, ") // this hace referencia al StringBuilder que se ha usado como receptor al invocar al objeto builderAction
        append("Kotlin!") // podemos omitir this
    }
    println(string)
}