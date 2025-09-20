package generics.runtime.reified.example.game.engine.with.events

// Clases base del juego
open class GameObject(val name: String) {
    open fun info(): String = "GameObject: $name"
    open fun handleEvent(event: GameEvent) {}
}

// Eventos genéricos
sealed class GameEvent
class DamageEvent(val amount: Int) : GameEvent()
class HealEvent(val amount: Int) : GameEvent()
class LevelUpEvent : GameEvent()

// Subclases con comportamiento específico
class Player(name: String, var level: Int = 1, var health: Int = 100) : GameObject(name) {
    override fun info(): String = "Player: $name, level $level, health $health"
    override fun handleEvent(event: GameEvent) {
        when (event) {
            is LevelUpEvent -> level++
            is HealEvent -> health += event.amount
            is DamageEvent -> health -= event.amount
        }
    }
}

class Enemy(name: String, var damage: Int = 5, var health: Int = 50) : GameObject(name) {
    override fun info(): String = "Enemy: $name, damage $damage, health $health"
    override fun handleEvent(event: GameEvent) {
        when (event) {
            is DamageEvent -> health -= event.amount
            is HealEvent -> health += event.amount
            // LevelUpEvent no aplica
            is LevelUpEvent -> {}
        }
    }
}

class NPC(name: String, val role: String = "Villager") : GameObject(name) {
    override fun info(): String = "NPC: $name, role $role"
    override fun handleEvent(event: GameEvent) {
        // NPC no responde a eventos de daño o nivel
    }
}

// Spawner genérico con parámetros tipados
inline fun <reified T : GameObject> spawn(
    name: String,
    level: Int = 1,
    damage: Int = 5,
    health: Int = 100,
    role: String = "Villager"
): T {
    return when (T::class) {
        Player::class -> Player(name, level, health) as T
        Enemy::class -> Enemy(name, damage, health) as T
        NPC::class -> NPC(name, role) as T
        else -> throw IllegalArgumentException("Unknown GameObject type")
    }
}

// Función inline con reified para enviar eventos a objetos de un tipo específico
inline fun <reified T : GameObject> List<GameObject>.sendEventToType(event: GameEvent) {
    this.filterIsInstance<T>().forEach { it.handleEvent(event) }
}

// Main: ejemplo de uso
fun main() {
    val objects: MutableList<GameObject> = mutableListOf(
        spawn<Player>("Alice", level = 10),
        spawn<Enemy>("Goblin", damage = 12),
        spawn<NPC>("Old Man", role = "Shopkeeper"),
        spawn<Player>("Bob"),
        spawn<Enemy>("Orc")
    )

    println("=== Initial state ===")
    objects.forEach { println(it.info()) }

    // Eventos
    println("\n=== Sending events ===")
    objects.sendEventToType<Player>(LevelUpEvent())       // Todos los jugadores suben de nivel
    objects.sendEventToType<Enemy>(DamageEvent(10))       // Todos los enemigos reciben daño
    objects.sendEventToType<Player>(HealEvent(20))        // Todos los jugadores sanan 20 puntos

    println("\n=== After events ===")
    objects.forEach { println(it.info()) }
}
