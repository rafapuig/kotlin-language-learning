# Ejercicios de Kotlin — Herencia

Colección progresiva de ejercicios para practicar la **herencia en Kotlin**, desde los conceptos más básicos hasta situaciones más avanzadas.

Se trabajarán progresivamente:

- `open`
- herencia de clases
- constructores
- `override`
- `super`
- propiedades heredadas
- métodos heredados
- polimorfismo
- clases abstractas
- métodos abstractos
- interfaces
- implementación de varias interfaces
- sobrescritura de miembros
- `final`
- `sealed class`
- jerarquías de clases

---

# Nivel 1 — Herencia básica

## Ejercicio 1 — Persona y estudiante

Crea una clase `Person` con:

- `name`
- `age`

Haz que pueda ser heredada.

Después crea una clase `Student` que herede de `Person` y añada:

- `course`

Debe ser posible crear:

```kotlin
val student = Student(
    name = "Ana",
    age = 20,
    course = "DAM"
)
```

Muestra todos sus datos por consola.

### Objetivo

Practicar:

- `open`
- herencia mediante `:`
- paso de parámetros al constructor de la clase padre.

---

## Ejercicio 2 — Persona y profesor

Crea una clase `Person` con:

```kotlin
name: String
age: Int
```

Crea dos clases derivadas:

```text
Student
Teacher
```

`Student` tendrá:

```text
course
```

y `Teacher` tendrá:

```text
subject
```

Crea objetos de las tres clases y muestra sus datos.

---

# Nivel 2 — `open` y `override`

## Ejercicio 3 — Animales

Crea:

```kotlin
open class Animal(
    val name: String
)
```

Añade un método:

```kotlin
open fun makeSound()
```

Crea las clases:

- `Dog`
- `Cat`
- `Cow`

Cada una debe sobrescribir `makeSound()`.

Por ejemplo:

```kotlin
val dog = Dog("Bobby")
dog.makeSound()
```

debe producir:

```text
Woof!
```

### Objetivo

Practicar:

- `open class`
- `open fun`
- `override fun`

---

## Ejercicio 4 — Vehículos

Crea:

```kotlin
open class Vehicle(
    val brand: String
)
```

Añade:

```kotlin
open fun start()
```

Crea:

- `Car`
- `Motorcycle`
- `Truck`

Cada clase debe sobrescribir `start()` y mostrar un mensaje diferente.

---

# Nivel 3 — `super`

## Ejercicio 5 — Empleados

Crea:

```kotlin
open class Employee(
    val name: String,
    val salary: Double
)
```

Añade:

```kotlin
open fun showInfo()
```

Crea:

```text
Manager
Developer
```

y sobrescribe `showInfo()`.

La implementación de las clases hijas debe llamar primero a:

```kotlin
super.showInfo()
```

y después mostrar la información específica de cada tipo de empleado.

---

## Ejercicio 6 — Modificar el comportamiento del padre

Crea:

```kotlin
open class Character(
    val name: String,
    var health: Int
) {
    open fun attack() {
        println("$name attacks")
    }
}
```

Crea:

```text
Warrior
Mage
Archer
```

Cada clase debe sobrescribir `attack()`.

Al menos una de ellas deberá llamar a:

```kotlin
super.attack()
```

antes de realizar su comportamiento adicional.

---

# Nivel 4 — Constructores y herencia

## Ejercicio 7 — Vehículos eléctricos

Crea:

```kotlin
open class Vehicle(
    val brand: String,
    val model: String
)
```

Crea:

```kotlin
class ElectricCar(
    brand: String,
    model: String,
    val batteryCapacity: Int
) : Vehicle(brand, model)
```

Crea varios vehículos y muestra toda su información.

### Objetivo

Comprender que el constructor de la clase derivada debe inicializar también la parte correspondiente a la clase padre.

---

## Ejercicio 8 — Productos

Crea:

```kotlin
open class Product(
    val name: String,
    val price: Double
)
```

Crea:

```text
FoodProduct
ElectronicProduct
ClothingProduct
```

Cada clase debe añadir al menos una propiedad propia.

Por ejemplo:

```text
FoodProduct       -> expirationDate
ElectronicProduct -> warranty
ClothingProduct   -> size
```

---

# Nivel 5 — Propiedades heredadas

## Ejercicio 9 — Figuras geométricas

Crea:

```kotlin
open class Shape(
    val color: String
)
```

Crea:

- `Rectangle`
- `Circle`
- `Triangle`

Cada clase tendrá sus propiedades específicas.

Añade a `Shape`:

```kotlin
open val area: Double
```

y haz que cada clase calcule su propia área.

Ejemplo:

```kotlin
val circle = Circle("red", 5.0)

println(circle.area)
```

---

## Ejercicio 10 — Animales y velocidad

Crea:

```kotlin
open class Animal(
    val name: String,
    open val speed: Double
)
```

Crea:

- `Dog`
- `Cheetah`
- `Turtle`

Cada clase deberá proporcionar una velocidad diferente.

Después crea una función:

```kotlin
fun fastestAnimal(animals: List<Animal>): Animal
```

que devuelva el animal más rápido.

---

# Nivel 6 — Polimorfismo

## Ejercicio 11 — Lista de animales

Utiliza las clases del ejercicio anterior.

Crea:

```kotlin
val animals: List<Animal>
```

que contenga:

- varios perros;
- varios gatos;
- varias vacas.

Recorre la lista:

```kotlin
for (animal in animals) {
    animal.makeSound()
}
```

Observa cómo se ejecuta automáticamente la implementación correspondiente al tipo real del objeto.

### Objetivo

Comprender el **polimorfismo**.

---

## Ejercicio 12 — Lista de vehículos

Crea:

```text
Vehicle
 ├── Car
 ├── Motorcycle
 └── Truck
```

Todos deben tener:

```kotlin
open fun move()
```

Crea una lista:

```kotlin
val vehicles: List<Vehicle>
```

con diferentes tipos de vehículos.

Recórrela llamando a:

```kotlin
vehicle.move()
```

No utilices `is` ni `when` para decidir qué tipo de vehículo es.

---

# Nivel 7 — Clases abstractas

## Ejercicio 13 — Figura abstracta

Crea:

```kotlin
abstract class Shape {
    abstract fun area(): Double
}
```

Crea:

- `Circle`
- `Rectangle`
- `Triangle`

Cada clase debe implementar `area()`.

Crea una lista:

```kotlin
val shapes: List<Shape>
```

y calcula el área de todas las figuras.

### Objetivo

Practicar:

- `abstract class`
- métodos abstractos;
- implementación obligatoria;
- polimorfismo.

---

## Ejercicio 14 — Empleados

Crea:

```kotlin
abstract class Employee(
    val name: String
) {
    abstract fun calculateSalary(): Double
}
```

Crea:

- `FullTimeEmployee`
- `PartTimeEmployee`
- `FreelanceEmployee`

Cada tipo calculará el salario de una manera diferente.

Después crea una lista de empleados y calcula cuánto dinero debe pagar la empresa en total.

---

## Ejercicio 15 — Sistema de pagos

Crea:

```kotlin
abstract class Payment {
    abstract fun pay(amount: Double)
}
```

Crea:

- `CreditCardPayment`
- `PayPalPayment`
- `BankTransferPayment`

Cada uno debe implementar `pay()` de manera diferente.

Después crea una lista de pagos y ejecútalos polimórficamente.

---

# Nivel 8 — Clases abstractas con comportamiento común

## Ejercicio 16 — Personajes

Crea:

```kotlin
abstract class Character(
    val name: String,
    var health: Int
) {
    fun receiveDamage(amount: Int) {
        health -= amount
    }

    abstract fun attack()
}
```

Crea:

- `Warrior`
- `Mage`
- `Archer`

El método `receiveDamage()` será común a todos los personajes, mientras que `attack()` será diferente.

### Objetivo

Comprender cuándo colocar comportamiento en la clase padre y cuándo hacerlo abstracto.

---

# Nivel 9 — Interfaces

## Ejercicio 17 — Voladores

Crea una interfaz:

```kotlin
interface Flyable {
    fun fly()
}
```

Crea:

- `Bird`
- `Airplane`
- `Drone`

Todos deben implementar `Flyable`.

Después crea una función:

```kotlin
fun makeFly(flyable: Flyable)
```

que haga volar cualquier objeto que implemente la interfaz.

---

## Ejercicio 18 — Interfaces múltiples

Crea:

```kotlin
interface Flyable {
    fun fly()
}
```

y:

```kotlin
interface Swimmable {
    fun swim()
}
```

Crea:

```text
Duck
```

que implemente ambas interfaces.

Debe ser posible:

```kotlin
duck.fly()
duck.swim()
```

### Objetivo

Comprender cómo Kotlin permite combinar comportamientos mediante interfaces.

---

## Ejercicio 19 — Vehículo anfibio

Crea:

```kotlin
interface Drivable {
    fun drive()
}

interface Sailable {
    fun sail()
}
```

Crea una clase:

```text
AmphibiousVehicle
```

que implemente ambas interfaces.

Después crea funciones:

```kotlin
fun drive(vehicle: Drivable)
fun sail(vehicle: Sailable)
```

y utiliza el mismo objeto en ambas.

---

# Nivel 10 — Herencia + interfaces

## Ejercicio 20 — Dispositivos electrónicos

Crea:

```kotlin
open class Device(
    val brand: String
)
```

y las interfaces:

```kotlin
interface Chargeable {
    fun charge()
}

interface Connectable {
    fun connect()
}
```

Crea:

```text
Smartphone
Tablet
Laptop
```

Todos heredan de `Device`.

Algunos implementan `Chargeable`, otros `Connectable` y algunos ambas interfaces.

### Objetivo

Diseñar una pequeña jerarquía combinando:

- herencia de clases;
- interfaces;
- polimorfismo.

---

# Nivel 11 — `final`

## Ejercicio 21 — Método que no puede sobrescribirse

Crea:

```kotlin
open class Person(
    val name: String
) {
    fun breathe() {
        println("Breathing...")
    }

    open fun speak() {
        println("Speaking...")
    }
}
```

Crea una clase derivada.

Intenta sobrescribir:

```kotlin
breathe()
```

y:

```kotlin
speak()
```

Observa qué ocurre.

### Pregunta

¿Por qué uno de los métodos puede sobrescribirse y el otro no?

---

## Ejercicio 22 — Clase que no puede heredarse

Crea una clase:

```kotlin
class DatabaseConnection
```

Intenta crear una clase que herede de ella.

Después investiga cómo conseguir que una clase sea explícitamente no heredable aunque sus miembros puedan tener otras características.

---

# Nivel 12 — Herencia y `protected`

## Ejercicio 23 — Cuenta bancaria

Crea:

```kotlin
open class BankAccount(
    val owner: String,
    protected var balance: Double
)
```

Añade métodos para:

```text
deposit()
withdraw()
```

Crea una clase derivada:

```text
SavingsAccount
```

que pueda acceder directamente a `balance`.

Desde `main`, intenta acceder directamente a `balance`.

### Objetivo

Comprender la diferencia entre:

```text
public
protected
```

---

# Nivel 13 — `sealed class`

## Ejercicio 24 — Resultados de una operación

Crea:

```kotlin
sealed class Result
```

con:

```text
Success
Error
Loading
```

Haz que `Success` almacene un resultado y `Error` un mensaje.

Por ejemplo:

```kotlin
sealed class Result {
    data class Success(val value: Int) : Result()
    data class Error(val message: String) : Result()
    data object Loading : Result()
}
```

Crea una función:

```kotlin
fun printResult(result: Result)
```

que utilice `when`.

No debe ser necesario utilizar `else`.

### Objetivo

Comprender la relación entre:

- herencia;
- `sealed class`;
- `when` exhaustivo.

---

## Ejercicio 25 — Estados de una pantalla

Crea:

```kotlin
sealed class ScreenState
```

con:

- `Loading`
- `Success`
- `Error`
- `Empty`

`Success` debe contener una lista de datos.

`Error` debe contener un mensaje.

Crea una función que reciba `ScreenState` y muestre por consola el contenido apropiado.

---

# Nivel 14 — Jerarquías de clases

## Ejercicio 26 — Sistema de empleados

Diseña la siguiente jerarquía:

```text
Employee
├── Manager
├── Developer
│   ├── BackendDeveloper
│   └── FrontendDeveloper
└── Designer
```

`Employee` debe ser abstracta.

Cada empleado tendrá:

```text
name
salary
```

y deberá implementar:

```kotlin
abstract fun work()
```

Los distintos tipos deberán proporcionar comportamientos diferentes.

### Objetivo

Practicar varios niveles de herencia.

---

# Nivel 15 — Reto de polimorfismo

## Ejercicio 27 — Sistema de notificaciones

Crea una clase abstracta:

```kotlin
abstract class Notification {
    abstract fun send(message: String)
}
```

Crea:

- `EmailNotification`
- `SmsNotification`
- `PushNotification`

Después crea:

```kotlin
fun notify(
    notification: Notification,
    message: String
)
```

La función debe funcionar con cualquier tipo de notificación.

### Restricción

No utilices:

```kotlin
is
when
```

para decidir qué tipo de notificación es.

---

# Nivel 16 — Reto avanzado

## Ejercicio 28 — Sistema de figuras

Diseña una jerarquía completa:

```text
Shape
├── Circle
├── Rectangle
├── Square
└── Triangle
```

`Shape` debe ser abstracta.

Debe proporcionar:

```kotlin
abstract fun area(): Double
abstract fun perimeter(): Double
```

Crea una lista:

```kotlin
val shapes: List<Shape>
```

que contenga diferentes figuras.

Calcula:

- área total;
- perímetro total;
- figura con mayor área;
- figura con mayor perímetro.

### Restricción

El código que recorra la lista no debe conocer los tipos concretos de las figuras.

---

# Nivel 17 — Reto avanzado con interfaces

## Ejercicio 29 — Sistema de dispositivos

Crea:

```kotlin
interface Switchable {
    fun turnOn()
    fun turnOff()
}
```

```kotlin
interface Adjustable {
    fun increase()
    fun decrease()
}
```

Diseña las siguientes clases:

```text
Light
Fan
Television
```

Algunos dispositivos podrán implementar ambas interfaces.

Después crea una lista de:

```kotlin
List<Switchable>
```

y controla todos los dispositivos que puedan encenderse.

Crea también:

```kotlin
List<Adjustable>
```

para controlar los dispositivos cuyo nivel pueda modificarse.

### Objetivo

Comprender que una misma clase puede ser tratada mediante diferentes abstracciones.

---

# Nivel 18 — Reto final: sistema de videojuegos

## Ejercicio 30 — Personajes de un videojuego

Diseña una jerarquía para representar personajes:

```text
Character
├── Warrior
├── Mage
├── Archer
└── Healer
```

La clase `Character` debe contener:

```text
name
health
level
```

y declarar:

```kotlin
abstract fun attack()
```

Añade una interfaz:

```kotlin
interface Healable {
    fun heal(target: Character)
}
```

Haz que `Healer` implemente esta interfaz.

Añade otra:

```kotlin
interface Defendable {
    fun defend()
}
```

Haz que algunos personajes puedan defenderse.

Después crea un grupo:

```kotlin
val party: List<Character>
```

que contenga diferentes tipos de personajes.

El programa deberá permitir:

- atacar;
- defender;
- curar;
- mostrar información de los personajes.

### Restricciones

El código que trabaje con `party` debe utilizar polimorfismo.

Evita comprobar constantemente el tipo concreto mediante `is`.

---

# Reto final avanzado — Sistema de archivos

## Ejercicio 31 — Sistema de archivos

Diseña una jerarquía que represente un sistema de archivos:

```text
FileSystemEntry
├── File
│   ├── TextFile
│   ├── ImageFile
│   └── VideoFile
└── Directory
```

`FileSystemEntry` debe ser una clase abstracta con:

```text
name
size
```

y:

```kotlin
abstract fun open()
```

`Directory` deberá contener una colección de:

```kotlin
List<FileSystemEntry>
```

y permitir añadir archivos y directorios.

Implementa:

```kotlin
fun totalSize(): Long
```

de manera que un directorio calcule recursivamente el tamaño de todos sus contenidos.

Por ejemplo:

```text
Documents/
    file1.txt       1000 bytes
    file2.txt       2000 bytes
    Images/
        photo.jpg   5000 bytes
```

El tamaño de `Documents` deberá ser:

```text
8000 bytes
```

### Objetivos

Este ejercicio combina:

- clases abstractas;
- herencia;
- polimorfismo;
- composición;
- recursividad;
- colecciones;
- métodos sobrescritos.

---

# Reto experto — Diseñar una jerarquía correctamente

## Ejercicio 32 — Transporte

Diseña una jerarquía para representar medios de transporte.

Debes decidir tú:

1. Qué clase o clases deben ser abstractas.
2. Qué métodos deben ser abstractos.
3. Qué comportamiento debe compartirse.
4. Qué comportamiento debe implementarse mediante interfaces.

Como mínimo deben existir:

```text
Car
Motorcycle
Bicycle
Bus
Train
Airplane
Boat
```

El sistema debe permitir preguntar a cualquier transporte:

```kotlin
transport.move()
```

pero también debe permitir representar capacidades que no todos comparten:

```text
Flyable
Sailable
Motorized
```

Por ejemplo:

```kotlin
interface Flyable {
    fun fly()
}

interface Sailable {
    fun sail()
}
```

Un avión podría ser:

```text
Transport
    ↓
Airplane
    ↓
Flyable
```

mientras que un barco podría ser:

```text
Transport
    ↓
Boat
    ↓
Sailable
```

### Objetivo

El alumno debe decidir la arquitectura de la jerarquía en lugar de limitarse a implementarla siguiendo un esquema proporcionado.

---

# Conceptos que se practican

| Nivel | Conceptos |
|---|---|
| 1 | Herencia básica |
| 2 | `open` |
| 3 | `override` |
| 4 | Constructores |
| 5 | `super` |
| 6 | Propiedades heredadas |
| 7 | Polimorfismo |
| 8 | Clases abstractas |
| 9 | Métodos abstractos |
| 10 | Interfaces |
| 11 | Implementación de varias interfaces |
| 12 | `final` |
| 13 | `protected` |
| 14 | `sealed class` |
| 15 | Jerarquías multinivel |
| 16 | Polimorfismo avanzado |
| 17 | Composición + herencia |
| 18 | Diseño de jerarquías |

# Objetivo final

Al terminar los ejercicios, el alumno debería saber distinguir entre:

### Herencia

```kotlin
class Dog : Animal()
```

**"Dog es un Animal".**

### Clase abstracta

```kotlin
abstract class Animal {
    abstract fun makeSound()
}
```

Define una abstracción que no se puede instanciar directamente.

### Interfaz

```kotlin
interface Flyable {
    fun fly()
}
```

Define una capacidad o contrato que pueden compartir clases que no necesariamente pertenecen a la misma jerarquía.

### Polimorfismo

```kotlin
val animals: List<Animal> = listOf(
    Dog(),
    Cat(),
    Cow()
)

animals.forEach {
    it.makeSound()
}
```

El código trabaja con la abstracción `Animal` sin tener que conocer el tipo concreto de cada objeto.

### `sealed class`

```kotlin
sealed class Result {
    data class Success(val value: Int) : Result()
    data class Error(val message: String) : Result()
    data object Loading : Result()
}
```

Permite representar una jerarquía cerrada de tipos, especialmente útil cuando todas las posibilidades deben estar contempladas mediante un `when` exhaustivo.