package imperative.controlflow

/**
 * Función para obtener un número aleatorio entre 1 y 10
 */
fun getRandomNumber(): Int = (1..10).random()

/**
 * Uso de la instrucción if para simplemente controlar el flujo
 * Es decir, decidir que instrucción se ejecuta según sea cierta o no una condición
 */
fun testIf() {
    val number = getRandomNumber()

    if (number % 2 == 0) {
        println("$number es par")
    } else {
        println("$number es impar")
    }
}


/**
 * Uso de if como expresión
 * La instrucción if se puede usar como expresión,
 * cuando se evalúa devuelve el valor de la rama if si la condición se cumple
 * o el valor de la rama else si no se cumple
 */
fun testIfExpr() {
    val number = getRandomNumber()
    val parity = if (number % 2 == 0) "par" else "impar"
    println("$number es $parity")
}

/**
 * Se puede usar la combinación típica if .. else if .. else
 * Pero en Kotlin es mejor usar para estos casos el when sin argumento
 */
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

/**
 * Aquí vemos el equivalente, pero usando la instrucción when (también es una expresión)
 */
fun testWhenWithoutArguments() {
    val number = getRandomNumber()

    val typeInt = when {
        number > 0 -> "positivo"
        number < 0 -> "negativo"
        else -> "cero"
    }
    println("$number es $typeInt")
}


fun main() {
    testIf()
    testIfExpr()
    testIfExpr2()
    testWhenWithoutArguments()
}