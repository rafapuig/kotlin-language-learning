package functional.intro.condition

fun check(
    number: Int,
    condition: (Int) -> Boolean
): Boolean {
    return condition(number)
}

fun main() {
    // Cuando la lambda tiene únicamente un parámetro podemos usar su nombre implícito it
    check(10) { it > 5 }
    check(10) { it % 2 == 0 }
    check(10) { it < 0 }
}