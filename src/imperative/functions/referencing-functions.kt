package imperative.functions

/**
 * Para hacer referencia a una función por su nombre se usa el operador ::
 */

fun add(a: Int, b: Int) = a + b
fun subtract(a: Int, b: Int)= a - b
fun multiply(a: Int, b: Int) = a * b
fun divide(a: Int, b: Int) = a / b


fun applyAllOperations(x: Int, y: Int) {
    val operations = listOf(::add, ::subtract, ::multiply, ::divide)

    for (operation in operations) {
        val result = operation(x,y)
        println("Resultado: $result")
    }
}

fun main() {
    var selectedOperation = ::add

    val x = 10
    val y = 2

    var result = selectedOperation(x,y)
    println("Resultado: $result")

    selectedOperation = ::subtract
    result = selectedOperation(x,y)
    println("Resultado: $result")

    selectedOperation = ::multiply
    result = selectedOperation(x,y)
    println("Resultado: $result")

    selectedOperation = ::divide
    result = selectedOperation.invoke(x,y)
    println("Resultado: $result")
}