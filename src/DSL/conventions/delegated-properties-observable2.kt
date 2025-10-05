package DSL.conventions.implementing.without.delegates3


/**
 * El código de los setters de las propiedades que envían notificaciones de cambio
 * en un objeto observable es prácticamente idéntico (la lógica se repite) DRY (don't repeat yourself!!!)
 */

/**
 * Vamos a extraer la lógica a una clase que almacene el valor de la propiedad
 * y lance la notificación
 */

class ObservableProperty(
    val propertyName: String,
    var propertyValue: Int,
    val observable: Observable
) {
    fun getValue() = propertyValue
    fun setValue(newValue: Int) {
        val oldValue = propertyValue
        propertyValue = newValue
        observable.notifyObservers(propertyName, oldValue, newValue)
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

    /**
     * Ahora creamos una propiedad _age que mantiene la referencia a
     * una instancia ObservableProperty en la que delega la propiedad age
     */
    val _age = ObservableProperty("age", age, this)

    /**
     * La propiedad age delega sus accesores en el delegado _age
     * el getter delega mediante la llamada al metodo getValue del delegado
     * el setter delega mediante la llamada al metodo setValue del delegado
     */
    var age: Int
        get() = _age.getValue()
        set(newValue) {
            _age.setValue(newValue)
        }

    val _salary = ObservableProperty("salary", salary, this)
    var salary: Int
        get() = _salary.getValue()
        set(newValue) {
           _salary.setValue(newValue)
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