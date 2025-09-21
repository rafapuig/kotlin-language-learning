package generics.runtime.reified.vs.classparam

import java.util.ServiceLoader

inline fun <reified T> loadService(): ServiceLoader<T> {
    return ServiceLoader.load(T::class.java)
}

// Usando Class<T>
fun <T> findFirstWithClass(items: List<Any>, clazz: Class<T>): T? {
    return items.firstOrNull { clazz.isInstance(it) } as? T
}

// Usando reified
inline fun <reified T> findFirstReified(items: List<Any>): T? {
    return items.firstOrNull { it is T } as? T
}

fun main() {
    val objects: List<Any> = listOf("Hello", 42, 3.14)

    // Con Class<T> hay que pasar la clase explícita
    val number1: Int? = findFirstWithClass(objects, Int::class.java)
    val text1: String? = findFirstWithClass(objects, String::class.java)

    // Con reified, el compilador conserva el tipo, no pasamos nada extra
    val number2: Int? = findFirstReified(objects)
    val text2: String? = findFirstReified(objects)

    println("With Class<T>: number=$number1, text=$text1")
    println("With reified:  number=$number2, text=$text2")
}


