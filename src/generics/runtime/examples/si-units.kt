package generics.runtime.examples

inline val <reified T : Number> T.m: T get() = to()
inline val <reified T : Number> T.km: T get() = (toDouble() * 1000).to<T>()
inline val <reified T : Number> T.cm: T get() = (toDouble() / 100).to<T>()
inline val <reified T : Number> T.mm: T get() = (toDouble() / 1000).to<T>()


inline fun <reified T : Number> Number.to(): T =
    when (T::class) {
        Byte::class -> this.toByte() as T
        Short::class -> this.toShort() as T
        Int::class -> this.toInt() as T
        Long::class -> this.toLong() as T
        Float::class -> this.toFloat() as T
        Double::class -> this.toDouble() as T
        else -> throw IllegalArgumentException("Tipo no soportado: ${T::class}")
    }

fun main() {
    val length1 = 100.m
    val length2 = 1000L.cm
    val length3 = 10.5f.km
    val length4 = 1.2.km
    val length5 = 1_246_000.mm

    println(length1)
    println(length2)
    println(length3)
    println(length4)
    println(length5)
}
