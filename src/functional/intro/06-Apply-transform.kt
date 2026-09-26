package functional.intro.transform

fun transform(
    number: Int,
    operation: (Int) -> Int
): Int {
    return operation(number)
}

fun main() {

    transform(5, operation = { num -> num * 3 })
    transform(5, { num -> num * 3 })
    transform(5) { num -> num * 3 }

    // Cuando la lambda tiene únicamente un parámetro podemos usar su nombre implícito it
    transform(5) { it * 3 }
}