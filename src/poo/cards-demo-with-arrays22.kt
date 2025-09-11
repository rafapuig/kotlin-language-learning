package poo.evolution.arrays.cards22

import poo.evolution.arrays.cards22.Card.Rank
import poo.evolution.arrays.cards22.Card.Suit


@ConsistentCopyVisibility
data class Card private constructor(val rank: Rank, val suit: Suit) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }

    override fun toString() = "$rank de ${suit.toString().lowercase()}"


    companion object {
        val totalCards = Suit.entries.size * Rank.entries.size

        val cards =
            buildList<Card>(totalCards) {
                for (suit in Suit.entries) {
                    for (rank in Rank.entries) {
                        this += Card(rank, suit)
                    }
                }
            }


        private fun calculateIndex(rank: Rank, suit: Suit) =
            suit.ordinal * Rank.entries.size + rank.ordinal

        operator fun List<Card>.get(rank: Rank, suit: Suit) = this[calculateIndex(rank, suit)]

        fun of(rank: Rank, suit: Suit): Card {
            return cards[rank, suit]
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