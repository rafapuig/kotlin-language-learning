package generics.variance.usesite

/**
 * Las declaraciones use-site de varianza en Kotlin
 * equivalen directamente a las wildcards
 * con límite superior <? extends T>
 * e inferior <? super T>
 * de Java
 *
 * MutableList<out T> significa lo mismo que MutableList<? extends T>
 * MutableList<in T> significa lo mismo que MutableList<? super T>
 */

/**
 * Función para copiar un elemento de una lista a otra
 * En esta función los parámetros source y destination
 * son de tipo * MutableList<T>
 * MutableList está declarada como invariante para el parámetro T
 */
fun <T> copyDataInvariant(source: MutableList<T>, destination: MutableList<T>) {
    for (item: T in source) {
        destination.add(item)
    }
}

fun testCopyDataInvariant() {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()

    /**
     * Como MutableList es invariante sobre T
     * no podemos pasar como argumento para
     * source MutableList<Int>
     * destination MutableList<Any>
     * porque ambos parámetros son del mismo tipo MutableList<T>
     */
    //copyDataInvariant(ints, anyItems) //ERROR

    val intsCopy = mutableListOf<Int>()
    copyDataInvariant(ints, intsCopy)
}

/**
 * Esta función no es generica
 * no declara un parámetro de tipo
 */
fun copyDataAny(source: MutableList<Any>, destination: MutableList<Any>) {
    for (item: Any in source) {
        destination.add(item)
    }
}

fun testCopyDataAny() {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()

    /**
     * Como MutableList es invariante sobre T
     * no podemos pasar como argumento para
     * source MutableList<Int> porque espera un MutableList<Any>,
     * pero con
     * destination MutableList<Any> si es correcto al argumento
     */
    //copyDataAny(ints, anyItems) //ERROR

    val intsCopy = mutableListOf<Int>()
    /**
     * Es incluso peor si pasamos dos MutableList<Int>
     */
    //copyDataAny(ints, intsCopy) // ERROR
}

/**
 * Primera solución (introducir un segundo parámetro de tipo)
 * Como la lista source solo se usa para leer sus elementos
 * y la lista destination solamente para escribir
 * Elementos de un tipo específico se pueden copiar en una lista
 * que almacene elementos de un supertipo de los elementos a copiar
 *
 * Si usamos dos parámetros de tipo en la función
 * y limitamos que uno (S) sea subtipo del otro (D) con un upper bound
 */
fun <S : D, D> copyDataUpperBound(source: MutableList<S>, destination: MutableList<D>) {
    for (item: S in source) {
        destination.add(item) // S es un subtipo de D llamar a add argumento OK
    }
}

fun testCopyDataUpperBound() {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()

    // Ahora funciona
    copyDataUpperBound(ints, anyItems)
}

/**
 * Segunda solución (use-site variance)
 * Cuando la implementación de una función generica
 * solamente llama a métodos que tienen el parámetro en posición de salida
 * (o solamente en posición de entrada)
 * podemos aprovecharlo usando modificadores de varianza
 * para usos particulares del parámetro de tipo en la definición de esa función
 */

fun <T> copyData(source: MutableList<out T>, destination: MutableList<in T>) {
    for (item: T in source) {
        destination.add(item)
    }
}

fun testCopyData() {
    /**
     * Sí declaramos una variable con el argumento de tipo
     * con proyección de salida
     */
    val list:MutableList<out Int> = mutableListOf()
    /**
     * El compilador prohíbe llamar a los métodos
     * que consuman un valor del tipo
     */
    //list.add(1)

    val ints : MutableList<out Int> = mutableListOf(1, 2, 3)
    val anyItems : MutableList<in Any> = mutableListOf()

    copyData(ints, anyItems)
}
