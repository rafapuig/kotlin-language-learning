package controlflow

fun getRandomNumber(): Int = (1..10).random()

fun testIf() {
    val number = getRandomNumber()
    if (number % 2 == 0) {
        println("$number es par")
    } else {
        println("$number es impar")
    }
}

fun testIfExpr() {
    val number = getRandomNumber()
    val parity = if (number % 2 == 0) "par" else "impar"
    println("$number es $parity")
}

fun testIfExpr2() {
    val number = getRandomNumber()
    val typeInt =
        if (number > 0)
            "positivo"
        else if (number < 0)
            "negativo"
        else "cero"

    println("$number es $typeInt")
}

fun main() {
    testIf()
    testIfExpr()
    testIfExpr2()
}