package poo.dataclasses.nocopy

/**
 * Si el constructor es privado,
 * podemos cambiar la visibilidad del método copy
 * y que sea la misma que la del constructor
 */
@ConsistentCopyVisibility
data class Rectangle private constructor(
    val width: Int = 0,
    val height: Int = 0
) {
    /**
     * Inicialización y cacheo del valor
     * Como el estado de objeto no cambia (es inmutable)
     * el área tampoco cambia
     */
    val area = width * height

    companion object Factory {
        fun create(width: Int = 0, height: Int = 0) = Rectangle(width, height)
    }
}

fun rectangle(width: Int = 0, height: Int = 0) =
    Rectangle.Factory.create(width, height)

fun Rectangle.clone(width: Int = this.width, height: Int = this.height) =
    Rectangle.Factory.create(width, height)


fun main() {
    val r1 = rectangle(3, 4)
    //r1.width = 5 // no se puede mutar

    println(r1)

    //val r2 = r1.copy(height = 7)
    //println(r2)

    val r3 = r1.clone(width = 8)
    println(r3)

}