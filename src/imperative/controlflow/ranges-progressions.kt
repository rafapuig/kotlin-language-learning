package intro.loops

/**
 * Rangos
 *
 * Un rango es esencialmente un intervalo entre dos valores (normalmente números)
 * - inicial
 * - final
 *
 * La operación más común que se puede aplicar a un rango es comprobar si un valor
 * cae dentro del intervalo de valores, mediante el operador in (contains)
 *
 *
 * Progresiones
 * - Si es posible iterar todos los valores de un rango entonces el rango se denomina progresión.
 *
 *
 * Para crear un rango inclusivo se utiliza el operador .. con sus dos operandos valor inicial y final
 *
 * Podemos crear un rango exclusivo que no incluya el valor indicado como segundo operando si utilizamos el operador ..<
 */

fun testRange() {
    val oneToTen = 1..10
    val oneToTen2 = 1.rangeTo(10)
    val oneToTenEx = 1..<10
    val oneToTenEx2 = 1.rangeUntil(10)

    val digits = '0'.rangeTo('9')
    println(digits)
    println(oneToTen)
    println(oneToTenEx)
    println(oneToTen2)
    println(oneToTenEx2)
}

fun testIntRangeInclusive() {
    val oneToFive = 1..5

    println(oneToFive.first)
    println(oneToFive.last)
    println(oneToFive.step)
    println(oneToFive.start)
    println(oneToFive.endInclusive)
}

fun testRangeExclusive() {
    val oneToFive = 1..<5
    println(oneToFive.first)
    println(oneToFive.last)
    println(oneToFive.step)
    println(oneToFive.start)
    println(oneToFive.endInclusive)
}

fun testIntProgression() {
    val oneToFive = 1..5 step 1
    println(oneToFive.first)
    println(oneToFive.last)
    println(oneToFive.step)
}

fun testIntProgressionExclusive() {
    val oneToFive = 1..<5 step 1
    println(oneToFive.first)
    println(oneToFive.last)
    println(oneToFive.step)
}

fun testIn() {
    val oneToTenOdds = 1..10 step 2
    println(3 in oneToTenOdds)
    println(4 in oneToTenOdds)
    println(10 in oneToTenOdds)
    println(11 in oneToTenOdds)
}

fun parseChar(c: Char) = when (c) {
    in 'a'..'z' -> "minúscula"
    in 'A'..'Z' -> "Mayúscula"
    in '0'..'9' -> "digito"
    else -> "desconocido"
}

fun main() {
    testRange()
    //testIntRangeInclusive()
    //testRangeExclusive()
    //testIntProgression()
    //testIntProgressionExclusive()
    testIn()
}