package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.formatting.printAsTable
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries

/**
 * Obtener todos los países que NO están en el continente europeo
 */

fun getAllCountriesNotInEurope() =
    Countries.WORLD_COUNTRIES
        .filter {
            it.continent !in setOf(Continent.EUROPE)
        }


fun printAllCountriesNotInEurope() =
    getAllCountriesNotInEurope()
        .printAsTable("Todos los países que no están en Europa:")


fun main() {
    printAllCountriesNotInEurope()
}