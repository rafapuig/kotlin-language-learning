package generics.runtime

/**
 * ERASURE
 * (borrado de la información de los argumentos de tipo)
 * Los argumentos de tipo de un objeto de un tipo genérico son eliminados,
 * no se preservan en tiempo de ejecución
 *
 * REIFIED
 * Si declaramos una función inline los argumentos de tipo no se borran
 * (en realidad son recreados : reified)
 */

/**
 * En tiempo de ejecución no existen tipos genéricos
 * Una instancia de una clase generica pierde la información sobre los argumentos
 * de tipo usados en la creación de la instancia
 *
 * En tiempo de compilación declaramos un tipo List<String> para referenciar
 * un objeto List cuyos elementos sean strings
 * En tiempo de ejecución lo único que sabremos es que es un objeto List
 * (pero no sabremos el valor del tipo de los elementos)
 *
 * No podremos comprobar si una lista es una lista de strings
 * o de otro tipo de objetos
 */

fun readNumbersOrWords(): List<Any> {
    val input = readln()
    val words = input.split(" ")
    val numbers = words.mapNotNull { it.toIntOrNull() }
    return numbers.ifEmpty { words }
}

/**
 * No podemos comprobar si la lista es de Ints o Strings
 * la información del argumento de tipo ha sido eliminada
 * Lo único que podemos comprobar es que sea una Lista con List<*>
 * (List<*> es el equivalente a List<?> en Java)
 */
fun printList(list: List<Any>) {
    when (list) {
        //is List<String> -> println("String $list") // ERROR
        //is List<Int> -> println("Int $list") // ERROR
        is List<*> -> println(list)
    }
}

fun testPrintList() {
    val list = readNumbersOrWords()
    printList(list)
}


/**
 * Una comprobación de tipos con el operador as o as?
 * Solamente comprobaría si un objeto es de un tipo genérico y no otro tipo
 * pero no es capaz de comprobar si también es del mismo tipo en el argumento de tipo
 */

/**
 * En la función printSum
 * Se realiza un casting con el operador as?
 * Que lo único que puede comprobar es si el objeto Iterable es una Lista o no
 * Pero no puede comprobar si la lista es de Ints o de otro tipo de elementos
 */
fun printSum(collection: Collection<*>) {
    val intList = collection as? List<Int> // unchecked cast
        ?: throw IllegalArgumentException("List is expected")
    // para que no de error los elementos de la lista deben poder convertirse a Number
    val result = intList.sum()
    println(result)
}

fun testPrintSum() {
    val intList = listOf(1, 2, 3, 4, 5)
    printSum(intList)

    try {
        val intSet = setOf(1, 2, 3, 4, 5)
        printSum(intSet)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    try {
        val stringList = listOf("Kotlin", "Java")
        /**
         * El casting a List funcionará, pero no se podrán sumar las strings
         */
        printSum(stringList)
    } catch (e: ClassCastException) {
        println(e.message)
    }
}

/**
 * Si el compilador sabe el tipo del argumento...
 *
 * En este caso sea cual sea el tipo concreto parámetro collection (List o Set)
 * el compilador sabe que el argumento de tipo es Int
 */
fun printSum2(collection: Collection<Int>) {
    when (collection) {
        is List<Int> -> println("List sum: ${collection.sum()}")
        is Set<Int> -> println("Set sum: ${collection.sum()}")
    }
}

/**
 * El compilador te avisará que comprobaciones son peligrosas
 * - prohibiendo las comprobaciones con is (error de compilación)
 * - advirtiendo los castings con as (warning)
 */


fun main() {
    //testPrintList()
    testPrintSum()
}