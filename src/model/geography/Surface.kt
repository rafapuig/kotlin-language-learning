package model.geography

import java.text.DecimalFormat

@JvmInline
value class Surface(val value: Float) : Comparable<Surface> {

    override fun compareTo(other: Surface) = value.compareTo(other.value)

    override fun toString(): String {
        return value.let {
            val number = if (it > 1) it else it * 1_000_000
            val suffix = if (it > 1) "km²" else "m²"
            "${DecimalFormat.getNumberInstance().format(number)} $suffix"
        }
    }
}

val Float.km2: Surface get() = Surface(this)
val Int.km2: Surface get() = toFloat().km2
val Double.km2: Surface get() = toFloat().km2

val Float.m2: Surface get() = Surface(this / 1_000_000)
val Double.m2: Surface get() = toFloat().m2
val Int.m2: Surface get() = toFloat().m2

fun Surface.toArea(): Area {
    val units = if (value > 1) SIUnit.KILO else SIUnit.NONE
    val number = if (value > 1) value else value * 1_000_000
    return Area(value.toLong(), units)
}

fun main() {
    val surface1 = 500.97.km2
    val surface2 = 5.7.km2
    val surface3 = 1200.m2
    println(surface1)
    println(surface2)
    println(surface3)
    val area1 = surface1.toArea()
    println(area1)
}