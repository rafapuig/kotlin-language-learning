package containers.collections.exercises.geography.queries

import containers.collections.exercises.formatting.ColumnAlignment
import containers.collections.exercises.formatting.builders.asTable
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPopulationFormat


fun getFiveMostPopulatedCountries() =
    Countries.WORLD_COUNTRIES
        .sortedByDescending { it.population }
        .take(5)

fun printFiveMostPopulatedCountries() {

    getFiveMostPopulatedCountries()
        //.map { it.name to it.population.toPopulationFormat() }
        .map {
            object {
                val countryName = it.name
                val population = it.population
            }
        }
        .asTable {
            column {
                label = "Pais"
                width = 15
                alignment = ColumnAlignment.Center
                value = { it.countryName }
            }
            column {
                label = "Población"
                width = 20
                alignment = ColumnAlignment.End
                value = { it.population.toPopulationFormat() }
            }
        }.let(::println)

    //.display("Los 5 países más poblados del mundo:")
}

fun main() {
    printFiveMostPopulatedCountries()
}