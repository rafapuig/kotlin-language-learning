package poo.objects.members

class Person(val name: String) {

    init {
        count++
    }

    companion object {
        var count = 0
            private set
    }
}

fun printNumPeople() {
    println("Número de personas: ${Person.count}")
}

fun main() {

    printNumPeople()

    val rafa = Person("Rafa")
    printNumPeople()

    val ramon = Person("Ramón")
    printNumPeople()

    // Obtener una referencia al objeto companion
    val ref = Person.Companion

    println(ref.count)

}

