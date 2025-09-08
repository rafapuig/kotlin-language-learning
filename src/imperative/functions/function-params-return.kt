package func
/**
 * parámetro -> a : Int (identificador : tipo)
 * lista de parámetros entre paréntesis y separados por ,
 * tipo devuelto : Int al final de la declaración del parámetro
 * el cuerpo de la función se escribe entre {}
 */
fun max(a: Int, b: Int): Int {
    // if es una expresión, se evalúa en tiempo de ejecución y resulta en un valor
    // es equivalente al operador ternario de otros lenguajes
    return if (a > b) a else b
}

fun main() {
    println(max(1, 2))
}