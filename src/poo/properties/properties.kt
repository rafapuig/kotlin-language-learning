package poo.properties

// Las clases son publicas por defecto
public class Person {

    // Los miembros son públicos por defecto
    public var name : String
    public var age : Int

    // Los constructores son públicos por defecto (este es un constructor secundario)
    public constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    public override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

fun main() {
    val p = Person("Rafael", 18)
    println(p.name) // Acceso a la propiedad (getter)
    println(p.age)
    println(p)
    p.name = "Rafa" // mutar la propiedad (setter)
    p.age = 48
    println(p)
}


