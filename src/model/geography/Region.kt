package model.geography

import model.geography.Continent.*

enum class Region(val continent: Continent, val displayName: String) {
    NORTH_AMERICA(AMERICAS, "Norteámerica"),
    SOUTH_AMERICA(AMERICAS, "Sudámerica"),
    CENTRAL_AMERICA(AMERICAS, "America Central"),
    CARIBBEAN(AMERICAS, "El Caribe"),
    WESTERN_EUROPE(EUROPE, "Europa Occidental"),
    EASTER_EUROPE(EUROPE, "Europa del Este"),
    NORTHERN_EUROPE(EUROPE, "Europa del Norte"),
    SOUTHERN_EUROPE(EUROPE, "Europa Meridional"),
    WESTERN_ASIA(ASIA, "Oriente Próximo"),
    EAST_ASIA(ASIA, "Extremo Oriente"),
    SOUTHEAST_ASIA(ASIA, "Sudeste Asiático"),
    CENTRAL_ASIA(ASIA, "Asia Central"),
    SOUTH_ASIA(ASIA, "Asia Meridional"),
    NORTHERN_AFRICA(AFRICA, "Norte de Africa"),
    WESTERN_AFRICA(AFRICA, "Oeste de Africa"),
    EASTERN_AFRICA(AFRICA, "Este de Africa"),
    CENTRAL_AFRICA(AFRICA, "Africa central"),
    SOUTHERN_AFRICA(AFRICA, "Sur de Africa"),
    AUSTRALIA_NEW_ZEALAND(AUSTRALIA, "Australia y Nueva Zelanda");

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