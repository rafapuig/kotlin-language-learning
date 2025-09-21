package generics.variance

/**
 * El tipo de una variable
 * especifica los posibles valores que puede almacenar
 *
 * A menudo se usan los términos tipo y clase de manera intercambiable
 * pero no lo son
 */

/**
 * Clases no genéricas
 * El nombre de una clase puede usarse directamente como un tipo
 * y también para declarar una variable de tipo anulable
 *
 * Cada clase Kotlin puede dar lugar al menos a dos tipos
 */
var text: String = "Hola Kotlin"
var nullableText: String? = null

/**
 * Clases genéricas
 * Para tener un tipo válido hay que especificar un valor al parámetro de tipo
 * Cada clase generica puede producir potencialmente un número infinito de tipos
 */

val l1: List<Int> = listOf(1, 2, 3)
val l2: List<String?> = listOf(null, "Kotlin")
val l3: List<List<String>> = listOf(listOf("Java", "Kotlin"), listOf("C", "C++"))

/**
 * SUBTIPO
 * Un tipo B es un subtipo del tipo A
 * si se puede usar un valor del tipo B
 * en cualquier lugar donde se requiera uno de tipo A
 *
 * Por ejemplo, Int es un subtipo de Number pero no de String
 * Corolario: Un tipo es considerado un subtipo de si mismo
 *
 * ✅ B --> A
 * ✅ Int --> Number
 * ✅ Int --> Int
 * ❌ Int -x-> String // Int no es subtipo de String
 */

/**
 * SUPERTIPO
 * Es lo opuesto a subtipo
 * Si A es un subtipo de B -> B es un supertipo de A
 */

/**
 * El compilador hace esta comprobación cada vez que
 * -asignamos un valor a una variable
 * -pasamos un argumento a una función
 */

/**
 * En los casos sencillos subtipo es sinónimo de subclase
 * Int es un subtipo de Number
 *
 * Si una clase implementa una interface
 * su tipo es un subtipo del tipo de la interface
 * String es un subtipo de CharSequence
 *
 * Los tipos anulables son ejemplo de cuando un subtipo
 * no es lo mismo que una subclase
 * El tipo no anulable es u subtipo de la version anulable,
 * pero ambos son de la misma clase
 *
 * ✅ A --> A?
 * ✅ Int --> Int?
 * ❌ Int? --> Int  // no se puede usar un Int? donde se espera un Int
 */

var name: String = "Kotlin"
var nullableName: String? = name // válido porque String? es subtipo de String

/**
 * INVARIANTE (sobre un parámetro de tipo)
 * Una clase generica GenericClass es invariante sobre el parámetro de tipo
 * si para dos tipos diferentes cualesquiera A y B
 * GenericClass<A> no es ni subtipo ni supertipo de GenericClass<B>
 *
 * COVARIANTE (sobre un parámetro de tipo)
 * Una clase generica Producer<T> es covariante sobre el parámetro de tipo T
 * si A es un subtipo de B -> Producer<A> es un subtipo de Producer<B>
 *
 * CONTRAVARIANTE (sobre un parámetro de tipo)
 * Una clase generica Consumer<T> es contravariante sobre el parámetro de tipo T
 * si A es un supertipo de B -> Consumer<A> es un subtipo de Consumer<B>
 */

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


interface Consumer<in T> {
    fun consume(t: T)
}

/**
 * Una clase puede ser covariante sobre un parámetro y contravariante en otro
 */

interface Function<in P, out R> {
    /**
     * El parámetro P solamente se consume,
     * solamente se usa en posiciones de entrada
     */
    /**
     * El parámetro R solamente se produce,
     * solamente se usa en posiciones de salida
     */
    operator fun invoke(p: P): R
}