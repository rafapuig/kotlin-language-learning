package functional.intro2

interface IntToInt {
    fun apply(number: Int) : Int
}

/**
 * Supongamos que queremos aplicar una operación que se proporcionará como valor argumento
 * sobre un dato del que disponemos y que le proporcionaremos a la operación
 */
fun applyIntToIntOperationToFive(operation: IntToInt) : Int {
    val number = 5
    val result = operation.apply(number)
    return result
}


fun testInToIntInterfaceWithObjectExpression() {

    val triple: IntToInt = object : IntToInt {
        override fun apply(number: Int): Int {
            return number * 3
        }
    }

    val square: IntToInt = object : IntToInt {
        override fun apply(number: Int): Int {
            return number * number
        }
    }

    // Al llamar a la funcíon applyIntToIntOperationToFive
    // le estamos proporcionando el comportamiento como argumento (lo que tiene que hacer)
    // no los datos con los que tiene que operar
    val result1 = applyIntToIntOperationToFive(square)
    val result2 = applyIntToIntOperationToFive(triple)

    println("result1 = $result1")
    println("result2 = $result2")
}




fun main() {
    testInToIntInterfaceWithObjectExpression()
}

