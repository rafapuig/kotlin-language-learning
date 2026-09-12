package poo.objects.singleton

data class Person(val name: String, val age: Int) {

    object ByNameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }

    object ByAgeComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.age.compareTo(p2.age)
    }
}

fun main() {
    val people = listOf(Person("Rafa", 48), Person("Emilio", 49))
    println(people.sortedWith(Person.ByNameComparator))
    println(people.sortedWith(Person.ByAgeComparator))
}