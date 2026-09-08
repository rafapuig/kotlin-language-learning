package poo.person9

class Person(val name: String = "Anonimo", val age: Int? = null)

fun main() {
    val person = Person()
    val armando = Person("Armando")
    val belen = Person("Belen", 57)

    // Si usamos los argumentos nombrados podemos pasar argumentos únicamente a las propiedades
    // que queremos proporcionar un valor explícitamente
    // y omitir argumentos para los parámetros para los cuales queremos se que use su valor por defecto
    val anonymous34 = Person(age = 34)

    println(person.name)
    println(person.age)

    println(armando.name)
    println(armando.age)

    println(belen.name)
    println(belen.age)

    println(anonymous34.name)
    println(person.age)
}