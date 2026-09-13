package poo.construction.builder.person1

// Clase final Person
class Person(
    val name: String,
    val age: Int?,
    val address: Address?,
    val phones: List<String>
) {
    override fun toString() =
        "Person(name=$name, age=$age, address=$address, phones=$phones)"

}

// Sub-clase para la dirección
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

// Builder para Person
class PersonBuilder(
    private val name: String // Valor obligatorio proporcionar al builder
) {
    var age: Int? = null
    private var address: Address? = null
    private val phones = mutableListOf<String>()

    fun address(block: AddressBuilder.() -> Unit) = apply {
        address = AddressBuilder().apply(block).build()
    }

    fun phone(number: String) = apply { phones.add(number) }

    fun build() = Person(name, age, address, phones)

}

// Función DSL principal
fun person(name: String, block: PersonBuilder.() -> Unit): Person {
    // Creamos un objeto PersonBuilder
    // para ello proporcionamos el argumento obligatorio del constructor, el nombre
    // a partir del nombre recibido como parámetro de entrada
    val builder = PersonBuilder(name)

    // Ahora podemos usar el objeto PersonBuilder como receptor de la llamada al objeto función block
    // (El objeto función block recibido como parámetro es una función con receptor de tipo PersonBuilder)
    builder.block()

    // Por último, devolvemos el producto fabricado tras llamar al metodo build del builder
    return builder.build()
}


fun main() {

    val person = person("Perico Palotes") {
        age = 30
        address {
            street = "Calle Colon 56"
            city = "Valencia"
            country = "ES"
        }
        phone("666012456")
        phone("666946572")
    }

    println(person)
}
