package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPercentFormat

/**
 * Obtener por cada continente el % de la poblacion que suponen
 * respecto a su respectivo continente sus dos países más poblados
 */

fun getTwoMostPopulatedCountriesPercentByContinent(): Map<Continent?, Double> {
    return Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .groupBy { it.continent }
        .mapValues { it.value.sortedByDescending { it.population!! } }
        .mapValues { it.value.map { it.population!!.toLong() } }
        .mapValues {
            it.value.let { continentCountriesPopulation ->
                val total = continentCountriesPopulation.sum()
                val top2Sum = continentCountriesPopulation.take(2).sum()
                top2Sum / total.toDouble()
            }
        }
}

fun main() {

    getTwoMostPopulatedCountriesPercentByContinent()
        .map { (continent, percent) -> continent to percent.toPercentFormat()}
        .display("Porcentajes de población de los 2 países más poblados por continente:")

}
