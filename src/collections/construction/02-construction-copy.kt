package collections.construction.copy

/**
 * Podemos crear una lista con los mismos elementos de otra
 * Es decir, una copia superficial (shallow)
 * Que sea superficial significa que si un elemento de la lista
 * es mutable y cambia su estado, se refleja en todas las copias
 *
 * Estas funciones de copia son:
 *
 * toList, toSet, toMutableList, toMutableSet, etc
 */

data class Person(var name: String, var age: Int)

val adam = Person("Adan", 28)
val eva = Person("Eva", 27)
val peter = Person("Perico", 28)

val sourceList = listOf(adam, eva)

fun testCopyList() {
    val copyList = sourceList.toMutableList()
    copyList.add(peter)
    adam.age++
    println(sourceList)
    println(copyList)


}

fun testCopyToSet() {
    val copySet =
        sourceList.toMutableSet().apply { remove(peter) }.toSet()

    println(copySet)
}

fun testCopyMap() {
    val countryCapitalMap = mapOf(
        "España" to "Madrid",
        "Francia" to "Paris"
    )
    // Crear una lista de Parejas (con las entradas del mapa)
    val mapToList = countryCapitalMap.toList()
    val mutableMap =
        countryCapitalMap.toMutableMap().apply {
            this += "Italia" to "Roma"
        }

    println(mapToList)
    println(mutableMap)
}


fun main() {
    testCopyList()
    testCopyToSet()
    testCopyMap()
}