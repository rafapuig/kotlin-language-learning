package functional.functiontypes

val f: (Int) -> Boolean = { it > 2 }
val g: (String) -> Int = { it.length }

val h: (String) -> Boolean = { f(g(it)) }

typealias funF = (Int) -> Boolean
typealias funG = (String) -> Int
typealias funH = (String) -> Boolean

val hof: ((Int) -> Boolean, (String) -> Int) -> (String) -> Boolean =
    { f, g -> { text -> f(g(text)) } }

val hofWithAlias: (funF, funG) -> funH = { f, g -> { s -> f(g(s)) } }

fun main() {
    val f1 = f
    val f2 = g

    val f3 = hof(f1, f2)
    val result = f3("Hola Kotlin")
    println("El texto Hola Kotlin tiene mas de 2 caracteres? $result")
}