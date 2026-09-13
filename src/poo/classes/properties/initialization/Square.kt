package poo.classes.properties.square

/**
 * El constructor primario de la clase declara un parámetro side de tipo Double
 */
class Square {

    /**
     * Propiedad mutable side
     */
    var side: Double // = 0.0

    /**
     * Un constructor definido en el cuerpo de la clase se denomina secundario
     */
    constructor(side: Double) {
        this.side = side
    }
}

fun main() {
    val square = Square(45.0)

    println(square.side)

}