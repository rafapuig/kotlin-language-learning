data class DominoTile(val left: Int, val right: Int) {

    fun matches(value: Int): Boolean = left == value || right == value

    fun flipped(): DominoTile = DominoTile(right, left)

    override fun toString() = "[$left|$right]"
}

class DominoTable {
    private val table = mutableListOf<DominoTile>()

    val leftEnd get() = table.firstOrNull()?.left
    val rightEnd get() = table.firstOrNull()?.right

    fun add(tile: DominoTile) {
        val leftEnd = leftEnd!!
        val rightEnd = rightEnd!!


        with(tile) {
            if (table.isEmpty()) {
                table.add(this)
            } else {
                if (matches(leftEnd)) {
                    val tileToPlace = if (right == leftEnd) this else flipped()
                    table.add(0, tileToPlace)
                } else {
                    let { if (left == rightEnd) this else flipped() }
                        .also { tileToPlace -> table.add(tileToPlace) }
                }
            }
        }
    }

}


fun main() {
    val players = listOf(
        mutableListOf(DominoTile(1, 2), DominoTile(3, 5), DominoTile(6, 6)),
        mutableListOf(DominoTile(2, 4), DominoTile(0, 6), DominoTile(3, 3)),
        mutableListOf(DominoTile(1, 1), DominoTile(5, 5), DominoTile(2, 2)),
        mutableListOf(DominoTile(0, 0), DominoTile(1, 3), DominoTile(4, 6))
    )

    val table = mutableListOf<DominoTile>()  // línea de fichas jugadas
    var round = 1

    outer@ while (round <= 20) { // límite de rondas para evitar bucles infinitos
        println("\n🔁 Round $round")
        var anyonePlayed = false

        for ((playerIndex, handPlayer) in players.withIndex()) {
            println("🎮 Player ${playerIndex + 1}'s turn - Hand: $handPlayer")

            val leftEnd = table.firstOrNull()?.left
            val rightEnd = table.lastOrNull()?.right

            val playableTile = handPlayer.firstOrNull { tile ->
                with(tile) {
                    table.isEmpty() || matches(leftEnd!!) || matches(rightEnd!!)
                }
            }

            if (playableTile != null) {
                handPlayer.remove(playableTile)
                anyonePlayed = true

                // Decide dónde colocar la ficha
                if (table.isEmpty()) {
                    table.add(playableTile)
                } else if (playableTile.matches(leftEnd!!)) {
                    val tileToPlace = if (playableTile.right == leftEnd) playableTile else playableTile.flipped()
                    table.add(0, tileToPlace)
                } else {
                    val tileToPlace = if (playableTile.left == rightEnd) playableTile else playableTile.flipped()
                    table.add(tileToPlace)
                }

                println("    ✅ Player ${playerIndex + 1} plays $playableTile")
                println("    🁫 Table: $table")

                if (handPlayer.isEmpty()) {
                    println("🏆 Player ${playerIndex + 1} wins the game!")
                    break@outer
                }

            } else {
                println("    ❌ No valid moves.")
            }
        }

        if (!anyonePlayed) {
            println("⚠️ No one can play. Skipping round.")
            continue@outer
        }

        round++
    }

    println("🎮 Game Over.")
}
