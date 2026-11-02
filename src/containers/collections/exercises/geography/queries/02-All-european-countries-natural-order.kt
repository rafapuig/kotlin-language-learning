package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries

/**
 * Obtiene todos los países de Europa ordenados por su orden natural
 */

fun getAllEuropeanCountriesSorted() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.EUROPE }
        .sorted()


fun printAllEuropeanCountriesSorted() {
    println("Todos los países de ${Continent.EUROPE} por orden natural:")
    println("----------------------------------------------------------")
    getAllEuropeanCountriesSorted()
        .forEach { println(it.name) } // Imprimimos solamente los nombres
}


fun main() {
    printAllEuropeanCountriesSorted()
}