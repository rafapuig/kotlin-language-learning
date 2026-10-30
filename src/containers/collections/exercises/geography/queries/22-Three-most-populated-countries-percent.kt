package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPercentFormat

/**
 * Obtener el porcentaje de la poblacion mundial que suman
 * los tres países más poblados
 */
fun getThreeMostPopulatedCountriesPercent(): Double =
    Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .sortedByDescending { it.population }
        .let { countries ->
            val total = countries.sumOf { it.population!!.toLong() }
            val sum3 = countries
                .take(3)
                .sumOf { it.population!!.toLong() }
            sum3 / total.toDouble()
        }

fun main() {
    println(
        "Porcentaje de población mundial de los 3 países más habitados = ${
            getThreeMostPopulatedCountriesPercent().toPercentFormat()
        }"
    )
}

