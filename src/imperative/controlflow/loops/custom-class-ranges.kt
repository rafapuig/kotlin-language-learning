package intro.loops

class Rectangle(val width: Int, val height: Int) : Comparable<Rectangle> {
    val area: Int = width * height

    override fun compareTo(other: Rectangle) = area.compareTo(other.area)
}

fun main() {
    val smallestRectangle = Rectangle(10, 10)
    val largestRectangle = Rectangle(8, 25)
    val rectangle = Rectangle(5, 30)

    val closedRange = smallestRectangle..largestRectangle
    /*for (rectangle in range) {
        println(rectangle)
    }*/
    val openRange = smallestRectangle..<largestRectangle

    println(rectangle in smallestRectangle..largestRectangle)

}