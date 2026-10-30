package containers.collections.exercises.geography.model

import java.text.NumberFormat

@ConsistentCopyVisibility
data class Country private constructor(
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
        //if(surface == null) return@run null
        surface?.let {
            population / surface.value * Surface.M2_PER_KM2
        }
    }


    override fun hashCode() = iso3.hashCode()

    override fun equals(other: Any?) =
        (other as? Country)?.let { iso3 == it.iso3 } ?: false


    // Implementación de la comparación natural: Comparable
    // Los países se comparan de manera natural por su nombre
    override fun compareTo(other: Country) =
        compareValuesBy(this, other) { it.name }


    private val properties = mapOf(
        "" to iso3,
        "name" to name,
        "region" to region,
        "capital" to capital,
        "area" to area,
        "surface" to surface,
        "population" to population?.let { "${NumberFormat.getNumberInstance().format(it)} habs" },
        "density" to populationDensity?.let { "${"%.2f".format(it)} habs/Km²" }
    ).entries
        .filterNot { it.value == null }
        .map { (k, v) ->
            "$k${if (k.isNotBlank()) "=" else ""}$v"
        }


    override fun toString() = buildString {
        append("Country")
        append(properties.joinToString(separator = ", ", prefix = "(", postfix = ")"))
    }


    class CapitalBuilder {
        var name: String? = null
        var population: Int? = null

        fun build() = run {

            require(!name.isNullOrBlank()) {
                "El nombre de la ciudad po puede ser nulo o vacío"
            }
            // Creamos la instancia de City con los datos recopilados por el CapitalBuilder
            City(
                name = name!!,
                population = population?.let { Population(it) }
            )
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

    /**
     * Builder de instancias Country
     */
    class Builder(
        val iso3: String, // El código ISO3 es obligatorio en el constructor
        var name: String? = null // name lo podemos proporcionar en el constructor
    ) {
        var region: Region? = null
        private var capital: City? = null
        private var area: Area? = null
        var surface: Surface? = null
        var population: Int? = null

        //fun region(region: Region) = apply { this.region = region }

        /**
         * Función que construye una instancia de City (la capital del país)
         */
        fun capital(block: CapitalBuilder.() -> Unit) = apply {
            // Creamos un nuevo objeto CapitalBuilder
            // para que sea el receptor de la llamada a apply
            capital = CapitalBuilder()
                // a apply se le pasa el objeto función referenciado por block
                .apply(block) // block se invoca dentro de apply
                // apply devuelve su receptor (El CapitalBuilder) para poder llamar a build
                .build()
        }

        fun area(block: AreaBuilder.() -> Unit) = apply {
            area = AreaBuilder().apply { block() }.build()
        }

        fun surface(block: () -> Surface) =
            apply { surface = block() }

        //fun population(population: Int) =
        //    apply { this.population = population }


        /**
         * Metodo build que fabrica el objeto Country
         */
        fun build() = run {
            require(!name.isNullOrBlank()) {
                "El nombre del país no ser nulo o blanco"
            }
            Country(iso3, name!!, region, capital, area, surface,
                population
            )
        }
    }
}


/**
 * Función builder de instancias Country
 *
 * Se encarga de crear un Country.Builder, pasar los datos al constructor
 * y aplicar el bloque de código adicional para la construcción del objeto
 */
fun buildCountry(
    iso3: String,
    name: String? = null,
    block: Country.Builder.() -> Unit
) =
    Country.Builder(iso3, name)
        .apply(block)
        .build()

