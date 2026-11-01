package containers.collections.operations.transforming.flatten

/**
 * Cuando trabajamos con colecciones de colecciones
 * también llamadas colecciones anidadas
 * - flatten
 * - flatMap
 * - FlatMapIndexed
 *
 * Permiten aplanar la jerarquía y pasar de una lista de listas
 * a una lista que combina todos los elementos de cada lista anidada
 */


/**
 * flatten
 *
 * Solamente realiza la combinación de listas
 */

fun testFlatten() {
    val europeanCountries = listOf("España", "Rusia", "Alemania")
    val americanCountries = listOf("EE.UU.", "Canadá", "Brasil", "Argentina")
    val asianCountries = listOf("Japón", "Corea", "China")

    // Creamos una lista de listas
    val listOfListOfCountries = listOf(
        europeanCountries,
        americanCountries,
        asianCountries
    )
    // Imprimimos la lista de listas
    println(listOfListOfCountries)

    // Y ahora la lista aplanada (cada elemento de cada lista ha ido a una única y misma colección)
    println(listOfListOfCountries.flatten())
}


/**
 * flatMap
 *
 * primero hace un mapeo
 * y después combina las listas resultantes en una sola lista (aplanamiento)
 */

fun testFlatMap() {
    val europeanCountries = listOf("España", "Rusia", "Alemania")
    val americanCountries = listOf("EE.UU.", "Canadá", "Brasil", "Argentina")
    val asianCountries = listOf("Japón", "Corea", "China")

    val listOfListOfCountries = listOf(
        europeanCountries,
        americanCountries,
        asianCountries
    )

    // Obtenemos una lista de listas de países que empiezan por C
    val listOfListOfCountriesStartingWithC =
        listOfListOfCountries.map { list -> // de cada lista
            list.filter { it.startsWith("C") } // la trasformamos en una lista con solo los que empiezan por C
        }
    println(listOfListOfCountriesStartingWithC) // Lista de listas de nombres que empiezan por C

    // Lista nombres que empiezan por C
    val listOfCountriesStartingWithC = listOfListOfCountriesStartingWithC.flatten()
    println(listOfCountriesStartingWithC)

    // Obtener una lista de países que empiezan por C
    val countriesStartingWithC =
        listOfListOfCountries
            .map { list -> list.filter { it.startsWith("C") } }
            .flatten()

    println(countriesStartingWithC)


    // Si utilizamos la operación flatMap se hace el mapeo y a continuación el aplanado
    val countriesStartingWithC2 =
        listOfListOfCountries
            .flatMap { list -> list.filter { it.startsWith("C") } }

    println(countriesStartingWithC2)
}


fun testFlatMapIndexed() {
    val continentToCountries = listOf(
        "Europa" to listOf("España", "Rusia", "Alemania"),
        "America" to listOf("EE.UU.", "Canadá", "Brasil", "Argentina"),
        "Asia" to listOf("Japón", "Corea", "China")
    )

    val countries: List<String> =
        continentToCountries.flatMapIndexed { index, pair ->
            pair.second.map { country -> "$index - $country" }
        }

    println(countries)
}


/**
 * Demo de uso de flatMap
 */

class Book(val title: String, val authors: List<String>)

val library = listOf(
    Book("Kotlin in action", authors = listOf("Isakova", "Smith", "Aigner")),
    Book("Android Studio Essentials", authors = listOf("Neil", "Smith"))
)

fun flatMapDemo() {
    // Lista de listas de autores
    val authors = library.map { it.authors }
    println(authors)

    // Aplanados a lista de autores en dosp pasos
    val allAuthors = library.map { it.authors }.flatten()
    println(allAuthors)

    // De lista de libros a lista de autores aplanada con flatMap()
    val allAuthors2 = library.flatMap { it.authors }


    // Solamente autores diferentes, no repetidos (Smith) con toSet
    val allDifferentAuthors = library.flatMap { it.authors }.toSet()
    println(allDifferentAuthors)

    // aplanar una lista de listas sin mapear / transformar
    val flattened = authors.flatten()
    println(flattened)
}


fun main() {
    testFlatten()
    testFlatMap()
    testFlatMapIndexed()
    flatMapDemo()
}