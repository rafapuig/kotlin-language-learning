package poo.inheritance.abstract

/**
 * Las clases abstractas:
 * - No permiten que se puedan crear instancias de la propia clase abstracta
 * - Pueden tener métodos abstractos
 * - Los métodos abstractos deben ser reemplazados por la subclase
 * - sino, la subclase deberá ser declarada como abstracta también
 */
abstract class Animal(val name: String) {

    abstract fun makeSound()

    fun display() {
        println(name)
    }
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("Guau")
    }
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("Miau")
    }
}

fun useAnimal(animal: Animal) {
    animal.display()
    animal.makeSound()
}

fun Animal.use() {
    useAnimal(this)
}

fun main() {
    val cat = Cat("Garfield")
    val dog = Dog("Pluto")

    var animal : Animal

    animal = cat
    animal.makeSound()

    animal = dog
    animal.makeSound()

    useAnimal(cat)
    useAnimal(dog)

    cat.use()
    dog.use()
}
