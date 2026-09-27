package generics.runtime.reified.accesors

inline val <reified T> T.canonical: String get() = T::class.java.canonicalName

fun main() {
    println(listOf(1, 2, 3, 4, 5).canonical)
    println(5.canonical)
    println("Hello".canonical)
}