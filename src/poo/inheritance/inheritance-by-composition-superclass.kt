package poo.inheritance.composition.superclass

open class Person (open var name: String, open var age: Int)

class Employee(name: String, age: Int, var salary: Int) : Person(name, age) {

    private val _super: Person = Person(name, age)

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
    val employee = Employee("Perico Palotes", 33, 1900)

    with(employee) {
        println(name)
        println(age)
        println(salary)
    }

    val person: Person = employee

}

