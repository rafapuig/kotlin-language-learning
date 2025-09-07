package imperative.functions

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val x = 100.0
    val y = 10.0

    val squareRoot = sqrt(x)
    val toPowerTwo = y.pow(2)

    val powerTwo = y power 2
}

infix fun Number.power(n: Number): Double = this.toDouble().pow(n.toDouble())