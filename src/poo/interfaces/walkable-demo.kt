package poo.interfaces

/**
 * Todos los objetos que pueden caminar deberían implementar la interface Walkable
 */
interface Walkable {

    fun walk()

    /**
     * Métodos estáticos que utilizan la interfaz Walkable
     */
    companion object {

        /**
         * Poner a un walkable a caminar
         */
        fun letItWalk(walkable: Walkable) =
            walkable.walk()


        /**
         * Poner a varios walkable a caminar
         */
        fun letThemWalk(vararg walkables: Walkable) {
            for (walkable in walkables) {
                letItWalk(walkable)
            }
        }
    }
}

/**
 * Otras implementaciones de letThemWalk
 */
fun Walkable.Companion.letThemWalkWithForRange(vararg walkables: Walkable) {
    for (i in 0..<walkables.size) {
        letItWalk(walkables[i])
    }
}

fun Walkable.Companion.letThemWalkWithIndex(vararg walkables: Walkable) {
    for ((index, _) in walkables.withIndex()) {
        letItWalk(walkables[index])
    }
}

fun Walkable.Companion.letThemWalkWithForeach(vararg walkables: Walkable) =
    walkables.forEach { letItWalk(it) }



/**
 * Función de extensión de la interface Walkable
 * (no tiene mucha utilidad práctica, es lo mismo que llamar directamente al método walk)
 */
fun Walkable.letWalk() {
    Walkable.letItWalk(this)
}


/**
 * Clase Person que implementa la interface Walkable
 */
class Person(val name: String) : Walkable {

    // El modificador override se usa para marcar un método de reemplazo del método de la interface
    override fun walk() {
        println("$name (una persona) esta caminando.")
    }
}


/**
 * Clase Duck que implementa la interface Walkable
 */
class Duck(val name: String) : Walkable {

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
    /**
     * Creamos una instancia de Person
     * Un objeto cuya clase implementa la interface Walkable
     */
    val person = Person("Perico Palotes")

    // Usando el metodo de extensión
    person.letWalk()

    // Usando el metodo de la interface
    person.walk()

    // Mediante el metodo estático
    Walkable.letItWalk(person)

    /**
     * Creamos un pato,
     * la clase Duck también implementa la interface Walkable
     */
    val duck = Duck("Pato Donald")
    duck.walk()
    duck.letWalk()
    Walkable.letItWalk(duck)
}


fun testWalkablePersonsAndDucks() {
    val person = Person("Perico Palotes")
    val duck = Duck("Pato Donald")

    // Ponemos a caminar tanto a un pato como a una persona (ambos son caminables)
    Walkable.letThemWalk(person, duck)

    // Creamos un array de referencias a objetos cuya clase implementa la interface Walkable
    val walkablesArray = arrayOf(person, duck)

    /**
     * Para desestructurar el array en sus elementos utilizamos el operador *
     */
    // Ponemos a caminar a todos los elementos walkables del array
    Walkable.letThemWalk(*walkablesArray)

    // Creamos ahora una lista de walkables
    val walkables = listOf<Walkable>(person, duck)

    /**
     * Para convertir una lista en un array se utiliza el metodo toTypedArray
     */
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
    /**
     * Creamos un array de tamaño 3
     * inicializado con referencias al valor nulo
     */
    val walkablesArray = Array<Walkable?>(3)  { index -> null }

    walkablesArray[0] = Person("Perico Palotes")
    walkablesArray[1] = Duck("Pato Donald")
    walkablesArray[2] = Person("Belen Tilla")

    /**
     * La función filterNotNull nos devuelve una LISTA que contiene los elementos de un array
     * que no contienen referencias al valor nulo
     * Luego mediante toTypedArray convertimos la lista de nuevo en un array
     * Y finalmente con el operador * desagregamos los elementos para poder pasarlos como
     * argumento vararg
     */
    Walkable.letThemWalk(*walkablesArray.filterNotNull().toTypedArray())
}