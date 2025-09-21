package generics.variance.generics

/**
 * La covarianza preserva la relación de subtipos
 *
 * Ejemplo, si Producer<T> es covariante
 * Producer<A> es un subtipo de Producer<B> si A es subtipo de B
 *
 * Producer<Cat> es subtipo de Producer<Animal> pq Cat es subtipo de Animal
 *
 * Para hacer una clase covariante en un parámetro de tipo
 * se usa out antes del nombre del parámetro de tipo
 */
interface Producer<out T> {
    fun produce(): T
}

open class Animal {
    fun feed() {}
}

/**
 * Si hacemos la clase Herd covariante sobre el parámetro T
 * entonces como Cat es un subtipo de Animal
 * Herd<Cat> es un subtipo de Herd<Animal>
 */
/** los parámetros de un constructor
 * no se consideran en posición de entrada
 * ni en posición de salida
 * Un constructor no es potencialmente peligroso
 * (no se puede llamar después de la creación de la instancia)
 */
class Herd<out T : Animal>(
    private var leader: T, //
    vararg animals: T
) {
    val size: Int get() = TODO()

    val first: T get() = leader // El getter es una posición de salida

    /*var random: T = leader // Si es var entonces el setter
        get() = field
        set(value) { // El setter usar T en posición de entrada
            field = value
        }*/


    /** se usa el parámetro T en posición de salida */
    operator fun get(i: Int): T = TODO()


}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        /**
         * Todo código que usa get en un Herd<Animal>
         * no tiene problema en que se le devuelva un Cat
         * ya que donde se espera un Animal también
         * se puede proporcionar un Cat sin problemas
         */
        animals.get(i).feed()
    }
}

/**
 * Un gato es un animal
 * La clase Cat es subclase de Animal
 * Cat es un subtipo de Animal
 */
class Cat : Animal() {
    fun clearLitter() {}
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].clearLitter()
    }
    /**
     * Podemos pasar como argumento un valor de tipo Herd<Cat>
     * a una función cuyo parámetro es de tipo Herd<Animal>
     * Si Herd<Cat> se considera un subtipo de Herd<Animal>
     */
    feedAll(cats)
}

/**
 * Cuando hacemos que una clase sea covariante para un parámetro de tipo
 * esto restringe los posibles usos del parámetro de tipo dentro de la clase
 *
 * Solamente se puede usar posiciones de salida (out)
 * La clase puede producir valores del tipo T del parámetro
 * pero no consumirlos
 */

interface Transformer<T> {
    fun transform(value: T /* posición de entrada */): T /* posición de salida */
}

/**
 * marcar con out un parámetro de tipo T
 * preserva la relación de subtipo para argumentos del tipo T
 * obliga a que todos los miembros que usan T lo hagan en posiciones de salida
 */