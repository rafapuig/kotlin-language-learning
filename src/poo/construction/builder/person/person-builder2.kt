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
    override fun toString(): String {
        return "Person(name=$name, age=$age, addresses=$addresses, phones=$phones, hobbies=$hobbies, friends=$friends)"
    }
}

// Sub-clase Address
class Address(
    val street: String,
    val city: String,
    val country: String
) {
    override fun toString(): String = "$street, $city, $country"
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

class AddressesBuilder {
    private val _addresses = mutableListOf<Address>()
    val addresses get() = _addresses.toList()

    fun address(block: AddressBuilder.() -> Unit) = apply {
        _addresses.add(AddressBuilder().apply(block).build())
    }
}

class FriendsBuilder {
    private val _friends = mutableListOf<Person>()
    val friends get() = _friends.toList()
    fun friend(block: PersonBuilder.() -> Unit) = apply {
        _friends.add(PersonBuilder("Anonimo").apply(block).build())
    }
}

// Builder para Person
class PersonBuilder(var name: String) {
    var age: Int? = null

    private val addressesBuilder = AddressesBuilder()
    private val phones = mutableListOf<String>()
    private val hobbies = mutableListOf<String>()
    private val friendsBuilder = FriendsBuilder()


    fun addresses(block: AddressesBuilder.() -> Unit) = apply {
        addressesBuilder.apply(block)
    }

    fun phone(number: String) = apply { phones.add(number) }
    fun hobby(name: String) = apply { hobbies.add(name) }

    fun friends(block: FriendsBuilder.() -> Unit) = apply {
        friendsBuilder.apply(block)
    }


    fun build(): Person {
        return Person(name, age, addressesBuilder.addresses, phones.toList(), hobbies.toList(), friendsBuilder.friends)
    }
}

// Función DSL principal
fun person(name: String, block: PersonBuilder.() -> Unit): Person {
    val builder = PersonBuilder(name)
    builder.block()
    return builder.build()
}

fun main() {
    val person1 = person("Alice Johnson") {
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
        phone("555-1111")
        phone("555-2222")
        hobby("Reading")
        hobby("Cycling")
        friends {
            friend {
                name = "Bob Smith"
                age = 30
                phone("555-3333")
                hobby("Gaming")
            }
        }
    }

    println(person1)
}

