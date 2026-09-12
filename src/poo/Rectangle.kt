package poo.rectangles

data class Rectangle(
    val width: Double = 0.0,
    val height: Double = 0.0
) : Comparable<Rectangle> {

    val area: Double = width * height


    object RectangleComparator : Comparator<Rectangle> {
        override fun compare(r1: Rectangle, r2: Rectangle) = r1.area.compareTo(r2.area)
    }

    /**
     * Implementación del metodo compareTo de la interface Comparable
     */
    override operator fun compareTo(other: Rectangle) = RectangleComparator.compare(this, other)
}


fun main() {

    val min = Rectangle(1.0, 2.0) // area 2
    val max = Rectangle(3.0, 5.0) // area 15

    val rect1 = Rectangle(4.0, 3.0) // area 12
    val rect2 = Rectangle(4.0, 3.0) // area 12

    /**
     * Comprobar si un objeto rectángulo pertenece a un intervalo
     * Para ello, la clase del objeto debe implementar Comparable
     */
    println(rect1 in min..max)

    /**
     * También podemos usar los operadores relacionales < > <= >=
     */
    println(min <= max)
    println(rect1 >= max)
    println(min > rect1)
    println(rect1 < rect2)

    /**
     * En objeto data class la igualdad es por equivalencia
     * es decir, si tienen el mismo estado (valores iguales propiedad a propiedad)
     */
    println(rect1 == rect2) // Son iguales, equivalentes == es la función equals de Java

    /**
     * Para la inigualdad se utiliza tambien el equals
     */
    println(rect1 != max)
}