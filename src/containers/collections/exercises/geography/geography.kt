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


fun Int?.toPopulationFormat(): String =
    "${this?.let { NumberFormat.getNumberInstance().format(it) } ?: 0} habs."


inline fun <T, A, B, R> Iterable<T>.teeing(
    f1: (Iterable<T>) -> A,
    f2: (Iterable<T>) -> B,
    merge: (A, B) -> R
): R = merge(f1(this), f2(this))