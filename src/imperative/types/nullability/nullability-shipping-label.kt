package imperative.types.nullability

data class Address(val street: String, val postalCode: Int, val city: String, val country: String)

data class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun printShippingLabel(person: Person) {
    /**
     * throw es una expresión y la podemos usar como valor alternativo en el operador Elvis si el operador
     * de la izquierda resulta ser el valor null
     * La variable Address ya no es de tipo anulable Address? Address (no anulable)
     */
    val address = person.company?.address ?: throw IllegalArgumentException("Sin dirección")
    with(address) {
        println(street)
        println("$postalCode $city, $country")
    }
}

fun main() {
    val address = Address("Calle Alberique 18", 46008, "Valencia", "España")
    val company = Company("IES Abastos", address)
    val person = Person("Rafa Puig", company)
    printShippingLabel(person)
    try {
        printShippingLabel(Person("Perico Palotes", null))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}