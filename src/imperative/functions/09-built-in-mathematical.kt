package imperative.functions

/**
 * En el paquete kotlin.math
 * se declaran las funciones y constantes para realizar las típicas operaciones matemáticas.
 *
 * En el archivo fuente MathJVM.kt se declaran pow, sqrt, cos y PI por ejemplo.
 * Y no es necesario en Kotlin una clase Math contenedora de métodos estáticos
 */
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val x = 100.0
    val y = 10.0

    val squareRoot = sqrt(x)
    val toPowerTwo = y.pow(2)

    val powerTwo = y power 2

    val cos = cos(toRadians(90.0))
}

fun toRadians(degrees: Double): Double {
    return degrees * PI / 180
}

infix fun Number.power(n: Number): Double = this.toDouble().pow(n.toDouble())