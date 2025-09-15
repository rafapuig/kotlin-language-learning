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

class Employee(var person: Person) : Person by person {

    fun printInfo() {
        println(person.javaClass.simpleName)
    }

}

fun main() {
    val man = Man("Jose")
    val woman = Woman("Maria")

    val employee = Employee(man)
    println(employee.name)
    employee.printInfo()
    employee.printGender()


    val womanEmployee = Employee(woman)

    womanEmployee.printInfo()
    womanEmployee.printGender()

    womanEmployee.person = man

    womanEmployee.printInfo()
    womanEmployee.printGender()
}