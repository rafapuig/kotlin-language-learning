/**
 * data class DTO (POJO)
 * Redefine los métodos equals, hashCode y toString
 */
data class Person (val name: String, val age: Int? = null) {}


fun main() {

    val person = Person("Alicia", 29)
    println(person)

    val persons = listOf(
        Person("Alicia", age = 29),
        Person("Roberto"),
        Person(name ="Rafa", age = 49),
        Person(age = 33, name ="Perico")
    )

    val oldest = persons.maxBy { it.age ?: Int.MIN_VALUE }

    println("La persona de más edad es: $oldest")
}