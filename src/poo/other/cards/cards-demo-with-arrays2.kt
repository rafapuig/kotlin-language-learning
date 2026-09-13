package poo.cards.arrays2

import kotlin.collections.plusAssign
import poo.cards.arrays2.Card.Rank
import poo.cards.arrays2.Card.Suit


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

        private val _cards =
            buildList<Card>(totalCards) {
                for (suit in Suit.entries) {
                    for (rank in Rank.entries) {
                        this += Card(rank, suit)
                    }
                }
            }.toTypedArray()


        // Lista inmutable, pero vinculada a los contenidos del array
        // Es una vista en forma de lista de los elementos del array
        val cards = _cards.asList()



        private fun calculateIndex(rank: Rank, suit: Suit) =
            suit.ordinal * Rank.entries.size + rank.ordinal

        /**
         * Definimos el operador [] para acceder mediante índice a un elemento del array de Cards
         * Como índice se puede proporcionar un número variable de argumentos
         */
        operator fun Array<Card>.get(rank: Rank, suit: Suit) = this[calculateIndex(rank, suit)]

        /**
         * La implementación de of hace uso del operador [] definido para los Array<Card> más arriba
         */
        fun of(rank: Rank, suit: Suit): Card =
            /**
             * Hacemos uso del operador get, para ahora proporcionar el rank y el suit como argumentos
             * para calcular en índice del elemento del array accedido
             */
            _cards[rank, suit]

    }
}

/**
 * Metodo de extension operador [] para clase receptora Iterable<Card>
 * Delega en el metodo of
 */
operator fun Iterable<Card>.get(rank: Rank, suit: Suit): Card = Card.of(rank, suit)



fun main() {
    //Card.cards[0] = Card.of(Rank.Rey, Suit.COPAS) // ERROR, la lista es inmutable

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

    /**
     * Uso del metodo de extension del operador []
     */
    val card3 = Card.cards[Rank.Caballo, Suit.COPAS]

    // Alternativamente, podemos usar el nombre explícito de la función correspondiente asociada al operador []
    val card4 = Card.cards.get(Rank.Caballo, Suit.COPAS)
}