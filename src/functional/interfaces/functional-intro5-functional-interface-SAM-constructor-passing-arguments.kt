package functional.interfaces.intro5

fun interface IntToInt {
    fun apply(number: Int): Int
}

fun applyIntToIntOperationToNumber(number: Int, operation: IntToInt) = operation.apply(number)

fun Int.applyIntToIntOperation(operation: IntToInt) = operation.apply(this)


fun testIntToIntInterfacePassingArguments() {

    /**
     * Cuando llamamos a una función
     * que espera una referencia a un objeto implementador de la interface funcional
     * NO es necesario usar explícitamente el constructor SAM
     */

    val num: Int = 9

    // Llamada explicita al constructor SAM, (el IDE lo marca en gris para indicar que no es necesario)
    val result1 = 4.applyIntToIntOperation(IntToInt({ number -> number * 10 }))
    println("result1 = $result1")

    // Aquí la llamada al contractor SAM está implícita (la añade el compilador)
    val result2 = 8.applyIntToIntOperation({ number -> number * 2 })
    println("result2 = $result2")

    // Una trailing lambda se puede sacar fuera de los paréntesis, y paréntesis vacíos se pueden omitir
    val result3 = num.applyIntToIntOperation { number -> number * number }
    println("result3 = $result3")

    // Cuando una lambda representa a una función con un único parámetro de entrada
    // se puede omitir la declaración del parámetro y la flecha ->
    // y usar el nombre implícito predeterminado: it
    val result4 = num.applyIntToIntOperation({ it - 1 })
    println("result4 = $result4")

    val result5 = num.applyIntToIntOperation { it * 2 }
    println("result5 = $result5")
}





fun main() {
    testIntToIntInterfacePassingArguments()
}

