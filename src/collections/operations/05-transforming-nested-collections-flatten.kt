package collections.operations.transforming.flatten




/**
 * Cuando trabajamos con colecciones de colecciones
 * también llamadas colecciones anidadas
 * - flatten
 * - flatMap
 *
 * Permiten aplanar la jerarquía y pasar de una lista de listas
 * a una lista que combina todos los elementos de cada lista anidada
 */

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

fun testFlatten() {
    val europeanCountries = listOf("España", "Rusia", "Alemania")
    val americanCountries = listOf("EE.UU.", "Canadá", "Brasil", "Argentina")
    val asianCountries = listOf("Japón", "Corea", "China")

    val listOfListOfCountries = listOf(
        europeanCountries,
        americanCountries,
        asianCountries
    )
    println(listOfListOfCountries)
    println(listOfListOfCountries.flatten())
}

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

    println(listOfListOfCountriesStartingWithC.flatten()) // Lista nombres que empiezan por C

    // Obtener una lista de países que empiezan por C
    val countriesStartingWithC =
        listOfListOfCountries
            .map { list ->  list.filter { it.startsWith("C") } }
            .flatten()

    println(countriesStartingWithC)


    // Si utilizamos la operación flatMap se hace el mapeo y a continuación el aplanado
    val countriesStartingWithC2 =
        listOfListOfCountries
            .flatMap { list ->  list.filter { it.startsWith("C") } }

    println(countriesStartingWithC2)
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
    testFlatten()
    testFlatMap()
    flatMapDemo()
}