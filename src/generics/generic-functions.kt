package generics.functions

/**
 * FUNCIONES GENÉRICAS
 *
 * Además de tipos (clase o interfaces) genéricas
 * también podemos declarar funciones genéricas
 *
 * Las funciones genéricas declaran parámetros de tipo
 * Cuando se llama a una función genérica
 * además de proporcionar los argumentos de los parámetros de entrada
 * debemos proporcionar los argumentos de tipo para especificar los
 * valores de los parámetros de tipo de la función
 */

/**
 * La función es genérica dado que declara un parámetro de tipo
 * con identificador T
 * El parámetro de tipo se puede usar para
 * - declarar el tipo del parámetro de entrada
 * - declarar el tipo de retorno
 * - ser el argumento de tipo de un tipo genérico usado como
 * tipo de un parámetro de entrada o tipo de retorno
 */
fun <T> printAndReturn(t: T): T = t.also { println(it) }

fun <T> process(elems: List<T>): List<T> = elems.reversed()

/**
 * FUNCIONES DE EXTENSION GENÉRICAS
 *
 * Una función de extensión
 * también puede ser generica
 * El parámetro de tipo se puede usar para el tipo del receiver
 */

fun <T> T.display() = println(this)


/**
 * PROPIEDADES DE EXTENSION GENÉRICAS
 *
 * Los getters y setters son funciones
 * Por tanto, también podemos declarar propiedades de extensión genéricas
 */
val <T> List<T>.middle: T get() = this[size / 2]



val friends = listOf("Emilio", "Ramon", "Raul", "Rafa")
val fruits: List<String> = listOf<String>("Manzana", "Banana", "Piña")


fun testInferredArgumentTypeCall() {
    val n = printAndReturn(45)
    n.display()
    val reversed = process(friends)
    reversed.display()
    val middle = fruits.middle
}

fun testExplicitArgumentTypeCall() {
    val n = printAndReturn<Int>(45)
    n.display<Int>()
    val reversed = process<String>(friends)
    reversed.display<List<String>>()

    //val middle = fruits.middle<String> // En propiedades no se puede explicitar
    val middle = fruits.middle
}

fun testStandardLibraryFunctions() {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2)) // a,b,c

    println(letters.slice(10..13)) // k,l,m,n

    val friendsStartingWithR = friends.filter {
        it.startsWith("R")
    }
    println(friendsStartingWithR)
}

fun main() {
    testInferredArgumentTypeCall()
    testExplicitArgumentTypeCall()
    testStandardLibraryFunctions()
}