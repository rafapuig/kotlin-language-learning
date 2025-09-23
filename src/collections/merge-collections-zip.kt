package collections.merge

data class Person(val name: String, val age: Int)

fun main() {
    val names = listOf("Pedro", "Pablo", "Luis", "Jose")
    val ages = listOf(56, 78, 23, 50)
    val zipped: List<Pair<String, Int>> = names.zip(ages)
    println(zipped)

    val people = names.zip(ages) { name, age ->
        Person(name, age)
    }
}