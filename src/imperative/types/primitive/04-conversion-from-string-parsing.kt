package imperative.types.primitive

/**
 * Parsing de String en Kotlin
 *
 * Para convertir un string en un valor de tipo primitivo Kotlin proporciona
 * funciones de extensión para la clase String:
 * - toInt
 * - toByte
 *  -toShort
 *  -toLong
 * - toBoolean
 * - toFloat
 * - toDouble
 * - toUXXX()
 */

val one = "1".toInt()
val two = "2".toUByte()
val three = "3".toByte()
val four = "4".toShort()

/**
 * Si al intentar convertir el texto del String falla, se lanza la excepción NumberFormatException
 */

fun testParsingFail() {
    val text = "Hello World"
    try {
        val result = text.toInt()
    } catch (e: NumberFormatException) {
        e.printStackTrace()
    }
}

/**
 * Si esperamos que la conversion falle con frecuencia, en lugar de manejar una excepción NumberFormatException
 * podemos usar una version de las funciones de conversion que si falla devuelve null
 * - toXXXOrNull()
 */

fun testParsingFailWithNull() {
    println("100".toIntOrNull())
    println("hundred".toIntOrNull())
}


fun main() {
    testParsingFail()
    testParsingFailWithNull()
}