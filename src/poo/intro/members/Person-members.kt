package poo.intro.members

// Las clases tienen visibilidad pública por defecto (por eso se indica public en gris)
public class Person {

    // Los miembros (propiedades y métodos) tienen visibilidad pública por defecto (por eso en gris)

    // En Kotlin se declaran propiedades (en lugar de campos privados con getter y setter)
    public var name : String    // Crea un campo de respaldo privado para almacenar el valor y un getter y un setter
    public var age : Int        // Crea un campo de respaldo privado para almacenar el valor y un getter y un setter
    public var isEmployed : Boolean = false

    // Los constructores son públicos por defecto (este es un constructor secundario)
    public constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    // Metodo de instancia
    public fun turnOneYearOlder() {
        this.age++
    }

    // La palabra clave override es obligatoria para reemplazar un método
    public override fun toString(): String {
        return "Person(name='$name', age=$age, isEmployed=$isEmployed)"
    }
}

fun main() {

    // La llamada al constructor se realiza sin usar un operador new
    val p = Person("Rafael", 18)

    println(p.name) // Acceso a la propiedad name (getter)
    println(p.age) // Acceso a la propiedad age (getter)
    println(p.toString()) // Uso explicito del metodo toString reemplazado en la clase Person

    p.name = "Rafa" // mutar la propiedad name (setter)
    p.age = 48
    p.isEmployed = true
    println(p) // Uso implícito del metodo toString

    // Llamar al metodo de instancia turnOneYearOlder
    p.turnOneYearOlder()
    println(p)
}


