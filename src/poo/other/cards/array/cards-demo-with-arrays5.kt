package poo.arrays5.cards

import poo.arrays5.cards.Card.Rank
import poo.arrays5.cards.Card.Suit


@ConsistentCopyVisibility
data class Card private constructor(val rank: Rank, val suit: Suit) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }

    override fun toString() = "$rank de ${suit.toString().lowercase()}"


    companion object {

        val totalCards = Suit.entries.size * Rank.entries.size

        // Creamos un array de Cards de tamaño totalCards con los elementos inicializados a null
        private val _cards = Array<Card?>(totalCards) { null }

        private fun calculateIndex(rank: Rank, suit: Suit) =
            suit.ordinal * Rank.entries.size + rank.ordinal

        /**
         * Operador get para obtener el valor de un elemento de un array
         * obtenido a partir de los argumentos proporcionados
         */
        operator fun Array<Card?>.get(rank: Rank, suit: Suit) = this[calculateIndex(rank, suit)]

        /**
         * Operador set para asignar a un elemento en una posición índice del array obtenido a partir de
         * los n-1 primeros argumentos: rank y suit en este caso concreto
         * el valor del último argumento: card
         */
        operator fun Array<Card?>.set(rank: Rank, suit: Suit, card: Card) {
            val index = calculateIndex(rank, suit)
            this[index] = card
        }

        init {
            for (suit in Suit.entries) {
                for (rank in Rank.entries) {
                    /**
                     * Se hace uso del operador set de Array<Card?>
                     */
                    _cards[rank,suit] = Card(rank, suit)
                }
            }
        }

        // Lista inmutable, pero vinculada a los contenidos del array
        // Es una vista en forma de lista de los elementos del array
        // Ahora tenemos que aplicar el filtrado de elementos no nulos
        // para que la lista sea de List<Card> y no List<Card?>
        val cards: List<Card> = _cards.asList().filterNotNull()


        fun of(rank: Rank, suit: Suit): Card {
            /**
             * Se hace uso del operador get definido para Array<Cards?>
             */
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


    //val card = Card(Card.Rank.As, Card.Suit.ESPADAS)
    val card1 = Card.of(Rank.Caballo, Suit.ESPADAS)
    val card2 = Card.of(Rank.Caballo, Suit.ESPADAS)

    println(card1)
    println(card2)

    println(card1 == card2) // Son iguales
    println(card1 === card2) // Son la misma

    val card3 = Card.cards[Rank.Caballo, Suit.COPAS]
    println(card3)

}