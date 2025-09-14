package poo.classes

import kotlin.math.PI
import kotlin.math.pow

class Circle {
    var radius: Double = 0.0

    /**
     * Propiedad de sola lectura
     * El compilador solamente genera el getter
     * El campo de respaldo se inicializa con el valor "Círculo"
     */
    val name : String = "Círculo"

    val type : String = "Forma"
        get() = field.uppercase()

    /**
     * Las propiedades declaradas con val
     * El compilador solamente genera un getter
     * (o lo definimos personalizado)
     * Si el getter no usa field ...
     * ... el compilador no crea un campo de respaldo
     */
    val circumference : Double
        get() = 2 * radius * PI

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
