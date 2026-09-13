package poo.operators

import imperative.functions.toRadians
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

data class Vector2(
    val x: Float = 0f,
    val y: Float = 0f
) {

    companion object {
        val ZERO = Vector2(0f, 0f)
        val ONE = Vector2(1f, 1f)
        val RIGHT = Vector2(1f, 0f)
        val UP = Vector2(0f, 1f)
    }

    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)
    operator fun minus(other: Vector2) = Vector2(x - other.x, y - other.y)
    operator fun times(scalar: Float) = Vector2(x * scalar, y * scalar)

    infix fun dot(v: Vector2) = x * v.x + y * v.y


    fun rotate(angle: Number) = run {

        val radians = toRadians(angle.toDouble())

        val sin = sin(radians).toFloat()
        val cos = cos(radians).toFloat()

        Vector2(
            x = x * cos - y * sin,
            y = x * sin + y * cos
        )
    }

    val squareLength = x * x + y * y

    val length = sqrt(squareLength)
}


fun testComputeMovement() {

    val speed = 5f

    var location = Vector2(10f, 20f)

    var direction = Vector2.RIGHT

    val deltaTime = 0.08f

    location += direction * speed * deltaTime

    println(location)

    direction = Vector2.RIGHT.rotate(45)

    location += direction * speed * deltaTime
    println(location)
}


fun main() {
    val v1 = Vector2(2f, 1f)
    val v2 = Vector2(3f, 4f)

    println("v1 = $v1")
    println("v2 = $v2")

    println(v1.length)
    println(v2.length)

    val v3 = v1 + v2

    val v4 = v1 - v2

    println(v3)
    println(v4)

    println(v1 * 3f)
    println(v1 dot v2)

    testComputeMovement()
}