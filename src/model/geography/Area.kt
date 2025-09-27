package model.geography

import imperative.functions.power
import java.text.DecimalFormat

data class Area(val value: Long, val units: SIUnit = SIUnit.NONE) : Comparable<Area> {

    companion object {
        const val BASE_UNIT = "m²"

        fun Number.toAreaString(units: SIUnit = SIUnit.NONE) =
            DecimalFormat.getNumberInstance().format(this).let {
                "$it ${units.symbol}$BASE_UNIT"
            }
    }

    override fun toString() = value.toAreaString(units)

    fun to(units: SIUnit) = scalarValue / units.multiplier.power(2)

    val scalarValue get() = value * units.multiplier.power(2)

    override fun compareTo(other: Area) =
         scalarValue.compareTo(other.scalarValue)
}

fun main() {
    val area = Area(5000, SIUnit.KILO)
    println(area)
    val area2 = Area(5_000_000_000)
    println(area2)
    println(area.scalarValue)
    println(area2.scalarValue)
}


