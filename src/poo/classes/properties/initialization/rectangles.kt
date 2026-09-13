package poo.classes.properties.initialization

/**
 * Rectangle como clase base
 * Debe abrirse para la extension por subclases
 */
open class Rectangle(width: Double, height: Double) {
    var width: Double = width
    var height: Double = height
}

class SquarePrimary public constructor(side: Double) : Rectangle(side, side)

class SquareSecondary : Rectangle {
    constructor(side: Double) : super(side, side) {}
}

fun main() {
    val rectangle = Rectangle(2.0, 3.0)
    println(rectangle.width)
    println(rectangle.height)

    val squarePrimary = SquarePrimary(5.0)
    println(squarePrimary.width)
    println(squarePrimary.height)

    val squareSecondary = SquareSecondary(4.0)
    println(squareSecondary.width)
    println(squareSecondary.height)
}