package poo.classes.properties6

import kotlin.math.PI
import kotlin.math.pow

class Circle {

    /**
     * El campo de respaldo es inicializado
     * El compilador infiere el tipo de la propiedad (y campo de respaldo)
     * a partir del tipo de la expresión de inicialización
     */
    var radius = 0.0

    /**
     * Propiedad de sola lectura
     * El compilador solamente genera el getter
     * El campo de respaldo se inicializa con el valor "Círculo"
     * El compilador infiere el tipo de name como String
     */
    val name = "Círculo"

    val type : String = "Forma"
        get() = field.uppercase()

    /**
     * Las propiedades declaradas con val
     * El compilador solamente genera un getter
     * (o lo definimos personalizado)
     * Si el getter no usa field ...
     * ... el compilador no crea un campo de respaldo
     *
     * El compilador infiere tipo Double
     * a partir del tipo de la expresión asignada al get
     */
    val circumference
        get() = 2 * radius * PI


    /**
     * En este caso no se usa una expresión,
     * sino un bloque para definir el get
     * El compilador no puede inferir el tipo
     * de la propiedad área
     */
    val area: Double
        get() {
            return PI * radius.pow(2)
        }
}

fun printCircleInfo(circle: Circle) {
    println("""
        == Circulo ==
        radio = ${circle.radius}
        circumferencia = ${circle.circumference}
        area = ${circle.area}
        """.trimIndent())
}

fun main() {
    val circle = Circle()

    printCircleInfo(circle)

    circle.radius = 5.0
    printCircleInfo(circle)
}
