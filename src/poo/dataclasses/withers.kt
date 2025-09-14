package poo.dataclasses.withers

/**
 * En Kotlin no hace falta crear métodos withers
 *
 * En una data class se define un método copy
 * El método copy
 * - tiene un parámetro de entrada por cada propiedad declarada en el constructor primario
 * - los parámetros tienen valor por defecto igual al valor de la propiedad del objeto receptor
 */
data class Point(val x: Float = 0f, val y: Float = 0f) {

    /**
     * Clonar sería el equivalente al metodo copy
     */
    fun clonar(x: Float = this.x, y: Float = this.y) = Point(x, y)

}

fun main() {
    val p1 = Point(3f, 4f)

    val p2 = p1.copy()
    val p3 = p1.copy(y = 5f)
    val p4 = p2.clonar(x = 1f)

    println(p1)
    println(p2)
    println(p3)
    println(p4)
}