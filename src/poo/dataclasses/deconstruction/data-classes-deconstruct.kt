package poo.dataclasses.deconstruct

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
     * Deconstrucción del objeto rectángulo
     * Una lista de nombres de variables entre paréntesis
     * En el orden en que han sido declaradas las propiedades en el constructor primario
     * son obtenidos y asignados los valores de estas a las variables
     */
    val (width, height) = rect

    println("ancho = $width y alto $height")

    /**
     * Si el valor de alguna propiedad no nos interesa podemos
     * usar el _
     * no se creará una variable para almacenar el valor de la propiedad
     */
    val (_, height2) = rect
    println("altura = $height2")
}