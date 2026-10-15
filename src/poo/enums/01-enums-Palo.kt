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

    /**
     * Las instancias de objetos de tipo enumerado ya cuentan con una propiedad name
     * que es igual al nombre usado para la instancia cuando se define la enumeración
     */
    println(palo1.name)
    println(palo2.name)

    /**
     * También cuentan con una propiedad ordinal
     * que es un valor entero que indica el orden o posición en que se declaró
     * empezando por cero la primera de todas
     */
    println(palo1.ordinal)
    println(palo2.ordinal)

    /**
     * valueOf es un metodo que devuelve la referencia a la constante enumerada
     * cuyo name coincida con el argumento
     */
    val oros = Palo.valueOf("Oros")
    println(oros)

    /**
     * Podemos crear rangos entre constantes de enumerados
     */
    val range = Palo.Copas..Palo.Espadas

    print(Palo.Oros in range)

}