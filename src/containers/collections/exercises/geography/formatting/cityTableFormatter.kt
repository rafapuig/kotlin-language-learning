package containers.collections.exercises.geography.formatting

import containers.collections.exercises.formatting.builders.buildColumnInfo
import containers.collections.exercises.formatting.builders.buildTableFormatter
import containers.collections.exercises.formatting.builders.toTable
import containers.collections.exercises.geography.model.City
import java.text.NumberFormat

val standardCityNameColumn = buildColumnInfo {
    label = "nombre"
    width = 13
    value = City::name
}

val standardCityPopulationColumn = buildColumnInfo {
    label = "habitantes"
    width = 13
    format = NumberFormat.getIntegerInstance()
    value = { city: City -> city.population?.value }
}

/**
 * Creamos un TableFormatter a medida para formatear en forma de tabla
 * los elementos de una colección cuando son tipo City
 */
val cityTableFormatter = buildTableFormatter {
    column(standardCityNameColumn)
    column(standardCityPopulationColumn)
}

/**
 * Para convertir una colección de objetos Country en un String con formato de tabla
 * llamamos a la función de extension toTable de Iterable<T>
 * pasando como argumento para el parámetro TableFormatter el countryTableFormatter
 */
fun Iterable<City>.toTable() = toTable(cityTableFormatter)


/**
 * Para imprimir por consola una colección de objetos Country en formato de tabla
 * llamamos a la función toTable sin argumentos específica para Iterable<Country>
 * y el String resultante se imprime después de imprimir una línea con un título
 * si se especifica como argumento de llamada.
 */
fun Iterable<City>.printAsTable(title: String = "") =
    toTable().let {
        if (title.isNotBlank()) println(title)
        print(it)
    }


