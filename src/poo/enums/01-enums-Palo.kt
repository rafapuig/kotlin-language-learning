package intro.poo.enums.palo

enum class Palo { Oros, Copas, Espadas, Bastos }

fun main() {

    val palo1 = Palo.Bastos
    val palo2 = Palo.Copas

    println("Palo 1: $palo1")
    println("Palo 2: $palo2")

    // Iterar todos los valores del tipo enumerado Palo
    for (palo in Palo.entries) {
        println("$palo")
    }

    println(Palo.entries.joinToString())

    println(palo1.name)
    println(palo2.name)

    println(palo1.ordinal)
    println(palo2.ordinal)

    val oros = Palo.valueOf("Oros")
    println(oros)

    /**
     * Podemos crear rangos
     */
    val range = Palo.Copas..Palo.Espadas

    print(Palo.Oros in range)

}