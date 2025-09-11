package poo.evolution.arrays.cards3

import poo.evolution.arrays.cards3.Card.Rank
import poo.evolution.arrays.cards3.Card.Suit


@ConsistentCopyVisibility
data class Card private constructor(val rank: Rank, val suit: Suit) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }

    override fun toString() = "$rank de ${suit.toString().lowercase()}"


    companion object {

        private val _cards = Array<Card?>(Suit.entries.size * Rank.entries.size) { null }

        private fun calculateIndex(rank: Rank, suit: Suit) =
            suit.ordinal * Rank.entries.size + rank.ordinal

        operator fun Array<Card?>.get(rank: Rank, suit: Suit) = this[calculateIndex(rank, suit)]
        operator fun Array<Card?>.set(rank: Rank, suit: Suit, card: Card) {
            val index = calculateIndex(rank, suit)
            this[index] = card
        }

        init {
            for (suit in Suit.entries) {
                for (rank in Rank.entries) {
                    _cards[rank,suit] = Card(rank, suit)
                }
            }
        }

        // Lista inmutable pero vinculada a los contenidos del array
        // Es una vista en forma de lista de los elementos del array
        val cards: List<Card> = _cards.asList().filterNotNull()


        fun of(rank: Rank, suit: Suit): Card {
            return _cards[rank, suit]!! // cards[calculateIndex(rank, suit)]
        }
    }
}

operator fun Iterable<Card>.get(rank: Rank, suit: Suit): Card = Card.of(rank, suit)


fun main() {

    //Card.cards[0] = Card.of(Card.Rank.Rey, Card.Suit.COPAS)

    for (card in Card.cards) {
        println(card)
    }


    //val aCard = Card(Card.Rank.As, Card.Suit.ESPADAS)
    val aCard = Card.of(Rank.Caballo, Suit.ESPADAS)
    val aCard2 = Card.of(Rank.Caballo, Suit.ESPADAS)

    println(aCard)
    println(aCard2)

    println(aCard == aCard2) // Son iguales
    println(aCard === aCard2) // Son la misma

    val aCard3 = Card.cards[Rank.Caballo, Suit.COPAS]
    println(aCard3)

}