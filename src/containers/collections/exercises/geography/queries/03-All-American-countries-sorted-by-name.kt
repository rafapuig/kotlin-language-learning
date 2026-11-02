package containers.collections.exercises.geography.queries

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Country

fun getAllAmericanCountriesSortedByName() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedBy { it.name } // Usando una lambda como selector


fun getAllAmericanCountriesSortedByName1() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedBy(Country::name) // Usando una referencia a metodo como selector


fun getAllAmericanCountriesSortedByName2() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        // usando un comparador creado con compareBy
        .sortedWith(compareBy { it.name })


fun getAllAmericanCountriesSortedByName3() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        // usando un comparador creado mediante una lambda implementando el SAM
        .sortedWith { c1, c2 ->
            compareBy<Country> { it.name }.compare(c1, c2)
        }


fun getAllAmericanCountriesSortedByName4() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedWith { c1, c2 ->
            compareValues(c1.name, c2.name)
        }


fun getAllAmericanCountriesSortedByName5() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedWith { c1, c2 ->
            compareValuesBy(c1, c2) { it.name } // selector mediante lambda
        }


fun getAllAmericanCountriesSortedByName6() =
    Countries.WORLD_COUNTRIES
        .filter { it.continent == Continent.AMERICAS }
        .sortedWith { c1, c2 ->
            compareValuesBy(c1, c2, Country::name) // selector con referencia a metodo
        }


private fun List<Country>.print() {
    println("Todos los países de ${Continent.AMERICAS} ordenados por nombre:")
    println("----------------------------------------------------------")
    joinToString { it.name }.let { println(it) }
    println()
}

fun main() {
    getAllAmericanCountriesSortedByName().print()
    getAllAmericanCountriesSortedByName1().print()
    getAllAmericanCountriesSortedByName2().print()
    getAllAmericanCountriesSortedByName3().print()
    getAllAmericanCountriesSortedByName4().print()
    getAllAmericanCountriesSortedByName5().print()
    getAllAmericanCountriesSortedByName6().print()
}