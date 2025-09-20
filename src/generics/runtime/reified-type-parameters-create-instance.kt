package generics.runtime.reified.create.instance

inline fun <reified T : Any> createInstance(): T {
    return T::class.java.getDeclaredConstructor().newInstance()
}

class Person(val name: String = "Anonimo")

fun main() {
    val person = createInstance<Person>()
    println(person.name) // Anónimo
}
