package poo.interfaces

// Interfaz que define el comportamiento de una ficha de dominó
interface DominoTile {
    val left: Int
    val right: Int

    fun canConnectWith(other: DominoTile): Boolean
    fun flip(): DominoTile
}

// Implementación concreta de una ficha estándar
class StandardTile(override val left: Int, override val right: Int) : DominoTile {
    override fun canConnectWith(other: DominoTile): Boolean {
        return this.right == other.left || this.right == other.right ||
                this.left == other.left || this.left == other.right
    }

    override fun flip(): DominoTile {
        return StandardTile(right, left)
    }

    override fun toString(): String = "[$left|$right]"
}

// Clase jugador que puede colocar fichas
class Player(val name: String) {
    val hand = mutableListOf<DominoTile>()

    fun playTile(boardEnd: Int): DominoTile? {
        val playable = hand.find { it.left == boardEnd || it.right == boardEnd }
        if (playable != null) {
            hand.remove(playable)
            return playable
        }
        return null
    }
}

// Función principal de prueba
fun main() {
    val tile1 = StandardTile(2, 5)
    val tile2 = StandardTile(5, 6)
    val tile3 = StandardTile(3, 4)

    println("¿Pueden conectarse ${tile1} y ${tile2}? ${tile1.canConnectWith(tile2)}")
    println("¿Pueden conectarse ${tile1} y ${tile3}? ${tile1.canConnectWith(tile3)}")
    println("Ficha volteada: ${tile1.flip()}")

    val player = Player("Carlos")
    player.hand.addAll(listOf(tile1, tile2, tile3))

    val boardEnd = 5
    val tilePlayed = player.playTile(boardEnd)
    println("\n${player.name} jugó: $tilePlayed")
    println("Fichas restantes: ${player.hand}")
}
