package generics

// Interfaz genérica común
interface RecordField<T> {
    fun getValue(): T
    fun describe(): String
}

// Campo obligatorio (no nullable)
class MandatoryField<T : Any>(private val value: T) : RecordField<T> {
    override fun getValue(): T = value
    override fun describe(): String = "Mandatory field: $value"
}

// Campo opcional (nullable)
class OptionalField<T : Any?>(private val value: T) : RecordField<T> {
    override fun getValue(): T = value
    fun isNull(): Boolean = value == null
    override fun describe(): String =
        if (value == null) "Optional field is empty" else "Optional field: $value"
}

// Ejemplo de registro de usuario
data class UserRecord(
    val id: RecordField<Int>,          // obligatorio
    val name: RecordField<String>,     // obligatorio
    val nickname: OptionalField<String?>, // opcional
    val age: OptionalField<Int?> //opcional
)

fun main() {
    val user1 = UserRecord(
        id = MandatoryField(1),
        name = MandatoryField("Rafael"),
        nickname = OptionalField("Rafa"),
        age = OptionalField<Int?>(48)
    )

    val user2 = UserRecord(
        id = MandatoryField(2),
        name = MandatoryField("Perica"),
        nickname = OptionalField(null),
        age = OptionalField<Int?>(null)
    )

    // Mostrar información
    listOf(user1, user2).forEach { user ->
        println(user.id.describe())
        println(user.name.describe())
        println(user.nickname.describe())
        println(user.age.describe())
        println()
    }

    // Uso seguro del campo nullable
    val nick = user2.nickname.getValue() ?: "No nickname"
    println("User2's nickname: $nick")
}
