package functional.lambdas.scope

import imperative.types.age

/**
 * La biblioteca estándar de Kotlin define 5 funciones scope
 *
 * let, run, with, apply y also
 *
 * Algunas son funciones de extensión: let, also y apply
 * otras son globales: run, with
 *
 * Algunas devuelven el resultado de la lambda: run, with, let
 * otras (si son de extensión) devuelven el receptor: also, apply
 *
 * Algunas usan una lambda regular: run, let, also --> it
 * otras una lambda con receptor: with, apply --> this
 */

data class Person(var name: String = "", var age: Int = 0)


inline fun <R> run(block: () -> R): R {
    return block()
}

inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}


inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}

inline fun <T, R> T.apply(block: T.() -> R): T {
    this.block()
    return this
}



fun main() {

    val person = Person()
    person.name = "Moncho"
    person.age = 30
    println(person)

    with(Person()) {
        name = "Pedro"
        age = 45
        println(this)
    }

    val manolo = Person().apply {
        name = "Manolo"
        age = 55
    }
    println(manolo)

    val person1: Person? = manolo

    val resultAge = person1?.let {
        it.name = "Manuel"
        it.age++
    }
    println(resultAge)

    val perico = Person().apply {
        name = "Pedro"
        age = 48
    }.also {
        it.age++
        println(it)
    }

    val age = run {
        println("Cumpleaños de manolo")
        manolo.age++
    }
    println(age)

}