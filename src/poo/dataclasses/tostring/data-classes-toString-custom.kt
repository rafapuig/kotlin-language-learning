package poo.dataclasses.tostring.custom

data class Rectangle(
    val width: Int = 0,
    val height: Int = 0
) {
    val area = width * height

    /**
     * Podemos definir explícitamente un metodo de reemplazo toString
     * en este caso el compilador no generará ninguno automático
     */
    override fun toString() = "Rectangle(width=$width, height=$height, area=$area)"

}


fun main() {
    val rect = Rectangle(3, 7)

    println(rect)
}