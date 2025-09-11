package poo

import kotlin.math.sqrt

data class Vector2(val x: Float = 0f, val y: Float = 0f) {

    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)
    operator fun minus(other: Vector2) = Vector2(x - other.x, y - other.y)
    operator fun times(scalar: Float) = Vector2(x * scalar, y * scalar)

    infix fun dot(v: Vector2) = x * v.x + y * v.y

    val squareLength = x * x + y * y
    val length = sqrt(squareLength)
}

fun main() {
    val v1 = Vector2(2f,1f)
    val v2 = Vector2(3f,4f)

    println("v1 = $v1")
    println("v2 = $v2")

    println(v1.length)
    println(v2.length)

    println(v1 + v2)
    println(v1 * 3f)

    println(v1 dot v2)
}