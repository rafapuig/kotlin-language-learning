package poo.rectangles

data class Rectangle(
    val width: Number = 0,
    val height: Number = 0
) : Comparable<Rectangle> {

    val area: Float = width.toFloat() * height.toFloat()

    /**
     * Implementación del metodo compareTo de la interface Comparable
     */
    override operator fun compareTo(other: Rectangle) =
        compareValuesBy(this, other, Rectangle::area)
}


fun main() {

    val min = Rectangle(1, 2) // area 2
    val max = Rectangle(3, 5) // area 15

    val rect1 = Rectangle(4, 3) // area 12
    val rect2 = Rectangle(4, 3) // area 12

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
     * Para la inigualdad se utiliza también el equals
     */
    println(rect1 != max)
}