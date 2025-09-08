package intro.loops

fun main() {
    testRange()
    //testIntRangeInclusive()
    //testRangeExclusive()
    //testIntProgression()
    //testIntProgressionExclusive()
    testIn()
}

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
    in 'a'..'z' -> "minuscula"
    in 'A'..'Z' -> "Mayuscula"
    in '0'..'9' -> "digito"
    else -> "desconocido"
}