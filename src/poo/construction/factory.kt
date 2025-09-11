package poo.construction.factory


@ConsistentCopyVisibility
data class Person private constructor(val name: String, val age: Int) {

    companion object {

        fun create(name: String, age: Int): Person {
            if (age < 0) throw IllegalArgumentException()
            return Person(name, age)
        }
    }

}

fun main() {
    val person = Person.create("Perico Palotes", 45)
    println(person)

    //val person2 = Person("Perica Palotes", 45) // No se puede acceder al constructor
}






