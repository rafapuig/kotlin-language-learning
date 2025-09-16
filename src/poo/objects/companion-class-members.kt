package poo.objects.members

class Person(val name: String) {

    init {
        population++
    }

    companion object {
        var population = 0
            private set
    }
}

fun printNumPeople() {
    println("Número de personas: ${Person.population}")
}

fun main() {

    printNumPeople()

    val rafa = Person("Rafa")
    printNumPeople()

    val ramon = Person("Ramón")
    printNumPeople()

    // Obtener una referencia al objeto companion
    val ref = Person.Companion

    println(ref.population)

}

