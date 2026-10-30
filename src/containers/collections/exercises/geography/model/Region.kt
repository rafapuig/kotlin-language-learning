package containers.collections.exercises.geography.model

enum class Region(
    val continent: Continent,
    val displayName: String
) {
    NORTH_AMERICA(Continent.AMERICAS, "Norteamérica"),
    SOUTH_AMERICA(Continent.AMERICAS, "Sudamérica"),
    CENTRAL_AMERICA(Continent.AMERICAS, "América Central"),
    CARIBBEAN(Continent.AMERICAS, "El Caribe"),
    WESTERN_EUROPE(Continent.EUROPE, "Europa Occidental"),
    EASTER_EUROPE(Continent.EUROPE, "Europa del Este"),
    NORTHERN_EUROPE(Continent.EUROPE, "Europa del Norte"),
    SOUTHERN_EUROPE(Continent.EUROPE, "Europa Meridional"),
    WESTERN_ASIA(Continent.ASIA, "Oriente Próximo"),
    EAST_ASIA(Continent.ASIA, "Extremo Oriente"),
    SOUTHEAST_ASIA(Continent.ASIA, "Sudeste Asiático"),
    CENTRAL_ASIA(Continent.ASIA, "Asia Central"),
    SOUTH_ASIA(Continent.ASIA, "Asia Meridional"),
    NORTHERN_AFRICA(Continent.AFRICA, "Norte de Africa"),
    WESTERN_AFRICA(Continent.AFRICA, "Oeste de Africa"),
    EASTERN_AFRICA(Continent.AFRICA, "Este de Africa"),
    CENTRAL_AFRICA(Continent.AFRICA, "Africa central"),
    SOUTHERN_AFRICA(Continent.AFRICA, "Sur de Africa"),
    AUSTRALIA_NEW_ZEALAND(Continent.AUSTRALIA, "Australia y Nueva Zelanda");

    override fun toString(): String = displayName
}


fun main() {

    Region.entries.forEach { println(it) }

    Region.entries.forEach {
        with(it) {
            println("$ordinal - $name -> $displayName")
        }
    }
}