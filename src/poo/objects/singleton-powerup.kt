package poo.objects

object PowerUpDispenser {
    private val powerUps = listOf(
        "Super velocidad",
        "Invisibilidad",
        "Escudo protector",
        "Doble daño",
        "Regeneración rápida",
        "Salto doble",
        "Rayo congelante"
    )

    private var usesLeft = 3

    fun dispensePowerUp(): String {
        return if (usesLeft > 0) {
            usesLeft--
            val power = powerUps.random()
            "Has recibido: $power. Usos restantes: $usesLeft"
        } else {
            "La máquina está vacía. Espera a que se recargue."
        }
    }

    fun recharge() {
        usesLeft = 3
        println("La máquina se ha recargado.")
    }
}

fun main() {
    println(PowerUpDispenser.dispensePowerUp())
    println(PowerUpDispenser.dispensePowerUp())
    println(PowerUpDispenser.dispensePowerUp())
    println(PowerUpDispenser.dispensePowerUp())

    PowerUpDispenser.recharge()
    println(PowerUpDispenser.dispensePowerUp())
}
