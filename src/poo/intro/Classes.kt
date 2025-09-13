package poo.intro

fun main() {
    val person = Person1("John", isStudent = true)
    println(person.name)
    println(person.isStudent)
    person.isStudent = false
    println(person.isStudent)
}