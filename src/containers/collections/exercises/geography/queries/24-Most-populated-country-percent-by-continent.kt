package containers.collections.exercises.geography.queries

import containers.collections.exercises.formatting.ColumnAlignment
import containers.collections.exercises.formatting.builders.asTable
import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country
import containers.collections.exercises.geography.toPercentFormat

/**
 * Obtener por cada continent el porcentaje de poblacion
 * que este país representa sobre el total de la poblacion
 * del continente al que pertenece
 */

fun getMostPopulatedCountryPercentByContinent(): Map<Continent, Double> {
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
                    val most = continentCountriesPopulation.first()
                    most / total.toDouble()
                }
        }
}


fun getMostPopulatedCountryPercentByContinent2(): Map<Continent, Pair<Country, Double>> {
    return Countries.WORLD_COUNTRIES
        .filterNot { it.continent == null }
        .filter { it.population != null }
        .groupBy { it.continent!! }
        .filterValues { it.isNotEmpty() } // El continente tiene países con información sobre su población
        .mapValues { entry ->
            entry.value
                .sortedByDescending { it.population }
                .let { continentCountries ->
                    val total = continentCountries
                        .mapNotNull { it.population }
                        .sumOf { it.toLong() }

                    val mostPopulatedInContinent = continentCountries
                        .maxBy { it.population!! }

                    mostPopulatedInContinent.let {
                        it to (it.population!! / total.toDouble())
                    }
                }
        }
}


private fun Map<Continent, Double>.prettyPrint() {
    map { (continent, percent) -> continent to percent }
        .asTable {
            column {
                label = "continente"
                width = 11
                value = { it.first }
            }
            column {
                label = "porcentaje"
                alignment = ColumnAlignment.End
                value = { it.second.toPercentFormat() }
            }
        }
        .display("Porcentajes de población del país más poblado de cada continente:")
}


private fun Map<Continent, Pair<Country, Double>>.prettyPrint2() {
    map {
        object {
            val continent = it.key
            val country = it.value.first
            val percentage = it.value.second
        }
    }.asTable {
        column {
            label = "continente"
            width = 11
            value = { it.continent }
        }
        column {
            label = "país"
            width = 11
            value = { it.country.name }
        }
        column {
            label = "porcentaje"
            alignment = ColumnAlignment.End
            value = { it.percentage.toPercentFormat() }
        }
    }.display("Porcentajes de población del país más poblado de cada continente:")
}

fun main() {
    getMostPopulatedCountryPercentByContinent().prettyPrint()
    getMostPopulatedCountryPercentByContinent2().prettyPrint2()
}