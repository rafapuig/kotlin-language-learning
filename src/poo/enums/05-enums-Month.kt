package poo.enums

import poo.enums.Month.*

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
    DECEMBER(31); // Un ; separa la lista de instancias de las declaraciones de la clase


    val isLong = days > 30 // El valor de la propiedad isLong se cachea al iniciar la instancia

    fun daysInLeapYear(): Int =
        days + if (this === FEBRUARY) 1 else 0

    /**
     * Más eficiente, el valor no se calcula en cada llamada, se cachea al inicio
     * mediante una propiedad de solo lectura (inmutable)
     */
    val daysInLeapYear = days + if (this.ordinal == 1) 1 else 0

}


fun testGetDaysInLeapYear() {
    println("Cuando el año es bisiesto...")
    for (month in entries) {
        println("El mes $month tiene ${month.daysInLeapYear()} días")
    }
}

fun testDaysInLeapYear() {
    println("Cuando el año es bisiesto...")
    for (month in entries) {
        println("El mes $month tiene ${month.daysInLeapYear} días")
    }
}


/**
 * Función que nos calcula sin un año se considera bisiesto
 */
fun isLeapYear(year: Int): Boolean =
    year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)


/**
 * Clase valor, para seguridad de tipos
 */
@JvmInline
value class Year(val value: Int) {
    fun isLeapYear(): Boolean = isLeapYear(value)
}

fun getDaysOfMonthForYear(month: Month, year: Year): Int =
    month.days + if (month == FEBRUARY && year.isLeapYear()) 1 else 0


/**
 * Método de extensión de la clase enumerada Month
 */
fun Month.getDaysForYear(year: Year): Int = getDaysOfMonthForYear(this, year)
fun Month.getDaysForYear(year: Int): Int = getDaysOfMonthForYear(this, Year(year))

fun testGetDaysForYear() {
    var days = FEBRUARY.getDaysForYear(Year(2000))
    println(days)

    days = MARCH.getDaysForYear(2000)
    println(days)
}


/**
 * Función de traducción del nombre del mes al español
 */
fun spanishName(month: Month): String {
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

/**
 * Propiedad de extensión del enum Month
 */
val Month.spanishName: String get() = spanishName(this)


fun testSpanishNameFunction() {
    for (month in entries) {
        println(spanishName(month))
    }
}

fun testSpanishNameExtensionProperty() {
    for (month in entries) {
        println(month.spanishName)
    }
}

fun main() {
    testGetDaysInLeapYear()
    testDaysInLeapYear()
    testGetDaysForYear()
    testSpanishNameFunction()
    testSpanishNameExtensionProperty()
}