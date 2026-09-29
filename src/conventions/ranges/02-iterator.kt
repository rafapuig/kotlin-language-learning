package conventions.ranges

import java.time.LocalDate

/**
 * El bucle for usa el operador in y un rango para iterar.
 *
 * `for(e in list)` se traduce a una llamada a `list.iterator()`
 *
 * El iterador define `hasNext` y `next` mediante las cuales se diseña el bucle for
 */

fun testListIterator() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val iterator = numbers.iterator()

    while (iterator.hasNext()) {
        print(iterator.next())
    }

    val otherIterator = numbers.iterator()
    otherIterator.forEach { print(it) }

    // Convención operador in en bucle for para llamar al iterador u usarlo
    for (i in numbers) {
        print(i)
    }

    println()
}


/** Se puede definir una función iterador
 * - en nuestras propias clases
 * - como función de extension de otras clases
 */

operator fun ClosedRange<LocalDate>.iterator() =
    // Crea una instancia de objeto Iterator de LocalDate
    // (objeto anónimo que implementa la interface Iterator<LocalDate>)
    object : Iterator<LocalDate> {

        // Usamos la propiedad start del receiver de la función de extensión: el ClosedRange<LocalDate>
        var current = this@iterator.start

        // Reescribimos el metodo hasNext para indicar si hay elemento siguiente
        // Hacemos uso de la propiedad endInclusive del objeto rango cerrado receptor
        override fun hasNext() =
            current <= endInclusive // Comparación de LocalDate con la convención compareTo

        override fun next(): LocalDate {
            val next = current
            current = current.plusDays(1) // Incrementamos el dia actual en 1 dia más
            return next
        }
    }


fun testLocalDateIterator() {
    val newYear = LocalDate.ofYearDay(2027, 1)
    val daysOff = newYear.minusDays(2)..newYear.plusDays(3)

    // Iteramos sobre el rango daysOff porque disponemos (hemos definido) de un iterador de rangos de LocalDate
    for (dayOff in daysOff) {
        println(dayOff)
    }
}

fun main() {
    testListIterator()
    testLocalDateIterator()
}