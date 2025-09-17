package poo.construction.factory


@ConsistentCopyVisibility
data class Person private constructor(val name: String, val age: Int) {

    companion object Factory {

        fun create(name: String, age: Int): Person {
            if (age < 0) throw IllegalArgumentException()
            return Person(name, age)
        }
    }

}

/**
 * Podemos crear una función top-level que llame al método factoría del companion object
 */
fun person(name: String, age: Int) = Person.Factory.create(name, age)


fun main() {
    val person = Person.create("Perico Palotes", 45)
    println(person)

    val factory = Person.Factory
    val otherPerson = factory.create("Armando Bronca", 56)

    val another = Person.Factory.create("Esther Malgin", 26)

    val other = person("Rafa Puig", 48)

    //val person2 = Person("Perica Palotes", 45) // No se puede acceder al constructor
}






