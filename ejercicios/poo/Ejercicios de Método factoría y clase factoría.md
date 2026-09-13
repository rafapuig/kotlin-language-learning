# Ejercicios de Kotlin — Método factoría y clase factoría

## Objetivos

Con estos ejercicios se pretende practicar:

- La encapsulación de la creación de objetos.
- El uso de **métodos factoría**.
- La creación de objetos sin utilizar directamente sus constructores desde el código cliente.
- La devolución de diferentes implementaciones a través de un tipo común.
- El uso de `companion object` como factoría.
- La creación de **clases factoría**.
- La aplicación de factorías junto con interfaces y clases abstractas.
- La separación entre el código que **utiliza** un objeto y el código que **decide cómo crearlo**.
- El uso de factorías para centralizar validaciones y decisiones de creación.

---

# Parte 1 — Métodos factoría sencillos

## Ejercicio 1 — Crear una persona

Define una clase:

```kotlin
class Person(
    val name: String,
    val age: Int
)
```

Crea una función:

```kotlin
fun createPerson(name: String, age: Int): Person
```

que actúe como método factoría.

El programa cliente deberá utilizar:

```kotlin
val person = createPerson("Alice", 25)
```

en lugar de:

```kotlin
val person = Person("Alice", 25)
```

### Objetivo

Comprender que una función puede encapsular la creación de un objeto.

---

## Ejercicio 2 — Crear usuarios a partir de un email

Define una clase:

```kotlin
class User(
    val username: String,
    val email: String
)
```

Crea una función factoría:

```kotlin
fun createUser(email: String): User
```

que obtenga el `username` a partir de la parte anterior a `@`.

Por ejemplo:

```text
rafa@example.com
```

debe producir:

```text
username = rafa
email = rafa@example.com
```

El código cliente no debe conocer cómo se calcula el nombre de usuario.

---

## Ejercicio 3 — Método factoría con validación

Define:

```kotlin
class Product(
    val name: String,
    val price: Double
)
```

Crea:

```kotlin
fun createProduct(name: String, price: Double): Product?
```

La factoría deberá devolver:

- un `Product` si el precio es mayor que cero;
- `null` si el precio no es válido.

Por ejemplo:

```kotlin
val product = createProduct("Keyboard", 49.99)
```

### Ampliación

Haz que también se compruebe que el nombre no esté vacío.

---

# Parte 2 — Factoría que decide qué clase crear

## Ejercicio 4 — Animales

Define una interfaz:

```kotlin
interface Animal {
    fun makeSound()
}
```

Implementa:

```kotlin
class Dog : Animal
class Cat : Animal
class Cow : Animal
```

Crea una función:

```kotlin
fun createAnimal(type: String): Animal
```

que devuelva el animal correspondiente.

Por ejemplo:

```kotlin
val animal = createAnimal("dog")
animal.makeSound()
```

El código cliente debe trabajar únicamente con `Animal`.

### Objetivo

Introducir una de las principales ventajas de una factoría:

> El cliente solicita un objeto sin tener que conocer qué clase concreta debe instanciar.

---

## Ejercicio 5 — Formas geométricas

Define:

```kotlin
interface Shape {
    fun area(): Double
}
```

Implementa:

```kotlin
class Circle(...)
class Rectangle(...)
class Square(...)
```

Crea:

```kotlin
fun createShape(type: String, size: Double): Shape
```

La función deberá decidir qué clase concreta crear.

Ejemplo:

```kotlin
val shape = createShape("circle", 10.0)

println(shape.area())
```

### Ampliación

Utiliza diferentes parámetros dependiendo del tipo de figura.

Por ejemplo:

```text
circle    -> radius
rectangle -> width + height
square    -> side
```

---

## Ejercicio 6 — Formas de pago

Define:

```kotlin
interface PaymentMethod {
    fun pay(amount: Double)
}
```

Implementa:

- `CreditCardPayment`
- `PayPalPayment`
- `BankTransferPayment`

Crea:

```kotlin
fun createPaymentMethod(type: String): PaymentMethod
```

El programa deberá poder hacer:

```kotlin
val payment = createPaymentMethod("paypal")

payment.pay(100.0)
```

El código que realiza el pago no debe saber qué clase concreta ha sido creada.

---

# Parte 3 — Método factoría mediante `companion object`

## Ejercicio 7 — Usuario

Modifica el ejercicio de `User` para que la factoría forme parte de la propia clase.

La utilización deberá ser:

```kotlin
val user = User.create("rafa@example.com")
```

Utiliza un:

```kotlin
companion object
```

para implementar el método factoría.

### Objetivo

Aprender el patrón:

```kotlin
class User(...) {

    companion object {
        fun create(...): User {
            ...
        }
    }
}
```

---

## Ejercicio 8 — Producto a partir de texto

Define:

```kotlin
class Product(
    val name: String,
    val price: Double
)
```

Añade:

```kotlin
companion object {
    fun from(text: String): Product
}
```

El texto tendrá el formato:

```text
Keyboard;49.99
```

La factoría deberá convertirlo en:

```kotlin
Product("Keyboard", 49.99)
```

El cliente solamente tendrá que hacer:

```kotlin
val product = Product.from("Keyboard;49.99")
```

---

## Ejercicio 9 — Fecha

Define una clase:

```kotlin
class MyDate(
    val day: Int,
    val month: Int,
    val year: Int
)
```

Crea diferentes métodos factoría:

```kotlin
MyDate.of(day, month, year)
MyDate.from(text)
MyDate.today()
```

Por ejemplo:

```kotlin
val date1 = MyDate.of(15, 9, 2026)
val date2 = MyDate.from("15/09/2026")
val date3 = MyDate.today()
```

### Objetivo

Observar que una misma clase puede proporcionar diferentes formas semánticas de creación.

---

# Parte 4 — Clase factoría

## Ejercicio 10 — Factoría de animales

Crea:

```kotlin
class AnimalFactory
```

con un método:

```kotlin
fun create(type: String): Animal
```

El cliente deberá utilizar:

```kotlin
val factory = AnimalFactory()

val animal = factory.create("dog")
```

### Objetivo

Diferenciar:

```kotlin
createAnimal(...)
```

de:

```kotlin
AnimalFactory().create(...)
```

En el primer caso tenemos una **función/método factoría** y en el segundo una **clase dedicada a la creación de objetos**.

---

## Ejercicio 11 — Factoría de vehículos

Define:

```kotlin
interface Vehicle {
    fun start()
}
```

Implementa:

- `Car`
- `Motorcycle`
- `Truck`

Crea:

```kotlin
class VehicleFactory {
    fun create(type: String): Vehicle
}
```

El programa principal deberá utilizar exclusivamente:

```kotlin
val factory = VehicleFactory()

val vehicle = factory.create("car")
vehicle.start()
```

No deberá aparecer ningún constructor concreto (`Car`, `Motorcycle`, `Truck`) en el código cliente.

---

## Ejercicio 12 — Factoría con parámetros

Define:

```kotlin
interface Weapon {
    fun attack()
}
```

Implementa:

```kotlin
class Sword(val damage: Int) : Weapon
class Bow(val arrows: Int) : Weapon
class Wand(val magicPower: Int) : Weapon
```

Crea:

```kotlin
class WeaponFactory {

    fun create(
        type: String,
        power: Int
    ): Weapon
}
```

La factoría decidirá qué clase crear y cómo interpretar `power`.

Por ejemplo:

```kotlin
val weapon = factory.create("sword", 25)
```

debe producir conceptualmente:

```kotlin
Sword(25)
```

---

# Parte 5 — Factorías con lógica de creación

## Ejercicio 13 — Usuarios según su rol

Define:

```kotlin
interface User {
    fun getPermissions(): List<String>
}
```

Implementa:

```kotlin
class AdminUser : User
class ManagerUser : User
class NormalUser : User
```

Crea:

```kotlin
class UserFactory {

    fun create(role: String): User
}
```

Cada tipo de usuario deberá tener diferentes permisos.

### Objetivo

La factoría no solamente selecciona una clase: también encapsula la lógica necesaria para configurar el objeto.

---

## Ejercicio 14 — Notificaciones

Define:

```kotlin
interface Notification {
    fun send(message: String)
}
```

Implementa:

- `EmailNotification`
- `SmsNotification`
- `PushNotification`

Crea:

```kotlin
class NotificationFactory {

    fun create(type: String): Notification
}
```

El cliente deberá poder escribir:

```kotlin
val notification = factory.create("email")

notification.send("Hello")
```

### Ampliación

Haz que la factoría reciba también la información necesaria para crear cada tipo de notificación.

---

## Ejercicio 15 — Documentos

Define:

```kotlin
interface Document {
    fun open()
}
```

Implementa:

- `PdfDocument`
- `WordDocument`
- `TextDocument`

Crea:

```kotlin
class DocumentFactory {

    fun create(fileName: String): Document
}
```

La factoría deberá determinar el tipo de documento a partir de su extensión.

Por ejemplo:

```kotlin
factory.create("report.pdf")
```

deberá crear un `PdfDocument`.

El cliente no deberá analizar la extensión.

---

# Parte 6 — Factoría y clases abstractas

## Ejercicio 16 — Personajes de un videojuego

Define:

```kotlin
abstract class Character(
    val name: String
) {
    abstract fun attack()
}
```

Implementa:

- `Warrior`
- `Mage`
- `Archer`

Crea:

```kotlin
class CharacterFactory {

    fun create(
        type: String,
        name: String
    ): Character
}
```

El programa deberá poder hacer:

```kotlin
val character = factory.create("mage", "Gandalf")

character.attack()
```

### Objetivo

Combinar:

- herencia;
- clases abstractas;
- polimorfismo;
- factorías.

---

## Ejercicio 17 — Enemigos

Define:

```kotlin
abstract class Enemy {
    abstract val health: Int
    abstract fun attack()
}
```

Implementa:

- `Goblin`
- `Orc`
- `Dragon`

Crea:

```kotlin
class EnemyFactory {

    fun create(level: Int): Enemy
}
```

La factoría decidirá qué enemigo crear dependiendo del nivel.

Por ejemplo:

```text
1-3   -> Goblin
4-7   -> Orc
8+    -> Dragon
```

### Ampliación

Haz que las características del enemigo también dependan del nivel.

---

# Parte 7 — Factoría y `enum class`

## Ejercicio 18 — Factoría de vehículos con enum

Define:

```kotlin
enum class VehicleType {
    CAR,
    MOTORCYCLE,
    TRUCK
}
```

La factoría deberá recibir:

```kotlin
fun create(type: VehicleType): Vehicle
```

en lugar de un `String`.

Ejemplo:

```kotlin
val vehicle = factory.create(VehicleType.CAR)
```

### Objetivo

Comparar esta solución con la versión basada en:

```kotlin
create("car")
```

y analizar las ventajas de utilizar un `enum class`.

---

## Ejercicio 19 — Factoría de operaciones

Define:

```kotlin
enum class OperationType {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE
}
```

Define:

```kotlin
interface Operation {
    fun execute(a: Double, b: Double): Double
}
```

Implementa una clase para cada operación.

Crea:

```kotlin
class OperationFactory {

    fun create(type: OperationType): Operation
}
```

El cliente deberá poder escribir:

```kotlin
val operation = factory.create(OperationType.MULTIPLY)

println(operation.execute(5.0, 3.0))
```

---

# Parte 8 — Factorías con métodos estáticos simulados

## Ejercicio 20 — `companion object` como factoría

Crea una jerarquía:

```kotlin
interface Parser
```

con:

```kotlin
class JsonParser : Parser
class XmlParser : Parser
class CsvParser : Parser
```

Crea una clase:

```kotlin
class ParserFactory {

    companion object {
        fun create(type: String): Parser
    }
}
```

El uso deberá ser:

```kotlin
val parser = ParserFactory.create("json")
```

### Objetivo

Comprender que `companion object` permite utilizar una clase factoría sin crear previamente una instancia de la factoría.

Comparar:

```kotlin
val factory = ParserFactory()
factory.create("json")
```

con:

```kotlin
ParserFactory.create("json")
```

---

# Parte 9 — Factoría con registro de clases

## Ejercicio 21 — Factoría extensible

Crea una interfaz:

```kotlin
interface Notification {
    fun send(message: String)
}
```

Implementa:

```kotlin
class EmailNotification : Notification
class SmsNotification : Notification
class PushNotification : Notification
```

Ahora crea una factoría que permita registrar nuevas formas de crear notificaciones.

Conceptualmente:

```kotlin
val factory = NotificationFactory()

factory.register("email") {
    EmailNotification()
}

factory.register("sms") {
    SmsNotification()
}

val notification = factory.create("email")
```

### Objetivo

Evitar que la factoría tenga que contener necesariamente un `when` con todos los tipos posibles.

### Ampliación

Utiliza una colección para almacenar las funciones constructoras.

---

# Parte 10 — Proyecto final

## Ejercicio 22 — Sistema de personajes

Desarrolla un pequeño sistema de creación de personajes para un videojuego.

Define:

```kotlin
abstract class Character(
    val name: String,
    val health: Int
) {
    abstract fun attack()
}
```

Crea al menos:

- `Warrior`
- `Mage`
- `Archer`
- `Healer`

Cada personaje tendrá características diferentes.

Crea:

```kotlin
class CharacterFactory {

    fun create(
        type: CharacterType,
        name: String
    ): Character
}
```

donde:

```kotlin
enum class CharacterType {
    WARRIOR,
    MAGE,
    ARCHER,
    HEALER
}
```

El programa deberá permitir:

```kotlin
val factory = CharacterFactory()

val characters = listOf(
    factory.create(CharacterType.WARRIOR, "Conan"),
    factory.create(CharacterType.MAGE, "Merlin"),
    factory.create(CharacterType.ARCHER, "Robin"),
    factory.create(CharacterType.HEALER, "Eir")
)
```

Posteriormente, recorrerá la colección utilizando polimorfismo:

```kotlin
for (character in characters) {
    character.attack()
}
```

### Restricción

El código cliente no podrá utilizar directamente:

```kotlin
Warrior(...)
Mage(...)
Archer(...)
Healer(...)
```

Toda la creación deberá pasar por `CharacterFactory`.

---

# Ejercicio 23 — Comparar las dos soluciones

Implementa el ejercicio anterior utilizando primero un **método factoría**:

```kotlin
fun createCharacter(
    type: CharacterType,
    name: String
): Character
```

y después utilizando una **clase factoría**:

```kotlin
class CharacterFactory {

    fun create(
        type: CharacterType,
        name: String
    ): Character
}
```

Compara ambas soluciones.

Explica:

1. ¿Dónde queda la lógica de creación?
2. ¿Qué ventajas tiene cada solución?
3. ¿Cuándo sería interesante utilizar una clase específica para la factoría?
4. ¿Qué ocurre si el número de tipos de objetos crece mucho?
5. ¿Qué solución resulta más fácil de extender?

---

# Reto final — Separar completamente creación y utilización

Diseña un sistema de almacenamiento de archivos.

Define:

```kotlin
interface Storage {
    fun save(fileName: String, content: String)
}
```

Implementa:

- `LocalStorage`
- `CloudStorage`
- `MemoryStorage`

Crea una factoría:

```kotlin
class StorageFactory {

    fun create(type: StorageType): Storage
}
```

con:

```kotlin
enum class StorageType {
    LOCAL,
    CLOUD,
    MEMORY
}
```

El programa cliente deberá funcionar de esta manera:

```kotlin
val factory = StorageFactory()

val storage = factory.create(StorageType.CLOUD)

storage.save(
    "document.txt",
    "Hello World"
)
```

### Condiciones

El código cliente:

- no puede conocer las clases concretas;
- no puede utilizar `when` para decidir el tipo de almacenamiento;
- no puede crear directamente `LocalStorage`, `CloudStorage` o `MemoryStorage`;
- solamente debe trabajar con la interfaz `Storage`.

### Reto adicional

Modifica la factoría para que sea posible añadir nuevos tipos de almacenamiento intentando minimizar los cambios necesarios en `StorageFactory`.

---

# Resumen conceptual

Al terminar los ejercicios, el alumno debería distinguir claramente estas tres situaciones:

### Creación directa

```kotlin
val car = Car()
```

El código cliente conoce la clase concreta.

### Método factoría

```kotlin
val car = createVehicle("car")
```

La creación está encapsulada en una función.

### Clase factoría

```kotlin
val factory = VehicleFactory()
val car = factory.create("car")
```

La responsabilidad de crear objetos se concentra en una clase especializada.

También debería entender una de las ideas fundamentales del patrón:

> **El código que utiliza un objeto no debería tener que conocer necesariamente cómo se crea ese objeto.**

Esto permite combinar factorías con interfaces, clases abstractas y polimorfismo para conseguir un código más desacoplado.