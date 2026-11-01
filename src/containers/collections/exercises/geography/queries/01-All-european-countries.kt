package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.formatting.printAsTable
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries

/**
 * Obtiene todos los países de Europa
 */

fun getAllEuropeanCountries() =
    Countries.WORLD_COUNTRIES.filter {country ->
        country.continent == Continent.EUROPE
    }


fun printAllEuropeanCountries() {
    getAllEuropeanCountries()
        .printAsTable("Todos los países de ${Continent.EUROPE}:")
}

fun main() {
    printAllEuropeanCountries()
}