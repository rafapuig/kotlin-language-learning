package functional.intro4

fun interface IntToInt {
    fun apply(number: Int): Int
}

fun applyIntToIntOperationToNumber(operation: IntToInt, number: Int): Int {
    return operation.apply(number)
}

fun Int.applyIntToIntOperation(operation: IntToInt): Int {
    return applyIntToIntOperationToNumber(operation, this)
}


fun testInToIntInterfaceWithLambda() {

    val triple: IntToInt = IntToInt { number -> number * 3 }

    val square: IntToInt = IntToInt { number -> number * number }

    val result1 = triple.apply(5)
    val result2 = square.apply(5)

    println("result1 = $result1")
    println("result2 = $result2")

    var operation: IntToInt

    operation = triple
    val result3 = operation.apply(5)
    println("result3 = $result3")

    operation = square
    val result4 = operation.apply(5)
    println("result4 = $result4")


    val result5 = 7.applyIntToIntOperation(operation)
    println("result5 = $result5")

    val result6 = 8.applyIntToIntOperation({ number -> number * 2 })
    println("result6 = $result6")

    val result7 = 9.applyIntToIntOperation { number -> number * number }
    println("result7 = $result7")

    val result8 = 9.applyIntToIntOperation({ it - 1 })
    println("result8 = $result8")

}


fun main() {
    testInToIntInterfaceWithLambda()
}

