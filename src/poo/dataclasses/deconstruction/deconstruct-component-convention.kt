package poo.dataclasses.deconstruction

import java.time.LocalDate

operator fun LocalDate.component1() = this.dayOfMonth
operator fun LocalDate.component2() = this.monthValue
operator fun LocalDate.component3() = this.year

fun main() {
    val today = LocalDate.now()

    val (day, month, year) = today

    println("$day / $month / $year")
}