package containers.collections.exercises.geography.formatting

import containers.collections.exercises.formatting.builders.buildTableFormatter
import containers.collections.exercises.formatting.builders.toTable
import containers.collections.exercises.geography.model.Country
import containers.collections.exercises.geography.model.Surface
import java.text.NumberFormat

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

fun List<Country>.toTable() = toTable(countryTableFormatter)

fun List<Country>.printAsTable(title:String = "") = toTable().let {
    if(title.isNotBlank()) println(title)
    print(it)
}