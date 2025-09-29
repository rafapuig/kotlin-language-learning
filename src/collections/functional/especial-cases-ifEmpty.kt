package collections

import collections.model.Person
import collections.model.people

fun main() {
    val emptyList = emptyList<Person>()

    val persons = emptyList.ifEmpty { people }
    println(persons)

    val persons2 = persons.ifEmpty {
        emptyList()
    }
    println(persons2)
}