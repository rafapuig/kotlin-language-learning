package functional.intro5

fun interface IntToInt {
    operator fun invoke(number: Int): Int
}


fun testInToIntInterfaceWithLambda() {

    val triple: IntToInt = IntToInt { number -> number * 3 }

    val square: IntToInt = IntToInt { number -> number * number }

    val result1 = triple(5)
    val result2 = square(5)

    println("result1 = $result1")
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

