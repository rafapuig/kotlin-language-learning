package poo.classes.properties.square2

/**
 * El constructor primario de la clase declara un parámetro side de tipo Double
 */
class Square public constructor(side: Double) {

    /**
     * Propiedad mutable side
     * También se puede inicializar con el parámetro del constructor primario
     */
    var side: Double = side


}

fun main() {
    val square = Square(45.0)

    println(square.side)
}