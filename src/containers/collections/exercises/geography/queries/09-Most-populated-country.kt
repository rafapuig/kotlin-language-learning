package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country
import containers.collections.exercises.geography.toNumericFormat
import containers.collections.exercises.geography.toPopulationFormat


fun printMostPopulatedCountry() {
    val result: Country? = Countries.WORLD_COUNTRIES
        .maxByOrNull{ country -> country.population ?: Int.MIN_VALUE }

    printResult(result)
}

fun printMostPopulatedCountry2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .maxByOrNull { it.population!! }

    printResult(result)
}

private fun printResult(country: Country?) {
    val message =
        if (country != null)
            "El país más poblado es ${country.name} con ${country.population.toNumericFormat()} habitantes"
        else
            "Ninguno"
    println(message)
}

fun main() {
    printMostPopulatedCountry()
    printMostPopulatedCountry2()
}