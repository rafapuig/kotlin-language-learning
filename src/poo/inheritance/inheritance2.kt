package poo.inheritance2



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
    val employee = Employee("John", 35, 1900)

    println(employee.name)
    println(employee.age)
    println(employee.salary)

    val person: Person = employee

}

