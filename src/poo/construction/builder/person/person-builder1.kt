package poo.construction.builder.person1

// Clase final Person
class Person(
    val name: String,
    val age: Int?,
    val address: Address?,
    val phones: List<String>
) {
    override fun toString(): String {
        return "Person(name=$name, age=$age, address=$address, phones=$phones)"
    }
}

// Sub-clase para la dirección
class Address(
    val street: String,
    val city: String,
    val country: String
) {
    override fun toString(): String {
        return "$street, $city, $country"
    }
}

// Builder para Address
class AddressBuilder {
    var street: String = ""
    var city: String = ""
    var country: String = ""

    fun build(): Address {
        require(street.isNotBlank()) { "Street cannot be empty" }
        require(city.isNotBlank()) { "City cannot be empty" }
        require(country.isNotBlank()) { "Country cannot be empty" }
        return Address(street, city, country)
    }
}

// Builder para Person
class PersonBuilder(private val name: String) {
    var age: Int? = null
    private var address: Address? = null
    private val phones = mutableListOf<String>()

    fun address(block: AddressBuilder.() -> Unit) = apply {
        address = AddressBuilder().apply(block).build()
    }

    fun phone(number: String) = apply { phones.add(number) }

    fun build(): Person {
        return Person(name, age, address, phones)
    }
}

// Función DSL principal
fun person(name: String, block: PersonBuilder.() -> Unit): Person {
    val builder = PersonBuilder(name)
    builder.block()
    return builder.build()
}




fun main() {
    val person1 = person("Perico Palotes") {
        age = 30
        address {
            street = "Calle Colon 56"
            city = "Valencia"
            country = "ES"
        }
        phone("666012456")
        phone("666946572")
    }

    println(person1)
}
