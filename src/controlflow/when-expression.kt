package controlflow

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year
import controlflow.Month.*
import kotlin.random.Random

/**
 * La expresión when sin un argumento
 * Cada rama es una expresión de tipo Boolean
 */
fun testWhenExpression() {
    val number = Random.nextInt(-1, 2)
    println("El numero es $number")
    when {
        number > 0 -> println("el numero es positivo")
        number == 0 -> println("el numero es cero")
        number < 0 -> println("el numero es negativo") // Si llega hasta aqui es porque no es > ni = entonces es <
        else -> println("error")
    }
}

fun testWhenExpression2() {
    val number = Random.nextInt(-1, 2)
    println("El numero es $number")
    when (number) {
        -1 -> println("el numero es negativo")
        0 -> println("el numero es cero")
        1 -> println("el numero es positivo")
        else -> println("error")
    }
}

fun testWhenExpression3() {
    val number = Random.nextInt(-1, 2)
    println("El numero es $number")
    when (number) {
        in Int.MIN_VALUE..-1 -> println("el numero es negativo") // Cambiar extremo del rango por <0
        in 1..Int.MAX_VALUE -> println("el numero es positivo")
        0 -> println("el numero es cero")
        else -> println("error")
    }
}

fun testWhenExpression4() {
    val hour = Random.nextInt(0, 24)
    when (hour) {
        in 0..11 -> println("Buenos dias")
        in 12..20 -> println("Buenas tardes")
        in 21..23 -> println("Buenas noches")
    }
}

enum class Month(val days: Int) {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    val isLong = days > 30

    fun getDaysLeapYear(): Int = when (this) {
        Month.FEBRUARY -> days + 1
        else -> days
    }
}

fun isLeapYear(year: Int): Boolean =
    year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)

@JvmInline
value class Year(val value: Int) {
    fun isLeapYear(): Boolean = isLeapYear(value)
}

fun getDaysInMonth(month: Month, year: Year): Int =
    if (month == FEBRUARY && year.isLeapYear()) month.days + 1
    else month.days

fun Month.getDaysYear(year: Year): Int = if (year.isLeapYear()) getDaysLeapYear() else days


fun getNameInSpanish(month: Month): String {
    return when (month) {
        JANUARY -> "Enero"
        FEBRUARY -> "Febrero"
        MARCH -> "Marzo"
        APRIL -> "Abril"
        MAY -> "Mayo"
        JUNE -> "Junio"
        JULY -> "Julio"
        AUGUST -> "Agosto"
        SEPTEMBER -> "Septiembre"
        OCTOBER -> "Octubre"
        NOVEMBER -> "Noviembre"
        DECEMBER -> "Diciembre"
    }
}

fun Month.getSpanishName(): String {
    return getNameInSpanish(this)
}

fun testGetSpanishNames() {
    val month = Month.FEBRUARY
    println(getNameInSpanish(month))
    println(month.getSpanishName())
}

fun main() {
    //testWhenExpression()
    testWhenExpression2()
}