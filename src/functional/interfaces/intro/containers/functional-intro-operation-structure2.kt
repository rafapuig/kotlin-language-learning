package functional.intro.operation.structure.comparator.implementers

data class Person(val name: String, val age: Int)

val friends = arrayOf(Person("Raul", 29), Person("Ramon", 31))

/**
 * Creamos un Singleton
 * que implementa la interface Comparator<Person>
 * La función compare realiza la comparación a partir de la edad de las personas
 */
object ByAgeComparator : Comparator<Person> {
    override fun compare(p1: Person, p2: Person): Int {
        return compareValues(p1.age, p1.age)
    }
}

/**
 * Creamos otro Singleton
 * que implementa la interface Comparator<Person>
 * La función compare realiza la comparación a partir de la edad de las personas
 */

object ByNameComparator : Comparator<Person> {
    override fun compare(p1: Person, p2: Person) = compareValues(p1.age, p1.age)
}

/**
 * Estos singletones representan distintas estrategias para comparar objetos Person
 * Como implementan la misma interface son intercambiables entre si
 *
 * La función findMax que espera una referencia a un objeto que implemente Comparable<Person>
 * se la podrá llamar pasando como argumento el objeto ByAgeComparator o el ByNameComparator
 */

/**
 * La función de extensión findMax
 * Codifica el algoritmo para seleccionar el primer elemento del contenedor (el array)
 * y realizar el bucle para ir pasando por el resto de elementos
 * para comparar cada elemento con el maximo entre los ya recorridos
 *
 * No obstante, la comparación la delega en un objeto que implemente Comparator<Person>
 * De este objeto lo único que debe conocer es su interface para poder interactuar con él,
 * pero no el tipo de objeto concreto que es
 *
 * Cuando el código de la función findMax llame al método compare del objeto
 * le proporcionará las dos personas a comparar
 * y dependiendo del tipo concreto del objeto se compararán de una manera u otra
 * ya que cada objeto comparador tiene su propia implementación del metodo compare
 * es decir, su propia estrategia
 */
fun Array<Person>.findMax(comparator: Comparator<Person>): Person? {
    if (isEmpty()) return null
    var max: Person = this[0]
    for (person in this.slice(1 until size)) {
        if (comparator.compare(person, max) > 0) {
            max = person
        }
    }
    return max
}

fun findMaxByAge() {
    /**
     * Cuando llamamos a la función findMax pasamos como argumento
     * una referencia a un objeto que implemente Comparador<Person>
     * Si pasamos el singleton ByAgeComparator
     * Se compararán las personas de array por edad
     * y el maximo será el de mayor edad
     */
    val oldest = friends.findMax(ByAgeComparator)
    println("Más Viejo = $oldest")
}

fun findMaxByName() {
    /**
     * Cuando llamamos a la función findMax pasamos como argumento
     * una referencia a un objeto que implemente Comparador<Person>
     * Si pasamos el singleton ByNameComparator
     * Se compararán las personas de array por nombre
     * y el maximo será aquel cuyo nombre va en ultimo lugar en orden alfabético
     */
    val max = friends.findMax(ByNameComparator)
    println("Último alfabeticamente = $max")
}


fun main() {
    findMaxByAge()
    findMaxByName()
}