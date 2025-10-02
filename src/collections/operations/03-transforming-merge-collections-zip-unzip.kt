package collections.merge

data class Person(val name: String, val age: Int)

fun testZip() {
    val firstNames = listOf("Sandra", "Consuelo", "Victor")
    val lastNames = listOf("Mática", "Teria", "Nado")

    val result = firstNames.zip(lastNames)
    println(result)
}

fun testZipWithTransform() {
    val firstNames = listOf("Sandra", "Consuelo", "Victor")
    val lastNames = listOf("Mática", "Teria", "Nado")

    val result =
        firstNames.zip(lastNames) { firstName, lastName ->
            "$firstName $lastName"
        }
    println(result)
}

fun testZipPersons() {
    val names = listOf("Pedro", "Pablo", "Luis", "Jose")
    val ages = listOf(56, 78, 23, 50)

    val zipped: List<Pair<String, Int>> = names.zip(ages)
    println(zipped)

    val people = names.zip(ages) { name, age ->
        Person(name, age)
    }
    println(people)
}

fun testZipPeople() {
    val firstNames = listOf("Sandra", "Consuelo", "Victor")
    val lastNames = listOf("Mática", "Teria", "Nado")
    val ages = listOf(56, 78, 23, 50) // Una edad de mas, no se utilizará

    val fullNames =
        firstNames.zip(lastNames) { firstName, lastName ->
            "$firstName $lastName"
        }

    val people = fullNames.zip(ages) { fullname, age ->
        Person(fullname, age)
    }
    println(people)
}

/**
 * unzip
 *
 * A partir de una lista de pares : List<Pair<T,S>>
 * Crea dos listas
 * La primera con los primeros elementos T de cada par de la lista original
 * La segunda con los segundos elementos S de cada par de la lista original
 *
 * Devuelve un par
 * El primer elemento del par es la primera lista
 * El segundo elemento del par es la segunda lista
 */

fun testUnzip() {
    val firstNames = listOf("Sandra", "Consuelo", "Victor")
    val lastNames = listOf("Mática", "Teria", "Nado")

    // Creamos una lista de pares
    val zipped = firstNames.zip(lastNames)

    val unzipped = zipped.unzip()
    println(unzipped)
}

fun testUnzipPerson() {
    val names = listOf("Pedro", "Pablo", "Luis", "Jose")
    val ages = listOf(56, 78, 23, 50)

    // Creamos una lista de personas
    val people = names.zip(ages) { name, age ->
        Person(name, age)
    }

    // Creamos la lista de pares
    val zipped = people.map { it.name to it.age }

    val unzipped = zipped.unzip()
    println(unzipped)

    //Volvemos a crear la lista de personas
    val persons = unzipped.first
        .zip(unzipped.second) { name, age ->
            Person(name, age)
        }
    println(persons)
}

fun main() {
    testZip()
    testZipWithTransform()
    testZipPersons()
    testZipPeople()
    testUnzip()
    testUnzipPerson()
}