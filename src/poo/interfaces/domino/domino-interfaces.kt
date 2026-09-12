package poo.interfaces.domino

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


/**
 * Clase jugador
 * que puede colocar fichas y tiene una mano de fichas
 */
class Player(val name: String) {

    /**
     * Lista de fichas de dominó que el jugador tiene en su mano
     */
    val hand = mutableListOf<DominoTile>()

    /**
     * Buscar en la mano una ficha de dominó jugable
     * boardEnd es el número no conectado a la otra ficha
     * de la ficha que está en la punta de la fila de fichas que están sobre la mesa
     */
    fun findPlayableTile(boardEnd: Int): DominoTile? {

        // Encontrar en la lista de fichas la primera que puede jugar
        val playable = hand.find { it.left == boardEnd || it.right == boardEnd }

        // Si se ha encontrado una ficha jugable ...
        if (playable != null) {
            // Quitarla de la lista de fichas del jugador
            hand.remove(playable)

            // Devolverla como ficha de domino jugable
            return playable
        }
        return null
    }
}

// Función principal de prueba
fun main() {
    // Creamos 3 fichas de dominó
    val tile25 = StandardTile(2, 5) // [2|5]
    val tile56 = StandardTile(5, 6) // [5|6]
    val tile34 = StandardTile(3, 4) // [3|4]

    println("¿Pueden conectarse $tile25 y $tile56? ${tile25.canConnectWith(tile56)}")
    println("¿Pueden conectarse $tile25 y $tile34? ${tile25.canConnectWith(tile34)}")
    println("Ficha volteada: ${tile25.flip()}")

    // Creamos un jugador de dominó
    val player = Player("Carlitos")

    // Creamos una lista de fichas de dominó
    val dominoTiles = listOf(tile25, tile56, tile34)

    // Añadimos las ficha de la lista a la mano del jugador
    player.hand.addAll(dominoTiles)

    // La ficha de extremo de las fichas de la mesa tiene un valor de 5
    // (se podrá conectar con una ficha que tenga un 5 en alguno de sus lados
    val boardEnd = 5

    // Buscar en la mano del jugador una ficha que se pueda colocar en la mesa si el extremo es un 5
    val tileToPlay = player.findPlayableTile(boardEnd)

    // Imprimir la ficha de dominó jugada
    println("\n${player.name} jugó: $tileToPlay")

    // Imprimir las fichas restantes en la mano del jugador
    println("Fichas restantes: ${player.hand}")
}
