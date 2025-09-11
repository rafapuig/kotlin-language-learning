package poo.rectangles

data class Rectangle(val width: Double = 0.0, val height: Double = 0.0) : Comparable<Rectangle> {

    val area: Double = width * height

    override fun compareTo(other: Rectangle) = RectangleComparator.compare(this, other)


    object RectangleComparator : Comparator<Rectangle> {

        override fun compare(r1: Rectangle, r2: Rectangle): Int {
            return r1.area.compareTo(r2.area)
        }
    }

}

fun main() {
    val min = Rectangle(1.0, 2.0)
    val max = Rectangle(3.0, 5.0)

    val rect = Rectangle(4.0, 3.0)

    println(rect in min..max)
    println(min <= max)
    println(rect >= max)
    println(rect != max)
    println(min > rect)
}