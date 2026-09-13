package model.geography

import imperative.functions.power

enum class ISUnit(
    val symbol: String,
    val power: Int
) {

    MILI("m", -3),
    NONE("", 0),
    KILO("K", 3),
    MEGA("M", 6);

    fun tenPower(power: Number) = 10.power(power).toFloat()

    val multiplier = tenPower(power)

    fun conversionFactorTo(unit: ISUnit) = tenPower(this.power - unit.power)

}