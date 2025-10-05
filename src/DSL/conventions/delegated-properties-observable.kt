package DSL.conventions.implementing.without.delegates

/**
 * Observable
 *
 * Para ver como se implementan las propiedades delegadas
 * vamos a ver un ejemplo:
 * La tarea de notificar a los listeners cuando una propiedad de un objeto cambia.
 * (Esto es útil en muchos casos, como cuando presentamos un objeto en una UI
 * y queremos que la UI se actualice automáticamente cuando la propiedad del objeto cambia)
 */

/**
 * Como la interface Observer
 * solamente declara un metodo podemos usar una interface funcional
 */
fun interface Observer {
    fun onChange(name: String, oldValue: Any?, newValue: Any?)
}

open class Observable {
    /**
     * La clase Observable administra una lista de observadores
     * interesados en recibir notificaciones cuando haya cambios
     */
    val observers = mutableListOf<Observer>()

    /**
     * notifyObservers
     * llama a onChange con cada observador registrado en la lista de observadores
     * como receiver pasando el valor anterior y el nuevo de la propiedad que cambia
     * además del nombre
     */
    fun notifyObservers(propertyName: String, oldValue: Any?, newValue: Any?) {
        observers.forEach {
            it.onChange(propertyName, oldValue, newValue)
        }
    }
}

/**
 * La clase persona
 * tiene dos propiedades age y salary
 * que cuando cambien notificarán su cambio
 * a los observadores
 */
class Person(val name: String, age: Int, salary: Int) : Observable() {

    var age = age
    set(newValue) {
        val oldValue = field
        field = newValue
        notifyObservers("age", oldValue, newValue)
    }

    var salary = salary
    set(newValue) {
        val oldValue = field
        field = newValue
        notifyObservers("salary", oldValue, newValue)
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