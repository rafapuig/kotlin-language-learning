package poo.interfaces.sealed

/**
 * Si una interface está sellada
 * Solamente la pueden implementar clases declaradas en el mismo paquete
 */
sealed interface Person {
    /**
     * Propiedad de solo lectura abstracta
     * Internamente el compilador genera un getter abstracto:
     * String getName()
     */
    val name: String
    val age: Int
}

/**
 * La clase Man implementa la interface Person
 * Debe implementar los miembros abstractos de la interface
 * Por tanto, implementa las propiedades abstractas
 *
 * Simplemente, añade override a la declaración de las propiedades declaradas
 * en el constructor
 * para indicar que no se trata de nuevas propiedades de la clase
 * sin de la implementación de las propiedades name y age de la interface
 */
class Man(override val name: String, override val age: Int) : Person

/**
 * La clase Woman implementa la interface Person
 *
 * En este caso, lo vemos de forma más explícita (y más verbosa de lo necesario)
 * El constructor declara solamente parámetros
 * En el cuerpo de la clase reemplazamos las propiedades abstractas de la interface *
 */
class Woman(name: String, age: Int) : Person {

    /**
     * Al inicializar la propiedad mediante una expresión
     * el compilador generará un campo de respaldo para almacenar el valor de la expresión
     * el getter puede hacer uso del campo de respaldo en su implementación
     * Dado que se trata de la implementación estándar que el compilador
     * haría de un getter (devolver el valor del campo de respaldo)
     * escribir el getter es redundante (boilerplate) y lo podemos eliminar del código
     */
    override val name: String = name
        get() = field

    override val age: Int = age
        get() = field
}

/**
 * La función printPersonCordialName imprime el nombre de la persona
 * anteponiendo Señor o Señora según se trata de un objeto de clase Man
 * o de clase Woman
 * Implementada mediante una expresión when donde las ramas pueden ser
 * exhaustivas, ya que al ser Person una interface sellada se conocen todas
 * las ramas posibles (una por cada clase implementadora)
 */
fun printPersonCordialName(person: Person) {
    val cordial = when(person) {
        is Man -> "Señor"
        is Woman -> "Señora"
    }
    println("$cordial ${person.name}")
}

/**
 * Función de extensión del interface Person
 */
fun Person.printCordialName() {
   printPersonCordialName(this)
}

fun main() {
    val man = Man("Pepe", 56)
    val woman = Woman("Pepa",18)

    /**
     * Llamada mediante la función de extensión
     * Ponemos un receiver a la izquierda del punto
     * El receiver debe ser una referencia a un objeto cuya clase implemente Person
     */
    man.printCordialName()
    woman.printCordialName()

    printPersonCordialName(man)
    printPersonCordialName(woman)
}