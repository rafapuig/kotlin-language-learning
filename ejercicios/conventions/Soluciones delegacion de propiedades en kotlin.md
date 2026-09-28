# Soluciones: Delegación de propiedades en Kotlin

Solucionario completo de los ejercicios de delegación de propiedades.

---

## 1. Propiedad inicializada de forma diferida con `lazy`

```kotlin
class User(
    val name: String,
    val email: String
) {
    val description: String by lazy {
        println("Calculando descripción...")
        "$name <$email>"
    }
}

fun main() {
    val user = User("Ana", "ana@example.com")

    println(user.description)
    println(user.description)
}
```

La expresión de `lazy` se ejecuta una sola vez.

---

## 2. `lazy` con una operación costosa

```kotlin
class Configuration {
    val databaseUrl: String by lazy {
        Thread.sleep(2000)
        "jdbc:mysql://localhost:3306/app"
    }
}

fun main() {
    println("Creando configuración...")
    val configuration = Configuration()
    println("Configuración creada")

    println("Consultando URL...")
    println(configuration.databaseUrl)

    println("Consultando URL de nuevo...")
    println(configuration.databaseUrl)
}
```

---

## 3. `Delegates.observable`

```kotlin
import kotlin.properties.Delegates

class Person(name: String) {
    var name: String by Delegates.observable(name) { _, oldValue, newValue ->
        println("El nombre ha cambiado de $oldValue a $newValue")
    }
}

fun main() {
    val person = Person("Ana")

    person.name = "Laura"
    person.name = "Carlos"
    person.name = "Marta"
}
```

---

## 4. Observar cambios en una propiedad numérica

```kotlin
import kotlin.properties.Delegates

class Player(score: Int) {
    var score: Int by Delegates.observable(score) { _, oldValue, newValue ->
        println("Puntuación: $oldValue -> $newValue")

        if (newValue >= 100) {
            println("¡Puntuación máxima alcanzada!")
        }
    }
}

fun main() {
    val player = Player(0)

    player.score = 10
    player.score = 50
    player.score = 100
}
```

---

## 5. `Delegates.vetoable`

```kotlin
import kotlin.properties.Delegates

class BankAccount(balance: Double) {
    var balance: Double by Delegates.vetoable(balance) { _, _, newValue ->
        newValue >= 0
    }
}

fun main() {
    val account = BankAccount(500.0)

    account.balance = 200.0
    account.balance = -100.0

    println(account.balance)
}
```

La asignación de `-100.0` es rechazada porque el bloque devuelve `false`.

---

## 6. Controlar una edad

```kotlin
import kotlin.properties.Delegates

class Person(age: Int) {
    var age: Int by Delegates.vetoable(age) { _, _, newValue ->
        newValue in 0..120
    }
}

fun main() {
    val person = Person(25)

    person.age = 40
    person.age = -5
    person.age = 150

    println(person.age)
}
```

---

## 7. Crear un delegado que escriba los cambios

```kotlin
import kotlin.reflect.KProperty

class LoggingDelegate<T>(
    private var value: T
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        println("Asignando valor: $newValue")
        value = newValue
    }
}

class Product {
    var price: Double by LoggingDelegate(0.0)
}

fun main() {
    val product = Product()

    product.price = 19.99
    println(product.price)
}
```

---

## 8. Delegado genérico para valores

El delegado del ejercicio anterior ya es genérico, por lo que puede reutilizarse con cualquier tipo:

```kotlin
import kotlin.reflect.KProperty

class LoggingDelegate<T>(
    private var value: T
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        println("${property.name}: $value -> $newValue")
        value = newValue
    }
}

class Person {
    var name: String by LoggingDelegate("")
    var age: Int by LoggingDelegate(0)
    var active: Boolean by LoggingDelegate(false)
}

fun main() {
    val person = Person()

    person.name = "Ana"
    person.age = 25
    person.active = true
}
```

---

## 9. Delegado que almacena el valor

```kotlin
import kotlin.reflect.KProperty

class StoredValue<T>(
    private var value: T
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        value = newValue
    }
}

class Person {
    var name: String by StoredValue("")
    var age: Int by StoredValue(0)
}

fun main() {
    val person = Person()

    person.name = "Ana"
    person.age = 30

    println(person.name)
    println(person.age)
}
```

Cada instancia del delegado mantiene su propio valor.

---

## 10. Delegado de solo lectura

```kotlin
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ConstantValue<T>(
    private val value: T
) : ReadOnlyProperty<Any?, T> {

    override operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T {
        return value
    }
}

class Game {
    val title: String by ConstantValue("Kotlin Game")
}

fun main() {
    val game = Game()

    println(game.title)
}
```

`title` es una propiedad `val`, por lo que no necesita `setValue`.

---

## 11. Delegado para valores por defecto

```kotlin
import kotlin.reflect.KProperty

class DefaultValue<T>(
    private var value: T
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        value = newValue
    }
}

class Configuration {
    var timeout: Int by DefaultValue(30)
    var host: String by DefaultValue("localhost")
}

fun main() {
    val configuration = Configuration()

    println(configuration.timeout)
    println(configuration.host)

    configuration.timeout = 60
    configuration.host = "server"

    println(configuration.timeout)
    println(configuration.host)
}
```

---

## 12. Delegado para propiedades restringidas

```kotlin
import kotlin.reflect.KProperty

class ValidatedValue<T>(
    private var value: T,
    private val validator: (T) -> Boolean
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        if (validator(newValue)) {
            value = newValue
        }
    }
}

class Person {
    var age: Int by ValidatedValue(0) { it in 0..120 }
}

fun main() {
    val person = Person()

    person.age = 25
    person.age = 200

    println(person.age)
}
```

Una variante con mensaje:

```kotlin
class ValidatedValue<T>(
    private var value: T,
    private val errorMessage: String,
    private val validator: (T) -> Boolean
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        if (validator(newValue)) {
            value = newValue
        } else {
            println(errorMessage)
        }
    }
}
```

---

## 13. Delegado para propiedades no vacías

```kotlin
import kotlin.reflect.KProperty

class NonEmptyString(
    private var value: String = ""
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: String
    ) {
        require(newValue.isNotBlank()) {
            "${property.name} no puede estar vacío"
        }

        value = newValue
    }
}

class User {
    var username: String by NonEmptyString()
}

fun main() {
    val user = User()

    user.username = "rafa"
    println(user.username)

    // Lanza IllegalArgumentException
    // user.username = "   "
}
```

---

## 14. Delegado para convertir automáticamente valores

```kotlin
import kotlin.reflect.KProperty

class StringToIntDelegate(
    private var value: String
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): Int {
        return value.toInt()
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: Int
    ) {
        value = newValue.toString()
    }
}

class Configuration {
    var port: Int by StringToIntDelegate("8080")
}

fun main() {
    val configuration = Configuration()

    println(configuration.port)

    configuration.port = 9090

    println(configuration.port)
}
```

Internamente se almacena un `String`, mientras que la propiedad expuesta es un `Int`.

---

## 15. Delegado para limitar valores

```kotlin
import kotlin.reflect.KProperty

class RangeDelegate(
    private val minimum: Int,
    private val maximum: Int,
    private var value: Int
) {
    init {
        require(value in minimum..maximum)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: Int
    ) {
        if (newValue in minimum..maximum) {
            value = newValue
        }
    }
}

class Volume {
    var level: Int by RangeDelegate(0, 100, 50)
}

fun main() {
    val volume = Volume()

    volume.level = 75
    volume.level = 150

    println(volume.level)
}
```

Una versión genérica para cualquier tipo comparable puede hacerse con `Comparable<T>`, aunque para un ejercicio inicial la versión específica para `Int` resulta más sencilla.

---

## 16. Delegado utilizando `ReadWriteProperty`

```kotlin
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class RangeDelegate(
    private val minimum: Int,
    private val maximum: Int,
    initialValue: Int
) : ReadWriteProperty<Any?, Int> {

    private var value = initialValue

    init {
        require(initialValue in minimum..maximum)
    }

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): Int {
        return value
    }

    override fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: Int
    ) {
        if (newValue in minimum..maximum) {
            value = newValue
        }
    }
}

class Volume {
    var level: Int by RangeDelegate(0, 100, 50)
}
```

La interfaz `ReadWriteProperty` permite expresar directamente que el delegado proporciona lectura y escritura.

---

## 17. Delegado para valores calculados

```kotlin
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ComputedValue<T>(
    private val calculation: () -> T
) : ReadOnlyProperty<Any?, T> {

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T {
        return calculation()
    }
}

class Rectangle(
    val width: Double,
    val height: Double
) {
    val area: Double by ComputedValue {
        width * height
    }

    val perimeter: Double by ComputedValue {
        2 * (width + height)
    }
}

fun main() {
    val rectangle = Rectangle(10.0, 5.0)

    println(rectangle.area)
    println(rectangle.perimeter)
}
```

En este caso el cálculo se realiza cada vez que se consulta la propiedad.

---

## 18. Delegado que memoriza el resultado

```kotlin
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class MemoizedValue<T>(
    private val calculation: () -> T
) : ReadOnlyProperty<Any?, T> {

    private var initialized = false
    private lateinit var value: T

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T {
        if (!initialized) {
            value = calculation()
            initialized = true
        }

        return value
    }
}

class Example {
    val expensiveCalculation: Int by MemoizedValue {
        println("Calculando...")
        42
    }
}

fun main() {
    val example = Example()

    println(example.expensiveCalculation)
    println(example.expensiveCalculation)
}
```

Para tipos no anulables, esta implementación reproduce la idea básica de `lazy`.

Una alternativa más general consiste en utilizar un `Any?` como almacenamiento y un booleano separado para indicar si ya se ha calculado.

---

## 19. Delegado con `provideDelegate`

```kotlin
import kotlin.reflect.KProperty

class NameCheckedDelegate<T>(
    private val value: T
) {
    operator fun provideDelegate(
        thisRef: Any?,
        property: KProperty<*>
    ): NameCheckedDelegate<T> {
        println("Creando delegado para: ${property.name}")

        require(property.name != "forbidden") {
            "El nombre de propiedad 'forbidden' no está permitido"
        }

        return this
    }

    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T {
        return value
    }
}

class User {
    val username: String by NameCheckedDelegate("rafa")
    val password: String by NameCheckedDelegate("1234")
}

fun main() {
    val user = User()

    println(user.username)
    println(user.password)
}
```

`provideDelegate` se ejecuta cuando se establece la delegación, antes de que se utilice la propiedad.

---

## 20. Delegado para propiedades de configuración

```kotlin
import kotlin.reflect.KProperty

class ConfigValue<T>(
    private var value: T
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T {
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        println("${property.name}: $value -> $newValue")
        value = newValue
    }
}

class AppConfig {
    var host: String by ConfigValue("localhost")
    var port: Int by ConfigValue(8080)
    var debug: Boolean by ConfigValue(false)
}

fun main() {
    val config = AppConfig()

    println(config.host)
    println(config.port)
    println(config.debug)

    config.host = "server"
    config.port = 9090
    config.debug = true
}
```

---

# Ejercicios de aplicación

## 21. `UserSettings`

```kotlin
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class ValidatedValue<T>(
    private var value: T,
    private val validator: (T) -> Boolean
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T = value

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        if (validator(newValue)) {
            value = newValue
        } else {
            println("Valor no válido para ${property.name}: $newValue")
        }
    }
}

class UserSettings {
    var username: String by ValidatedValue("") {
        it.isNotBlank()
    }

    var language: String by ValidatedValue("es") {
        it in setOf("es", "en", "fr")
    }

    var fontSize: Int by ValidatedValue(16) {
        it in 8..32
    }

    var darkMode: Boolean by Delegates.observable(false) { _, oldValue, newValue ->
        println("darkMode: $oldValue -> $newValue")
    }
}

fun main() {
    val settings = UserSettings()

    settings.username = "rafa"
    settings.language = "en"
    settings.fontSize = 20
    settings.darkMode = true
}
```

---

## 22. Sistema de configuración de un videojuego

```kotlin
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class ValidatedValue<T>(
    private var value: T,
    private val validator: (T) -> Boolean
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T = value

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        if (validator(newValue)) {
            value = newValue
        } else {
            println("Valor no válido para ${property.name}")
        }
    }
}

class GameSettings {
    var resolution: String by ValidatedValue("1920x1080") {
        it.isNotBlank()
    }

    var volume: Int by ValidatedValue(50) {
        it in 0..100
    }

    var difficulty: String by ValidatedValue("NORMAL") {
        it in setOf("EASY", "NORMAL", "HARD")
    }

    var fullscreen: Boolean by Delegates.observable(false) { _, oldValue, newValue ->
        println("fullscreen: $oldValue -> $newValue")
    }
}
```

---

## 23. Sistema de propiedades observables

```kotlin
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class ValidatedValue<T>(
    private var value: T,
    private val validator: (T) -> Boolean
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T = value

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        if (validator(newValue)) {
            value = newValue
        }
    }
}

class Player(
    name: String,
    health: Int = 100,
    score: Int = 0,
    level: Int = 1
) {
    var name: String by ValidatedValue(name) {
        it.isNotBlank()
    }

    var health: Int by ValidatedValue(health) {
        it in 0..100
    }

    var score: Int by Delegates.vetoable(score) { _, oldValue, newValue ->
        newValue >= oldValue
    }

    var level: Int by Delegates.observable(level) { _, oldValue, newValue ->
        if (newValue > oldValue) {
            println("Player level increased: $oldValue -> $newValue")
        }
    }
}

fun main() {
    val player = Player("Rafa")

    player.health = 80
    player.score = 100
    player.score = 50       // Rechazado
    player.level = 2
    player.level = 3
}
```

---

## 24. Implementar tu propio `lazy`

```kotlin
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class MyLazy<T>(
    private val initializer: () -> T
) : ReadOnlyProperty<Any?, T> {

    private var initialized = false
    private var value: T? = null

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T {
        if (!initialized) {
            value = initializer()
            initialized = true
        }

        @Suppress("UNCHECKED_CAST")
        return value as T
    }
}

class Example {
    val number: Int by MyLazy {
        println("Calculando...")
        100
    }
}

fun main() {
    val example = Example()

    println(example.number)
    println(example.number)
}
```

Salida:

```text
Calculando...
100
100
```

---

## 25. Proyecto final: sistema de propiedades delegadas

```kotlin
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class ValidatedValue<T>(
    private var value: T,
    private val validator: (T) -> Boolean
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T = value

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        if (validator(newValue)) {
            value = newValue
        } else {
            println("Valor no válido para ${property.name}: $newValue")
        }
    }
}

class User(
    username: String,
    email: String,
    age: Int,
    role: String
) {
    var username: String by ValidatedValue(username) {
        it.isNotBlank()
    }

    var email: String by ValidatedValue(email) {
        '@' in it
    }

    var age: Int by ValidatedValue(age) {
        it in 0..120
    }

    var role: String by ValidatedValue(role) {
        it in setOf("USER", "ADMIN", "MODERATOR")
    }

    var active: Boolean by Delegates.observable(false) { _, oldValue, newValue ->
        println("active: $oldValue -> $newValue")
    }

    val description: String by lazy {
        "$username <$email>, $age años, role=$role"
    }
}

fun main() {
    val user = User(
        username = "rafa",
        email = "rafa@example.com",
        age = 40,
        role = "ADMIN"
    )

    user.active = true
    user.age = 45
    user.role = "USER"

    println(user.description)
}
```

---

# Reto final

## `Validated<T>`

```kotlin
import kotlin.reflect.KProperty

class Validated<T>(
    private var value: T,
    private val validator: (T) -> Boolean
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T = value

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        println("Changing ${property.name}: $value -> $newValue")

        if (validator(newValue)) {
            value = newValue
        } else {
            println("Invalid value for ${property.name}")
        }
    }
}

class Person {
    var age: Int by Validated(0) {
        it in 0..120
    }

    var username: String by Validated("") {
        it.isNotBlank()
    }
}

fun main() {
    val person = Person()

    person.age = 20
    person.age = 30
    person.age = 150

    person.username = "rafa"
    person.username = "   "
}
```

---

## Variante con mensaje de error personalizado

```kotlin
import kotlin.reflect.KProperty

class Validated<T>(
    private var value: T,
    private val errorMessage: (T) -> String,
    private val validator: (T) -> Boolean
) {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): T = value

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        newValue: T
    ) {
        if (validator(newValue)) {
            value = newValue
        } else {
            println(errorMessage(newValue))
        }
    }
}

class Person {
    var age: Int by Validated(
        0,
        { value -> "Edad no válida: $value" }
    ) {
        it in 0..120
    }

    var username: String by Validated(
        "",
        { value -> "Nombre de usuario no válido: '$value'" }
    ) {
        it.isNotBlank()
    }
}

fun main() {
    val person = Person()

    person.age = 25
    person.age = 150

    person.username = "rafa"
    person.username = ""
}
```

---

# Conceptos clave del solucionario

Los principales mecanismos utilizados son:

| Mecanismo | Uso |
|---|---|
| `by lazy { }` | Inicialización diferida |
| `Delegates.observable` | Reaccionar ante cambios |
| `Delegates.vetoable` | Aceptar o rechazar cambios |
| `getValue` | Lectura de una propiedad delegada |
| `setValue` | Escritura de una propiedad delegada |
| `ReadOnlyProperty` | Delegados para propiedades `val` |
| `ReadWriteProperty` | Delegados para propiedades `var` |
| `KProperty` | Información sobre la propiedad delegada |
| `provideDelegate` | Intervenir durante la creación de la delegación |
| Delegados genéricos | Reutilizar el mismo delegado con diferentes tipos |

La idea fundamental es que:

```kotlin
var value: Int by Delegate()
```

hace que las operaciones de lectura y escritura de `value` sean gestionadas por el objeto `Delegate`.
