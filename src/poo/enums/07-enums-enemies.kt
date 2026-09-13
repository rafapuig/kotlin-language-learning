package poo.enums.enemies

enum class EnemyType(
    val life: Int,
    val damage: Int,
    val speed: Double
) {
    ZOMBIE(100, 10, 1.5),
    SKELETON(80, 15, 2.0),
    DEMON(200, 25, 3.5);

    // Poder total como una combinación de atributos (puede cambiarse según el juego)
    val totalPower get() = life * 0.5 + damage * 2 + speed * 10


    // Determina si el enemigo es rápido según una velocidad mínima umbral
    fun isFast(threshold: Double = 2.5) = speed > threshold


    // Descripción general del enemigo
    val description get() =
         """
            === $name ===
            Vida: $life
            Daño: $damage
            Velocidad: $speed (${if (isFast()) "Rápido" else "Lento"})            
            Poder total: ${"%.2f".format(totalPower)}
        """.trimIndent()
    }


fun main() {
    for (enemyType in EnemyType.entries) {
        println(enemyType.description)
        println()
    }
}
