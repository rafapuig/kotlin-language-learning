package poo.construction.builder4


@ConsistentCopyVisibility
data class Person private constructor(
    val name: String = DEFAULT_NAME,
    val age: Int = DEFAULT_AGE,
    val married: Boolean = DEFAULT_MARRIED
) {

    companion object {
        const val DEFAULT_NAME = "Anonimo"
        const val DEFAULT_AGE = 18
        const val DEFAULT_MARRIED = false
    }

    class Builder {
        var name = DEFAULT_NAME
        var age = DEFAULT_AGE
        var married = DEFAULT_MARRIED

        // apply devuelve this
        fun name(name: String) = apply { this.name = name }
        fun age(age: Int) = apply { this.age = age }
        fun married(married: Boolean) = apply { this.married = married }

        fun build() = Person(name = name, age = age, married = married)
    }
}



fun main() {
    //val person = Person(name = "Rafa Puig", age = 48)

    /*val perico = Person(
        name = "Perico Palotes",
        age = 35,
        married = true
    )*/

    /*val armando = Person().apply {
        name = "Armando"
        age = 45
        married = true
    }*/

    val belen = Person.Builder()
        .name("Belen Tilla")
        .age(19)
        .married(true)
        .build()

    val anonimoAged60 = Person.Builder().age(60).build()

}