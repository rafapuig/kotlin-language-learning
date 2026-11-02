package containers.collections.exercises.geography.formatting

import containers.collections.exercises.formatting.builders.buildTableFormatter
import containers.collections.exercises.formatting.builders.toTable
import containers.collections.exercises.geography.model.Country
import containers.collections.exercises.geography.model.Surface
import java.text.NumberFormat


/**
 * Creamos un TableFormatter a medida para formatear en forma de tabla
 * los elementos de una colección cuando son tipo Country
 */
val countryTableFormatter = buildTableFormatter {
    column {
        label = "ISO3"
        value = Country::iso3
    }
    column {
        label = "nombre"
        length = 13
        value = Country::name
    }
    column {
        label = "region"
        length = 25
        value = Country::region
    }
    column {
        label = "capital"
        length = 16
        value = { it.capital?.name }
    }
    column {
        label = "capital habs"
        format = NumberFormat.getIntegerInstance()
        value = { it.capital?.population?.value }
    }
    column {
        label = "superficie Km2"
        format = NumberFormat.getNumberInstance()
        value = { it.surface?.value?.div(Surface.M2_PER_KM2) }
    }
    column {
        label = "habitantes"
        length = 13
        format = NumberFormat.getIntegerInstance()
        value = Country::population
    }
    column {
        label = "densidad habs/km2"
        //length = 2
        format = NumberFormat.getNumberInstance()
            .apply {
                minimumFractionDigits = 2
                maximumFractionDigits = 2
            }
        value = Country::populationDensity
    }
}

/**
 * Para convertir una colección de objetos Country en un String con formato de tabla
 * llamamos a la función de extension toTable de Iterable<T>
 * pasando como argumento para el parámetro TableFormatter el countryTableFormatter
 */
fun Iterable<Country>.toTable() = toTable(countryTableFormatter)


/**
 * Para imprimir por consola una colección de objetos Country en formato de tabla
 * llamamos a la función toTable sin argumentos específica para Iterable<Country>
 * y el String resultante se imprime después de imprimir una línea con un título
 * si se especifica como argumento de llamada.
 */
fun Iterable<Country>.printAsTable(title: String = "") =
    toTable().let {
        if (title.isNotBlank()) println(title)
        print(it)
    }