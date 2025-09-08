/**
 * data class DTO (POJO)
 * Redefine los métodos equals, hashCode y toString
 */
data class Person constructor(val name: String, val age: Int? = null) {}

fun main() {
    val person = Person("Alice", 29)

    val persons = listOf(
        Person("Alice", age = 29),
        Person("Bob"),
    )

    val oldest = persons.maxBy { it.age ?: 0 }

    println("The oldest is: $oldest")
}