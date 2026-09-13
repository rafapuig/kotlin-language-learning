package model.geography

import imperative.functions.power
import java.text.DecimalFormat

data class Area(
    val value: Number,
    val unit: ISUnit = ISUnit.NONE
) : Comparable<Area> {

    companion object {
        const val BASE_UNIT = "m²"

        fun Number.toAreaString(unit: ISUnit = ISUnit.NONE) =
            DecimalFormat.getNumberInstance().format(this).let {
                "$it ${unit.symbol}$BASE_UNIT"
            }
    }

    val baseValue = value.toDouble() * unit.multiplier.power(2)

    fun to(unit: ISUnit) = run {
        val factor = this.unit.conversionFactorTo(unit)
        val targetValue = value.toDouble() * factor.power(2)
        Area(
            targetValue.toFloat(), unit
        )
    } /*Area(
        (baseValue / units.multiplier.power(2)).toFloat(),
        units
    )*/

    override fun compareTo(other: Area) =
        compareValuesBy(this, other) { it.baseValue }

    override fun toString() = value.toAreaString(unit)

}

fun main() {
    val area = Area(5.6f, ISUnit.KILO)
    println(area)

    val areaInSquareMeters = area.to(ISUnit.NONE)
    println(areaInSquareMeters)

    val area2 = Area(5_700_000f)
    println(area2)

    val areaInKiloMeters = area2.to(ISUnit.KILO)
    println(areaInKiloMeters)

    println(area.baseValue)
    println(area2.baseValue)
}


