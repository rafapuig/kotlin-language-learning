# Ejercicios de Kotlin — Object expressions

## Objetivos

Con estos ejercicios se pretende practicar:

- La sintaxis de las **object expressions**.
- La creación de objetos anónimos.
- La implementación de interfaces mediante `object`.
- La herencia de clases mediante objetos anónimos.
- La diferencia entre `object expression` y `object declaration`.
- El acceso a variables del contexto exterior.
- El uso de `object` como parámetro de una función.
- La utilización de objetos anónimos para implementar comportamientos puntuales.
- La combinación de object expressions con interfaces, clases abstractas y polimorfismo.

---

# Parte 1 — Primer contacto con object expressions

## Ejercicio 1 — Objeto anónimo

Define una interfaz:

```kotlin
interface Greeting {
    fun sayHello()
}
```

Crea una instancia de la interfaz utilizando una object expression:

```kotlin
val greeting = object : Greeting {
    override fun sayHello() {
        println("Hello!")
    }
}
```

Utiliza posteriormente:

```kotlin
greeting.sayHello()
```

### Objetivo

Comprender la estructura:

```kotlin
object : Interface {
    // implementación
}
```

y observar que no es necesario crear una clase con nombre que implemente `Greeting`.

---

## Ejercicio 2 — Comparar con una clase normal

Partiendo de:

```kotlin
interface Greeting {
    fun sayHello()
}
```

crea primero una implementación tradicional:

```kotlin
class EnglishGreeting : Greeting {
    override fun sayHello() {
        println("Hello!")
    }
}
```

y después una implementación mediante object expression:

```kotlin
val greeting = object : Greeting {
    override fun sayHello() {
        println("Hello!")
    }
}
```

Compara ambas soluciones.

### Preguntas

1. ¿Qué nombre tiene la primera implementación?
2. ¿Qué nombre tiene la segunda?
3. ¿Cuándo podría ser interesante utilizar una object expression?
4. ¿Qué ocurre si solamente necesitamos esa implementación una vez?

---

# Parte 2 — Object expressions como parámetros

## Ejercicio 3 — Ordenador de números

Define:

```kotlin
interface NumberComparator {
    fun compare(a: Int, b: Int): Int
}
```

Define una función:

```kotlin
fun sortNumbers(
    numbers: List<Int>,
    comparator: NumberComparator
): List<Int>
```

Utiliza una object expression para proporcionar el comparador:

```kotlin
val result = sortNumbers(
    numbers,
    object : NumberComparator {
        override fun compare(a: Int, b: Int): Int {
            return a - b
        }
    }
)
```

### Ampliación

Crea otro comparador que ordene los números de mayor a menor.

---

## Ejercicio 4 — Sistema de descuentos

Define:

```kotlin
interface Discount {
    fun apply(price: Double): Double
}
```

Crea:

```kotlin
fun calculatePrice(
    price: Double,
    discount: Discount
): Double
```

Utiliza una object expression para aplicar un descuento del 20 %:

```kotlin
val finalPrice = calculatePrice(
    100.0,
    object : Discount {
        override fun apply(price: Double): Double {
            return price * 0.8
        }
    }
)
```

### Ampliación

Prueba diferentes descuentos creando diferentes object expressions.

---

## Ejercicio 5 — Validador

Define:

```kotlin
interface Validator<T> {
    fun validate(value: T): Boolean
}
```

Crea una función:

```kotlin
fun <T> validate(
    value: T,
    validator: Validator<T>
): Boolean
```

Utiliza una object expression para comprobar si un número es positivo:

```kotlin
val result = validate(
    10,
    object : Validator<Int> {
        override fun validate(value: Int): Boolean {
            return value > 0
        }
    }
)
```

### Ampliación

Crea validadores para:

- números pares;
- números mayores que 100;
- cadenas no vacías;
- emails que contengan `@`.

---

# Parte 3 — Object expressions y estado

## Ejercicio 6 — Contador

Define:

```kotlin
interface Counter {
    fun increment()
    fun getValue(): Int
}
```

Crea una implementación utilizando una object expression:

```kotlin
val counter = object : Counter {

    private var value = 0

    override fun increment() {
        value++
    }

    override fun getValue(): Int {
        return value
    }
}
```

Prueba varias llamadas:

```kotlin
counter.increment()
counter.increment()
counter.increment()

println(counter.getValue())
```

### Pregunta

¿Dónde está almacenado el estado del objeto anónimo?

---

## Ejercicio 7 — Generador de identificadores

Define:

```kotlin
interface IdGenerator {
    fun nextId(): Int
}
```

Crea una object expression que genere identificadores consecutivos:

```text
1
2
3
4
...
```

Utiliza una propiedad privada dentro del objeto para mantener el estado.

### Ampliación

Crea otra implementación que genere identificadores empezando en `1000`.

---

# Parte 4 — Object expressions y variables externas

## Ejercicio 8 — Saludo personalizado

Declara:

```kotlin
val language = "Spanish"
```

Crea una object expression que implemente:

```kotlin
interface Greeter {
    fun greet(name: String)
}
```

El objeto deberá utilizar la variable `language` para decidir cómo saludar.

Por ejemplo:

```text
Hola, Rafael
```

### Objetivo

Observar que una object expression puede acceder a variables del contexto en el que se crea.

---

## Ejercicio 9 — Contador con incremento configurable

Declara:

```kotlin
var increment = 5
```

Crea:

```kotlin
interface Counter {
    fun next(): Int
}
```

Utiliza una object expression que utilice `increment` para calcular el siguiente valor.

Prueba posteriormente a modificar:

```kotlin
increment = 10
```

y observa el comportamiento.

### Pregunta

¿Por qué el objeto puede acceder a `increment` aunque esa variable no sea una propiedad del objeto?

---

# Parte 5 — Object expressions heredando de clases

## Ejercicio 10 — Persona anónima

Define:

```kotlin
open class Person(
    val name: String
) {
    open fun introduce() {
        println("My name is $name")
    }
}
```

Crea una persona mediante una object expression:

```kotlin
val person = object : Person("Alice") {

    override fun introduce() {
        println("Hello! My name is $name")
    }
}
```

Llama a:

```kotlin
person.introduce()
```

### Objetivo

Aprender que una object expression no solamente puede implementar interfaces, sino también **heredar de una clase**.

---

## Ejercicio 11 — Personaje especial

Define:

```kotlin
open class Character(
    val name: String
) {
    open fun attack() {
        println("$name attacks")
    }
}
```

Crea un personaje anónimo que sobrescriba `attack()`:

```kotlin
val character = object : Character("Wizard") {

    override fun attack() {
        println("$name casts a powerful spell")
    }
}
```

### Ampliación

Añade una propiedad específica del objeto anónimo:

```kotlin
val magicPower = 100
```

e intenta acceder a ella.

### Pregunta

¿Puedes acceder a `magicPower` a través de una variable cuyo tipo sea `Character`?

---

# Parte 6 — Tipo estático de una object expression

## Ejercicio 12 — Propiedades adicionales

Crea:

```kotlin
val person = object {

    val name = "Alice"
    val age = 25

    fun sayHello() {
        println("Hello")
    }
}
```

Utiliza:

```kotlin
println(person.name)
println(person.age)
person.sayHello()
```

Ahora asigna el objeto a una variable de tipo `Any`:

```kotlin
val value: Any = person
```

Intenta acceder a:

```kotlin
value.name
```

### Pregunta

¿Por qué deja de estar disponible la propiedad `name`?

### Objetivo

Comprender la diferencia entre:

- el objeto real;
- el tipo estático mediante el que se referencia.

---

## Ejercicio 13 — Object expression privada

Dentro de una función crea:

```kotlin
fun createGreeter() {

    val greeter = object {

        fun greet() {
            println("Hello")
        }
    }

    greeter.greet()
}
```

Intenta devolver ese objeto desde la función.

Investiga qué ocurre si intentas declarar:

```kotlin
fun createGreeter(): ??? {
    ...
}
```

### Objetivo

Comprender las restricciones de visibilidad y de tipo de los objetos anónimos.

---

# Parte 7 — Object expressions frente a object declarations

## Ejercicio 14 — Comparar `object` y `object :`

Compara:

```kotlin
object Logger {
    fun log(message: String) {
        println(message)
    }
}
```

con:

```kotlin
val logger = object {
    fun log(message: String) {
        println(message)
    }
}
```

Responde:

1. ¿Cuál es un Singleton?
2. ¿Cuál crea un objeto anónimo?
3. ¿Cuál tiene un nombre?
4. ¿Cuántas instancias puede haber del primero?
5. ¿Cuántas object expressions como la segunda pueden existir?
6. ¿Cuál utilizarías para un logger global?
7. ¿Cuál utilizarías para un comportamiento que solamente necesitas en un punto concreto?

---

## Ejercicio 15 — Dos objetos diferentes

Crea:

```kotlin
val object1 = object {
    val value = 10
}

val object2 = object {
    val value = 10
}
```

Comprueba:

```kotlin
println(object1 === object2)
```

### Pregunta

¿Por qué el resultado es `false`?

### Objetivo

Diferenciar claramente una object expression de un Singleton.

Cada evaluación de:

```kotlin
object { ... }
```

crea un objeto independiente.

---

# Parte 8 — Object expressions con clases abstractas

## Ejercicio 16 — Animal abstracto

Define:

```kotlin
abstract class Animal(
    val name: String
) {
    abstract fun makeSound()
}
```

Crea directamente un objeto anónimo:

```kotlin
val animal = object : Animal("Unknown") {

    override fun makeSound() {
        println("Some sound")
    }
}
```

Utiliza:

```kotlin
animal.makeSound()
```

### Pregunta

¿Por qué una object expression permite crear una instancia de una clase abstracta cuando normalmente no podemos hacer:

```kotlin
Animal("Unknown")
```

?

---

## Ejercicio 17 — Enemigo especial

Define:

```kotlin
abstract class Enemy {
    abstract val health: Int
    abstract fun attack()
}
```

Crea un enemigo anónimo con:

```kotlin
val boss = object : Enemy() {

    override val health = 1000

    override fun attack() {
        println("The boss attacks!")
    }
}
```

### Ampliación

Añade propiedades y métodos adicionales que solamente existan en ese objeto.

---

# Parte 9 — Varias interfaces

## Ejercicio 18 — Objeto con varias capacidades

Define:

```kotlin
interface Printable {
    fun print()
}

interface Savable {
    fun save()
}
```

Crea un único objeto que implemente ambas interfaces:

```kotlin
val document = object : Printable, Savable {

    override fun print() {
        println("Printing...")
    }

    override fun save() {
        println("Saving...")
    }
}
```

Utiliza el objeto mediante ambas interfaces.

### Objetivo

Observar que una object expression puede implementar varias interfaces simultáneamente.

---

## Ejercicio 19 — Personaje jugable

Define:

```kotlin
interface Attacker {
    fun attack()
}

interface Movable {
    fun move()
}

interface Healable {
    fun heal()
}
```

Crea un objeto anónimo que implemente las tres interfaces.

Añade estado interno:

```kotlin
private var health = 100
```

Implementa las operaciones de forma coherente.

---

# Parte 10 — Casos de uso reales

## Ejercicio 20 — Callback

Define:

```kotlin
interface OnCompleteListener {
    fun onComplete()
}
```

Crea:

```kotlin
fun performOperation(
    listener: OnCompleteListener
) {
    println("Performing operation...")
    listener.onComplete()
}
```

Utiliza una object expression:

```kotlin
performOperation(
    object : OnCompleteListener {
        override fun onComplete() {
            println("Operation completed")
        }
    }
)
```

### Objetivo

Comprender uno de los usos clásicos de los objetos anónimos:

> proporcionar un comportamiento puntual a una función.

---

## Ejercicio 21 — Ordenador personalizado

Define:

```kotlin
data class Product(
    val name: String,
    val price: Double
)
```

Crea una lista de productos.

Utiliza una object expression que implemente:

```kotlin
Comparator<Product>
```

para ordenar los productos por precio.

Después crea otra object expression para ordenarlos por nombre.

### Pregunta

¿Por qué puede tener sentido utilizar aquí una object expression en lugar de crear dos clases?

---

## Ejercicio 22 — Listener de eventos

Define:

```kotlin
interface ClickListener {
    fun onClick()
}
```

Crea:

```kotlin
class Button(
    private val listener: ClickListener
) {
    fun click() {
        listener.onClick()
    }
}
```

Utiliza:

```kotlin
val button = Button(
    object : ClickListener {
        override fun onClick() {
            println("Button clicked")
        }
    }
)
```

### Ampliación

Crea varios botones con comportamientos diferentes sin crear una clase diferente para cada comportamiento.

---

# Parte 11 — Object expressions y polimorfismo

## Ejercicio 23 — Lista de comportamientos

Define:

```kotlin
interface Operation {
    fun execute()
}
```

Crea una lista:

```kotlin
val operations = listOf(
    object : Operation {
        override fun execute() {
            println("Operation A")
        }
    },

    object : Operation {
        override fun execute() {
            println("Operation B")
        }
    },

    object : Operation {
        override fun execute() {
            println("Operation C")
        }
    }
)
```

Recorre la lista:

```kotlin
for (operation in operations) {
    operation.execute()
}
```

### Objetivo

Combinar:

- interfaces;
- object expressions;
- colecciones;
- polimorfismo.

---

## Ejercicio 24 — Estrategias

Define:

```kotlin
interface AttackStrategy {
    fun attack()
}
```

Crea tres object expressions:

```text
espada
arco
magia
```

Cada una deberá implementar una estrategia de ataque diferente.

Después crea:

```kotlin
class Character(
    private val attackStrategy: AttackStrategy
) {
    fun attack() {
        attackStrategy.attack()
    }
}
```

El programa deberá poder crear personajes utilizando estrategias anónimas:

```kotlin
val warrior = Character(
    object : AttackStrategy {
        override fun attack() {
            println("Sword attack")
        }
    }
)
```

### Objetivo

Introducir de manera práctica la idea del **Strategy Pattern** utilizando object expressions.

---

# Parte 12 — Reto final

## Ejercicio 25 — Sistema de procesamiento

Define:

```kotlin
interface Processor<T> {
    fun process(value: T): T
}
```

Crea:

```kotlin
fun processValues(
    values: List<Int>,
    processor: Processor<Int>
): List<Int>
```

Utiliza diferentes object expressions para realizar:

### Procesador 1

Multiplicar todos los valores por dos.

### Procesador 2

Sumar diez a cada valor.

### Procesador 3

Elevar cada valor al cuadrado.

### Procesador 4

Limitar los valores a un máximo de `100`.

El mismo método `processValues()` deberá funcionar con todos ellos.

---

# Proyecto final — Sistema de eventos

Desarrolla un pequeño sistema de eventos.

Define:

```kotlin
interface EventListener<T> {
    fun onEvent(event: T)
}
```

Define diferentes eventos:

```kotlin
data class UserCreated(
    val userName: String
)

data class OrderCreated(
    val orderId: Int
)
```

Crea una clase:

```kotlin
class EventManager<T> {

    private val listeners =
        mutableListOf<EventListener<T>>()

    fun subscribe(listener: EventListener<T>) {
        // ...
    }

    fun publish(event: T) {
        // ...
    }
}
```

El programa deberá permitir registrar comportamientos mediante object expressions:

```kotlin
val manager = EventManager<UserCreated>()

manager.subscribe(
    object : EventListener<UserCreated> {
        override fun onEvent(event: UserCreated) {
            println(
                "User created: ${event.userName}"
            )
        }
    }
)
```

Registra varios listeners con comportamientos diferentes.

Después publica eventos:

```kotlin
manager.publish(
    UserCreated("Alice")
)
```

### Condiciones

No debes crear clases como:

```kotlin
class EmailUserCreatedListener : EventListener<UserCreated>

class LogUserCreatedListener : EventListener<UserCreated>

class StatisticsUserCreatedListener : EventListener<UserCreated>
```

para los listeners concretos.

Utiliza object expressions cuando el comportamiento solamente se necesite en ese punto.

---

# Reto de razonamiento

Analiza las siguientes situaciones y decide si utilizarías:

- una clase normal;
- una `object expression`;
- un `object declaration`;
- una función lambda.

### Situación 1

Necesitas un logger global para toda la aplicación.

### Situación 2

Necesitas un comparador que solamente utilizarás una vez.

### Situación 3

Necesitas tres implementaciones diferentes de una interfaz que se utilizarán en muchas partes del programa.

### Situación 4

Necesitas un objeto global que solamente puede tener una instancia.

### Situación 5

Necesitas pasar un comportamiento sencillo como parámetro de una función.

### Situación 6

Necesitas crear un objeto que implemente dos interfaces y solamente existirá en un punto concreto del programa.

---

# Resumen conceptual

Una **object expression** permite crear un objeto anónimo directamente:

```kotlin
val greeter = object : Greeter {

    override fun greet() {
        println("Hello")
    }
}
```

También puede heredar de una clase:

```kotlin
val character = object : Character("Mage") {

    override fun attack() {
        println("Magic attack")
    }
}
```

o implementar varias interfaces:

```kotlin
val object = object : Printable, Savable {

    override fun print() {
        // ...
    }

    override fun save() {
        // ...
    }
}
```

La idea fundamental es:

> **Una object expression permite crear una implementación anónima cuando necesitamos un objeto concreto, normalmente de forma puntual.**

Es importante no confundirla con una declaración `object`:

```kotlin
object Logger
```

que declara un objeto con nombre y comportamiento de Singleton.

Una buena regla práctica para el alumno es:

```text
Necesito muchas instancias con la misma implementación
        ↓
      class

Necesito una única instancia global
        ↓
      object

Necesito una implementación puntual y anónima
        ↓
 object expression

Necesito pasar un comportamiento sencillo
        ↓
     lambda
```

El objetivo final es que el alumno no memorice solamente la sintaxis `object : ...`, sino que sea capaz de **elegir entre clase, Singleton, object expression y lambda dependiendo de la necesidad del programa**.