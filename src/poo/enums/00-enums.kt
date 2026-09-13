package poo.enums

/**
 * Para crear un tipo enumerado se usa la palabra enum seguida de class
 * y el nombre del nuevo tipo enumerado
 */

enum class Palo {
    OROS, COPAS, ESPADAS, BASTOS
}

fun testEnumEntries() {
    for (palo in Palo.entries) {
        println("${palo.ordinal} = ${palo.name}")
    }
}

/**
 * Un enumerado se puede considerar una clase de objetos para la cual se declaran
 * explícitamente en código fuente todas sus instancias
 *
 * Es decir, para el caso del tipo Palo solamente existirán 4 objetos (instancias del tipo)
 * y las referencias para acceder a estos objetos son los nombres OROS, COPAS, ESPADAS y BASTOS
 *
 * Como clases que son pueden tener atributos
 */

enum class Suit(val color: String) {
    Diamonds("red"),
    Hearts("red"),
    Clubs("black"),
    Spades("black"),
}

fun testSuits() {
    for (suit in Suit.entries) {
        println("$suit color ${suit.color}")
    }
}

fun main() {
    testEnumEntries()
    testSuits()
}