package poo.properties

// Las clases tienen visibilidad pública por defecto
public class Person {

    // Los miembros tienen visibilidad pública por defecto
    public var name : String    // Crea un campo de respaldo privado para almacenar el valor y un getter y un setter
    public var age : Int

    // Los constructores son públicos por defecto (este es un constructor secundario)
    public constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    // La palabra clave override es obligatoria para reemplazar un método
    public override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

fun main() {
    // La llamada al constructor se realiza sin usar un operador new
    val p = Person("Rafael", 18)
    println(p.name) // Acceso a la propiedad name (getter)
    println(p.age) // Acceso a la propiedad age (getter)
    println(p)  // Uso implícito del metodo toString

    p.name = "Rafa" // mutar la propiedad name (setter)
    p.age = 48
    println(p)
}


