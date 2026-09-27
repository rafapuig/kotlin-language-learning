package generics.type.parameter.constraints


/**
 * Las restricciones aplicadas a un parámetro de tipo
 *
 * nos permiten limitar los tipos que se pueden usar como argumento
 */

/**
 * Por ejemplo,
 * una función genérica que calcule la suma de los elementos de una lista
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
 * Si A es extendida por B
 * B es extendida por C
 * y C es extendida por D y E
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

fun testSum() {
    val numbers = listOf<Number>(1, 2L, 3f, 4.0)
    val result = numbers.sum()
    println(result)
}

fun testSum2() {
    val integers = listOf(1, 2, 3)
    // Se puede llamar a sum con un argumento de tipo Int dado que Int es un subtipo de Number
    // y se cumple la restricción upper bound que pide que como mínimo el argumento de tipo sea Number,
    // pero también puede ser cualquier subclase que herede de Number o de sus subclases
    val result = integers.sum()
    println(result)
}


/**
 * El upper bound
 * sirve para usar valores de tipo T como si fueran objetos del tipo upper bound
 * Se puede llamar a los métodos declarados en la clase o interface del tipo upper bound
 */
fun <T : Number> half(value: T): Double {
    /**
     * Podemos llamar al metodo toDouble porque está declarado en la clase Number
     * y como T está restringido con un upper bound Number
     * el parámetro value que es de tipo T será de tipo Number o una subclase de number
     * lo que permite llamar al metodo toDouble
     */
    return value.toDouble() / 2.0
}

fun testHalf() {
    val result1 = half(10)
    println(result1)

    val result2 = half(20.0)
    println(result2)
}

/**
 * En la función genérica max
 * queremos usar el operador > con los parámetros a y b que son de tipo T
 * para ello debemos garantizar que son instancias de objetos cuya clase
 * implementa la interface Comparable<T>
 * aplicando la restricción upper bound al parámetro de tipo declarado en la función
 *
 * Solamente será válido llamar a la función max con argumentos
 * cuya clase implemente la interfaz Comparable
 *
 * El operador > de Kotlin para a > b es la abreviación de `a.compareTo(b)`
 */
fun <T : Comparable<T>> max(a: T, b: T): T = if (a > b) a else b


fun testMax() {
    // La clase Int implementa Comparable<Int>
    println(max(1, 2))

    // La clase String implementa Comparable<String>
    println(max("Kotlin", "Java"))
}


/**
 * En el caso necesitar especificar más de una restricción
 * la sintaxis que debemos utilizar es diferente.
 * Se usa where, después del tipo de retorno de la función,
 * con la lista de restricciones separadas por ,
 */
fun <T> ensureTrailingPeriod(sequence: T): Unit where T : CharSequence, T : Appendable {
    if (!sequence.endsWith('.')) { // para llamar a endsWith -> CharSequence
        sequence.append('.') // para llamar a append --> Appendable
    }
}

fun ensureTrailingPeriodDemo() {
    // La clase StringBuilder implementa CharSequence y Appendable luego es un subtipo de ambas
    val sb = StringBuilder("Hola Kotlin")

    // Si pasamos un objeto StringBuilder como argumento para el parámetro sequence
    // se cumplen las restricciones impuestas sobre el parámetro de tipo T, que especifica el tipo para sequence
    ensureTrailingPeriod(sb)

    println(sb) // Hola Kotlin.
}


fun main() {
    testSum()
    testSum2()
    testHalf()
    testMax()
    ensureTrailingPeriodDemo()
}

