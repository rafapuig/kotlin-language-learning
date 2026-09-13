package poo.other.cards.map

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
         * Para crear el mapa usamos un builder (que permite especificar el proceso de creación)
         */
        val cardsMap = buildMap {

            // Para cada palo posible
            for (suit in Suit.entries) {

                // Para cada valor posible
                for (rank in Rank.entries) {

                    // El companion object tiene acceso al constructor privado
                    val card = Card(rank, suit)

                    // El operador += está sobrecargado para operar con mapas
                    // La función infija to crea la tupla que será la entrada a añadir al mapa
                    this += card.hashCode to card
                }
            }
        }

        private fun calculateHashCode(rank: Rank, suit: Suit) =
            Objects.hash(suit, rank)


        //Metodo factoría para crear objetos Card
        fun of(rank: Rank, suit: Suit): Card =
            //cardsMap.get(calculateHashCode(rank, suit)) ?: Card(rank, suit)
            cardsMap[calculateHashCode(rank, suit)]!!

    }

}


fun main() {

    // Imprimir todas las cartas generadas en el mapa
    for (card in Card.cardsMap.values) {
        println(card)
    }

    //val aCard = Card(Card.Rank.As, Card.Suit.ESPADAS)
    val aCard = Card.of(Card.Rank.As, Card.Suit.ESPADAS)
    val aCard2 = Card.of(Card.Rank.As, Card.Suit.ESPADAS)

    println(aCard == aCard2) // Son iguales
    println(aCard === aCard2) // Son la misma

}