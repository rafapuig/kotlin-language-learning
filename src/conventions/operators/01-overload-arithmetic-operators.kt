package conventions.operators.arithmetic

data class Point(val x: Int, val y: Int)

/**
 * Definimos una sobrecarga para el operador + actuando sobre operandos de tipo Point
 * Por convención la función se denomina plus
 * Hay que usar además la palabra clave operator
 *
 * Podemos declarar el operador como un miembro de la clase Point o como una función de extensión
 */
operator fun Point.plus(other: Point): Point =
    Point(x + other.x, y + other.y) // Suma las coordenadas y devuelve un nuevo Point

fun testOperatorPlus() {
    val p1 = Point(10, 20)
    val p2 = Point(20, 40)

    // Llamada a la función plus mediante el signo + (la función plus se ha declarado como operator)
    val p3 = p1 + p2

    println(p3)

    // Código equivalente mediante la sintaxis de llamada a función explícitamente
    val p4 = p1.plus(p2)
}

/**
 * Cuando definimos un operador binario, no es necesario usar el mismo tipo para ambos operandos
 */

operator fun Point.times(scale: Double) =
    Point((x * scale).toInt(), (y * scale).toInt())

fun testTimesOperator() {
    val p1 = Point(10, 20)
    val p2 = p1 * 1.5
    println(p2)
}

/**
 * Los operadores no soportan de manera automática la conmutatividad
 * Necesitamos definir otro operador con los tipos de los operadores izquierdo y derecho intercambiados
 */
operator fun Double.times(point: Point) = point.times(this)

fun testTimesCommutativity() {
    val p1 = Point(10, 20)
    val p2 = p1 * 1.5
    println(p2)

    val p3 = 1.5 * p1
    println(p3)
}

/**
 * El tipo retornado por el operador puede ser diferente al tipo de los operandos
 */
operator fun Char.times(count: Int): String = toString().repeat(count)

fun testCharTimesCount() {
    val char = '*'
    val text = char * 10
    println(text)
}



fun main() {
    testOperatorPlus()
    testTimesOperator()
    testTimesCommutativity()
    testCharTimesCount()
}