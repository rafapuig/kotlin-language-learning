package DSL.conventions.lazy.intro

/**
 * La inicialización perezosa es un patron común que
 * implica la creación de partes de un objeto bajo demanda
 * cuando se acceden por primera vez
 *
 * Es útil cuando el proceso de inicialización es costoso
 * y esos datos no siempre son requeridos cuando se usa un objeto de ese tipo.
 */

/**
 * Por ejemplo, una clase Person permite acceder a la lista
 * de emails escritos por esa persona
 * Los emails están almacenados en una base de datos (toma tiempo recuperarlos)
 * Queremos cargar los emails la primera vez que se accede
 * a la propiedad (y solamente esa primera vez)
 */

class Email

fun loadEmails(person: Person): List<Email> {
    println("Cargando los emails de ${person.name}")
    /* Aquí cargamos los emails desde la BBDDs */
    return listOf(/*... */) // Y la devolvemos como lista
}


class Person(val name: String) {
    /**
     * Usando la técnica denominada: backing property
     *
     * Tenemos que usar dos propiedades porque tienen diferente tipo
     * una es nullable y la otra non-null
     * La convención es que la privada tenga el prefijo _
     */

    // En esta propiedad privada _emails
    // Se almacenan los emails recuperados de la BBDD
    // En ella delega la propiedad emails

    private var _emails: List<Email>? = null

    // Propiedad delegada en _emails
    // Proporciona el acceso
    val emails: List<Email>
        get() { // Accesor personalizado para leer el valor de la propiedad
            if (_emails == null) { // Solo la primera vez
                _emails = loadEmails(this) // Carga los emails
            }
            return _emails!!
        }
}

fun main() {
    val person = Person("Perico Palotes") // Crea la persona, pero no carga los emails

    // Los emails son cargados por ser el primer acceso
    person.emails

    // Ahora ya los recupera directamente, porque ya los tiene cargados
    person.emails
}