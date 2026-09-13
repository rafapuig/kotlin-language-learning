package poo.construction.builder.person2

// Clase final Person
class Person(
    val name: String,
    val age: Int?,
    val addresses: List<Address>,
    val phones: List<String>,
    val hobbies: List<String>,
    val friends: List<Person>
) {
    override fun toString() =
        "Person(name=$name, age=$age, addresses=$addresses, phones=$phones, hobbies=$hobbies, friends=$friends)"

}

// Sub-clase Address
class Address(
    val street: String,
    val city: String,
    val country: String
) {
    override fun toString() = "$street, $city, $country"
}

// Builder para Address
class AddressBuilder {
    var street: String = ""
    var city: String = ""
    var country: String = ""

    fun build(): Address {
        require(street.isNotBlank()) { "Street no puede estar vacío" }
        require(city.isNotBlank()) { "City no puede estar vacío" }
        require(country.isNotBlank()) { "Country no puede estar vacío" }
        return Address(street, city, country)
    }
}

/**
 * Ahora vamos a tener varias direcciones
 */
class AddressesBuilder {

    private val _addresses = mutableListOf<Address>()
    val addresses get() = _addresses.toList()

    fun address(block: AddressBuilder.() -> Unit) = apply {
        val address = AddressBuilder().apply(block).build()
        _addresses.add(address)
    }
}

class FriendsBuilder {

    private val _friends = mutableListOf<Person>()
    val friends get() = _friends.toList()

    fun friend(block: PersonBuilder.() -> Unit) = apply {
        _friends.add(PersonBuilder("Anónimo").apply(block).build())
    }
}

// Builder para Person
class PersonBuilder(var name: String) {

    var age: Int? = null

    private val phones = mutableListOf<String>()
    private val hobbies = mutableListOf<String>()

    private val addressesBuilder = AddressesBuilder()
    private val friendsBuilder = FriendsBuilder()


    fun phone(number: String) = apply { phones.add(number) }
    fun hobby(name: String) = apply { hobbies.add(name) }


    fun addresses(block: AddressesBuilder.() -> Unit) = apply {
        addressesBuilder.apply(block)
    }

    fun friends(block: FriendsBuilder.() -> Unit) = apply {
        friendsBuilder.apply(block)
    }

    fun build() =
        Person(name, age, addressesBuilder.addresses, phones.toList(), hobbies.toList(), friendsBuilder.friends)
}

// Función DSL principal
fun person(name: String, block: PersonBuilder.() -> Unit): Person {
    val builder = PersonBuilder(name)
    builder.block()
    return builder.build()
}

fun main() {
    val person = person("Armando Bronca Segura") {
        age = 28
        addresses {
            address {
                street = "123 Main Street"
                city = "New York"
                country = "USA"
            }
            address {
                street = "456 Elm Street"
                city = "Boston"
                country = "USA"
            }
        }
        phone("678123456")
        phone("788111444")
        hobby("Lectura")
        hobby("Ciclismo")
        friends {
            friend {
                name = "Dolores Fuertes Garriga"
                age = 30
                phone("676909565")
                hobby("Videojuegos")
            }
        }
    }

    println(person)
}

