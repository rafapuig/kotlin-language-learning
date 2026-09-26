package functional.intro5

/**
 * La interface funcional puede declarar como método SAM
 * la sobrecarga del operador de invocación de funciones
 *
 * En este caso, con simplemente indicar la referencia al objeto seguida de los paréntesis
 * de invocación, se llamará al metodo invoke de la interface
 */
fun interface IntToInt {
    operator fun invoke(number: Int): Int
}

fun applyIntToIntOperationToNumber(number: Int, operation: IntToInt): Int {
    return operation(number)
}

fun Int.applyIntToIntOperation(operation: IntToInt): Int {
    return operation(this)
}


fun testInToIntInterfaceWithLambda() {

    val triple: IntToInt = IntToInt { number -> number * 3 }

    // Llamada al metodo invoke usando la sintaxis de operador de llamada ()
    val result1 = triple(5)

    // Llamada explicita al metodo invoke mediante la sintaxis receptor.metodo()
    val result11 = triple.invoke(5)

    println("result1 = $result1")
    println("result11 = $result11")


    val square: IntToInt = IntToInt { number -> number * number }
    val result2 = square(5)

    println("result2 = $result2")

    var operation: IntToInt

    operation = triple
    val result3 = operation(5)
    println("result3 = $result3")

    operation = square
    val result4 = operation(5)
    println("result4 = $result4")
}


fun main() {
    testInToIntInterfaceWithLambda()
}

