package collections.operations.transforming.mapping.collections


import java.util.Locale.getDefault

/**
 * Las operaciones de mapeo consisten en aplicar una función de transformación
 * a cade elemento de una colección y añadir el resultado de la transformación (elemento transformado)
 * en una nueva colección que será el resultado de la operación de mapeo
 *
 * - map
 * - mapNotNull (no añade a la lista resultante los elementos cuya transformation da como resultado el valor null)
 * - mapIndexed (si para realizar la trasformación además del elemento es necesario la posición que ocupa en la colección)
 */

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
        "(${index + 1}) $element"
    }
    println(numberedRank)
}

fun testMapIndexedNotNull() {
    val rank = listOf("Oro", "Plata", "Bronce")

    val numberedRank = rank.mapIndexedNotNull { index, element ->
        if (element.length > 3) "(${index + 1}) $element" else null
    }
    println(numberedRank)
}

/**
 * Podemos decidir la colección donde queremos que se almacenen los resultados
 * Los nombres de estas operaciones son los mismos pero con el sufijo To
 * Estas versiones declaran un parámetro adicional paras proporcionar la referencia al objeto colección destino
 */

fun testMapTo() {
    val medals = listOf("Oro", "Plata", "Bronce")
    val destination = mutableListOf<Int>()
    medals.mapTo(destination) { it.length }
    println(destination)
}

fun main() {
    testMap()
    testMapNotNull()
    testMapIndexed()
    testMapIndexedNotNull()
    testMapTo()
}

