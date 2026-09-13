package poo.construction.builder.person

data class Person(var name: String, var age: Int)

fun Person.print() = println("Name: $name, Age: $age")


fun main() {

    val person = Person("Perico", 30)

    person.print()

    /**
     * La scope function apply
     * - usa el objeto receptor de la llamada a apply en el bloque (acceso mediante this)
     * - devuelve la referencia al objeto receptor
     * (con lo cual podemos usar la referencia devuelta para llamar a otro método sobre el mismo objeto receptor)
     */
    person.apply {
        this.name = "${this.name} Palotes"
        age++
    }.print()


    fun changePerson(person: Person, actions: Person.() -> Unit) = person.apply(actions)


    changePerson(person, { name = "Pepito Grillo" })
    person.print()

    changePerson(person) { age = 25 }
    person.print()


    fun Person.change(actions: Person.() -> Unit) = apply(actions)


    person.change(actions = { age *= 2 })
    person.print()

    person.change {
        name = "Lorenzo Penco"
        age = 45
    }.print()

    person
        .change { name = "Pedro Gado" }
        .change { age = 50 }
        .print()

}