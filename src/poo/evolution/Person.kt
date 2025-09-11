package poo

data class Person(val name: String, val age: Int) {

    fun greet(): Unit {
        println("Hola, me llamo $name y tengo $age años")
    }

}

fun main() {
    val armando = Person("Armando Bronca", 28)
    val belen = Person("Belen Tilla", 25)

    armando.greet()
    belen.greet()
}
