package generics

class Box<T : Any>(private val value: T) {
    fun get(): T = value
    fun describe(): String = "La caja contiene: $value"
}

class NullableBox<T : Any?>(private val value: T) {
    fun get(): T = value
    fun isNull() = value == null
    fun describe(): String = if (value == null) "La caja contiene: $value" else "Esta vacia"
}

fun main() {
    val stringBox = Box("Kotlin")
    println(stringBox.get().uppercase())

    //val StringBoxWithNull = Box<String>(null) // ERROR
    //val nullableStringBox = Box<String?>(null) //ERROR

    val nullableStringNullableBox = NullableBox<String?>("Java")
    println(nullableStringNullableBox.get()?.uppercase())
    val nullStringNullableBox = NullableBox<String?>(null)
    println(nullStringNullableBox.get()?.uppercase())
}