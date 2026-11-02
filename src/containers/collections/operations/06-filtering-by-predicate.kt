package containers.collections.operations.filtering

/**
 * filter
 * conserva en la colección resultante los elementos que cumple el predicado
 */
fun testFilter() {

    val names =
        listOf("Pedro", "Pablo", "Luis", "Jose", "Rafa", "Miguel", "Oscar")

    val namesWithLetterO =
        names.filter { it.contains("o",  true) }

    println(namesWithLetterO)
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

fun testFilterIndexed() {
    val names =
        listOf("Pedro", "Pablo", "Luis", "Jose", "Rafa", "Miguel", "Oscar")

    // Pablo y Jose no pasan el filtro porque están en posición de índice impar
    val namesWithLetterO =
        names.filterIndexed { index, name ->
            name.contains("o",  true) && index % 2 == 0
        }

    println(namesWithLetterO)
}


/**
 * filterIsInstance
 *
 * Conserva los elementos del tipo indicado
 * - como argumento de tipo
 * - como argumento de clase literal ::class.java
 */

fun testFilterIsInstance() {
    val list : List<Any?> =
        listOf(null, 1, "dos", 3.0, "cuatro", '5')

    /* El argumento de tipo (String) es un argumento de tipo revivido (reified) */
    val strings = list.filterIsInstance<String>()
    println(strings)

    val chars = list.filterIsInstance<Char>()
    println(chars)

    // Otra forma, pero no es la recomendada
    // Mejor usar la version que usa un argumento de tipo revivido (reified)
    val numbers = list.filterIsInstance(Number::class.java)
    println(numbers)
}



fun main() {
    testFilter()
    testFilterOnMap()
    testFilterNot()
    testFilterNotNull()
    testFilterIndexed()
    testFilterIsInstance()
}

