package generics.runtime.reified.example.game.engine

// Clases base del juego
open class GameObject(val name: String) {
    open fun info(): String = "GameObject: $name"
}

class Player(name: String, val level: Int = 1) : GameObject(name) {
    override fun info(): String = "Player: $name, level $level"
}

class Enemy(name: String, val damage: Int = 5) : GameObject(name) {
    override fun info(): String = "Enemy: $name, damage $damage"
}

class NPC(name: String, val role: String = "Villager") : GameObject(name) {
    override fun info(): String = "NPC: $name, role $role"
}

// Spawner genérico inline con reified y parámetros opcionales
inline fun <reified T : GameObject> spawn(name: String, params: Map<String, Any> = emptyMap()): T {
    return when (T::class) {
        Player::class -> {
            val level = params["level"] as? Int ?: 1
            Player(name, level) as T
        }
        Enemy::class -> {
            val damage = params["damage"] as? Int ?: 5
            Enemy(name, damage) as T
        }
        NPC::class -> {
            val role = params["role"] as? String ?: "Villager"
            NPC(name, role) as T
        }
        else -> throw IllegalArgumentException("Unknown GameObject type")
    }
}

// Filtrar por tipo usando reified
inline fun <reified T> List<Any>.filterByType(): List<T> = this.filterIsInstance<T>()

fun main() {
    // Crear lista de objetos heterogéneos
    val objects: MutableList<GameObject> = mutableListOf(
        spawn<Player>("Alice", mapOf("level" to 10)),
        spawn<Enemy>("Goblin", mapOf("damage" to 12)),
        spawn<NPC>("Old Man", mapOf("role" to "Shopkeeper")),
        spawn<Player>("Bob"),              // level por defecto
        spawn<Enemy>("Orc")                // damage por defecto
    )

    // Mostrar todos los objetos
    println("All GameObjects:")
    objects.forEach { println(it.info()) }

    // Filtrar por tipo
    val players = objects.filterByType<Player>()
    println("\nPlayers:")
    players.forEach { println(it.info()) }

    val enemies = objects.filterByType<Enemy>()
    println("\nEnemies:")
    enemies.forEach { println(it.info()) }

    val npcs = objects.filterByType<NPC>()
    println("\nNPCs:")
    npcs.forEach { println(it.info()) }
}
