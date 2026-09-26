package functional.lambdas

import kotlin.math.pow


/**
 * Una expresión lambda es un literal de función
 *
 * La idea es convertir un bloque de código (o una función) en un valor
 *
 * Sintaxis:
 * { <lista de parámetros de entrada> -> <expresión que usa los parámetros> }
 *
 * Ejemplos:
 *`{ text : String -> println(text) }
 * { text : String -> text.length }
 * { x : Int -> x * 2 }
 * { x: Double, y : Double -> x.pow(y) }`
 */

/** Es, por tanto, una expresión (un valor)
 * y se puede usar para
 * - inicializar o asignar una variable
 * - como argumento en la llamada a una función
 * - como valor de retorno de una función
 *
 * Y tiene tipo, su tipo es un tipo función
 */

val printText = { text: String -> println(text) }
val len = { text: String -> text.length }
val double = { x: Int -> x * 2 }
val power = { x: Double, n: Int -> x.pow(n) }




/** Según el paradigma de la programación funcional, una función que
 * - recibe como parámetro una función como valor
 * - o devuelve una función como valor
 * se denomina función de orden superior (high order function - HOF)
 */

/**
 * Cuando el literal de función tiene un único parámetro de entrada
 * El nombre por defecto del parámetro es it
 * y no es necesario escribir explícitamente la lista de parámetros de entrada y la flecha ->
 */
val f: (Int) -> Boolean = { it > 2 } // it es el parámetro de entrada de tipo Int
val g: (String) -> Int = { it.length } // it es el parámetro de entrada de tipo String

val h: (String) -> Boolean = { f(g(it)) }

/**
 * Tratar a las funciones como si fueran valores y combinar funciones para expresar
 * comportamiento es un de los pilares principales de la programación funcional
 *
 * Paradigma de la programación funcional
 * - Funciones como valores: Se pueden almacenar en variables, pasarlas como parámetros y devolverlas
 * - Inmutabilidad: El estado interno de los objetos no cambia después de su creación
 * - No efectos colaterales (side effects): La función devuelve siempre el mismo resultado cuando recibe las
 * mismas entradas, sin modificar el estado de otros objetos. Funciones puras
 */

fun demo1() {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(3, 4))
}

fun demo2() {
    // Llamada a la lambda directamente
    { println("Hola lambdas") }()
}

fun demo3() {
    //Usar la función run para ejecutar una lambda: argumento un literal de función (una lambda)
    run({ println("Hola lambdas") })
}

fun demo4() {
    // Por convención, en Kotlin el último argumento se puede sacar fuera de los paréntesis
    run() { println("Hola lambdas") }
}

fun demo5() {
    //Llamar a la función run sin paréntesis (si la lista de argumentos queda vacía se pueden omitir los paréntesis)
    run { println("Hola lambdas") }
}

fun demo6() {
    val favoriteNumber = run {
        println("Pensando un numero...")
        println("Ya casi lo tenemos...")
        77// El resultado devuelto por una lambda es el de avaluar la última instrucción (no es necesario el return)
    }
    println(favoriteNumber)
}

fun main() {
    demo1()
    demo2()
    demo3()
    demo4()
    demo5()
    demo6()
}