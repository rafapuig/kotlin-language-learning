package DSL.buildString.lambda.with.receiver

import java.util.Locale
import kotlin.math.pow

/**
 * Podemos dar a uno de los parámetros de una lambda el status especial
 * de objeto receptor (this)
 *
 * Tipo de función extensión
 *
 * El tipo de function de extensión
 * saca el tipo del parámetro que queremos convertir en receptor
 * de los paréntesis donde se indican los parámetros del tipo función
 * y lo colocamos seguido de un punto y antes de los paréntesis
 */

val capitalize: String.() -> String =
    { this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } }

val triple: Int.() -> Int = { this * 3 }
val power: Int.(Int) -> Double = { this.toDouble().pow(it) }
val doublePower: Double.(Int) -> Double = { pow(it)  * 2 } // se puede omitir this
val timesX: Int.(Int) -> Int = { this * it }

fun main() {
    val string = "rafael"
    println(string.capitalize())

    println(5.triple())
    println(2.power(10))
    println(1.5.doublePower(2))
    println(2.timesX(5))
}