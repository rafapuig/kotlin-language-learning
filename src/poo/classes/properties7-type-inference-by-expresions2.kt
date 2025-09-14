package poo.classes.properties7


class Rectangle {
    /**
     * La propiedad width
     * el compilador infiere tipo Double a partir de
     * la expresión de inicialización mediante el literal
     * de tipo Double 0.0
     */
    var width = 0.0
    var height = 0.0

    /**
     * Se inifiere el tipo de las propiedades de solo lectura
     */
    val perimeter get() = (width + height) * 2
    val area get() = width * height
}


fun printRectangleInfo(rectangle: Rectangle) {
    println(
        """
        == Rectanguloo ==
        ancho = ${rectangle.width}
        alto = ${rectangle.height}
        perímetro = ${rectangle.perimeter}
        area = ${rectangle.area}
        """.trimIndent()
    )
}

fun main() {
    val rectangle = Rectangle()

    printRectangleInfo(rectangle)

    rectangle.width = 20.0
    rectangle.height = 5.0
    printRectangleInfo(rectangle)
}
