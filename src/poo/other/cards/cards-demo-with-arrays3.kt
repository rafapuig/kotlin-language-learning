package poo.cards.arrays3

import poo.cards.arrays2.get
import poo.cards.arrays3.Card.Rank
import poo.cards.arrays3.Card.Suit


class Card private constructor(
    val rank: Rank,
    val suit: Suit
) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }

    override fun toString() = "$rank de ${suit.toString().lowercase()}"


    companion object {

        // El número total de cartas es la combinación de cada palo con cada valor posible
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

        fun of(rank: Rank, suit: Suit): Card =
             cards[calculateIndex(rank, suit)]

    }
}

/**
 * Metodo de extension operador [] para clase receptora Iterable<Card>
 * Delega en el metodo factoria of
 */
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

    /**
     * Uso del metodo de extension del operador []
     */
    val aCard3 = Card.cards[Rank.Caballo, Suit.COPAS]

    // Alternativamente, podemos usar el nombre explícito de la función correspondiente asociada al operador []
    val card4 = Card.cards.get(Rank.Caballo, Suit.COPAS)

}
