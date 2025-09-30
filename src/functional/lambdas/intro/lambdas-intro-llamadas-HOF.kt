package functional.lambdas.intro

import kotlin.random.Random

/**
 * Vamos a ver como llamar a una función de orden superior
 * pasando una lambda como argumento de llamada
 *
 * La función de orden superior combine
 * recibe dos funciones y retorna una función
 */

fun combine(f1: (Int) -> Int, f2: (Int) -> Int): (Int) -> Int {
    return { x -> f2(f1(x)) }
}

fun testCombine() {
    val double: (Int) -> Int = { x -> x * 2 }
    val square: (Int) -> Int = { x -> x * x }
    val squareDoble: (Int) -> Int = combine(double, square)
    val result = squareDoble(5)
    println(result)
}

fun randomOperation(): (Int) -> Int {
    val double: (Int) -> Int = { x -> x * 2 }
    val square: (Int) -> Int = { x -> x * x }
    val triple: (Int) -> Int = { x -> x * 3 }

    val operations = listOf(double, square, triple)
    return operations.random()
}

fun testRandomOperation() {
    for (i in 1..5) {
        val operation = randomOperation()
        println(operation(4))
    }
}

fun main() {
    testCombine()
    testRandomOperation()
}