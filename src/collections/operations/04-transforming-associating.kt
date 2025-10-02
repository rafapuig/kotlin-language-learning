package collections.operations.associating

/**
 * Si queremos crear un mapa a partir de los elementos de una colección
 * SIN agrupar los elementos
 */

/**
 * associate
 *
 * Recibe un objeto tipo función como argumento (si es literal será una lambda)
 * que expresa la transformación de un elemento de la colección
 * en un par clave-valor y añadirá dicho par como entrada al mapa resultado
 */

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Jose", 29),
    Person("Maria", 18),
    Person("Juan", 29),)


fun testAssociate() {
    val nameToAgeMap = people.associate { it.name to it.age }

    nameToAgeMap.forEach { (name, age) ->
        println("Clave = $name \t: Valor = $age")
    }
}

/**
 * Si lo que queremos es crear una asociación entre los elementos
 * de la colección y un determinado valor:
 *
 * - associateWith (elementos de la colección -> claves) valores via lambda
 * - associateBy (elementos de la colección -> valores) claves via lambda
 *
 */

fun testAssociateWith() {
    // Crea un mapa cuyas claves son personas y valor asociado su edad
    val personToAgeMap = people.associateWith { it.age }
    println(personToAgeMap)
}

fun testAssociateBy() {
    // Crea un mapa cuyas claves son enteros (edad) y valor asociado una Persona
    // (en este caso la última persona de la lista con esa edad)
    val ageToPersonMap = people.associateBy { it.age }

    // Juan tiene la misma edad 29 que Jose
    // Como la edad es el valor para las claves del mapa
    // la entrada del mapa con clave: 29 y valor asociado "Jose"
    // se reemplaza por la entrada con clave:29 y valor "Juan"
    println(ageToPersonMap)
}

/**
 * IMPORTANTE:
 * Tener en cuenta que las claves de un mapa deben ser únicas
 * Si la función de transformación proporcionada a las operaciones associate,
 * associateWith o associateBy da como resultado la misma clave más de una
 * vez, la más clave reciente reemplaza a la entrada con esa misma clave en el mapa
 */

fun exampleAssociate() {
    data class FullName (val firstName: String, val lastName: String)

    fun parseFullName(fullName: String): FullName {
        val nameParts = fullName.split(" ")
        if (nameParts.size == 2) {
            return FullName(nameParts[0], nameParts[1])
        } else throw Exception("Wrong name format")
    }

    val names = listOf("Belen Tilla", "Victor Nado", "Pedro Gado")

    val lastNameToFirstName = names.associate { name ->
        parseFullName(name).let { it.lastName to it.firstName }
    }

    println(lastNameToFirstName)
}


fun main() {
    testAssociate()
    testAssociateWith()
    testAssociateBy()
    exampleAssociate()
}
