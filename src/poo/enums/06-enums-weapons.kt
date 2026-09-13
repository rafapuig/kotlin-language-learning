package poo.enums.weapons

enum class Weapon(val damage: Int, val range: Int) {
    SWORD(50, 1),
    ARC(30, 5),
    SPIRE(40, 3)
}

val Weapon.description get() =  "Arma: ${name}, Daño: $damage, Alcance: $range"


fun main() {
    val arc = Weapon.ARC
    println(arc.description)

    for (weapon in Weapon.entries) {
        println(weapon.description)
    }

    Weapon.entries.forEach { entry -> println(entry.description) }
}
