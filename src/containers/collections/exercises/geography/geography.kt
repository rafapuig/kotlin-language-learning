package containers.collections.exercises.geography

import containers.collections.exercises.geography.model.Continent
import containers.collections.exercises.geography.model.Countries
import containers.collections.exercises.geography.model.Population
import java.text.NumberFormat
import java.util.*

fun <T> Collection<T>.display(title: String) {
    println(title)
    println("-".repeat(title.length))
    this.forEach { println(it) }
}

fun Number?.toNumericFormat(): String =
    "${this?.let { number -> 
        NumberFormat.getNumberInstance().format(number) 
    } ?: 0}"

fun Number?.toPopulationFormat(): String =
    "${toNumericFormat()} habs."

fun Number?.toPercentFormat(fractionalDigits: Int = 2): String =
    NumberFormat.getPercentInstance().apply {
        minimumFractionDigits = fractionalDigits
        maximumFractionDigits = fractionalDigits
    }.format(this)


inline fun <T, A, B, R> Iterable<T>.teeing(
    f1: (Iterable<T>) -> A,
    f2: (Iterable<T>) -> B,
    merge: (A, B) -> R
): R = merge(f1(this), f2(this))