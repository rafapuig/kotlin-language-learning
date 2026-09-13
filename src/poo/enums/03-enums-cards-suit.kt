package poo.enums.suit

import poo.enums.suit.Suit.Color.*

enum class Suit(val symbol: Char, val color: Color) {

    HEARTS('♥', Red),
    DIAMONDS('♦', Red),
    CLUBS('♣', Black),
    SPADES('♠', Black);

    enum class Color { Red, Black }

    val description get() =  "$name ($symbol) - Color: $color"

    val isRed get() = color.name == "Red"
    val isBlack get() = color === Black
}


val Suit.colorEmoji get() =  if (isRed) "🔴" else "⚫"

val Suit.emoji get() = when (this) {
    Suit.HEARTS -> "♥️"
    Suit.CLUBS -> "️♣️"
    Suit.SPADES -> "♠️"
    Suit.DIAMONDS -> "♦️"
}

fun main() {

    for (suit in Suit.entries) {
        println("${suit.emoji} : ${suit.description} ${suit.colorEmoji}")
    }
}

