package containers.collections.exercises.geography.queries

import containers.collections.exercises.formatting.ColumnAlignment
import containers.collections.exercises.formatting.builders.asTable
import containers.collections.exercises.geography.display
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.toPopulationFormat


fun getPopulationByContinent() =
    Countries.WORLD_COUNTRIES
        .filterNot { it.continent == null }
        .groupBy { it.continent!! } // Para que el primer argumento de tipo del Map no sea anulable
        .mapValues { entry ->
            entry.value
                .mapNotNull { it.population }
                .map { it.toLong() }.sum()
        }


fun getPopulationByContinent2() =
    Countries.WORLD_COUNTRIES
        .filterNot { it.continent == null }
        .groupBy { it.continent!! }
        .mapValues { entry ->
            entry.value
                .mapNotNull { it.population }
                .sumOf { it.toLong() }
        }


fun getPopulationByContinent3() =
    Countries.WORLD_COUNTRIES
        .filterNot { it.continent == null }
        .groupBy { it.continent!! }
        .mapValues { entry ->
            entry.value.sumOf { it.population?.toLong() ?: 0L }
        }


fun getPopulationByContinent4() =
    Countries.WORLD_COUNTRIES
        .filterNot { it.continent == null }
        .groupBy { it.continent!! }
        .mapValues { entry ->
            entry.value
                .mapNotNull { it.population }
                .map { it.toLong() }
                .reduce { acc, population -> acc + population }
        }


fun printPopulationByContinent() {
    val result = getPopulationByContinent()

    result.entries
        .map { it.key to it.value.toPopulationFormat() }
        .display("Poblacion total por continente:")
}


fun printPopulationByContinent2() {
    val result = getPopulationByContinent2()

    result.entries
        .map {
            object {
                val continent = it.key
                val population = it.value
            }
        }
        .asTable {
            column {
                label = "continente"
                width = 12
                value = { it.continent }
            }
            column {
                label = "población"
                width = 20
                alignment = ColumnAlignment.End
                value = { it.population.toPopulationFormat() }
            }
        }.display("Poblacion total por continente:")

}

fun main() {
    printPopulationByContinent()
    printPopulationByContinent2()
}