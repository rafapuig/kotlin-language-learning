package poo.intro


/**
 * En Kotlin una propiedad es la combinación de lo que equivaldría en Java a:
 * - un campo de respaldo (backing field)
 * - más el accesor (getter) y el mutador (setter)
 *
 * val en la declaración del parámetro crea una propiedad de solo lectura (getter)
 * el uso de var crea una propiedad de lectura/escritura (getter + setter)
 */

class Person(val name: String)


class Person1(
    val name: String, // Propiedad de solo lectura (campo y getter)
    var isStudent: Boolean // Propiedad mutable (campo más getter y setter)
)

class Person0 {
    var name: String = ""
    var age: Int = 0
}

class Person2 {
    var name: String = ""
    var age: Int = 0

    constructor(name: String, age:Int) {
        this.name = name
        this.age = age
    }
}

fun main() {
    val person = Person1("John", isStudent = true)
    println(person.name)
    println(person.isStudent)
    person.isStudent = false
    println(person.isStudent)
}