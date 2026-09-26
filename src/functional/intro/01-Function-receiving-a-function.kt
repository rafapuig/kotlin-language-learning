package functional.intro

/**
 * La función applyOperation recibe como tercer parámetro una función
 */
fun applyOperation(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int // tipo función
) : Int {
    return operation(a, b)
}

fun add(a: Int, b: Int): Int = a + b
fun multiply(a: Int, b: Int) = a * b

fun main() {
    // Llamamos a applyOperation pasando la función add
    val result1 = applyOperation(3,5, ::add)
    println(result1)

    // LLamamos a applyOperation pasando la funcion multiply
    val result2 = applyOperation(3,5, ::multiply)
    println(result2)
}