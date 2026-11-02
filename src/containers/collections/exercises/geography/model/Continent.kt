package containers.collections.exercises.geography.model

enum class Continent(val displayName: String) {
    AMERICAS("America"),
    EUROPE("Europa"),
    ASIA("Asia"),
    AFRICA("Africa"),
    AUSTRALIA("Australia"),
    OCEANIA("Oceanía");

    override fun toString(): String = displayName
}


fun main() {

    // Imprimir los nombres de los continentes tal como indica su toString
    Continent.entries.forEach { println(it) }

    Continent.entries.forEach {
        with(it) {
            println("$ordinal - $name -> $displayName")
        }
    }
}