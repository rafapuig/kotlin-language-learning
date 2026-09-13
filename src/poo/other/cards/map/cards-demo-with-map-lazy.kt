package poo.other.cards.map.lazy

import java.util.Objects

/**
 * Clase Card
 * para modelar una carta de la baraja
 * El constructor lo hacemos privado para no permitir la instanciación directa de objetos Card
 * y que se obtengan mediante un metodo factoría `of`
 */
class Card private constructor(
    val rank: Rank, // Valor de la carta
    val suit: Suit // Palo de la carta
) {

    enum class Suit { OROS, COPAS, ESPADAS, BASTOS }
    enum class Rank { As, Dos, Tres, Cuatro, Cinco, Seis, Siete, Sota, Caballo, Rey }


    // Como el objeto Card es inmutable podemos cachear el valor del hash porque su estado no cambia
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

        /**
         * Creamos un mapa
         * que asocia el código hash del objeto Card con la instancia Card correspondiente
         *
         */
        private val _cardsMap = mutableMapOf<Int, Card>()

        private fun calculateHashCode(rank: Rank, suit: Suit) =
            Objects.hash(suit, rank)


        //Metodo factoría para crear objetos Card
        fun of(rank: Rank, suit: Suit): Card =
            calculateHashCode(rank, suit).let { cardHashCode ->
                _cardsMap.getOrPut(cardHashCode) { Card(rank, suit) }
            }

        // Version inmutable del mapa para acceso público
        val cardsMap get() = _cardsMap.toMap()

        // Colección de los valores del mapa: las cartas
        val cards get() = cardsMap.values
    }

}


fun main() {

    //val aCard = Card(Card.Rank.As, Card.Suit.ESPADAS)
    val card1 = Card.of(Card.Rank.As, Card.Suit.ESPADAS)
    val card2 = Card.of(Card.Rank.As, Card.Suit.ESPADAS)

    val card3 = Card.of(Card.Rank.Rey, Card.Suit.COPAS)
    val card4 = Card.of(Card.Rank.Sota, Card.Suit.OROS)
    val card5 = Card.of(Card.Rank.Caballo, Card.Suit.BASTOS)


    // Imprimir todas las cartas generadas en el mapa
    for (card in Card.cardsMap.values) {
        println(card)
    }

    // Imprimir todas las cartas
    for (card in Card.cards) {
        println(card)
    }

    println(card1 == card2) // Son iguales
    println(card1 === card2) // Son la misma

}