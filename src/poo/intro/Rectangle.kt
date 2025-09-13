package poo.intro

class Rectangle (
    var height: Int,
    var width: Int
) {
    val isSquare: Boolean
        get() {
            return height == width
        }

    val isSquare2 get() = height == width
}

fun createUnitSquare() = Rectangle(1,1)

fun main() {
    val rect = Rectangle(5, 5)
    println(rect.height)
    println(rect.width)
    println(rect.isSquare)
    println(createUnitSquare().isSquare)
}