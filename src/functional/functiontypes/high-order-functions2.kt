package functional.hof2

/**
 * La funcion de orden superior filterBy
 * Recibe un parametro de tipo funcion
 */

fun IntArray.filterBy(predicate: (Int) -> Boolean): IntArray {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result.toIntArray()
}

private fun testFilterEvenNumbers() {
    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = numbers.filterBy({ it % 2 == 0 })
    println(evenNumbers.joinToString())
}

fun testFilterOperation(operation: (IntArray) -> IntArray) {
    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val result = operation(numbers)
    println(result.joinToString())
}

fun main() {
    testFilterEvenNumbers()

    testFilterOperation({ numbers -> numbers.filterBy({ it % 2 == 0 }) })
    testFilterOperation { numbers -> numbers.filterBy({ it % 2 == 0 }) }
    testFilterOperation { numbers -> numbers.filterBy { it % 2 == 0 } }
    testFilterOperation { it.filterBy { it % 2 == 0 } }
}

