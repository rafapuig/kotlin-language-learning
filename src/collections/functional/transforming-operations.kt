package collections.functional.transforming

import java.util.Locale
import java.util.Locale.getDefault

fun testMap() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    val capitalizedFruits = fruits.map {
        it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(getDefault()) else it.toString() }
    }
    println(capitalizedFruits)
}

fun testMapNotNull() {
    val numbers =
        listOf("1", "2", "tres", "4", "cinco", "6", "7", "ocho", "9")

    val result = numbers.mapNotNull { it.toIntOrNull() }

    println(result)
}

fun testMapIndexed() {
    val rank = listOf("Oro", "Plata", "Bronce")

    val numberedRank = rank.mapIndexed { index, element ->
        "(${index+1}) $element"
    }
    println(numberedRank)
}

fun main() {
    testMap()
    testMapNotNull()
    testMapIndexed()
}

