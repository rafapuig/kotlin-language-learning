package poo.inheritance.composition.interfaces.dynamic

interface Person {
    var name: String
    var age: Int
}

class Man(override var name: String, override var age: Int) : Person
class Woman(override var name: String, override var age: Int): Person

class Employee(person: Person, var salary: Int) : Person {

    private val _super: Person = person

    override var name
        get() = _super.name
        set(value) {
            _super.name = value
        }

    override var age
        get() = _super.age
        set(value) {
            _super.age = value
        }

}

fun main() {
    val manEmployee = Employee(Man("Perico", 35), 1900)

    println(manEmployee.name)
    println(manEmployee.age)
    println(manEmployee.salary)

    val womanEmployee = Employee(Woman("Perica", 23), 1700)

    val person: Person = manEmployee

}

