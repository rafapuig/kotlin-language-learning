package conventions.operators.comparison

/**
 * Kotlin permite usar los operadores de comparación == != > < >= <=
 * con cualquier tipo de objetos
 * (no solamente con los tipos primitivos como en Java)
 *
 * En Java para comparar objetos tenemos que usar el metodo equals para la igualdad ==
 * y el metodo compareTo para > < >= <= (incluso también para == ) implementado la interface Comparable<T>
 *
 * Kotlin permite una sintaxis más concisa mediante el uso directo de operadores
 */

/**
 * Operador equals ==
 *
 * En Kotlin el uso del operador == se traduce en una llamada al método equals
 * Y el operador != en una llamada a equals invirtiendo en resultado obtenido
 *
 * Estos operadores == y != se pueden usar con tipos anulables dado que comprueban igualdad con null
 *
 *  a == b comprueba primero si a != null y si no lo es entonces llama a a.equals(b)
 *
 *  `a == b` ---> `a?.equals(b) ?: (b == null)`
 *
 *  Si ambas a y b son null el resultado de == es true
 */

/**
 * Si creamos una data class en compilador nos genera automáticamente el metodo equals
 */

class Point(val x: Int, val y: Int) {

    // Aunque aquí no usamos la palabra operator en realidad estamos sobrecargando el operador == para objetos Point
    // Tampoco podemos implementarlo como metodo de extension por ser un metodo de la clase Any
    override fun equals(other: Any?): Boolean {
        // Comprobamos si el parámetro es el mismo objeto que this mediante el operador identity equals ===
        // === comprueba si dos referencias apuntan al MISMO objeto (equivale al == de Java para objetos)
        if (other === this) return true

        // Comprueba el tipo de objeto del parámetro other
        if (other !is Point) return false

        // Llegados a esta línea se ha aplicado el smart cast
        // y el compilador ahora trata a other como de tipo Point
        // (No como de tipo Any?)
        return other.x == this.x && other.y == this.y
    }
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(10, 20)
    val p3 = Point(10, 2)

    val p4: Point? = null
    val p5: Point? = null

    println(p1 == p1) // true
    println(p1 == p2) // true
    println(p1 == p3) // false
    println(p1 != p3) // true
    println(p1 != null) // true
    println(null == p1) // false
    println(null == p4) // true
    println(p4 == p5) // true
}