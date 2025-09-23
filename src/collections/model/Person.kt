package collections.model

enum class Gender { MALE, FEMALE }

data class Person(
    val name: String,
    val age: Int,
    val gender: Gender
)

val people = listOf(
    Person("Aitor Tilla", 24, Gender.MALE),
    Person("Belen Tilla", 31, Gender.FEMALE),
    Person("Marta Baco", 29, Gender.FEMALE),
    Person("Pedro Gado", 17, Gender.MALE),
    Person("Armando Bronca", 31, Gender.FEMALE),
)
