package poo.classes.properties.square3

/**
 * El constructor primario de la clase declara un parámetro side de tipo Double
 * y ese parámetro es a su vez una propiedad de la clase inicializada con el valor del parametro
 */
class Square public constructor(var side: Double)

fun main() {
    val square = Square(45.0)

    println(square.side)
}