package poo.classes.properties.square1

/**
 * El constructor primario de la clase declara un parámetro side de tipo Double
 */
class Square public constructor(side: Double) {

    /**
     * Propiedad mutable side
     */
    var side: Double // = 0.0

    /**
     * El bloque init permite hacer uso de los parámetros del constructor primario
     * lo que permite inicializar la propiedad side
     */
    init {
        this.side = side
    }
}

fun main() {
    val square = Square(45.0)

    println(square.side)

}