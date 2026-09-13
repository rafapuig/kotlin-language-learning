# Ejercicios de Kotlin — Companion objects y nested objects

## Objetivos

Con estos ejercicios se pretende practicar:

- La declaración de `companion object`.
- Propiedades y funciones dentro de un `companion object`.
- El acceso a miembros del `companion object` mediante el nombre de la clase.
- La utilización de `companion object` para crear métodos factoría.
- La implementación de interfaces mediante `companion object`.
- La diferencia entre `companion object` y un `object` normal.
- La declaración de `nested objects`.
- El acceso a nested objects.
- La organización de funcionalidad relacionada dentro de una clase.
- La diferencia entre `nested class` y `nested object`.
- La combinación de `companion object` y nested objects.
- La elección del mecanismo más apropiado según el problema.

---

# Parte 1 — Companion object básico

## Ejercicio 1 — Constante de una clase

Define:

```kotlin
class Circle(
    val radius: Double
) {
    companion object {
        const val PI = 3.141592653589793
    }
}
```

Utiliza la constante desde `main()`:

```kotlin
println(Circle.PI)
```

### Preguntas

1. ¿Por qué podemos acceder a `PI` sin crear un `Circle`?
2. ¿Por qué escribimos `Circle.PI`?
3. ¿Qué relación conceptual existe entre `PI` y la clase `Circle`?

---

## Ejercicio 2 — Función del companion object

Define:

```kotlin
class Temperature(
    val celsius: Double
) {
    companion object {
        fun fromFahrenheit(fahrenheit: Double): Temperature {
            return Temperature(
                (fahrenheit - 32) * 5 / 9
            )
        }
    }
}
```

Utiliza:

```kotlin
val temperature =
    Temperature.fromFahrenheit(86.0)

println(temperature.celsius)
```

### Objetivo

Comprender que un `companion object` puede contener funciones relacionadas con la creación o manipulación de objetos de su clase.

---

## Ejercicio 3 — Contador de instancias

Define una clase:

```kotlin
class Person(
    val name: String
) {
    companion object {
        var count = 0
    }

    init {
        count++
    }
}
```

Crea varias personas:

```kotlin
Person("Alice")
Person("Bob")
Person("Charlie")
```

Muestra:

```kotlin
println(Person.count)
```

### Ampliación

Añade una función:

```kotlin
fun getCreatedCount(): Int
```

al `companion object`.

---

# Parte 2 — Companion object como factoría

## Ejercicio 4 — Factoría de usuarios

Define:

```kotlin
class User(
    val username: String,
    val email: String
) {
    companion object {
        fun create(email: String): User {
            // ...
        }
    }
}
```

El método `create()` deberá obtener el `username` a partir del email.

El cliente deberá poder hacer:

```kotlin
val user =
    User.create("rafa@example.com")
```

### Objetivo

Aplicar lo aprendido anteriormente sobre **métodos factoría** utilizando `companion object`.

---

## Ejercicio 5 — Producto desde texto

Define:

```kotlin
class Product(
    val name: String,
    val price: Double
) {
    companion object {
        fun from(text: String): Product {
            // ...
        }
    }
}
```

El texto tendrá este formato:

```text
Keyboard;49.99
```

Deberá poder utilizarse:

```kotlin
val product =
    Product.from("Keyboard;49.99")
```

### Ampliación

Añade:

```kotlin
Product.fromCsv(...)
```

y:

```kotlin
Product.fromJson(...)
```

aunque inicialmente el contenido JSON sea muy sencillo.

---

## Ejercicio 6 — Métodos factoría alternativos

Define:

```kotlin
class Rectangle(
    val width: Double,
    val height: Double
) {
    companion object {

        fun create(width: Double, height: Double): Rectangle

        fun square(side: Double): Rectangle

        fun fromText(text: String): Rectangle
    }
}
```

Permite crear rectángulos mediante diferentes métodos.

Ejemplo:

```kotlin
val rectangle1 =
    Rectangle.create(10.0, 20.0)

val rectangle2 =
    Rectangle.square(10.0)

val rectangle3 =
    Rectangle.fromText("10x20")
```

### Objetivo

Comprender que el `companion object` puede proporcionar **diferentes formas semánticas de crear una misma clase**.

---

# Parte 3 — Companion object e interfaces

## Ejercicio 7 — Companion object que implementa una interfaz

Define:

```kotlin
interface Factory<T> {
    fun create(): T
}
```

Haz que el `companion object` de una clase implemente la interfaz:

```kotlin
class Person(
    val name: String
) {
    companion object : Factory<Person> {

        override fun create(): Person {
            return Person("Unknown")
        }
    }
}
```

Comprueba:

```kotlin
val factory: Factory<Person> =
    Person

val person = factory.create()
```

### Objetivo

Descubrir que el `companion object` es realmente un objeto y, por tanto, puede implementar interfaces.

---

## Ejercicio 8 — Parser

Define:

```kotlin
interface Parser<T> {
    fun parse(text: String): T
}
```

Crea:

```kotlin
class Point(
    val x: Int,
    val y: Int
) {
    companion object : Parser<Point> {

        override fun parse(text: String): Point {
            // ...
        }
    }
}
```

El formato será:

```text
10,20
```

Utiliza:

```kotlin
val parser: Parser<Point> = Point

val point = parser.parse("10,20")
```

### Objetivo

Combinar:

- `companion object`;
- interfaces;
- polimorfismo;
- creación de objetos.

---

# Parte 4 — Companion object frente a object declaration

## Ejercicio 9 — ¿Companion o Singleton?

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
class User {

    companion object {
        fun create(): User {
            return User()
        }
    }
}
```

Responde:

1. ¿Cuál es un Singleton independiente?
2. ¿Cuál pertenece conceptualmente a una clase?
3. ¿Cómo se accede a cada uno?
4. ¿Por qué tiene sentido `User.create()`?
5. ¿Por qué no tendría sentido escribir `Logger.create()`?

---

## Ejercicio 10 — Convertir una factoría

Partiendo de:

```kotlin
class ProductFactory {

    fun create(name: String): Product {
        return Product(name)
    }
}
```

modifica el diseño para eliminar `ProductFactory` y trasladar la funcionalidad a:

```kotlin
Product.Companion
```

El cliente deberá pasar de:

```kotlin
val factory = ProductFactory()

val product =
    factory.create("Keyboard")
```

a:

```kotlin
val product =
    Product.create("Keyboard")
```

### Objetivo

Comparar una **clase factoría** con un **companion object utilizado como factoría**.

---

# Parte 5 — Nested objects

## Ejercicio 11 — Primer nested object

Define:

```kotlin
class Game {

    object Settings {
        val maxPlayers = 4
        val maxLevel = 100
    }
}
```

Accede a sus propiedades mediante:

```kotlin
println(Game.Settings.maxPlayers)
println(Game.Settings.maxLevel)
```

### Preguntas

1. ¿Es necesario crear un `Game`?
2. ¿Es necesario crear un `Settings`?
3. ¿Qué relación existe entre `Game` y `Settings`?
4. ¿Es `Settings` un Singleton?

---

## Ejercicio 12 — Nested object para constantes

Define:

```kotlin
class HttpClient {

    object StatusCodes {
        const val OK = 200
        const val NOT_FOUND = 404
        const val SERVER_ERROR = 500
    }
}
```

Utiliza:

```kotlin
HttpClient.StatusCodes.OK
HttpClient.StatusCodes.NOT_FOUND
```

### Objetivo

Utilizar nested objects para **agrupar constantes relacionadas**.

---

## Ejercicio 13 — Varios nested objects

Define:

```kotlin
class Application {

    object Configuration {
        const val VERSION = "1.0"
    }

    object Defaults {
        const val LANGUAGE = "en"
    }

    object Limits {
        const val MAX_USERS = 100
    }
}
```

El programa deberá poder utilizar:

```kotlin
Application.Configuration.VERSION
Application.Defaults.LANGUAGE
Application.Limits.MAX_USERS
```

### Pregunta

¿Qué ventaja proporciona esta organización frente a declarar todas las constantes directamente dentro de `Application`?

---

# Parte 6 — Nested object con comportamiento

## Ejercicio 14 — Conversor

Define:

```kotlin
class UnitConverter {

    object Length {
        fun metersToKilometers(meters: Double): Double {
            return meters / 1000
        }

        fun kilometersToMeters(kilometers: Double): Double {
            return kilometers * 1000
        }
    }
}
```

Utiliza:

```kotlin
UnitConverter.Length.metersToKilometers(5000.0)
```

### Ampliación

Añade:

```kotlin
UnitConverter.Weight
UnitConverter.Temperature
```

con sus propias funciones de conversión.

---

## Ejercicio 15 — Validador

Define:

```kotlin
class Validator {

    object Email {
        fun isValid(email: String): Boolean {
            // ...
        }
    }

    object Password {
        fun isValid(password: String): Boolean {
            // ...
        }
    }
}
```

El cliente podrá utilizar:

```kotlin
Validator.Email.isValid(email)
Validator.Password.isValid(password)
```

### Objetivo

Utilizar nested objects para agrupar funcionalidades relacionadas.

---

## Ejercicio 16 — Formateadores

Define:

```kotlin
class Formatter {

    object Date {
        fun format(...): String {
            // ...
        }
    }

    object Currency {
        fun format(...): String {
            // ...
        }
    }
}
```

Implementa diferentes operaciones de formateo.

### Pregunta

¿Por qué podría ser más legible:

```kotlin
Formatter.Currency.format(25.50)
```

que:

```kotlin
Formatter.formatCurrency(25.50)
```

---

# Parte 7 — Nested object y estado

## Ejercicio 17 — Registro de eventos

Define:

```kotlin
class Application {

    object EventLog {

        private val events =
            mutableListOf<String>()

        fun add(event: String) {
            events.add(event)
        }

        fun getAll(): List<String> {
            return events.toList()
        }
    }
}
```

Utiliza:

```kotlin
Application.EventLog.add("Application started")
Application.EventLog.add("User logged in")
```

y posteriormente:

```kotlin
println(
    Application.EventLog.getAll()
)
```

### Pregunta

¿Quién puede acceder directamente a la colección `events`?

---

## Ejercicio 18 — Cache

Define:

```kotlin
class ProductService {

    object Cache {

        private val products =
            mutableMapOf<Int, Product>()

        fun put(product: Product) {
            // ...
        }

        fun get(id: Int): Product? {
            // ...
        }
    }
}
```

Utiliza:

```kotlin
ProductService.Cache.put(product)

val cached =
    ProductService.Cache.get(10)
```

### Objetivo

Utilizar un nested object con estado interno.

### Pregunta

¿En qué se diferencia este diseño de un `object Cache` declarado fuera de `ProductService`?

---

# Parte 8 — Companion object y nested object juntos

## Ejercicio 19 — Configuración de un servidor

Define:

```kotlin
class Server(
    val host: String,
    val port: Int
) {

    companion object {

        object Defaults {
            const val HOST = "localhost"
            const val PORT = 8080
        }

        fun createDefault(): Server {
            return Server(
                Defaults.HOST,
                Defaults.PORT
            )
        }
    }
}
```

Utiliza:

```kotlin
val server =
    Server.createDefault()
```

y:

```kotlin
println(Server.Defaults.PORT)
```

### Objetivo

Combinar `companion object` y nested `object`.

---

## Ejercicio 20 — Factoría con configuraciones

Define una clase:

```kotlin
class Database(
    val host: String,
    val port: Int,
    val database: String
) {

    companion object {

        object Defaults {
            const val HOST = "localhost"
            const val PORT = 5432
            const val DATABASE = "app"
        }

        fun createDefault(): Database {
            // ...
        }
    }
}
```

Añade métodos factoría:

```kotlin
Database.createDefault()
Database.create(host, port, database)
```

### Ampliación

Añade configuraciones para:

```text
DEVELOPMENT
TEST
PRODUCTION
```

mediante un nested object para cada entorno.

---

# Parte 9 — Nested class frente a nested object

## Ejercicio 21 — Comparar `class` y `object`

Compara:

```kotlin
class Computer {

    class Cpu
}
```

con:

```kotlin
class Computer {

    object Cpu
}
```

Comprueba cómo se utilizan:

```kotlin
val cpu1 = Computer.Cpu()
```

frente a:

```kotlin
val cpu2 = Computer.Cpu
```

### Preguntas

1. ¿Cuál necesita una instancia?
2. ¿Cuál puede crear múltiples objetos?
3. ¿Cuál solamente representa un único objeto?
4. ¿Qué significa que `Cpu` sea un nested object?

---

## Ejercicio 22 — Sistema de estados

Define:

```kotlin
class Game {

    class State(
        val name: String
    )

    object States {
        val MENU = State("Menu")
        val PLAYING = State("Playing")
        val PAUSED = State("Paused")
        val GAME_OVER = State("Game Over")
    }
}
```

Utiliza:

```kotlin
val state = Game.States.PLAYING
```

### Objetivo

Combinar:

- nested class;
- nested object;
- instancias almacenadas dentro del objeto.

---

# Parte 10 — Diseñar la API de una clase

## Ejercicio 23 — Clase `Color`

Diseña:

```kotlin
class Color(
    val red: Int,
    val green: Int,
    val blue: Int
)
```

El cliente deberá poder utilizar:

```kotlin
Color.RED
Color.GREEN
Color.BLUE
```

y también:

```kotlin
Color.fromHex("#FF0000")
```

Decide si cada elemento debería estar:

- directamente en la clase;
- en un `companion object`;
- en un nested object.

### Objetivo

Diseñar una API idiomática utilizando `companion object` y nested objects.

---

## Ejercicio 24 — Clase `HttpRequest`

Diseña una clase:

```kotlin
class HttpRequest(
    val url: String,
    val method: String
)
```

El cliente debería poder utilizar:

```kotlin
HttpRequest.Method.GET
HttpRequest.Method.POST
HttpRequest.Method.PUT
HttpRequest.Method.DELETE
```

y además:

```kotlin
HttpRequest.get("https://example.com")
HttpRequest.post("https://example.com")
```

### Reto

Decide qué elementos deberían pertenecer al `companion object` y cuáles deberían formar parte del nested object `Method`.

---

# Parte 11 — Ejercicios de razonamiento

## Ejercicio 25 — ¿Companion object o nested object?

Para cada elemento decide dónde lo colocarías:

### Caso A

Una función:

```kotlin
User.create(...)
```

### Caso B

Las constantes:

```text
User.Role.ADMIN
User.Role.USER
User.Role.GUEST
```

### Caso C

Una función:

```kotlin
User.validateEmail(...)
```

### Caso D

Una colección global de usuarios.

### Caso E

Los códigos de error relacionados con `NetworkClient`:

```text
NetworkClient.Error.TIMEOUT
NetworkClient.Error.UNAUTHORIZED
NetworkClient.Error.NOT_FOUND
```

Justifica cada decisión.

---

## Ejercicio 26 — Diseñar una clase completa

Diseña una clase:

```kotlin
class User(
    val name: String,
    val role: Role
)
```

que permita:

```kotlin
User.create("Alice")
```

y:

```kotlin
User.Role.ADMIN
User.Role.USER
User.Role.GUEST
```

La clase deberá contener:

- un `companion object`;
- un nested object o nested class para los roles;
- al menos una función factoría;
- al menos una constante.

### Reto

Decide si `Role` debería ser:

```kotlin
object Role
```

o:

```kotlin
class Role
```

o:

```kotlin
enum class Role
```

y justifica la decisión.

---

# Parte 12 — Proyecto final

## Ejercicio 27 — API de configuración

Diseña una clase:

```kotlin
class App
```

que proporcione una API como:

```kotlin
App.createDefault()
App.Environment.DEVELOPMENT
App.Environment.PRODUCTION
App.Version.CURRENT
```

La clase deberá utilizar:

- un `companion object`;
- al menos dos nested objects;
- una nested class o `enum class`;
- propiedades y funciones.

Por ejemplo:

```kotlin
val app =
    App.createDefault()

println(
    App.Version.CURRENT
)

println(
    App.Environment.PRODUCTION
)
```

### Objetivo

Diseñar una API coherente utilizando diferentes tipos de `object`.

---

# Reto final — Diseñar una API idiomática

Diseña una clase `Game` que permita utilizar una API similar a:

```kotlin
val game =
    Game.create(
        Game.Mode.SINGLE_PLAYER
    )

println(Game.Constants.MAX_PLAYERS)

println(Game.Defaults.STARTING_LEVEL)

game.start()
```

La clase deberá tener:

### `companion object`

Utilízalo para:

```kotlin
Game.create(...)
```

### Nested object `Constants`

Debe contener constantes como:

```text
MAX_PLAYERS
MAX_LEVEL
MAX_SCORE
```

### Nested object `Defaults`

Debe contener valores predeterminados:

```text
STARTING_LEVEL
STARTING_LIVES
STARTING_SCORE
```

### Nested type `Mode`

Puede ser:

```kotlin
enum class Mode {
    SINGLE_PLAYER,
    MULTI_PLAYER
}
```

### Restricción

Intenta que la API resultante sea intuitiva para alguien que utilice la clase sin conocer su implementación interna.

---

# Resumen conceptual

Al terminar los ejercicios, el alumno debería diferenciar claramente:

## `companion object`

Está asociado a una clase:

```kotlin
class User {

    companion object {

        fun create(): User {
            return User()
        }
    }
}
```

Se utiliza mediante:

```kotlin
User.create()
```

Es especialmente apropiado para:

- métodos factoría;
- constantes relacionadas con la clase;
- funciones auxiliares relacionadas con la clase;
- miembros que conceptualmente pertenecen a la clase y no a una instancia concreta.

---

## Nested `object`

Es un objeto declarado dentro de otra clase:

```kotlin
class HttpClient {

    object StatusCodes {
        const val OK = 200
        const val NOT_FOUND = 404
    }
}
```

Se utiliza mediante:

```kotlin
HttpClient.StatusCodes.OK
```

Es especialmente útil para:

- agrupar constantes;
- agrupar funcionalidades relacionadas;
- organizar una API;
- encapsular un objeto singleton dentro del espacio de nombres de una clase.

---

## Nested `class`

Una clase anidada normal:

```kotlin
class Computer {

    class Cpu
}
```

se utiliza mediante:

```kotlin
val cpu = Computer.Cpu()
```

y permite crear tantas instancias como sea necesario.

---

## La diferencia fundamental

Una forma sencilla de explicarlo a los alumnos es:

```text
companion object
        ↓
"Esto pertenece a la clase"

nested object
        ↓
"Este objeto está organizado dentro de esta clase"

nested class
        ↓
"Esta clase está organizada dentro de esta clase"
```

Y finalmente:

```text
User.create()
        ↑
companion object

User.Role.ADMIN
        ↑
nested object / nested type

User.Address(...)
        ↑
nested class
```

El objetivo final es que el alumno no utilice `object` simplemente porque "funciona", sino que sea capaz de diseñar una **API de clase bien organizada y semánticamente coherente**.