package poo

import java.util.Objects

@ConsistentCopyVisibility
data class Card private constructor(val rank: Rank, val suit: Card.Suit) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }

    private val hashCode: Int = calculateHashCode(rank, suit)

    override fun hashCode(): Int = hashCode

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Card) return false

        if (hashCode != other.hashCode) return false
        if (rank != other.rank) return false
        if (suit != other.suit) return false

        return true
    }

    override fun toString() = "$rank de ${suit.toString().lowercase()}"


    companion object {

        val cards: Map<Int, Card> = buildMap {
            for (suit in Suit.entries) {
                for (rank in Rank.entries) {
                    val card = Card(rank, suit)
                    this += card.hashCode to card
                }
            }
        }

        fun calculateHashCode(rank: Rank, suit: Suit) = Objects.hash(suit, rank)


        fun of(rank: Rank, suit: Card.Suit): Card {
            //return cards.first { it.rank == rank && it.suit == suit }
            return cards[calculateHashCode(rank, suit)]!!
        }
    }


}


fun main() {
    for (card in Card.cards.values) {
        println(card)
    }

    //val aCard = Card(Card.Rank.As, Card.Suit.ESPADAS)
    val aCard = Card.of(Card.Rank.As, Card.Suit.ESPADAS)
    val aCard2 = Card.of(Card.Rank.As, Card.Suit.ESPADAS)

    println(aCard == aCard2) // Son iguales
    println(aCard === aCard2) // Son la misma

}