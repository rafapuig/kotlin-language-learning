package generics.variance.contravariance

/**
 * La contravarianza es un espejo de la covarianza
 *
 * Si Consumer<T> es contravariante entonces
 *
 * Consumer<Animal> es un subtipo de Consumer<Cat>
 * porque Animal es un supertipo de Cat
 *
 * La relación de subtipos entre consumidores de dos tipos
 * va en la dirección opuesta
 * a la relación de subtipos entre esos tipos
 *
 * Para definir una clase como contravariante para un parámetro de tipo
 * se usa la palabra in delante del nombre del parámetro
 */
interface Consumer<in T> {
    fun consume(t: T)
}

/**
 * En este interface (funcional)
 * Solamente se consumen valores de tipo T
 */
interface Comparator<in T> {
    /**
     * Al encontrarse el parámetro T en posiciones de entrada
     * al metodo compare se le pueden proporcionar valores del tipo T
     * o de cualquier subtipo de T
     */
    fun compare(a: T, b: T): Int // T se usa en posiciones de entrada
}

sealed class Fruit {
    abstract val weight: Int
}

data class Apple(override val weight: Int, val color: String) : Fruit()
data class Orange(override val weight: Int, val juicy: Boolean) : Fruit()

/**
 * Si creamos un comparador de frutas
 * lo podemos usar para comparar valores de cualquier tipo de fruta específico
 */

fun main() {
    val weightComparator = Comparator<Fruit> { a, b ->
        compareValues(a.weight, b.weight)
    }

    // Lista de frutas
    val fruits : List<Fruit> = listOf(
        Orange(180,true),
        Apple(100, "green")
    )

    // Lista de manzanas
    val apples : List<Apple> = listOf(
        Apple(150, "red"),
        Apple(120, "yellow"),
        Apple(130, "green")
    )

    /**
     * El metodo sortedWith espera un Comparador de Fruit
     * porque la lista fruits es List<Fruit>
     * luego el argumento de tipo para el parámetro de tipo T es Fruit
     */
    println(fruits.sortedWith(weightComparator))

    /**
     * Aquí el metodo sortedWith espera un Comparator<Apple>
     * porque la lista apples es de tipo List<Apple>
     * el argumento de tipo tiene como valor Apple
     * Es seguro pasar un Comparator<Fruit> que compara valores del tipo más general
     * Al metodo compare, que espera dos valores Fruit
     * se le pueden proporcionar dos valores de tipo Apple
     * porque Apple es un subtipo de Fruit
     * y, por tanto, se cumple que donde se espera un valor de un tipo
     * se puede proporcionar un valor de un subtipo
     *
     * Esto quiere decir que Comparator<Fruit> es un subtipo de Comparator<Apple>
     * y lo es porque Fruit es un SUPERTIPO de Apple
     */
    println(apples.sortedWith(weightComparator))
}