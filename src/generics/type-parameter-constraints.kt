package generics.type.parameter.constraints

import generics.functions.display

/**
 * Las restricciones aplicadas a un parámetro de tipo
 *
 * nos permiten limitar los tipos que se pueden usar como argumento
 */

/**
 * Por ejemplo,
 * una función generica que calcule la suma de los elementos de una lista
 * Se puede usar con List<Int> o List<Double> pero no con List<String>
 */

/**
 * UPPER BOUND TYPE CONSTRAINT
 *
 * Si aplicamos una restricción tipo upper bound a un parámetro de tipo
 * el argumento de tipo que podemos usar debe ser el propio tipo upper bound
 * o alguno de sus subtipos
 * En otras palabras, el tipo upper bound indica
 * hasta cuanto podemos generalizar en la jerarquía de clases (subir hacia arriba)
 *
 * Por ejemplo,
 * Si A extiende B
 * B extiende C
 * y C extiende D y E
 * Si decimos que el tipo upper bound es C
 * Los argumentos posibles para el parámetro de tipo serían C, D y E (A y B no serían válidos)
 *
 * Si el tipo upper bound es B
 * Los argumentos válidos son B, C, D y E (pero no A)
 *
 * Para especificar una restricción upper bound type
 * se usan : y el nombre del tipo upper bound
 * Por ejemplo <T : Number>
 */
fun <T : Number> List<T>.sum(): Double {
    var sum = 0.0
    for (element in this) {
        sum += element.toDouble() // se asume que T es de tipo Number como mínimo
    }
    return sum
}

/**
 * El upper bound
 * sirve usar valores de tipo T como si fueran objetos del tipo upper bound
 * Se puede llamar a los métodos declarados en la clase o interface upper bound
 */
fun <T: Number> half(value: T): Double {
    /**
     * Podemos llamar al metodo toDouble porque está declarado en la clase Number
     * y como T está restringido con un upper bound Number
     * el parámetro value que es de tipo T será de tipo Number o una subclase de number
     * lo que permite llamar al metodo toDouble
     */
    return value.toDouble() / 2.0
}

/**
 * En la función generica max
 * queremos usar el operador > con los parámetros a y b que son de tipo T
 * para ello debemos garantizar que son instancias de objetos cuya clase
 * implementa la interface Comparable<T>
 * aplicando la restricción upper bound al parámetro de tipo declarado en la función
 *
 * Solamente será válido llamar a la función max con argumentos
 * cuya clase implemente la interfaz Comparable
 */
fun <T : Comparable<T>> max(a:T, b:T) : T = if (a > b) a else b


/**
 * En el caso necesitar especificar más de una restricción
 * la sintaxis que debemos utilizar es diferente
 * Se usa where después del tipo de retorno
 * con la lista de restricciones
 */
fun <T> ensureTrailingPeriod(seq: T): Unit where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) { // para llamar a endsWith -> CharSequence
        seq.append('.') // para llamar a append --> Appendable
    }
}

fun ensureTrailingPeriodDemo() {
    val sb = StringBuilder("Hola Kotlin")
    ensureTrailingPeriod(sb)
    println(sb)
}

fun main() {
    val result = listOf<Number>(1, 2L, 3f, 4.0).sum()
    println(result)
    println(half(10))
    println(max(1, 2))
    println(max("Kotlin", "Java"))
    ensureTrailingPeriodDemo()
}

