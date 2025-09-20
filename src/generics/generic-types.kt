package generics.types

import java.util.function.IntFunction

/**
 * TIPOS GENÉRICOS
 *
 * Podemos definir un tipo (clase o interface) que tenga parámetros de tipo
 * Diremos que este tipo es un tipo genérico
 *
 * Cuando creemos una instancia de este tipo genérico
 * especificamos el valor del parámetro de tipo
 * mediante un argumento de tipo
 *
 * Ejemplo:
 * Tipo genérico: La interface List<T>
 *     T es el parámetro de tipo
 * Cuando creamos una instancia (objeto) del tipo genérico
 * indicamos el valor de parámetro genérico especificando un tipo
 * el argumento de tipo
 * List<String> el argumento del parámetro de tipo es String
 */

/**
 * Los argumentos de tipo pueden ser inferidos por el compilador de Kotlin
 *
 * Si los elementos de la lista son de tipo String el compilador
 * infiere el argumento de tipo como tipo String
 */

val friends = listOf("Emilio", "Ramon", "Raul", "Rafa")
val fruits: List<String> = listOf<String>("Manzana", "Banana", "Piña")

/**
 * Si creamos una lista vacía el compilador no puede inferir el valor
 * del tipo del parámetro T de tipo del tipo genérico List<T>
 */
val names: List<String> = mutableListOf() // Explicitamos el tipo de la variable
val cities = mutableListOf<String>() // En la función genérica

/**
 * CLASES E INTERFACES GENÉRICAS
 *
 * Para declarar una clase (o interfaces) como genérica
 * se usan los <> después del nombre de la clase
 * con los nombres de los parámetros de tipo dentro de los <>
 *
 * Los parámetros de tipo se pueden usar dentro del cuerpo de la clase
 * Para indicar
 * - el tipo de una propiedad
 * - el tipo un parámetro de entrada de un metodo
 * - el tipo de retorno de un metodo
 * - el argumento de tipo si en alguno de los casos anteriores se trata de un tipo genérico
 */

class MyGenericClass<T, R>(intProp: R) {
    var prop: R = intProp
    fun method1(param: T): R = prop
    val listProp: List<R> = listOf(prop)
}

/**
 * HERENCIA DE UNA CLASE GENÉRICA / IMPLEMENTACIÓN DE UNA INTERFACE GENÉRICA
 *
 * Tenemos que proporcionar el argumento de tipo para el parámetro genérico de la clase base
 */
class StringList : ArrayList<String>() {
    override fun get(index: Int): String { // Devuelve un String (argumento de tipo)
        return super.get(index)
    }
}

/**
 * Si implementamos una interface
 * proporcionamos el argumento de tipo
 */
class DoubleList() : List<Double> by ArrayList<Double>()

/**
 * El argumento de tipo puede ser específico como en los ejemplos anteriores
 * o, si la subclase es genérica (entonces habremos declarado algún parámetro de tipo)
 * el parámetro de tipo declarado en la subclase
 */

class MyList<T> : ArrayList<T>()


/**
 * Una clase puede referirse a sí misma como argumento de tipo
 *
 * Por ejemplo, las clases que implementan el interface genérico Comparable
 */

data class Person(val name: String, val age: Int) : Comparable<Person> {
    override fun compareTo(other: Person): Int = TODO()
}