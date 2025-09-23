package functional.functiontypes

/**
 * Una función de orden superior es una función que
 * - declara un parámetro de tipo función
 * - devuelve como retorno un valor de tipo función
 */

/**
 * La función twoAndFive es una función de orden superior
 * declara un parámetro de tipo función (Int, Int)-> Int
 *
 * Se puede especificar nombres a los parámetros de entrada de un tipo de función
 */

fun twoAndFive(operation: (operand1: Int, operand2: Int) -> Int) {
    val result = operation(2, 5) // Llama a la función operation con las entradas 2 y 5
    println("El resultado de ejecutar la funcion (operation) sobre 2 y 5 es $result")
}

fun two(operation: (operand: Int) -> Int) {
    val result = operation(2)
    println("El resultado de ejecutar la funcion (operation) sobre 2 es $result")
}

fun operateWith(number: Int, operation: (Int) -> Int) {
    val result = operation(number)
    println("El resultado de ejecutar la funcion (operation) sobre $number es $result")
}

fun Int.operate(operation: (Int) -> Int) {
    operateWith(this, operation)
}

fun main() {
    twoAndFive(operation = { a, b -> a + b })
    twoAndFive({ a, b -> a - b })
    twoAndFive() { m, n -> m * n }
    twoAndFive { x, y -> y / x }

    two(operation = { a -> a * 2 })
    two({ n -> n * n })
    two() { n -> n + 1 }
    two { n -> n - 1 }
    two(operation = { it * 2 })
    two({ it * it })
    two() { it + 1 }
    two { it - 1 }

    operateWith(4, { it * it })
    operateWith(4) { it * it }

    5.operate(operation = { it * 2 })
    6.operate({ it + 10 })
    7.operate() { it - 1 }
    8.operate { it * 5 }
}