package containers.collections.exercises.geography.queries

import containers.collections.exercises.formatting.ColumnAlignment
import containers.collections.exercises.formatting.builders.asTable
import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPercentFormat

/**
 * Obtener por cada continente el % de la poblacion que suponen
 * respecto a su respectivo continente sus dos países más poblados
 */

fun getTwoMostPopulatedCountriesPercentByContinent(): Map<Continent, Double> {
    return Countries.WORLD_COUNTRIES
        .filterNot { it.continent == null }
        .filter { it.population != null }
        .groupBy { it.continent!! }
        .mapValues { entry ->
            entry.value
                .sortedByDescending { it.population }
                .mapNotNull { it.population }
                .map { it.toLong() }
                .let { continentCountriesPopulation ->
                val total = continentCountriesPopulation.sum()
                val top2Sum = continentCountriesPopulation.take(2).sum()
                top2Sum / total.toDouble()
            }
        }
}


fun getTwoMostPopulatedCountriesPercentByContinent2(): Map<Continent, Double> {
    return Countries.WORLD_COUNTRIES
        .filterNot { it.continent == null }
        .filter { it.population != null }
        .groupBy { it.continent!! }
        .mapValues { entry ->
            entry.value
                .sortedByDescending { it.population }
                .let { continentCountries ->
                    val total = continentCountries
                        .mapNotNull { it.population }
                        .sumOf { it.toLong() }

                    val top2Sum = continentCountries
                        .take(2)
                        .mapNotNull { it.population?.toLong() }
                        .sum()

                    top2Sum / total.toDouble()
                }
        }
}


private fun Map<Continent, Double>.prettyPrint() {
    map { (continent, percent) -> continent to percent.toPercentFormat() }
        .asTable {
            column {
                label = "continente"
                width = 11
                value = { it.first }
            }
            column {
                label = "porcentaje"
                alignment = ColumnAlignment.End
                value = { it.second }
            }
        }
        .display("Porcentajes de población de los 2 países más poblados por continente:")
}

fun printTwoMostPopulatedCountriesPercentByContinent() {
    getTwoMostPopulatedCountriesPercentByContinent()
        .map { (continent, percent) -> continent to percent.toPercentFormat() }
        .asTable {
            column {
                label = "continente"
                width = 11
                value = { it.first }
            }
            column {
                label = "porcentaje"
                alignment = ColumnAlignment.End
                value = { it.second }
            }
        }
        .display("Porcentajes de población de los 2 países más poblados por continente:")
}



fun main() {
    getTwoMostPopulatedCountriesPercentByContinent().prettyPrint()
    getTwoMostPopulatedCountriesPercentByContinent2().prettyPrint()
}
