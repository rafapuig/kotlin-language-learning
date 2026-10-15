package poo.inheritance.sealed

/**
 * Cuando una clase está sellada, implícitamente está abierta a la extension
 * (no es necesario usar open)
 *
 * El constructor de la clase sellada es protected por defecto, no puede ser public
 */
sealed class Person protected constructor(val name: String)


/**
 * Las clases Man y Woman pueden llamar al constructor de Person porque hereda de ella
 */
class Man(name: String) : Person(name)
class Woman(name: String) : Person(name)


fun processPerson(person: Person) {
    when (person) {
        is Man -> println("${person.name} es un hombre")
        is Woman -> println("${person.name} es una mujer")
    }
}

fun main() {
    val man = Man("Pepe")
    val woman = Woman("Pepa")

    processPerson(man)
    processPerson(woman)

    /**
     * Como el constructor es protected no se puede crear objetos directamente de la clase sellada Person
     */
    //val person = Person("X") // ERROR
}