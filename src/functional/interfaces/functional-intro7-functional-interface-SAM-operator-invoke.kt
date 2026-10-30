package functional.interfaces.intro7

/**
 * La interface funcional puede declarar como método SAM
 * la sobrecarga del operador de invocación de funciones: `invoke`
 *
 * En este caso, con simplemente indicar la referencia al objeto seguida de los paréntesis
 * de invocación, se llamará al metodo invoke de la interface
 */
fun interface IntToInt {
    operator fun invoke(number: Int): Int
}

fun applyIntToIntOperationToNumber(number: Int, operation: IntToInt) =
    operation.invoke(number) // Podemos usar explícitamente la llamada al metodo invoke

fun Int.applyIntToIntOperation(operation: IntToInt) =
    operation(this) // O podemos usar la convención de operador de llamada y solamente usar ()


fun testInToIntInterfaceWithLambda() {

    val triple: IntToInt = IntToInt { number -> number * 3 }

    // Llamada explicita al metodo invoke mediante la sintaxis receptor.metodo()
    val result11 = triple.invoke(5)

    // Llamada al metodo invoke usando la sintaxis de operador de llamada ()
    val result12 = triple(5)

    println("result11 = $result11")
    println("result12 = $result12")


    // Si indicamos el tipo de la variable explícitamente,
    // no es necesario la llamada explicita al constructor SAM
    val square: IntToInt = { number -> number * number }
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

