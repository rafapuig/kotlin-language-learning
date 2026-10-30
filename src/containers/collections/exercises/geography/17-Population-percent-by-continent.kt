package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries


fun printPopulationPercentByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!! }
            val continentsTotals = it
                .groupBy { it.continent }
                .mapValues { it.value.sumOf { it.population!! } }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }

    result.entries.display("Porcentaje poblacion por continente:")
}


fun printPopulationPercentByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.population != null }
        .let {
            val total = it.sumOf { it.population!! }
            val continentsTotals = it
                .groupingBy { it.continent }
                .fold(0) { acc, country ->
                    acc + country.population!!
                }
            continentsTotals.mapValues { it.value / total.toDouble() }
        }

    result.entries.display("Porcentaje poblacion por continente:")
}

fun main() {
    printPopulationPercentByContinent()
    printPopulationPercentByContinent2()
}

