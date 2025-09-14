package poo.construction.secondary

class Person(val name: String, age: Int) {

    var age = age
        private set

    var isAlive = true
        private set

    fun turnYear() {
        age++
    }

    fun kill() {
        isAlive = false
    }

    /**
     * Un constructor secundario debe llamar al constructor primario
     * (o otro secundario que a su vez acabe llamando al primario)
     */
    constructor(name: String, age: Int, isAlive: Boolean) : this(name, age) {
        /**
         * El constructor secundario inicializa propiedades no declaradas
         * en el constructor primario
         */
        this.isAlive = isAlive
    }

}

fun Person.printPersonInfo() {
    println("""
        === Persona ===
        nombre: $name
        edad: $age
        viva: ${if (isAlive) "Si" else "no"}
    """.trimIndent())
}

fun main() {
    val person = Person("Rafa Puig", 48)

    person.printPersonInfo()

    person.turnYear()
    person.kill()

    person.printPersonInfo()

    /**
     * Uso de constructor secundario para crear personas muertas
     */

    val deadPerson = Person("John Lennon", 84, false)
    deadPerson.printPersonInfo()

}