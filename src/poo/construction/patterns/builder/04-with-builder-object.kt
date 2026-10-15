package poo.construction.builder4


@ConsistentCopyVisibility
data class Person private constructor(
    val name: String = DEFAULT_NAME,
    val age: Int = DEFAULT_AGE,
    val married: Boolean = DEFAULT_MARRIED
) {

    companion object {
        const val DEFAULT_NAME = "Anónimo"
        const val DEFAULT_AGE = 18
        const val DEFAULT_MARRIED = false
    }

    // Clase anidada Builder
    class Builder {
        var name = DEFAULT_NAME
        var age = DEFAULT_AGE
        var married = DEFAULT_MARRIED

        // apply devuelve this, es decir, la referencia al builder
        fun withName(name: String) = apply { this.name = name }
        fun withAge(age: Int) = apply { this.age = age }
        fun married() = apply { this.married = true }

        // Metodo que fabrica el objeto producto Person, a partir de los datos recabados
        fun build() = Person(name = name, age = age, married = married)
    }
}



fun main() {

    val belen = Person.Builder()
        .withName("Belen Tilla")
        .withAge(29)
        .married()
        .build()

    val anonimoAged60 = Person.Builder().withAge(60).build()

    println(belen)
    println(anonimoAged60)
}