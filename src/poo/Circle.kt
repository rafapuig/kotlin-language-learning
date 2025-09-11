package poo

import kotlin.math.PI

class Circle {

    var radius: Double = 0.0

    constructor(radius: Double = 0.0) {
        this.radius = radius
    }

    fun circumference(): Double {
        return 2 * PI * radius
    }

    val areaWrong: Double = PI * radius * radius // Es una inicialización de una propiedad (solo an crear el objeto)
    val area: Double get() = PI * radius * radius // Es un getter, se calcula en cada llamada

    val circumference: Double get() = 2 * PI * radius
}


class Square1 public constructor(side: Double) {
    var side: Double = 0.0
    init {
        this.side = side
    }
}

open class Rectangle(width: Double, height: Double) {
    var width: Double = width
    var height: Double = height
}

class Square2 public constructor(side: Double) : Rectangle(side, side)

class Square3 : Rectangle {
    constructor(side: Double) : super(side, side) {}
}




fun main() {
    val circle = Circle(10.0)
    println(circle.circumference())
    println(circle.circumference)
    println(circle.area)
    circle.radius = 3.0
    println(circle.circumference)
    println(circle.area)
    println(circle.areaWrong)
}