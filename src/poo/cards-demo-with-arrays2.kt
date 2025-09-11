package poo.evolution.arrays.cards2

import poo.evolution.arrays.cards2.Card.Rank
import poo.evolution.arrays.cards2.Card.Suit
import kotlin.collections.plusAssign

@ConsistentCopyVisibility
data class Card private constructor(val rank: Rank, val suit: Suit) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }

    override fun toString() = "$rank de ${suit.toString().lowercase()}"


    companion object {

        private val _cards =
            buildList<Card>(Suit.entries.size * Rank.entries.size) {
                for (suit in Suit.entries) {
                    for (rank in Rank.entries) {
                        this += Card(rank, suit)
                    }
                }
            }.toTypedArray()


        // Lista inmutable pero vinculada a los contenidos del array
        // Es una vista en forma de lista de los elementos del array
        val cards = _cards.asList()



        private fun calculateIndex(rank: Rank, suit: Suit) =
            suit.ordinal * Rank.entries.size + rank.ordinal

        operator fun Array<Card>.get(rank: Rank, suit: Suit) = this[calculateIndex(rank, suit)]

        fun of(rank: Rank, suit: Suit): Card {
            return _cards[rank, suit]
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


}