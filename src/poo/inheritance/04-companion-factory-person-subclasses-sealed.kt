package poo.inheritance.companion.factory.sealed

/**
 * El constructor de las clases selladas es protected
 */
sealed class Person protected constructor(val name: String, val gender: Gender) {

    enum class Gender { MALE, FEMALE }

    companion object Factory {

        fun of(name: String, gender: Gender): Person =
            when (gender) {
                Gender.MALE -> createMan(name)
                Gender.FEMALE -> createWoman(name)
            }

        fun createMan(name: String): Person = Man(name)
        fun createWoman(name: String): Person = Woman(name)
    }

    /**
     * Las funciones de las cuales no implementamos su cuerpo
     * deben ser declaradas como abstractas
     */
    abstract fun describe()
}


class Man(name: String) : Person(name, Gender.MALE) {
    override fun describe() = println("$name es un hombre")
}


class Woman(name: String) : Person(name, Gender.FEMALE) {
    override fun describe() = println("$name es una mujer")
}


/**
 * Metodo factoría para crear personas
 */
fun createPerson(name: String, gender: Person.Gender) =
    Person.of(name, gender)


fun main() {

    // Crear personas usando el metodo factoría of del objeto factoría Factory anidado en Person
    val p1 = Person.of("John", Person.Gender.MALE)
    val p2 = Person.Factory.of("Joan", Person.Gender.FEMALE)

    p1.describe()
    p2.describe()

    val p3 = createPerson("Perico Palotes", Person.Gender.MALE)
    p3.describe()
}