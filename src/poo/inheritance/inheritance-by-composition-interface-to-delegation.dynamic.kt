package poo.inheritance.composition.interfaces.dynamic

interface Person {
    var name: String
    var age: Int
}

/**
 * Ahora tenemos dos clases implementadoras de Person: Man y Woman
 */
class Man(override var name: String, override var age: Int) : Person
class Woman(override var name: String, override var age: Int) : Person

/**
 * Lo importante en esta versión es que hemos permitido que en el constructor primario
 * se proporcione (inyecte) la referencia a "la persona que todo empleado lleva dentro"
 * que ahora podrá ser de clase Man o Woman
 * Al declarar var la propiedad _super, estamos permitiendo que los empleados
 * puedan cambiar de sexo (en realidad es cambiar de persona completamente)
 */
class Employee(var _super: Person, var salary: Int) : Person {

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

    val gender: String
        get() = when (_super) {
            is Man -> "hombre"
            is Woman -> "mujer"
            else -> ""
        }

}


fun printEmployeeInfo(manEmployee: Employee) {
    with(manEmployee) {
        println(gender)
        println(name)
        println(age)
        println(salary)
    }
}

fun Employee.printInfo() {
    printEmployeeInfo(this)
}

fun main() {
    val manEmployee = Employee(Man("Perico", 35), 1900)

    manEmployee.printInfo()

    val womanEmployee = Employee(Woman("Perica", 23), 1700)

    womanEmployee.printInfo()

    /**
     * Perico acude al registro civil y se cambia de género a mujer
     * con nuevo nombre Loreto
     */
    manEmployee._super = Woman("Loreto", manEmployee.age)
    manEmployee.printInfo()
}