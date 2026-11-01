package containers.collections.operations.transforming.mapping.collections

/**
 * Las operaciones de mapeo consisten en aplicar una función de transformación
 * a cada elemento de una colección y añadir el resultado de la transformación (elemento transformado)
 * en una nueva colección que será el resultado de la operación de mapeo
 *
 * - map
 * - mapNotNull (no añade a la lista resultante los elementos cuya transformation da como resultado el valor null)
 * - mapIndexed (si para realizar la trasformación además del elemento es necesario la posición que ocupa en la colección)
 * - mapIndexedNotNull (igual que mapNotNull y además con índices)
 *
 * Las mismas pero acabadas en to
 * - mapTo
 * - mapNotNullTo
 * - mapIndexedTo
 * - mapIndexedNotNullTo
 */

fun testMap() {
    val fruits = listOf("banana", "aguacate", "manzana", "kiwi")
    val capitalizedFruits = fruits.map { fruit ->
        fruit.replaceFirstChar {
            if (it.isLowerCase()) it.uppercaseChar() else it
        }
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
        // Si el nombre de la medalla no tiene más de 3 caracteres se transforma en null (el oro)
        if (element.length > 3) "(${index + 1}) $element" else null
    }
    println(numberedRank)
}


fun testMapIndexedNotNull2() {
    val weekDays = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    val evenWeekDays = weekDays.mapIndexedNotNull { index, day ->
        if (index % 2 != 0) "(${index + 1}) $day" else null
    }
    println(evenWeekDays)
}

/**
 * Podemos decidir la colección donde queremos que se almacenen los resultados
 * Los nombres de estas operaciones son los mismos, pero con el sufijo To
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
    testMapIndexedNotNull2()
    testMapTo()
}

