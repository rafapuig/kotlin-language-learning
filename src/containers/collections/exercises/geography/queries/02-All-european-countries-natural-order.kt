package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries

/**
 * Obtiene todos los países de Europa ordenados por su orden natural
 */
fun printAllEuropeanCountriesSorted() {

    val result = Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.EUROPE }
        .sorted()

    println("Todos los países de ${Continent.EUROPE} por orden natural:")
    println("----------------------------------------------------------")
    result.forEach { println(it.name) }
}


fun main() {
    printAllEuropeanCountriesSorted()
}