package functional.intro2

interface IntToInt {
    fun apply(number: Int) : Int
}


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

    val result1 = applyIntToIntOperationToFive(square)
    val result2 = applyIntToIntOperationToFive(triple)

    println("result1 = $result1")
    println("result2 = $result2")
}




fun main() {
    testInToIntInterfaceWithObjectExpression()
}

