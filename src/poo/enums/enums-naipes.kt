package intro.poo.enums

enum class Suit(val symbol: Char, val color: String) {
    HEARTS('♥', "Red"),
    DIAMONDS('♦', "Red"),
    CLUBS('♣', "Black"),
    SPADES('♠', "Black");

    fun description(): String {
        return "$name ($symbol) - Color: $color"
    }

    fun isRed(): Boolean = color == "Red"
    fun isBlack(): Boolean = color == "Black"
}



fun main() {
    for (suit in Suit.entries) {

        val colorEmoji = if (suit.isRed()) "🔴" else "⚫"

        val suitEmoji = when (suit) {
            Suit.HEARTS -> "♥️"
            Suit.CLUBS -> "️♣️"
            Suit.SPADES-> "♠️"
            Suit.DIAMONDS ->"♦️"
        }

        println("$suitEmoji : ${suit.description()} $colorEmoji")
    }
}

