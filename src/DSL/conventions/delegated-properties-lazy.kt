package DSL.conventions.lazy

import DSL.conventions.lazy.Email.loadEmails


object Email {
    fun loadEmails(person: Person): List<Email> {
        println("Cargando los emails de ${person.name}")
        /* Aquí cargamos los emails desde la BBDDs */
        return listOf() // Y la devolvemos como lista
    }
}

class Person(val name: String) {
    /**
     * Usamos una propiedad delegada
     * que encapsula:
     * - la propiedad de respaldo usada para almacenar (cachear) los datos
     * - la lógica para asegurar que los datos solamente se inicializan una vez
     */
    val emails by lazy { loadEmails(this) }
    /**
     * La funcion lazy
     * devuelve un objeto Lazy<T>
     * que cuenta con un metodo getValue
     * El argumento de lazy es una lambda a la cual llama para inicializar
     * el valor (los dotos)
     */

}

fun main() {
    val person = Person("Perico Palotes")
    person.emails // Los emails son cargados por ser el primer acceso
    person.emails // Ahora ya los recupera directamente
}