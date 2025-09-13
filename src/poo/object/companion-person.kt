package `object`.`companion`

open class Person private constructor (val name: String, val gender: Gender) {

    enum class Gender {
        MALE, FEMALE
    }

    companion object {
        fun createPerson(name: String, gender: Gender): Person {
            return when (gender) {
                Gender.MALE -> Man(name)
                Gender.FEMALE -> Woman(name)
            }
        }
    }

    open fun describe() {}

    private class Man (name: String) : Person(name, Gender.MALE) {
        override fun describe() {
            println("$name is a Man")
        }
    }

    private class Woman (name: String) : Person(name, Gender.FEMALE) {
        override fun describe() {
            println("$name is a Woman")
        }
    }
}

fun main() {

    //val person = Person("Rafa", Person.Gender.FEMALE)
    val p1 = Person.createPerson("John", Person.Gender.MALE)
    val p2 = Person.createPerson("Joan", Person.Gender.FEMALE)

    p1.describe()
    p2.describe()
}