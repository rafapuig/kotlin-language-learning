package conventions.operators.compound

import conventions.operators.arithmetic.Point
import conventions.operators.arithmetic.testOperatorPlus

data class Point(val x: Int, val y: Int)

/**
 * Cuando definimos el operador (en este caso plus) Kotlin soporta
 * no solo la operación de suma +, sino que también acepta el uso de  +=
 *
 * Y si fuera la resta aceptaría la operación - y la -=
 *
 * Es decir, los operadores de asignación compuestos
 */
operator fun Point.plus(other: Point) = Point(x + other.x, y + other.y)

fun testCompoundAssignmentPlus() {
    var point = Point(10, 20)
    point += Point(5, 10)

    // Que sería lo mismo que escribir
    //point = point + Point(5, 10)

    println(point)
}

/**
 * En otros casos lo que tiene sentido es definir la operación +=
 * para que modifique un objeto pero no reasignar el objeto
 * Por ejemplo, en el caso de modificar una colección por añadir un elemento
 */

fun testAddElemToCollection() {
    val names = mutableListOf<String>()
    names.add("Rafa")
    names += "Emilio"
    println(names)
}

/**
 * Para sobrecargar el operador += definimos la función plusAssign
 * (para -= minusAssign, para *= timesAssign, ...)
 */

operator fun MutableCollection<Int>.plusAssign(element: Int) {
    this.add(element)
}



fun main() {
    testCompoundAssignmentPlus()
    testAddElemToCollection()
}