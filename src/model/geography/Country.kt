package model.geography

import java.text.NumberFormat

data class Country(
    val iso3: String,
    val name: String,
    val region: Region? = null,
    val capital: City? = null,
    val area: Area? = null,
    val surface: Surface? = null,
    val population: Int? = null
) : Comparable<Country> {

    val continent: Continent? = region?.continent

    val populationDensity = run {
        if (population == null) return@run null
        if (area == null) return@run null
        population / (area.to(ISUnit.KILO).value.toFloat())
    }


    override fun hashCode() = iso3.hashCode()

    override fun equals(other: Any?)=
         (other as? Country)?.let { iso3 == it.iso3 } ?: false


    override fun compareTo(other: Country) =
        compareValuesBy(this, other) { it.name }

    override fun toString() =
        "Country(" +
                "$iso3, " +
                "$name, " +
                "$continent, " +
                "$region, " +
                "capital=$capital, " +
                "surface=$area, " +
                "population=${NumberFormat.getNumberInstance().format(population)}, " +
                "density=${"%.2f".format(populationDensity)} habs/Km²" +
                ")"


    class CapitalBuilder {
        var name: String? = null
        var population: Int? = null

        fun build() = run {
            require(!name.isNullOrBlank()) { "El nombre de la ciudad po puede ser nulo o vacío" }
            City(name!!, population)
        }
    }

    class AreaBuilder {
        var value: Long? = null
        var units: ISUnit = ISUnit.KILO

        fun build() = run {
            require(value != null) { "El valor del area no puede ser nulo" }
            Area(value?.toFloat() ?: 0f, units)
        }
    }

    class Builder(val iso3: String, val name: String) {
        var region: Region? = null
        private var capital: City? = null
        private var area: Area? = null
        var surface: Surface? = null
        var population: Int? = null

        //fun region(region: Region) = apply { this.region = region }

        fun capital(block: CapitalBuilder.() -> Unit) = apply {
            capital = CapitalBuilder().apply { block() }.build()
        }

        fun area(block: AreaBuilder.() -> Unit) = apply {
            area = AreaBuilder().apply { block() }.build()
        }

        fun surface(block: () -> Surface) =
            apply { surface = block() }

        //fun population(population: Int) =
        //    apply { this.population = population }


        fun build() = Country(iso3, name, region, capital, area, surface, population)
    }
}


fun buildCountry(iso3: String, name: String, block: Country.Builder.() -> Unit) =
    Country.Builder(iso3, name).apply(block).build()

