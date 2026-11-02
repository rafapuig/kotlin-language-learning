package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country
import containers.collections.exercises.geography.toPopulationFormat
import containers.collections.exercises.operations.teeing


fun printMostAndLeastPopulatedCountryByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .groupBy { it.continent }
        .mapValues {
            val most = it.value.maxByOrNull { it.population!! }
            val least = it.value.minByOrNull { it.population!! }
            listOf(most, least)
        }

    printResult(result)
}

fun printMostAndLeastPopulatedCountryByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues {
            it.value.teeing(
                { it.maxByOrNull { it.population ?: Int.MIN_VALUE } },
                { it.minByOrNull { it.population ?: Int.MAX_VALUE } },
            ) { most, least -> listOf(most, least) }
        }

    printResult(result)
}

private fun printResult(result: Map<Continent?, List<Country?>>) {
    result.entries
        .map {
            listOf(
                it.key?.displayName,
                "mas poblado",
                it.value.first()?.name,
                it.value.first()?.population.toPopulationFormat(),
                "menos poblado",
                it.value.last()?.name,
                it.value.last()?.population.toPopulationFormat()
            )
        }
        .display("Pais mas y menos poblado por continente:")
}

fun main() {
    printMostAndLeastPopulatedCountryByContinent()
    printMostAndLeastPopulatedCountryByContinent2()
}