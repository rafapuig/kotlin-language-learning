package containers.collections.operations.filtering


/**
 * filter
 *
 * Filtra las entradas de un mapa
 */

fun testFilterOnMap() {
    val numbersToNames =
        mapOf(1 to "uno", 2 to "dos", 3 to "tres", 4 to "cuatro", 5 to "cinco")

    /**
     * Cuando filtramos sobre un mapa el resultado es otro mapa
     */
    val filteredMap =
        numbersToNames.filter { it.key % 2 == 1 }

    // Imprimimos un mapa cuyas entradas su clave es un valor impar
    println(filteredMap)

    // Nos quedamos con las entradas cuyo valor es un texto de longitud menor o igual que 4
    val shortNamesMap = numbersToNames.filter {
        it.value.length <= 4
    }
    println(shortNamesMap)
}

/**
 * filterKeys
 *
 * Filtra las entradas de un mapa según sus claves
 */

fun testFilterKeys() {
    val numbersToNames =
        mapOf(1 to "uno", 2 to "dos", 3 to "tres", 4 to "cuatro", 5 to "cinco")

    // Obtenemos un mapa cuyas entradas su clave es un valor impar
    val filteredMap = numbersToNames.filterKeys {
        it % 2 == 1
    }

    println(filteredMap)
}


/**
 * filterValues
 *
 * Filtra las entradas de un mapa según sus valores
 */
fun testFilterValues() {
    val numbersToNames =
        mapOf(1 to "uno", 2 to "dos", 3 to "tres", 4 to "cuatro", 5 to "cinco")

    // Nos quedamos con las entradas cuyo valor es un texto de longitud menor o igual que 4
    val shortNamesMap = numbersToNames.filterValues {
        it.length <= 4
    }
    println(shortNamesMap)
}


fun main() {
    testFilterOnMap()
    testFilterKeys()
    testFilterValues()
}

