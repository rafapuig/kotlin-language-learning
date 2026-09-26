package functional.intro.lambdas




/**
 * Se puede almacenar en una variable la referencia a una función
 * si esa variable es del tipo de la función referenciada
 */

fun double(number: Int) = number * 2
fun square(number: Int) = number * number


fun main() {

    /**
     * ¿Podemos asignar a la variable operation
     * directamente el código de una función sin tener que declarar
     * previamente la función (por ejemplo, double)?
     * Sí, podemos usar un LITERAL DE FUNCIÓN también llamada expresión lambda
     */
    var operation: (Int) -> Int = {number -> number * 2}

    println(operation(5)) // 10

    operation = ::square
    println(operation(5))

    operation = ::double
    println(operation(5))

    val triple : (Int) -> Int = { number -> number * 3 } // El triple

    operation = triple
    println(operation(5))
}