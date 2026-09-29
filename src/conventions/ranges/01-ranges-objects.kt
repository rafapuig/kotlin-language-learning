package conventions.ranges

import java.time.LocalDate

/**
 * El operador .. sirve para crear rangos
 *
 * Es la forma concisa de llamar a la función rangeTo
 *
 * `start..end` --> `start.rangeTo(end)`
 *
 * que devuelve un rango.
 *
 * Podemos:
 * - definir el operador .. en nuestras propias clases
 * - implementar Comparable en la clase
 *
 * Se puede crear un rango entre dos objetos comparables, ya que la biblioteca estándar de Kotlin
 * define una función rangeTo genérica:
 * `operator fun <T:Comparable<T>> T.rangeTo(that:T): ClosedRange<T>`
 */

fun testRangeToOperator() {
    val now = LocalDate.now()
    val tenDaysFromNow = now.plusDays(10)

    // Creamos un rango de 10 dias empezando por el dia de hoy
    val vacation = now..tenDaysFromNow

    // Equivalente a usar la sintaxis de llamada a la función rangeTo
    val vacationFun = now.rangeTo(tenDaysFromNow)

    // Comprobamos si dentro de una semana a partir de hoy seguimos en el periodo de 10 días de vacaciones
    println(now.plusWeeks(1) in vacation)
}

/**
 * Analogo a rangeTo y ..
 *
 * contamos con el operador rangeUntil y el operador ..< para rangos con el extremo final abierto,
 * que no incluye el valor del límite superior. *
 */

fun testRangeUntil() {
    (0..<10).forEach { print(it) }
}

fun main() {
    testRangeToOperator()
    testRangeUntil()
}