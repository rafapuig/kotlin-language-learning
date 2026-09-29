package conventions.collections.belonging

data class Point(val x: Int, val y: Int)

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point) =
    p.y in upperLeft.y..lowerRight.y && // Comprueba si y está en el rango
            p.x in upperLeft.x..lowerRight.x // y la coordenada x también está dentro de un rango


fun main() {
    val rectangle = Rectangle(Point(10, 10), Point(40, 50))


    // Hacemos uso de la convención in como operador para comprobar si el punto pertenece al rectángulo
    println(Point(25, 25) in rectangle)

    // El equivalente al uso de el operador in es la llamada al metodo contains
    println(rectangle.contains(Point(20, 30)))
}