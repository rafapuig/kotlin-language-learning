package containers.collections

import containers.collections.model.Person
import containers.collections.model.people

fun main() {
    val emptyList = emptyList<Person>()

    val persons = emptyList.ifEmpty { people }
    println(persons)

    val persons2 = persons.ifEmpty {
        emptyList()
    }
    println(persons2)
}