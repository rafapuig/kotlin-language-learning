package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries

fun printMostPopulatedCountryByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .groupBy { it.continent }
        .mapValues { it.value.maxByOrNull { it.population!! } }

    result.entries.display("Pais más poblado por continente:")
}

fun printMostPopulatedCountryByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .filterNot { it.population == null }
        .groupBy { it.continent }
        .mapValues { entry ->
            entry.value.maxByOrNull { it.population!! }?.let { country ->
                country.name to country.population
            }
        }

    result.entries.display("Pais más poblado por continente:")
}

fun main() {
    printMostPopulatedCountryByContinent()
    printMostPopulatedCountryByContinent2()
}