package poo.interfaces

/**
 * Interface que define el comportamiento de una ficha de dominó
 */
interface DominoTile {
    val left: Int
    val right: Int

    fun canConnectWith(other: DominoTile): Boolean
    fun flip(): DominoTile
}

// Implementación concreta de una ficha estándar
class StandardTile(
    override val left: Int,
    override val right: Int
) : DominoTile {

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

    /**
     * Lista de fichas de dominó que el jugador tiene en su mano
     */
    val hand = mutableListOf<DominoTile>()

    /**
     * Jugar una ficha de dominó
     * boardEnd es el número no conectado a la otra ficha
     * de la ficha que está en la punta de la fila de fichas que están sobre la mesa
     */
    fun playTile(boardEnd: Int): DominoTile? {
        // Encontrar en la lista de fichas la primera que puede jugar
        val playable = hand.find { it.left == boardEnd || it.right == boardEnd }

        // Si se ha encontrado una ficha jugable ...
        if (playable != null) {
            hand.remove(playable) // Quitarla de la lista de fichas del jugador
            return playable
        }
        return null
    }
}

// Función principal de prueba
fun main() {
    val tile25 = StandardTile(2, 5)
    val tile56 = StandardTile(5, 6)
    val tile34 = StandardTile(3, 4)

    println("¿Pueden conectarse ${tile25} y ${tile56}? ${tile25.canConnectWith(tile56)}")
    println("¿Pueden conectarse ${tile25} y ${tile34}? ${tile25.canConnectWith(tile34)}")
    println("Ficha volteada: ${tile25.flip()}")

    val player = Player("Carlos")
    player.hand.addAll(listOf(tile25, tile56, tile34))

    val boardEnd = 5
    val tilePlayed = player.playTile(boardEnd)
    println("\n${player.name} jugó: $tilePlayed")
    println("Fichas restantes: ${player.hand}")
}
