package containers.collections.exercises.geography

import java.text.NumberFormat

/*fun <T> Collection<T>.display(title: String) {
    println(title)
    println("-".repeat(title.length))
    this.forEach { println(it) }
}*/

fun <T> T.display(title: String) {
    println(title)
    println(this)
}

fun <T> Collection<T>.display(
    title: String,
    displayer: Collection<T>.() -> Unit = { this.forEach { println(it) } }
) {
    println(title)
    println("-".repeat(title.length))
    displayer()
    //this.forEach { println(it) }
}

fun Number?.toNumericFormat(): String =
    "${
        this?.let { number ->
            NumberFormat.getNumberInstance().format(number)
        } ?: 0
    }"


fun Number?.toPopulationFormat(): String =
    "${toNumericFormat()} habs."


fun Number?.toPercentFormat(fractionalDigits: Int = 2): String =
    NumberFormat.getPercentInstance().apply {
        minimumFractionDigits = fractionalDigits
        maximumFractionDigits = fractionalDigits
    }.format(this)


