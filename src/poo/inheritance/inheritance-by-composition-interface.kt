package poo.inheritance

interface Person {
    var name: String
    var age: Int
}

class PersonImpl(override var name: String, override var age: Int) : Person

class Employee(name: String, age: Int, var salary: Int) : Person {

    private val _super: Person = PersonImpl(name, age)

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
    val employee = Employee("John", 35, 1900)

    println(employee.name)
    println(employee.age)
    println(employee.salary)

    val person: Person = employee

}

