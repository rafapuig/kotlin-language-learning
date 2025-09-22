package functional.lambdas.withreceivers

/**
 * Permiten llamar a los métodos de un objeto
 * dentro del cuerpo de la lambda
 * sin tener que usar cualificadores
 */

/**
 * with
 * Sirve para realizar operaciones multiples sobre el mismo objeto
 */

/**
 * En esta implementación de la función alphabet
 * se llama varias veces a métodos usando la referencia
 * result
 */
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

/**
 * Ahora usando with
 */
fun alphabetWith(): String {
    with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        return toString()
    }
}

fun alphabetWithVerbose(): String {
    with(
        receiver = StringBuilder(),
        block = {
            for (letter in 'A'..'Z') {
                append(letter)
            }
            append("\nNow I know the alphabet!")
            return toString()
        })
}

/**
 * La función with que recibe dos parámetros:
 * un receiver de tipo T
 * una lambda con receiver
 * with convierte el primer argumento en el receiver
 * de la lambda pasada como segundo
 * dentro del bloque lambda se accede al receiver con la
 * referencia this
 */
fun alphabetWithExplicitThis(): String {
    with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow I know the alphabet!")
        return this.toString()
    }
}

/**
 * El valor que retorna la función with
 * es el resultado de la ejecución del código del cuerpo de la lambda
 *
 * El resultado de una lambda
 * es el resultado de la ultima expresión
 */
fun alphabetWithExpresionBody() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString() // ultima expresión, es el resultado de la lambda
}

/**
 * apply
 * Se diferencia de with en que
 * - devuelve el objeto receiver
 * - es una función de extensión
 * Su uso más característico es el de inicializar y configurar objetos
 * Ayuda a implementar el patron de diseño Builder
 */
fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()


/**
 * La clase persona es inmutable
 */
data class Person(val name: String, val age: Int)

class PersonBuilder {
    var name = "Anonimo"
    var age = 0
    fun build(): Person = Person(name, age)
}

fun buildPerson(name: String, age: Int): Person =
    PersonBuilder().apply {
        this.name = name
        this.age = age
    }.build()

fun alphabetFun() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}

fun buildPerson(builderAction: PersonBuilder.() -> Unit) =
    PersonBuilder().apply(builderAction).build()

/**
 * En Kotlin hay funciones builder que ayudan a crear
 * listas, conjuntos y map de solo lectura como resultado,
 * pero que durante la creación son mutables
 */
val fibonacci = buildList {
    addAll(listOf(1, 2))
    add(3)
    add(index = 0, element = 1)
}

const val shouldAdd = true

val fruits = buildSet {
    add("manzana")
    if (shouldAdd) {
        addAll(listOf("manzana", "banana", "cereza"))
    }
}

val medals = buildMap {
    put("Oro",1)
    putAll(listOf("Plata" to 2, "Bronce" to 3))
}


/**
 * also
 *
 * Realizar acciones adicionales con un objeto
 * Es como apply, pero en este caso se accede al receptor
 * como argumento de la lambda (dando un nombre o usando el nombre por defecto it)
 * Es más conveniente que apply cuando
 * vamos a llamar a métodos para pasarles como argumento el objeto receiver
 *
 * Devuelve el objeto mediante el cual se llamó a also
 */

fun alsoDemo() {
    val fruits = listOf("manzana", "banana", "cereza")
    val uppercaseFruits = mutableListOf<String>()
    val reversedLongFruits = fruits
        .map { it.uppercase() }
        .also { uppercaseFruits.addAll(it) } // acción adicional
        .filter { it.length > 5 }
        .also { println(it) } // Acción adicional con el objeto
        .reversed()

    println(uppercaseFruits)
    println(reversedLongFruits)
}