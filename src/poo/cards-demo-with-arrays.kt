package poo.evolution.arrays.cards

@ConsistentCopyVisibility
data class Card private constructor(val rank: Rank, val suit: Suit) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }

    override fun toString() = "$rank de ${suit.toString().lowercase()}"


    companion object {

        val totalCards = Suit.entries.size * Rank.entries.size

        fun getRankOrdinal(index: Int) = index % Rank.entries.size
        fun getSuitOrdinal(index: Int) = index / Rank.entries.size

        fun getRank(index: Int): Rank = Rank.entries[getRankOrdinal(index)] // Rank.entries[index % Rank.entries.size]
        fun getSuit(index: Int): Suit = Suit.entries[getSuitOrdinal(index)]

        private val _cards = Array<Card>(totalCards) { index ->
            Card(getRank(index), getSuit(index))
        }

        // Lista inmutable pero vinculada a los contenidos del array
        // Es una vista en forma de lista de los elementos del array
        val cards = _cards.asList() //get() = _cards.copyOf()


        private fun calculateIndex(rank: Rank, suit: Suit) =
            suit.ordinal * Rank.entries.size + rank.ordinal


        fun of(rank: Rank, suit: Card.Suit): Card {
            return cards[calculateIndex(rank, suit)]
        }
    }

}


fun main() {
    //Card.cards[0] = Card.of(Card.Rank.Rey, Card.Suit.COPAS)

    for (card in Card.cards) {
        println(card)
    }


    //val aCard = Card(Card.Rank.As, Card.Suit.ESPADAS)
    val aCard = Card.of(Card.Rank.Caballo, Card.Suit.ESPADAS)
    val aCard2 = Card.of(Card.Rank.Caballo, Card.Suit.ESPADAS)

    println(aCard)
    println(aCard2)

    println(aCard == aCard2) // Son iguales
    println(aCard === aCard2) // Son la misma
}