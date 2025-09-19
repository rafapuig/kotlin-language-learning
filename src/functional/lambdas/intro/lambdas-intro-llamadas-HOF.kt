package functional.lambdas.intro

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

fun main() {
    val double: (Int) -> Int = { x -> x * 2 }
    val square: (Int) -> Int = { x -> x * x }
    val squareDoble: (Int) -> Int = combine(double, square)
    val result = squareDoble(5)
    println(result)
}