package functional.intro.type1

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


fun main() {

    // Llamamos a la función referenciada por la variable operation
    // mediante el metodo invoke de los objetos de tipo función
    val result1 = operation.invoke(2, 3)
    println(result1)

    // La variable operation también puede guardar la referencia
    // a la función multiply porque add y multiply son funciones
    // del mismo tipo (Int, Int) -> Int
    operation = ::multiply

    // Llamamos a la función referenciada por la variable operation
    // (no hace falta explicitar la llamada al metodo invoke, ya que invoke es el operador de llamada a función)
    // Con esta sintaxis parece que estemos llamando a la función operation !!!
    val result2 = operation(2, 3)
    println(result2)
}