package model.geography

import sun.java2d.Surface

data class Country(
    val iso3: String,
    val name: String,
    val region: Region? = null,
    val capital: City? = null,
    val surface: Area? = null,
    val population: Int? = null
) : Comparable<Country> {

    val populationDensity get() = population?.div(surface?.scalarValue ?: 1.0)

    override fun hashCode() = iso3.hashCode()

    override fun equals(other: Any?): Boolean {
        return (other as? Country)?.let { iso3 == it.iso3 } ?: false
        /*if (this === other) return true
        if (other !is Country) return false
        return iso3 == other.iso3*/
    }

    override fun compareTo(other: Country) =
        compareValuesBy(this, other) { it.name }


    class CapitalBuilder

    class Builder(val iso3: String, val name: String) {
        private var region: Region? = null
        private var capital: City? = null
        private var surface: Area? = null
        private var population: Int? = null

        fun population(population: Int) =
            apply { this.population = population }


        fun build(): Country =
            Country(iso3, name, region, capital, surface, population)

    }
}

fun buildCountry(iso3: String, name: String, block: Country.Builder.() -> Unit) =
    Country.Builder(iso3, name).apply(block).build()

