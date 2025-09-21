package generics.variance

/**
 * VARIANZA
 * Describe como se relacionan tipos
 * con el mismo tipo base
 * y diferentes argumentos de tipo
 *
 * Por ejemplo, qué relación hay entre List<String> y List<Any>
 *
 * Determina cuando es seguro pasar un argumento a una función
 *
 * Si una función declara un parámetro de tipo Any
 * Es seguro pasar un argumento de tipo String
 * Porque la clase String es una subclase de Any
 *
 * Donde se espera un Any se puede proporcionar un String
 * sin problemas
 *
 * Pero,
 * Si la función declara un parámetro de tipo List<Any>
 * ¿Se puede pasar un argumento de tipo List<String> ?
 */

/**
 * Es seguro si solamente se leen los elementos de la lista
 *
 * Si pasamos una lista de solo lectura es seguro
 */
fun printContent(list: List<Any>) {
    println(list.joinToString())
}

fun printContentMutable(list: MutableList<Any>) {
    println(list.joinToString())
}

private fun testPrintContent() {
    val friends = listOf("Rafael", "Raul", "Ramon")
    printContent(friends)

    val languages = mutableListOf("Java", "Javax", "Python")
    //printContentMutable(languages) // ERROR
}

/**
 * No es seguro si la función añade o reemplaza elementos
 *
 * Si el tipo del parámetro de entrada es de tipo MutableList
 */
fun addLanguage(list:MutableList<Any>) {
    list.add(123)
}

fun testAddLanguage() {
    val languages =
        mutableListOf("Java", "Kotlin")
    // Si esto compilara añadiríamos un integer a una lista de strings
    //addLanguage(languages) // ERROR
    println(languages.maxBy { it.length }) // Esto daria excepción
}


fun main() {
    testPrintContent()
}