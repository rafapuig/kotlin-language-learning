package intro.loops

/**
 * Un RANGO es un intervalo de valores entre dos valores (start y end)
 * Se crea:
 * - cerrado (inclusivo) mediante el operador ..
 * - abierto (exclusivo) mediante el operador ..<
 *
 * Si un rango permite iterar todos los valores dentro de rango ese rango también es considerado una PROGRESIÓN
 *
 *  En el caso de rangos de valores enteros se cumple:
 *  Range -hereda de -> Progression -implementa-> Iterator
 */

/**
 * El operador .. es por convención una llamada a la función rangeTo
 */


/**
 * El bucle for en Kotlin se aplica a Iterables (objeto cuya clase implementa la interface Iterable<T>)
 *
 * Las progresiones implementan la interface Iterable
 */

fun main() {
    val zeroToTen = 0..10   // rango inclusivo
    val zeroToTenExclusive = 0..<10 // rango exclusivo
    val zeroUntilTen = 0 until 10 // rango exclusivo
    val zeroToTenByTwo = 0..10 step 2 // en incrementos de 2 en 2
    val tenDownToZero = 10 downTo 0
    val twentyDownToZeroByTwo = 20 downTo 0 step 2
    testFor1()
    testFor5()
    testLetters()
    testLettersWithIndex()
    testEvenDigits()
    testEvenDigitsWithIndex1()
    testEvenDigitsWithIndex2()

    // Version verbosa
    val verboseZeroToTen = 0.rangeTo(10)
    val verboseZeroToTenExclusive = 0.rangeUntil(10)
    val verboseZeroUntilTen = 0.until(10) // Llamada al metodo de extension infijo until
    val verboseZeroToTenByTwo = 0.rangeTo(10).step(2)
    val verboseTenDownToZero = 10.downTo(0) // Llamada al metodo de extension infijo downTo
    val verboseTwentyDownToZeroByTwo = 20.downTo(0).step(2)
}

fun testFor1() {
    // Rango de 1 a 10 inclusive
    val oneToTen = 1..10
    for (i in 1..10) {
        println("Valor de i: $i")
    }
}

/**
 * El operador ..< es una llamada a la función operador rangeUntil
 */
fun testFor2() {
    // Rango de 0 a 9 (no incluye el ultimo valor)
    val range = 0..<10
    for (i in 0..<10) {
        println(i)
    }
}

/**
 * la función infija until crea un rango exclusivo
 */
fun testFor21() {
    // Rango de 0 a 9 (no incluye el ultimo valor)
    val range = 0 until 10
    for (i in 0 until 10) {
        println(i)
    }

    val verboseRange = 0.until(10) // forma verbosa de llamar a la función infija until
}


fun testFor3() {
    val progression = 0..10 step 2
    for (i in 0..100 step 2) {
        println(i)
    }
}

fun testFor4() {
    val progression = 10 downTo 1
    for (i in 10 downTo 1) {
        println(i)
    }
}

fun testFor5() {
    val progression = 20 downTo 1 step 2
    for (i in 20 downTo 1 step 2) {
        println(i)
    }
}

fun testFor6() {
    val intIterable: Iterable<Int> = 0..30 step 3
    for (i in intIterable) {
        println(i)
    }
}


fun testCharRangesAndProgressions() {
    val letters = 'a'..'z'
    val digits = '0'..'9'

    val letters2 = 'z' downTo 'a'
    val evenDigits = '0'..'8' step 2
}

fun testLetters() {
    val letters = 'a'..'f'
    for (letter in letters) {
        println(letter)
    }
}

fun testLettersWithIndex() {
    val letters = 'a'..'f'
    for (letter in letters.withIndex()) {
        println("Index ${letter.index} -> ${letter.value}")
    }
}

fun testEvenDigits() {
    val evenDigits = '0'..'8' step 2

    for (digit in evenDigits) {
        println(digit)
    }
}

fun testEvenDigitsWithIndex1() {
    val evenDigits = '0'..'8' step 2

    for (digit in evenDigits.withIndex()) {
        println(digit)

    }
}

fun testEvenDigitsWithIndex2() {
    val evenDigits = '0'..'8' step 2

    for (digit in evenDigits.withIndex()) {
        println("Index[${digit.index}] value -> ${digit.value}")
    }
}