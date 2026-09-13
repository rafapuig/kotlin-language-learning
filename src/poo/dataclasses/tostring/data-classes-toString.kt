package poo.dataclasses.tostring

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
    val rect = Rectangle(3,7)

    /**
     * En una data class el compilador
     * reemplaza el método toString
     * para que devuelva una representación textual del objeto
     * teniendo en cuenta las propiedades declaradas
     * en el constructor primario
     */
    println(rect)
}