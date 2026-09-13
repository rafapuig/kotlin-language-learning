package poo.dataclasses.copy.withers

/**
 * En Kotlin no hace falta crear métodos withers
 *
 * En una data class se define un método copy
 * El método copy
 * - tiene un parámetro de entrada por cada propiedad declarada en el constructor primario
 * - los parámetros tienen valor por defecto igual al valor de la propiedad del objeto receptor
 */
data class Point(
    val x: Number = 0,
    val y: Number = 0
) {

    /**
     * Clone sería el equivalente al método copy (que ya se incluye con las data class)
     */
    fun clone(x: Number = this.x, y: Number = this.y) = Point(x, y)

    fun withX(x: Number) = Point(x, y)
    fun withY(y: Number) = Point(x, y)

}

fun main() {

    val p1 = Point(3, 4)

    /**
     * Withers para cada propiedad (clásica solución en Java)
     */
    val p2 = p1.withX(1)
    val p3 = p1.withY(2)

    /**
     * Puntos copias modificadas en X o Y del punto original
     */
    val p4 = p1.clone()
    val p5 = p1.clone(x = 10)
    val p6 = p1.clone(y = 20)

    /**
     * Metodo copy de la data class
     */
    val p7 = p1.copy()
    val p8 = p1.copy(x = -5)
    val p9 = p1.copy(y = -6)


    println(p1)
    println(p2)
    println(p3)
    println(p4)
    println(p5)
    println(p6)
    println(p7)
    println(p8)
    println(p9)
}