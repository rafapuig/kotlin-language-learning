package collections.operations.filtering

fun testFilterOnMap() {
    val numbersToNames =
        mapOf(1 to "uno", 2 to "dos", 3 to "tres", 4 to "cuatro", 5 to "cinco")

    /**
     * Cuando filtramos sobre un mapa el resultado es otro mapa
     */
    val filteredMap =
        numbersToNames.filter { it.key % 2 == 1 }

    println(filteredMap)

    val shortNamesMap = numbersToNames.filter {
        it.value.length <= 4
    }
    println(shortNamesMap)
}

fun testFilterNot() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val notMultipleOf3 = numbers.filterNot { it % 3 == 0 }
    println(notMultipleOf3)
}

fun testFilterNotNull() {
    val numbers = listOf(null, 1, 2, 3 , null, 4, 5)

    val notNullNumbers = numbers.filterNotNull()
    println(notNullNumbers)
}


fun testFilterIsInstance() {
    val list : List<Any?> =
        listOf(null, 1, "dos", 3.0, "cuatro", '5')

    val strings = list.filterIsInstance<String>()
    println(strings)

    val chars = list.filterIsInstance<Char>()
    println(chars)

    // Otra forma, pero no es la recomendada
    // Mejor usar la version que usa un argumento de tipo revivido
    val numbers = list.filterIsInstance(Number::class.java)
    println(numbers)
}



fun main() {
    testFilterOnMap()
    testFilterNot()
    testFilterNotNull()
    testFilterIsInstance()
}

