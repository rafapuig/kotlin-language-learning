package collections

class Book(val title: String, val authors: List<String>)

val library = listOf(
    Book("Kotlin in action", authors = listOf("Isakova","Smith","Aigner")),
    Book("Android Studio Essentials", authors = listOf("Neil","Smith"))
)

/**
 * flatMap
 *
 * primero hace un mapeo
 * y después combina las listas resultantes en una sola lista (aplanamiento)
 */

/**
 * flatten
 *
 * Solamente realiza la combinación de listas
 */

fun flatMapDemo() {
    // Lista de listas de autores
    val authors = library.map { it.authors }
    println(authors)

    // Aplanados a lista de autores
    val allAuthors = library.flatMap { it.authors }
    println(allAuthors)

    val allDifferentAuthors = library.flatMap { it.authors }.toSet()
    println(allDifferentAuthors)

    // aplanar una lista de listas sin mapear / transformar
    val flattened = authors.flatten()
    println(flattened)
}

fun main() {
    flatMapDemo()
}