package imperative

import imperative.Month.*

/**
 * Para crear un tipo enumerado se usa la palabra enum seguida de class y el nombre del nuevo tipo enumerado
 */

enum class Palo {
    OROS, COPAS, ESPADAS, BASTOS
}

fun testEnumEntries() {
    for (palo in Palo.entries) {
        println("${palo.ordinal} = ${palo.name}")
    }
}

/**
 * Un enumerado se puede considerar una clase de objetos para la cual se declaran
 * explícitamente en código fuente todas sus instancias
 *
 * Es decir, para el caso del tipo Palo solamente existirán 4 objetos (instancias del tipo)
 * y las referencias para acceder a estos objetos son los nombres OROS, COPAS, ESPADAS y BASTOS
 *
 * Como clases que son pueden tener atributos
 */

enum class Suit(val color: String) {
    Diamonds("red"),
    Hearts("red"),
    Clubs("black"),
    Spades("black"),
}

fun testSuits() {
    for (suit in Suit.entries) {
        println("$suit color ${suit.color}")
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
    DECEMBER(31); // Un ; separa la lista de instancias de las declaraciones de la clase


    val isLong = days > 30 // El valor de isLong se cachea al iniciar la instancia

    fun getDaysIfLeapYear(): Int =
        days + if (this === FEBRUARY) 1 else 0

    // Mas eficiente, el valor no se calcula en cada llamada, se cachea al inicio
    val numDaysIfLeapYear = days + if (this.ordinal == 1) 1 else 0
}


fun testGetDaysIfLeapYear() {
    println("Cuando el año es bisiesto...")
    for (month in Month.entries) {
        println("El mes $month tiene ${month.getDaysIfLeapYear()} dias")
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

fun getDaysInMonthIfYear(month: Month, year: Year): Int =
    month.days + if (month == FEBRUARY && year.isLeapYear()) 1 else 0


/**
 * Método de extensión de la clase enumerada Month
 */
fun Month.getDaysIfYear(year: Year): Int = getDaysInMonthIfYear(this, year)


fun get_SpanishName(month: Month): String {
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
 * Propiedad de extensión
 */
val Month.spanishName: String get() = get_SpanishName(this)


fun testGetSpanishName() {
    for (month in Month.entries) {
        println(get_SpanishName(month))
        println(month.spanishName)
    }
}

fun main() {
    testEnumEntries()
    testSuits()
    testGetDaysIfLeapYear()
    testGetSpanishName()
}