package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries


fun printMostAndLeastPopulatedCountryByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .groupBy { it.continent }
        .mapValues {
            val most = it.value.maxByOrNull { it.population!! }
            val least = it.value.minByOrNull { it.population!! }
            listOf(most, least)
        }

    result.entries.display("Pais mas y menos poblado por continente:")
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

    result.entries.display("Pais mas y menos poblado por continente:")
}

fun main() {
    printMostAndLeastPopulatedCountryByContinent()
    printMostAndLeastPopulatedCountryByContinent2()
}