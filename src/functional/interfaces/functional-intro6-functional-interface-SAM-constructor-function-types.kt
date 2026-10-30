package functional.interfaces.intro6

fun interface IntToInt {
    fun apply(number: Int): Int
}

fun applyIntToIntOperationToNumber(number: Int, operation: IntToInt) = operation.apply(number)

fun Int.applyIntToIntOperation(operation: IntToInt) = operation.apply(this)


fun testIntToIntInterfaceWithFunctionTypes() {
    val num = 8

    /**
     * Una variable declarada sin especificar su tipo explícitamente
     * Si la inicializamos mediante una lambda
     * Inferirá su tipo como un tipo función
     * y el tipo de función concreto lo inferirá a partir de los parámetros de entrada de la lambda
     * y el tipo de la expresión resultado de la lambda
     */
    val triple = { number: Int -> number * 3 } // Tipo función (Int) -> Int

    /**
     * El constructor SAM puede recibir como argumento una referencia a un objeto función
     */
    val tripleIntFun = IntToInt(triple) // Tipo IntToInt

    // Usamos el constructor SAM para convertir un objeto de tipo función
    // en un objeto que implementa la interface funcional IntToInt
    val result1 = num.applyIntToIntOperation(IntToInt(triple))

    // En ese caso, llamada a una función que espera un objeto que implementa la interface funcional
    // no hace falta la llama explícita al constructor SAM (la añade el compilador)
    val result2 = num.applyIntToIntOperation(triple) // Pasamos directamente el objeto función

    // Si no indicamos el tipo de la variable se infiere como tipo función
    val halfFunction = { number : Int -> number / 2 }

    // Si usamos el constructor SAM se infiere como tipo de la interface funcional
    val halfInterface = IntToInt { number -> number / 2 }

    // Si declaramos el tipo de la variable explícitamente como de tipo interface funcional
    // no es necesario llamar explícitamente al constructor SAM, basta con la lambda
    val halInterfaceAlt: IntToInt = { number -> number / 2 }

    // Un objeto de tipo funcion se puede usar como argumento de llamada al constructor SAM
    val halfFunToInterface = IntToInt(halfFunction)

    // Los objetos función definen un metodo para invocar la lambda denominado invoke
    val result3 = halfFunction.invoke(num)
    val result4 = halfInterface.apply(num)
    val result5 = halfFunToInterface.apply(num)
}


fun main() {
    testIntToIntInterfaceWithFunctionTypes()
}

