package functional.intro.type2

/**
 * ¿Qué tipo tiene la función add?
 * (Int, Int) -> Int
 */
fun add(a: Int, b: Int): Int = a + b

/**
 * ¿Y de qué tipo es la función multiply?
 * (Int, Int) -> Int
 */
fun multiply(a: Int, b: Int) = a * b


/**
 * Se puede almacenar en una variable la referencia a una función
 * si esa variable es del tipo de la función referenciada
 */
var operation: (Int, Int) -> Int = ::add


fun double(number: Int) = number * 2
fun square(number: Int) = number * number



fun main() {

    val result1 = operation(2, 3)
    println(result1)

    // La variable operation también puede guardar la referencia
    // a la función multiply porque add y multiply son funciones
    // del mismo tipo (Int, Int) -> Int
    operation = ::multiply

    // Llamamos a applyOperation pasando la función multiply
    val result2 = operation(2, 3)
    println(result2)

    // La variable operation no puede almacenar la referencia
    // a la función square porque el tipo de la función no
    // coincide con el tipo de la variable
    //operation = ::square

    var operation2: (Int) -> Int

    // La variable operation si es del tipo de función correcto
    // para almacenar la referencia a la función square
    operation2 = ::square

    println(operation2(4)) // 16

    // También puede guardar la referencia a la función double
    // porque double y square son funciones del mismo tipo
    operation2 = ::double

    println(operation2(4)) // 8

}