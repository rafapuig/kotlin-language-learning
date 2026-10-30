package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Area
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Surface

fun printAllCountriesWithKnownSurface() {
    val result = Countries.WORLD_COUNTRIES
        .filter { it.surface != null }

    data class NameSurfaceTuple(val name: String, val surface: Surface?)

    result
        .map { NameSurfaceTuple(it.name, it.surface) }
        .display("Todos los países con superficie conocida:")
}

fun main() {
    printAllCountriesWithKnownSurface()
}