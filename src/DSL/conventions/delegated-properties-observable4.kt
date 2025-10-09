package DSL.conventions.implementing.with.delegates.library

/**
 * Vamos a usar la clase equivalente a ObservableProperty de la biblioteca estándar de Kotlin
 * Son:
 * ReadOnlyProperty
 * ReadWriteProperty
 */
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


fun interface Observer {
    fun onChange(name: String, oldValue: Any?, newValue: Any?)
}

/**
 * La clase ObservableProperty de la biblioteca estándar no conoce nada
 * acerca de esta clase Observable
 */
open class Observable {

    val observers = mutableListOf<Observer>()

    fun notifyObservers(propertyName: String, oldValue: Any?, newValue: Any?) {
        observers.forEach {
            it.onChange(propertyName, oldValue, newValue)
        }
    }
}

/**
 * La clase persona
 * usar propiedades que delegan en ObservableProperty de la biblioteca estándar de Kotlin
 */
class Person(val name: String, age: Int, salary: Int) : Observable() {

    /**
     * Podemos guardar en una variable de tipo función
     * e inicializarla mediante una lambda
     */
    private val onChange = { property: KProperty<*>, oldValue: Any?, newValue: Any? ->
        notifyObservers(property.name, oldValue, newValue)
    }

    /**
     * El delegado se puede obtener por la llamada a una función
     * Usamos la variable que almacena el objeto función como segundo argumento
     */
    var age by Delegates.observable(age, onChange)

    /**
     * Para salary podemos usar como segundo argumento de llamada a observable
     * una lambda (como es último argumento fuera de los paréntesis)
     */
    var salary by Delegates.observable(salary) { property: KProperty<*>, oldValue: Any?, newValue: Any? ->
        notifyObservers(property.name, oldValue, newValue)
    }

}

fun main() {
    val person = Person("Perico Palotes", 30, 2000)

    // Creamos un observador
    // implementando la interface funcional Observer
    val observer = Observer { propertyName, oldValue, newValue ->
        println("Propiedad $propertyName ha cambiado de $oldValue a $newValue")
    }
    // Añadimos el observador a la lista de observadores del objeto Person
    person.observers += observer
    // Cambiamos la edad
    person.age = 18 // El observador recibe la notificación
    // Cambiamos el salario
    person.salary = 2100 // El observador recibe la notificación
}