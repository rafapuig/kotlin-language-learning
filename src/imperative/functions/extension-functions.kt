package imperative.functions

/**
 * Una función de extension es una función que se invoca como si fuera una función miembro de
 * una clase, pero que está realmente definida fuera de la clase.
 */


/**
 * Función de extensión de la clase String
 *
 * String se considera el Tipo de Receptor (receiver type)
 *
 * this es el objeto receptor (receiver object) es decir, el objeto sobre el cual se ejecuta el método
 */
fun String.numVowels(): Int {
    return this.filter { it in "aeiou" }.length
}

fun String.lastChar(): Char = this.get(this.length - 1)

/**
 * Podemos omitir la referencia explícita a this igual que en los métodos de instancia de la clase
 */
fun String.lastChar2(): Char = get(length - 1)

fun main() {
    val vowels = "Murcielago".numVowels()
    println(vowels)
}