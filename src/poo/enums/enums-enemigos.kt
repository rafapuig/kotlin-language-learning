package intro.poo.enums

enum class TipoEnemigo(val vida: Int, val daño: Int, val velocidad: Double) {
    ZOMBIE(100, 10, 1.5),
    ESQUELETO(80, 15, 2.0),
    DEMONIO(200, 25, 3.5);

    // Poder total como una combinación de atributos (puede cambiarse según el juego)
    fun poderTotal(): Double {
        return vida * 0.5 + daño * 2 + velocidad * 10
    }

    // Determina si el enemigo es rápido según una velocidad mínima
    fun esRapido(umbral: Double = 2.5): Boolean {
        return velocidad > umbral
    }

    // Descripción general del enemigo
    fun descripcion(): String {
        val rapidez = if (esRapido()) "Rápido" else "Lento"
        return """
            === $name ===
            Vida: $vida
            Daño: $daño
            Velocidad: $velocidad ($rapidez)
            Poder total: ${"%.2f".format(poderTotal())}
        """.trimIndent()
    }
}

fun main() {
    for (enemigo in TipoEnemigo.values()) {
        println(enemigo.descripcion())
        println()
    }
}
