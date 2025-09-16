package poo.objects.companion.factory.sealed



sealed class Person(val name: String, val gender: Gender) {

    enum class Gender {
        MALE, FEMALE
    }

    companion object Factory {
        fun create(name: String, gender: Gender): Person {
            return when (gender) {
                Gender.MALE -> Man(name)
                Gender.FEMALE -> Woman(name)
            }
        }

        fun createMan(name: String): Person = Man(name)
        fun createWoman(name: String): Person = Woman(name)
    }

    open fun describe() {}
}

fun createPerson(name: String, gender: Person.Gender) =
    Person.create(name, gender)



private class Man(name: String) : Person(name, Gender.MALE) {
    override fun describe() {
        println("$name es un hombre")
    }
}

private class Woman(name: String) : Person(name, Gender.FEMALE) {
    override fun describe() {
        println("$name es una mujer")
    }
}

fun main() {

    //val person = Person("Rafa", Person.Gender.FEMALE)
    val p1 = Person.create("John", Person.Gender.MALE)
    val p2 = Person.create("Joan", Person.Gender.FEMALE)

    p1.describe()
    p2.describe()

    val p3 = createPerson("Perico Palotes", Person.Gender.MALE)
}