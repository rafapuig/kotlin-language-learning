package poo.delegation

interface Person {
    val name: String

    fun printGender()

}

class Man(override val name: String) : Person {
    override fun printGender() {
        println("MALE")
    }
}

class Woman(override val name: String) : Person {
    override fun printGender() {
        println("FEMALE")
    }
}

/**
 * Aunque se delega en la propiedad person
 * Cuando cambia la referencia a otro objeto implementador de Person
 * no afecta al objeto en el que se ha delegado al inicio
 */
class Programmer(var person: Person) : Person by person {

    fun printInfo() {
        println(person.javaClass.simpleName)
    }

}

fun main() {
    val man = Man("Jose")
    val woman = Woman("Maria")

    val manProgrammer = Programmer(man)
    println(manProgrammer.name)
    manProgrammer.printInfo()
    manProgrammer.printGender()


    val womanProgrammer = Programmer(woman)

    womanProgrammer.printInfo()
    womanProgrammer.printGender()

    womanProgrammer.person = man

    womanProgrammer.printInfo()
    womanProgrammer.printGender()
}