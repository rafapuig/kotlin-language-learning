package model.geography

import sun.java2d.Surface
import java.text.NumberFormat

data class Country(
    val iso3: String,
    val name: String,
    val region: Region? = null,
    val capital: City? = null,
    val surface: Area? = null,
    val population: Int? = null
) : Comparable<Country> {

    val continent: Continent? = region?.continent

    val populationDensity
        get() = run {
            if (population == null) return@run null
            if (surface == null) return@run null
            population / (surface.to(SIUnit.KILO))
        }


    override fun hashCode() = iso3.hashCode()

    override fun equals(other: Any?): Boolean {
        return (other as? Country)?.let { iso3 == it.iso3 } ?: false
        /*if (this === other) return true
        if (other !is Country) return false
        return iso3 == other.iso3*/
    }

    override fun compareTo(other: Country) =
        compareValuesBy(this, other) { it.name }

    override fun toString(): String {
        return "Country(" +
                "$iso3, " +
                "$name, " +
                "$continent, " +
                "$region, " +
                "capital=$capital, " +
                "surface=$surface, " +
                "population=${NumberFormat.getNumberInstance().format(population)}, " +
                "density=${"%.2f".format(populationDensity)} habs/Km²" +
                ")"
    }


    class CapitalBuilder {
        var name: String? = null
        var population: Int? = null

        fun build() = run {
            require(!name.isNullOrBlank()) { "El nombre de la ciudad po puede ser nulo o vacio" }
            City(name!!, population)
        }
    }

    class AreaBuilder {
        var value: Long? = null
        var units: SIUnit = SIUnit.KILO

        fun build() = run {
            require(value != null) { "El valor del area no puede ser nulo" }
            Area(value!!, units)
        }
    }

    class Builder(val iso3: String, val name: String) {
        var region: Region? = null
        private var capital: City? = null
        private var surface: Area? = null
        var population: Int? = null

        //fun region(region: Region) = apply { this.region = region }

        fun capital(block: CapitalBuilder.() -> Unit) = apply {
            capital = CapitalBuilder().apply { block() }.build()
        }

        fun surface(block: AreaBuilder.() -> Unit) = apply {
            surface = AreaBuilder().apply { block() }.build()
        }

        //fun population(population: Int) =
        //    apply { this.population = population }


        fun build(): Country =
            Country(iso3, name, region, capital, surface, population)
    }

}

fun buildCountry(iso3: String, name: String, block: Country.Builder.() -> Unit) =
    Country.Builder(iso3, name).apply(block).build()

