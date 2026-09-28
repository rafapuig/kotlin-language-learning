package imperative.types.primitive

/**
 * Los tipos anulables NO se pueden representar mediante un tipo primitivo de Java.
 * Porque el valor null solo se puede almacenar en una variable de tipo por referencia en Java.
 *
 * Cuando se usa la version anulable de un tipo primitivo en Kotlin, se compila al tipo envoltorio correspondiente.
 */

data class Person(
    val name: String,
    val age: Int? = null // La propiedad age se almacena como java.lang.Integer (wrapper), solo importa si se usa Java
)

fun Person.isOlderThan(other: Person): Boolean? {
    if (age == null) return null
    if (other.age == null) return null
    // No podemos comparar directamente dos valores de tipo Int? porque podrían ser null
    // Primero tenemos que comprobar y descartar que sean null
    // El compilador sabe que si llegamos a esta instrucción tanto age como other.age no son null
    // y los trata como valores de tipo no anulable
    return age > other.age
}

fun main() {
    val person = Person("Rafa", 28)
    println(person.isOlderThan(Person("Emilio", 29)))
    println(person.isOlderThan(Person("Ramon"))) // No indicamos la edad de Ramon
}