package functional.intro3

interface IntToInt {
    fun apply(number: Int): Int
}


fun applyIntToIntOperationToNumber(operation: IntToInt, number: Int): Int {
    val result = operation.apply(number)
    return result
}

fun Int.applyIntToIntOperation(operation: IntToInt) : Int {
    return applyIntToIntOperationToNumber(operation, this)
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

    val result1 = applyIntToIntOperationToNumber(square, 5)
    val result2 = applyIntToIntOperationToNumber(triple, 5)

    println("result1 = $result1")
    println("result2 = $result2")

    val result3 = 2.applyIntToIntOperation(square)
    println("result3 = $result3")
    val result4 = 2.applyIntToIntOperation(triple)
    println("result4 = $result4")
}


fun main() {
    testInToIntInterfaceWithObjectExpression()
}

