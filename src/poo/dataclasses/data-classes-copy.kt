package poo.dataclasses.copy

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
    val r1 = Rectangle(3, 4)
    //r1.width = 5 // no se puede mutar

    println(r1)

    /**
     * Copy hace una clonación superficial del objeto rectángulo,
     * pero con los valores de las propiedades que le indiquemos
     *
     * Que la copia sea superficial no es un problema si la jerarquía
     * de objetos anidados son también inmutables
     */

    val r2 = r1.copy(height = 7)
    println(r2)

    val r3 = r1.copy(width = 8)
    println(r3)

}