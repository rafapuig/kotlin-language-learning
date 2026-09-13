package poo.dataclasses.deconstruct.components

data class Rectangle(
    val width: Int = 0,
    val height: Int = 0
) {
    /**
     * Inicialización y cacheo del valor
     * Como el estado de objeto no cambia (es inmutable)
     * el área tampoco cambia
     */
    val area = width * height
}

fun main() {
    val rect = Rectangle(3, 4)

    /**
     * La deconstrucción es una convención que equivale a escribir este
     * código más verboso
     *
     * El compilador crea una función componentX() por cada propiedad
     * declarada en el constructor primario
     */
    val width = rect.component1()
    val height = rect.component2()

    println("ancho = $width y alto $height")
}