# Ejercicios de Kotlin — Patrón Singleton

## Objetivos

Con estos ejercicios se pretende practicar:

- El concepto de **Singleton**.
- La declaración `object` de Kotlin.
- La diferencia entre `object` y `class`.
- El acceso a un objeto Singleton desde diferentes partes del programa.
- El mantenimiento de estado compartido.
- La utilización de propiedades y métodos dentro de un Singleton.
- Los `companion object` como mecanismo diferente de `object`.
- La aplicación del Singleton a problemas reales.
- La combinación de Singleton con interfaces.
- La identificación de situaciones en las que **no conviene utilizar Singleton**.

---

# Parte 1 — Introducción al Singleton

## Ejercicio 1 — Configuración de la aplicación

Crea un Singleton:

```kotlin
object AppConfig {
    val applicationName = "My Application"
    val version = "1.0"
}
```

Desde `main()` muestra la información almacenada.

Por ejemplo:

```text
My Application
Version: 1.0
```

### Objetivo

Comprender la sintaxis:

```kotlin
object AppConfig
```

y entender que no es necesario hacer:

```kotlin
AppConfig()
```

---

## Ejercicio 2 — Contador global

Crea un Singleton:

```kotlin
object Counter {
    var value = 0

    fun increment() {
        value++
    }
}
```

Desde `main()` realiza varias llamadas:

```kotlin
Counter.increment()
Counter.increment()
Counter.increment()

println(Counter.value)
```

El resultado debe ser:

```text
3
```

### Pregunta

¿Por qué no es necesario crear un objeto `Counter`?

---

## Ejercicio 3 — Comprobar que existe una única instancia

Crea:

```kotlin
object Logger {
    var messageCount = 0

    fun log(message: String) {
        messageCount++
        println(message)
    }
}
```

Utiliza el Singleton desde dos funciones diferentes:

```kotlin
fun firstFunction() {
    Logger.log("Message 1")
}

fun secondFunction() {
    Logger.log("Message 2")
}
```

Después muestra:

```kotlin
println(Logger.messageCount)
```

### Pregunta

Explica por qué el contador contiene `2` aunque `Logger` se haya utilizado desde dos funciones diferentes.

---

# Parte 2 — Singleton con comportamiento

## Ejercicio 4 — Logger

Crea un Singleton:

```kotlin
object Logger
```

que permita registrar mensajes mediante:

```kotlin
Logger.info("Application started")
Logger.warning("Low memory")
Logger.error("Connection failed")
```

La salida podría ser:

```text
[INFO] Application started
[WARNING] Low memory
[ERROR] Connection failed
```

### Ampliación

Añade un contador para saber cuántos mensajes se han registrado de cada tipo.

---

## Ejercicio 5 — GameManager

Crea un Singleton:

```kotlin
object GameManager
```

que almacene:

- nombre del jugador;
- puntuación;
- nivel actual.

Debe proporcionar métodos:

```kotlin
startGame(playerName: String)
addPoints(points: Int)
nextLevel()
reset()
```

Ejemplo:

```kotlin
GameManager.startGame("Rafa")
GameManager.addPoints(100)
GameManager.nextLevel()
```

Después muestra el estado de la partida.

---

## Ejercicio 6 — SessionManager

Crea:

```kotlin
object SessionManager
```

que almacene información sobre la sesión actual:

```kotlin
userName
isLoggedIn
```

Debe proporcionar:

```kotlin
login(userName: String)
logout()
```

El siguiente código:

```kotlin
SessionManager.login("alice")

println(SessionManager.isLoggedIn)
println(SessionManager.userName)

SessionManager.logout()

println(SessionManager.isLoggedIn)
```

deberá mostrar correctamente el estado de la sesión.

### Ampliación

Impide que se pueda hacer `login()` si ya existe una sesión activa.

---

# Parte 3 — Singleton y colecciones

## Ejercicio 7 — Registro de usuarios

Crea:

```kotlin
object UserRegistry
```

que mantenga una colección de usuarios.

Debe proporcionar:

```kotlin
add(user: User)
remove(user: User)
findByName(name: String): User?
getAll(): List<User>
```

Define una clase:

```kotlin
data class User(
    val name: String,
    val email: String
)
```

Ejemplo:

```kotlin
UserRegistry.add(
    User("Alice", "alice@example.com")
)

UserRegistry.add(
    User("Bob", "bob@example.com")
)
```

Después consulta los usuarios almacenados.

---

## Ejercicio 8 — Carrito de compra global

Crea:

```kotlin
data class Product(
    val name: String,
    val price: Double
)
```

y:

```kotlin
object ShoppingCart
```

El Singleton deberá permitir:

```kotlin
add(product: Product)
remove(product: Product)
clear()
getTotal(): Double
getProducts(): List<Product>
```

Ejemplo:

```kotlin
ShoppingCart.add(Product("Keyboard", 50.0))
ShoppingCart.add(Product("Mouse", 25.0))

println(ShoppingCart.getTotal())
```

Resultado:

```text
75.0
```

### Ampliación

Añade:

```kotlin
getItemCount()
```

para obtener el número de productos.

---

# Parte 4 — Singleton frente a una clase normal

## Ejercicio 9 — Convertir una clase en Singleton

Se proporciona:

```kotlin
class ScoreManager {

    var score = 0

    fun addPoints(points: Int) {
        score += points
    }
}
```

El programa utiliza:

```kotlin
val manager1 = ScoreManager()
val manager2 = ScoreManager()

manager1.addPoints(100)

println(manager2.score)
```

El resultado es:

```text
0
```

Modifica el diseño para que `manager1` y `manager2` hagan referencia al mismo objeto.

El programa deberá producir:

```text
100
```

### Objetivo

Comprender qué problema pretende resolver el Singleton.

---

## Ejercicio 10 — ¿Clase o Singleton?

Para cada uno de los siguientes casos decide si utilizarías una clase normal o un Singleton.

Justifica la respuesta.

1. Un jugador de un videojuego.
2. La configuración global de una aplicación.
3. Un logger.
4. Una conexión a una base de datos.
5. Una factura.
6. Un carrito de compra.
7. Un repositorio de usuarios.
8. Una ventana de una aplicación.
9. Un archivo.
10. Un gestor global de audio.

### Objetivo

No limitarse a aprender la sintaxis de `object`, sino aprender a decidir cuándo tiene sentido utilizar el patrón.

---

# Parte 5 — Singleton con `object` frente a `companion object`

## Ejercicio 11 — Dos formas diferentes

Crea:

```kotlin
object DatabaseManager {
    fun connect() {
        println("Connected")
    }
}
```

y:

```kotlin
class User {

    companion object {
        fun create(name: String): User {
            return User()
        }
    }
}
```

Compara:

```kotlin
DatabaseManager.connect()
```

con:

```kotlin
User.create("Alice")
```

### Preguntas

1. ¿Qué representa `DatabaseManager`?
2. ¿Qué representa el `companion object`?
3. ¿Puede hacerse `DatabaseManager()`?
4. ¿Puede hacerse `User()`?
5. ¿Son equivalentes ambas construcciones?

---

## Ejercicio 12 — Factoría Singleton

Combina los conceptos de **Singleton** y **método factoría**.

Define:

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

Crea:

```kotlin
object NotificationFactory {

    fun create(type: String): Notification {
        // ...
    }
}
```

El cliente deberá utilizar:

```kotlin
val notification =
    NotificationFactory.create("email")

notification.send("Hello")
```

### Objetivo

Observar que una factoría puede ser a su vez un Singleton.

---

# Parte 6 — Singleton implementando interfaces

## Ejercicio 13 — Logger como interfaz

Define:

```kotlin
interface Logger {
    fun info(message: String)
    fun error(message: String)
}
```

Crea un Singleton que implemente la interfaz:

```kotlin
object ConsoleLogger : Logger {

    override fun info(message: String) {
        // ...
    }

    override fun error(message: String) {
        // ...
    }
}
```

Utiliza:

```kotlin
val logger: Logger = ConsoleLogger
```

### Objetivo

Comprender que un Singleton puede utilizarse mediante una interfaz.

---

## Ejercicio 14 — Configuración de la aplicación

Define:

```kotlin
interface Configuration {
    fun get(key: String): String?
}
```

Implementa:

```kotlin
object AppConfiguration : Configuration
```

Almacena internamente diferentes configuraciones:

```text
server
port
language
theme
```

El código cliente deberá trabajar con:

```kotlin
val configuration: Configuration =
    AppConfiguration
```

### Ampliación

Añade un método para modificar una configuración.

---

# Parte 7 — Singleton con estado

## Ejercicio 15 — Banco

Crea:

```kotlin
object Bank
```

que mantenga una colección de cuentas.

Define:

```kotlin
data class Account(
    val number: String,
    var balance: Double
)
```

La factoría deberá permitir:

```kotlin
Bank.createAccount("001")
Bank.createAccount("002")
```

y operaciones:

```kotlin
Bank.deposit("001", 500.0)
Bank.withdraw("001", 100.0)
Bank.getBalance("001")
```

### Condiciones

- No puede haber dos cuentas con el mismo número.
- No se puede retirar más dinero del disponible.
- Una cuenta inexistente debe producir un error controlado.

---

## Ejercicio 16 — Inventario de un videojuego

Crea:

```kotlin
object Inventory
```

que gestione los objetos del jugador.

Debe permitir:

```kotlin
add(item)
remove(item)
contains(item)
clear()
```

Define:

```kotlin
data class Item(
    val id: Int,
    val name: String
)
```

Prueba el Singleton desde diferentes funciones del programa.

### Pregunta

¿Por qué podría resultar peligroso que `Inventory` mantenga estado global?

---

# Parte 8 — Singleton y arquitectura

## Ejercicio 17 — Repository Singleton

Define:

```kotlin
data class Product(
    val id: Int,
    val name: String,
    val price: Double
)
```

y una interfaz:

```kotlin
interface ProductRepository {
    fun add(product: Product)
    fun findById(id: Int): Product?
    fun getAll(): List<Product>
}
```

Implementa el repositorio como Singleton:

```kotlin
object InMemoryProductRepository : ProductRepository {
    // ...
}
```

El código cliente deberá depender de:

```kotlin
ProductRepository
```

y no directamente del Singleton siempre que sea posible.

### Objetivo

Introducir la relación entre Singleton, interfaces y desacoplamiento.

---

## Ejercicio 18 — Servicio de configuración

Define:

```kotlin
interface ConfigurationService {
    fun get(key: String): String?
}
```

Implementa:

```kotlin
object DefaultConfigurationService :
    ConfigurationService
```

Crea una función:

```kotlin
fun startApplication(
    configuration: ConfigurationService
)
```

y utiliza:

```kotlin
startApplication(
    DefaultConfigurationService
)
```

### Pregunta

¿Por qué esta solución puede ser más fácil de probar que utilizar directamente:

```kotlin
DefaultConfigurationService.get(...)
```

dentro de toda la aplicación?

---

# Parte 9 — Detectar problemas del Singleton

## Ejercicio 19 — Estado global

Analiza:

```kotlin
object GameState {
    var score = 0
    var playerName = ""
}
```

Y el siguiente código:

```kotlin
fun playGame() {
    GameState.score += 100
}

fun showScore() {
    println(GameState.score)
}
```

Explica qué ocurre si diferentes partes del programa modifican `GameState`.

### Preguntas

1. ¿Quién puede modificar `score`?
2. ¿Cómo se puede saber quién lo modificó?
3. ¿Qué problemas puede causar en un programa grande?
4. ¿Cuándo podría estar justificado utilizar este diseño?

---

## Ejercicio 20 — Singleton y pruebas

Supón que tienes:

```kotlin
object Counter {
    var value = 0

    fun increment() {
        value++
    }
}
```

Y dos pruebas:

```kotlin
@Test
fun testFirst() {
    Counter.increment()

    assertEquals(1, Counter.value)
}

@Test
fun testSecond() {
    Counter.increment()

    assertEquals(1, Counter.value)
}
```

Analiza por qué la segunda prueba puede fallar dependiendo del estado dejado por la primera.

### Reto

Propón diferentes soluciones para evitar que el estado de una prueba contamine a otra.

---

# Parte 10 — Singleton y concurrencia

## Ejercicio 21 — Contador compartido

Utiliza:

```kotlin
object Counter {
    var value = 0

    fun increment() {
        value++
    }
}
```

Crea varios hilos que llamen simultáneamente a:

```kotlin
Counter.increment()
```

Realiza miles de incrementos desde cada hilo.

Comprueba si el resultado final coincide siempre con el número esperado.

### Objetivo

Descubrir que:

> Que exista una única instancia no significa que el acceso a su estado sea automáticamente seguro para múltiples hilos.

### Ampliación

Investiga cómo podría hacerse seguro el contador utilizando mecanismos de sincronización apropiados.

---

# Parte 11 — Proyecto final

## Ejercicio 22 — Sistema de configuración

Desarrolla un sistema de configuración para una aplicación.

Define:

```kotlin
interface Configuration {
    fun get(key: String): String?
    fun set(key: String, value: String)
}
```

Implementa:

```kotlin
object AppConfiguration : Configuration
```

Debe permitir:

```kotlin
AppConfiguration.set("language", "es")
AppConfiguration.set("theme", "dark")

println(
    AppConfiguration.get("language")
)
```

### Requisitos

- Debe existir una única instancia.
- Los datos deben almacenarse internamente.
- No se debe permitir acceder directamente a la colección interna.
- Debe poder utilizarse mediante la interfaz `Configuration`.

---

# Ejercicio 23 — Sistema de juego

Diseña un pequeño sistema de gestión de una partida.

Debe existir un Singleton:

```kotlin
object GameManager
```

que gestione:

- jugador actual;
- puntuación;
- nivel;
- estado de la partida.

Define un enum:

```kotlin
enum class GameState {
    MENU,
    PLAYING,
    PAUSED,
    GAME_OVER
}
```

El Singleton deberá proporcionar operaciones como:

```kotlin
startGame()
pauseGame()
resumeGame()
gameOver()
addPoints(points: Int)
nextLevel()
reset()
```

### Restricciones

El resto del programa no podrá crear otra instancia de `GameManager`.

### Ampliación

Haz que `GameManager` implemente una interfaz:

```kotlin
interface GameController
```

para que el resto del programa pueda depender de la interfaz.

---

# Reto final — ¿Realmente necesitas un Singleton?

Para cada uno de los siguientes diseños, decide si mantendrías el Singleton o lo sustituirías por otra solución:

```text
Logger
DatabaseConnection
UserRepository
ShoppingCart
GameManager
AppConfiguration
EmailSender
Player
AudioManager
Cache
```

Para cada caso, razona:

1. ¿Debe existir realmente una única instancia?
2. ¿Es necesario compartir el estado?
3. ¿Quién controla el ciclo de vida del objeto?
4. ¿Qué problemas puede producir un estado global?
5. ¿Sería fácil realizar pruebas unitarias?
6. ¿Podría utilizarse inyección de dependencias en lugar de Singleton?

---

# Objetivo final

Al terminar estos ejercicios, el alumno debería comprender que en Kotlin la forma habitual de implementar un Singleton es:

```kotlin
object Logger {

    fun log(message: String) {
        println(message)
    }
}
```

y utilizarlo directamente:

```kotlin
Logger.log("Hello")
```

También debe diferenciarlo de:

```kotlin
class Logger
```

y de:

```kotlin
class MyClass {

    companion object {
        fun create(): MyClass {
            return MyClass()
        }
    }
}
```

El concepto fundamental que debe quedar claro es:

> **Un Singleton restringe la existencia a una única instancia accesible globalmente.**

Pero también es importante comprender que:

> **Que algo pueda implementarse como Singleton no significa que deba implementarse como Singleton.**

En aplicaciones grandes, el estado global puede aumentar el acoplamiento, dificultar las pruebas y hacer más difícil controlar el ciclo de vida de los objetos.

Por ello, el objetivo de los últimos ejercicios es que el alumno no solamente sepa escribir un `object`, sino que sea capaz de **decidir cuándo el patrón Singleton es apropiado y cuándo es preferible utilizar otras técnicas, como la inyección de dependencias**.