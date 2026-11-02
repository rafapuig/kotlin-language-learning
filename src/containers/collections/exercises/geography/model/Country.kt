package containers.collections.exercises.geography.model

import containers.collections.exercises.geography.model.builders.CityBuilder
import java.text.NumberFormat

@ConsistentCopyVisibility
data class Country private constructor(
    val iso3: String,
    val name: String,
    val region: Region? = null,
    val capital: City? = null,
    val surface: Surface? = null,
    val population: Int? = null
) : Comparable<Country> {

    val continent: Continent? = region?.continent

    // Propiedad calculada de solo lectura y cacheada
    val populationDensity = run {
        surface?.let {
            // Smart cast de surface
            // (dentro del bloque se considera de tipo no anulable)
            population?.div(surface.value * Surface.M2_PER_KM2)
        }
    }


    // El código hash lo determina el código ISO3
    // (Si dos países son iguales tienen el mismo código hash)
    // (Si tienen el mismo código hash no tienen por qué ser iguales)
    override fun hashCode() = iso3.hashCode()

    // Dos países son iguales si tienen el mismo código ISO3
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
        "surface" to surface,
        "population" to population?.let {
            "${NumberFormat.getNumberInstance().format(it)} habs"
        },
        "density" to populationDensity?.let {
            "${"%.2f".format(it)} habs/Km²"
        }
    ).entries
        .filterNot { it.value == null }
        .map { (key, value) ->
            "${if (key.isNotBlank()) "$key=" else ""}$value"
        }


    override fun toString() = buildString {
        append("Country")
        append(
            properties.joinToString(
                separator = ", ",
                prefix = "(",
                postfix = ")"
            )
        )
    }


    /**
     * Builder de instancias Country
     * Tiene que ser una clase interna anidada en la clase Country
     * para poder tener acceso al constructor de Country (que es privado)
     */
    class Builder(
        val iso3: String, // El código ISO3 es obligatorio en el constructor
        var name: String? = null // name lo podemos proporcionar en el constructor
    ) {
        // Otras propiedades para recopilar datos con los que construir el objeto Country
        var region: Region? = null
        private var capital: City? = null

        //private var area: Area? = null
        var surface: Surface? = null
        var population: Int? = null

        //fun region(region: Region) = apply { this.region = region }

        /**
         * Función que construye una instancia de City (la capital del país)
         */
        fun capital(block: CityBuilder.() -> Unit) = apply {
            // Creamos un nuevo objeto CapitalBuilder
            // para que sea el receptor de la llamada a apply
            capital = CityBuilder()
                // a apply se le pasa el objeto función referenciado por block
                .apply(block) // block se invoca dentro de apply
                // apply devuelve su receptor (El CapitalBuilder) para poder llamar a build
                .build()
        }

        /*fun area(block: AreaBuilder.() -> Unit) = apply {
            area = AreaBuilder().apply { block() }.build()
        }*/

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
            Country(iso3, name!!, region, capital, surface, population)
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
    Country.Builder(iso3, name).apply { block() }.build()