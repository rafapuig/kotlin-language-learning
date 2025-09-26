package model.geography

import imperative.functions.power

enum class SIUnit(val symbol: String, val power: Int) {
    NONE("", 0),
    KILO("K", 3),
    MEGA("M", 6);

    val multiplier = 10.power(power).toLong()

}