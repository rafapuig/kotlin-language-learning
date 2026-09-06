package imperative.controlflow.loops.`while`

fun main() {
    val totalRounds = 3
    val totalPlayers = 4

    var round = 1

    outer@ while (round <= totalRounds) {
        println("🔁 Round $round")

        var player = 1
        while (player <= totalPlayers) {
            println("  🎮 Player $player's turn")

            val hasValidMove = (1..10).random() > 3  // 70% de tener una jugada válida
            val wins = (1..100).random() == 1        // 1% de ganar (simulación)

            if (!hasValidMove) {
                println("    ❌ No valid moves. Skipping to next round.")
                continue@outer
            }

            if (wins) {
                println("    🏆 Player $player wins the game!")
                break@outer
            }

            println("    ✅ Player $player plays a tile.")
            player++
        }

        round++
    }

    println("🎮 Game ended.")
}
