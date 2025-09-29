package DSL.buildString.lambda.receiver.with.apply

/**
 * apply
 *
 * Tiene un parámetro block de tipo función de extensión
 * Usa el receptor proporcionado en la llamada (a apply)
 * como argumento para el receptor
 * al invocar al objeto función de extensión del parámetro block
 * apply devuelve una referencia al receptor con el que fue llamada
 */
inline fun <T> T.apply(block: T.() -> Unit): T {
    this.block() // this es el receptor de apply (de tipo T)
    return this
}

/**
 * La diferencia con with es que
 * apply devuelve su receiver
 * y with devuelve el resultado de invocar a block (llamar a la lambda)
 */
inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

/**
 * Si no importa el valor de retorno podemos usar
 * indistintamente apply o with
 */
fun test() {
    val map = mutableMapOf("uno" to 1)
    map.apply { this["dos"] = 2 }
    with(map) { this["tres"] = 3 }
    println(map)
}

/**
 * Implementamos la función buildString usando apply
 * El receptor de apply es en nuevo objeto StringBuilder instanciado
 * la llamada a apply lo devolverá como valor de retorno
 * apply usa el objeto StringBuilder como argumento receptor
 * en la invocación del objeto de tipo función de extension
 * referenciado por la variable builderAction
 */
fun buildString(builderAction: StringBuilder.() -> Unit) =
    StringBuilder().apply(builderAction).toString()

fun main() {
    val string = buildString {
        this.append("Hola, ") // this hace referencia al receptor de la lambda
        append("Kotlin!") // podemos omitir this
    }
    println(string)
}