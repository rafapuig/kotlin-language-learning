package poo.intro.properties2

import poo.intro.Person1

/**
 * En Kotlin una propiedad es la combinación de lo que equivaldría en Java a:
 * - un campo de respaldo (backing field)
 * - más el accesor (getter) y el mutador (setter)
 *
 * val en la declaración del parámetro crea una propiedad de solo lectura (getter)
 * el uso de var crea una propiedad de lectura/escritura (getter + setter)
 */

class Person(
    val name: String, // Propiedad de solo lectura (campo y getter)
    var isStudent: Boolean // Propiedad mutable (campo más getter y setter)
)

fun main() {
    val person = Person("Perico Palotes", isStudent = true)
    println(person.name)
    println(person.isStudent)
    person.isStudent = false
    println(person.isStudent)
}