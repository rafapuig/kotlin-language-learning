package DSL.conventions.implementing.with.delegates.convention

import kotlin.reflect.KProperty

/**
 * Mediante la delegación de propiedades podremos eliminar de la clase
 * Person el código para crear la instancia del delegado de age y el delegado de salary
 * y la lógica de delegación de los accesores
 */

/**
 * Para ello se necesita hacer cambios en la firma de los métodos de
 * la clase ObservableProperty
 * para que se correspondan con los que se require por convención de Kotlin
 */

class ObservableProperty(
    // Eliminamos la propiedad name del constructor porque ahora accederemos con la KProperty
    var propertyValue: Int,
    val observable: Observable
) {
    /**
     * getValue se convierte en un operator
     * añadimos 2 parámetros:
     * - thisRef: para recibir como argumento la referencia la objeto cuya propiedad se obtiene (get)
     * - property: para representar a la propiedad misma
     * La propiedad se representa mediante un objeto de tipo KProperty (reflexión)
     */
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = propertyValue

    /**
     * a setValue tambien se le convierte en operator y se le añaden los dos parámetros
     * en este caso para la propiedad que se accede para mutar (set)
     */
    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: Int) {
        val oldValue = propertyValue
        propertyValue = newValue
        // Para acceder al nombre de la propiedad usamos property.name
        observable.notifyObservers(property.name, oldValue, newValue)
    }
}

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

    // El objeto a la derecha de by se denomina delegado
    var age by ObservableProperty(age, this)
    var salary by ObservableProperty(salary, this)

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