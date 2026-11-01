package containers.collections.iterable

import java.util.function.Consumer
import kotlin.collections.forEach


fun testForEachFunctionWithConsumerInterface() {

    // Crear un objeto Consumer<String> mediante un objeto expresión (tipo anónimo de Java)
    val action: Consumer<String> = object : Consumer<String> {
        override fun accept(t: String) {
            println(t)
        }
    }

    // Este foreach no es un metodo de extensión (pertenece a la interfaz Iterable original de Java)
    NAMES.forEach(action)

    // Otra forma, si el interface no fuera funcional
    // (habría que especificar el metodo, mediante una referencia a metodo)
    NAMES.forEach(action::accept) // es una referencia cerrada, el objeto receptor ya está indicado: action

    // La referencia a metodo evita especificar una lambda que simplemente delega en el metodo
    NAMES.forEach { name -> action.accept(name) }

    // Cuando la expresión lambda únicamente consta de un parámetro
    // si no especificamos un nombre, explícitamente se usa como nombre del parámetro: it
    NAMES.forEach { action.accept(it) }
}


fun testForEachFunctionWithConsumerSAM() {
    // Ahora hacemos uso del constructor SAM porque Consumer es una interface funcional de Java
    val action = Consumer<String> { t -> println(t) }
    NAMES.forEach(action)
    NAMES.forEach(action::accept)
    NAMES.forEach { name -> action.accept(name) }
    NAMES.forEach { action.accept(it) }
}

fun testForEachFunctionWithConsumerSAMImplicit() {
    // Cuando la variable se declara con su tipo explícitamente podemos omitir el constructor SAM
    val action: Consumer<String> = { t -> println(t) }
    NAMES.forEach(action)
    NAMES.forEach(action::accept)
    NAMES.forEach { name -> action.accept(name) }
    NAMES.forEach { action.accept(it) }
}


fun testForEachFunctionWithFunctionTypeVariableImplicit() {
    // Si no se declara el tipo de la variable y tampoco se usa el constructor SAM
    // lo que se crea es un objeto de tipo función
    // (y hay que explicitar el tipo del parámetro en la lambda)
    val action = { t: String -> println(t) }
    NAMES.forEach(action)
    NAMES.forEach { name -> action.invoke(name) } // El metodo SAM de un objeto función se llama invoke
    NAMES.forEach { name -> action(name) } // Se puede omitir invoke por convención
    NAMES.forEach { action.invoke(it) }
    NAMES.forEach { action(it) }
}

fun testForEachFunctionWithFunctionTypeVariableExplicit() {
    // Si usamos explícitamente variables de tipo función
    // ya no hace falta declarar el tipo del parámetro en la lambda
    val action: (String) -> Unit = { t -> println(t) }
    NAMES.forEach(action)
    NAMES.forEach { name -> action.invoke(name) }
    NAMES.forEach { name -> action(name) }
    NAMES.forEach { action.invoke(it) }
    NAMES.forEach { action(it) }
}



fun testForEachFunctionWithLambda() {
    NAMES.forEach { name -> println(name) }
    NAMES.forEach { println(it) }
}


fun main() {
    testForEachFunctionWithConsumerInterface()
    testForEachFunctionWithConsumerSAM()
    testForEachFunctionWithConsumerSAMImplicit()
    testForEachFunctionWithFunctionTypeVariableImplicit()
    testForEachFunctionWithFunctionTypeVariableExplicit()
    testForEachFunctionWithLambda()
}
