package imperative.types.nullability.platform

fun yellAt(person: Person) {
    // Al acceder a la propiedad name de la persona, Kotlin no sabe si String es anulable o no
    // lo considera de tipo String! (tipo plataforma)
    val personName = person.name

    // Podemos usarlo de manera directa, sin el operador seguro de llamada ?.
    // El compilador de Kotlin nos da libertad de uso
    // Pero si no comprobamos y puede ser nulo entonces nos exponemos a una NullPointerException
    println(personName.uppercase() + "!!!")
}

fun yellAtSafe(person: Person) {
    println("${person.name?.uppercase() ?: "TU"} !!!")
}

fun platformTypes() {
    val person = Person("Perico")

    // Todas estas declaraciones son válidas
    val pName = person.name
    val nnName : String = person.name
    val nName : String? = person.name


    // Aqui al ser no anulable, llamada directa sin comprobar (riesgo de null pointer)
    println(nnName.lowercase())

    // Aqui al ser anulable el compilador obliga a comprobación o llamada segura
    println(nName?.uppercase())

    // Tipo plataforma, libertad total ambas formas le parecen correctas al compilador
    println(pName.uppercase())
    println(pName?.lowercase())

}


fun main() {

    yellAt(Person("Perico"))

    try {
        yellAt(Person(null))
    } catch (e: NullPointerException) {
        println(e.message)
    }

    yellAtSafe(Person("perica"))
    yellAtSafe(Person(null))

}