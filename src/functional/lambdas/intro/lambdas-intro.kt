package functional.lambdas.intro

/**
 * Una expresión lambda es un literal de función
 * Sintaxis:
 * { <lista de parámetros de entrada> -> <expresión que usa los parámetros> }
 * Ejemplos:
 * { text : String -> println(text) }
 * { text : String -> text.length }
 * { x : Int -> x * 2 }
 * { x: Double, y : Double -> x.pow(y) }
 *
 * Es, por tanto, una expresión
 * y se puede usar para
 * - inicializar o asignar una variable
 * - como argumento en la llamada a una función
 * - como valor de retorno de una función
 *
 * Una función que recibe como parámetro una función o devuelve una función
 * se denomina función de orden superior (high order function - HOF)
 *
 */

/**
 * Cuando la función tiene un único parámetro de entrada
 * El nombre por defecto del parámetro es it
 * y no es necesario escribir explícitamente la lista de parámetros de entrada y la flecha
 */
val f: (Int) -> Boolean = { it > 2 }
val g: (String) -> Int = { it.length }

val h: (String) -> Boolean = { f(g(it)) }


fun demo1() {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(3, 4))
}

fun demo2() {
    // Llamada a la lambda directamente
    { println("Hola lambdas") }()
}

fun demo3() {
    //Usar la función run para ejecutar una lambda
    run({ println("Hola lambdas") })
}

fun demo4() {
    //Llamar a la función run sin paréntesis
    run { println("Hola lambdas") }
}

fun demo5() {
    val favoriteNumber = run {
        println("Pensando un numero...")
        println("Ya casi lo tenemos...")
        77
    }
    println(favoriteNumber)
}

fun main() {
    demo1()
    demo2()
    demo3()
    demo4()
    demo5()
}