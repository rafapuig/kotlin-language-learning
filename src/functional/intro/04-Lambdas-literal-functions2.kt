package functional.intro.lambdas2

val add: (Int, Int) -> Int = { a, b -> a + b }
val subtract: (Int, Int) -> Int = { a, b -> a - b }
val multiply: (Int, Int) -> Int = { a, b -> a * b }
val divide: (Int, Int) -> Int = { a, b -> a / b }

fun main() {
    println(add(5, 4))
    println(subtract(5, 4))
    println(multiply(5, 4))
    println(divide(6, 2))
}