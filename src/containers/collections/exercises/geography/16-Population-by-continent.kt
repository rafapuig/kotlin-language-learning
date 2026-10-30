package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Countries

fun printPopulationByContinent() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues { it.value.mapNotNull { it.population }.sum() }

    result.entries.display("Poblacion total por continente:")
}

fun printPopulationByContinent2() {
    val result = Countries.WORLD_COUNTRIES
        .groupBy { it.continent }
        .mapValues {
            it.value.mapNotNull { it.population }
                .reduce { acc, population -> acc + population }
        }

    result.entries.display("Poblacion total por continente:")
}

fun main() {
    printPopulationByContinent()
    printPopulationByContinent2()
}