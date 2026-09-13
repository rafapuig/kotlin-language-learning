package poo.cards.arrays6

import poo.cards.arrays6.Card.Rank
import poo.cards.arrays6.Card.Suit


@ConsistentCopyVisibility
data class Card private constructor(val rank: Rank, val suit: Suit) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }

    override fun toString() = "$rank de ${suit.toString().lowercase()}"


    companion object {

        private val totalCards = Suit.entries.size * Rank.entries.size

        @JvmInline
        private value class Position(val index: Int) {
            val rank: Rank get() = Rank.entries[index % Rank.entries.size]
            val suit: Suit get() = Suit.entries[index / Rank.entries.size]

            constructor(rank: Rank, suit: Suit) :
                    this(suit.ordinal * Rank.entries.size + rank.ordinal)
        }


        private val _cards = Array<Card>(totalCards) { index ->
            with(Position(index)) {
                Card(rank, suit)
            }
        }

        fun of(rank: Rank, suit: Suit): Card = _cards[Position(rank, suit).index]

        // Lista inmutable, pero vinculada a los contenidos del array
        // Es una vista en forma de lista de los elementos del array
        val cards = _cards.asList()
    }

}


fun main() {
    //Card.cards[0] = Card.of(Card.Rank.Rey, Card.Suit.COPAS)

    for (card in Card.cards) {
        println(card)
    }

    //val card = Card(Rank.As, Suit.ESPADAS)
    val card1 = Card.of(Rank.Caballo, Suit.ESPADAS)
    val card2 = Card.of(Card.Rank.Caballo, Suit.ESPADAS)

    println(card1)
    println(card2)

    println(card1 == card2) // Son iguales
    println(card1 === card2) // Son la misma
}