package poo.interfaces


/**
 * Todos los objetos que pueden caminar deberían implementar la interface Walkable
 */
interface Walkable {

    fun walk()

    companion object {
        fun letThemWalk(vararg walkables: Walkable) {
            for (walkable in walkables) {
                letItWalk(walkable)
            }
        }

        fun lemThemWalkWithForRange(vararg walkables: Walkable) {
            for (i in 0..<walkables.size) {
                letItWalk(walkables[i])
            }
        }

        fun lemThemWalkWithIndex(vararg walkables: Walkable) {
            for ((index, _) in walkables.withIndex()) {
                letItWalk(walkables[index])
            }
        }

        fun lemThemWalkWithForeach(vararg walkables: Walkable) {
            walkables.forEach { letItWalk(it) }
        }

        fun letItWalk(walkable: Walkable) {
            walkable.walk()
        }
    }
}

fun Walkable.letWalk() {
    Walkable.letItWalk(this)
}

class Person(private val name: String) : Walkable {
    // El modificador override se usa para marcar un metodo de reemplazo del metodo de la interface
    override fun walk() {
        println("$name (una persona) esta caminando.")
    }
}

class Duck(private val name: String) : Walkable {
    override fun walk() {
        println("$name (un pato) esta caminando.")
    }
}


fun main() {
    //testWalkable()
    //testWalkablePersonsAndDucks()
    testWalkables()
    //testWalkablesNullable()
}


fun testWalkable() {
    val person = Person("Perico Palotes")
    person.letWalk()
    person.walk()
    Walkable.letItWalk(person)

    val duck = Duck("Pato Donald")
    duck.walk()
    duck.letWalk()
    Walkable.letItWalk(duck)
}


fun testWalkablePersonsAndDucks() {
    val person = Person("Perico Palotes")
    val duck = Duck("Pato Donald")

    Walkable.letThemWalk(person, duck)

    val walkablesArray = arrayOf(person, duck)
    Walkable.letThemWalk(*walkablesArray)

    val walkables = listOf<Walkable>(person, duck)
    Walkable.letThemWalk(*walkables.toTypedArray())
}


fun testWalkables() {
    val walkablesArray = arrayOf(
        Person("Perico Palotes"),
        Duck("Pato Donald"),
        Person("Belen Tilla")
    )
    Walkable.letThemWalk(*walkablesArray)
}


fun testWalkablesNullable() {
    val walkablesArray = Array<Walkable?>(3)  { index -> null }
    walkablesArray[0] = Person("Perico Palotes")
    walkablesArray[1] = Duck("Pato Donald")
    walkablesArray[2] = Person("Belen Tilla")
    Walkable.letThemWalk(*walkablesArray.filterNotNull().toTypedArray())
}