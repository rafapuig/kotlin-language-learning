package functional.intro.calculator

val add: (Int, Int) -> Int = { a, b -> a + b }
val subtract: (Int, Int) -> Int = { a, b -> a - b }
val multiply: (Int, Int) -> Int = { a, b -> a * b }
val divide: (Int, Int) -> Int = { a, b -> a / b }

fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    calculate(5,2, add)
    calculate(5,2, subtract)
    calculate(5,2, multiply)
    calculate(5,2, divide)

    calculate(5, 2, { a, b -> a + b })
    calculate(5, 2, { a, b -> a - b })
    calculate(5, 2, { a, b -> a * b })
    calculate(5, 2, { a, b -> a / b })

    // Una lambda se puede mover fuera de los paréntesis si es el último argumento
    calculate(5, 2) { a, b -> a + b }
    calculate(5, 2) { a, b -> a - b }
    calculate(5, 2) { a, b -> a * b }
    calculate(5, 2) { a, b -> a / b }


}