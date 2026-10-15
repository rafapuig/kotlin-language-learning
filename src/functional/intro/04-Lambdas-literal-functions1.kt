package functional.intro.lambdas1

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

    /**
     * La variable tiple, de tipo función (Int) -> Int
     * guarda la referencia a la instancia que ejecuta cuando se invoca pasando un valor a number como argumento
     * number * 3 y devuelve el resultado
     */
    val triple : (Int) -> Int = { number -> number * 3 } // El triple

    println(triple.invoke(4)) // 12
    println(triple(10)) // 100

    // Podemos asignar la referencia al objeto en la variable triple en la variable operation
    // (son del mismo tipo)
    operation = triple
    println(operation(5))
}