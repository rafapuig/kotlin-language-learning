package poo.evolution.arrays.cards4

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

        fun of(rank: Rank, suit: Card.Suit): Card = _cards[Position(rank, suit).index]

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


    //val aCard = Card(Card.Rank.As, Card.Suit.ESPADAS)
    val aCard = Card.of(Card.Rank.Caballo, Card.Suit.ESPADAS)
    val aCard2 = Card.of(Card.Rank.Caballo, Card.Suit.ESPADAS)

    println(aCard)
    println(aCard2)

    println(aCard == aCard2) // Son iguales
    println(aCard === aCard2) // Son la misma
}