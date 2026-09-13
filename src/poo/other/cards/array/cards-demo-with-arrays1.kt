package poo.cards.arrays

import poo.cards.arrays.Card.Suit
import poo.cards.arrays.Card.Rank

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

        private fun getRankOrdinal(index: Int) = index % Rank.entries.size
        private fun getSuitOrdinal(index: Int) = index / Rank.entries.size

        private fun getRank(index: Int): Rank = Rank.entries[getRankOrdinal(index)]
        private fun getSuit(index: Int): Suit = Suit.entries[getSuitOrdinal(index)]

        private val _cards = Array<Card>(totalCards) { index ->
            Card(getRank(index), getSuit(index))
        }

        // Lista inmutable, pero vinculada a los contenidos del array
        // Es una vista en forma de lista de los elementos del array
        val cards = _cards.asList() //get() = _cards.copyOf()


        private fun calculateIndex(rank: Rank, suit: Suit) =
            suit.ordinal * Rank.entries.size + rank.ordinal


        fun of(rank: Rank, suit: Suit): Card {
            return cards[calculateIndex(rank, suit)]
        }
    }

}


fun main() {
    //Card.cards[0] = Card.of(Rank.Rey, Suit.COPAS) // ERROR, la lista es inmutable no se puede modificar elementos

    // Imprimir todas las cartas de la lista
    for (card in Card.cards) {
        println(card)
    }


    //val card = Card(Card.Rank.As, Card.Suit.ESPADAS) // ERROR, no se pueden crear directamente via constructor
    val card1 = Card.of(Rank.Caballo, Suit.ESPADAS)
    val card2 = Card.of(Rank.Caballo, Suit.ESPADAS)

    println(card1)
    println(card2)

    println(card1 == card2) // Son iguales
    println(card1 === card2) // Son la misma
}