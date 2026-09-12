# Convenciones de nombres en Kotlin

Seguir unas convenciones de nombres coherentes hace que el código sea más fácil de leer, entender y mantener.

En este curso utilizaremos las siguientes convenciones.

---

## 1. Clases

Las clases utilizan **UpperCamelCase** (también llamado PascalCase).

Cada palabra comienza con mayúscula y no se utilizan guiones bajos.

```kotlin
class Person

class Student

class BankAccount

class UserProfile
```

### Incorrecto

```kotlin
class person
class student_data
class Bank_Account
```

### Regla

> **Clases → UpperCamelCase**

---

## 2. Interfaces

Las interfaces siguen la misma convención que las clases:

**UpperCamelCase**

```kotlin
interface Drawable

interface Serializable

interface UserRepository
```

### Regla

> **Interfaces → UpperCamelCase**

No es necesario añadir prefijos como `I`:

```kotlin
// ❌ No recomendado
interface IUserRepository

// ✅ Kotlin
interface UserRepository
```

---

## 3. Objetos (`object`)

Los objetos también utilizan **UpperCamelCase**.

```kotlin
object DatabaseManager

object GameManager

object AppConfig
```

### Regla

> **Objetos → UpperCamelCase**

---

## 4. Funciones

Las funciones utilizan **lowerCamelCase**.

La primera palabra comienza en minúscula y cada palabra siguiente comienza en mayúscula.

```kotlin
fun calculateTotal()

fun getUserName()

fun printMessage()

fun calculateAverage()
```

### Incorrecto

```kotlin
fun CalculateTotal()

fun calculate_total()

fun calculate_total_price()
```

### Regla

> **Funciones → lowerCamelCase**

---

## 5. Variables locales

Las variables locales utilizan **lowerCamelCase**.

```kotlin
val name = "Rafael"

var age = 20

val studentName = "Ana"

var totalPrice = 25.50
```

### Incorrecto

```kotlin
val StudentName = "Ana"

val student_name = "Ana"

val STUDENT_NAME = "Ana"
```

### Regla

> **Variables → lowerCamelCase**

---

## 6. Propiedades

Las propiedades de una clase siguen también **lowerCamelCase**.

```kotlin
class Person(
    val firstName: String,
    val lastName: String,
    var age: Int
)
```

Otro ejemplo:

```kotlin
class Product {
    val productName: String
    var price: Double
    var stockQuantity: Int
}
```

### Regla

> **Propiedades → lowerCamelCase**

---

## 7. Parámetros de funciones y constructores

Los parámetros utilizan **lowerCamelCase**.

```kotlin
fun createUser(firstName: String, lastName: String) {
    // ...
}
```

Otro ejemplo:

```kotlin
class Person(
    val firstName: String,
    val lastName: String,
    val birthYear: Int
)
```

### Regla

> **Parámetros → lowerCamelCase**

---

# 8. Valores booleanos

Los nombres de propiedades y variables booleanas deben intentar expresar claramente una condición.

Es habitual utilizar prefijos como:

- `is`
- `has`
- `can`
- `should`

Por ejemplo:

```kotlin
val isActive = true

val isStudent = true

val hasChildren = false

val hasPermission = true

val canEdit = true

val canLogin = false

val shouldUpdate = true
```

Esto hace que las expresiones sean fáciles de leer:

```kotlin
if (isActive) {
    // ...
}

if (hasPermission) {
    // ...
}

if (canEdit) {
    // ...
}
```

En cambio:

```kotlin
val active = true
```

puede ser correcto, pero:

```kotlin
val isActive = true
```

deja más claro que se trata de un valor booleano.

### Regla

> **Booleanos → utilizar nombres que expresen claramente una condición, normalmente con `is`, `has`, `can` o `should`.**

---

# 9. Constantes de tiempo de compilación

Las constantes de tiempo de compilación declaradas mediante `const val` utilizan **SCREAMING_SNAKE_CASE**.

Es decir:

- todas las letras en mayúscula;
- palabras separadas mediante `_`.

```kotlin
const val MAX_USERS = 100

const val DEFAULT_PORT = 8080

const val PI = 3.14159

const val MAX_RETRIES = 3
```

### Incorrecto

```kotlin
const val maxUsers = 100

const val MaxUsers = 100

const val max_users = 100
```

### Regla

> **Constantes `const val` → SCREAMING_SNAKE_CASE**

### Importante

En este curso reservaremos **SCREAMING_SNAKE_CASE para las constantes de tiempo de compilación**.

Por tanto, no utilizaremos este estilo para variables normales ni para las entradas de un `enum`.

---

# 10. Enumeraciones (`enum`)

El nombre de la clase `enum` utiliza **UpperCamelCase**, como cualquier otra clase.

```kotlin
enum class Direction {
    North,
    South,
    East,
    West
}
```

Para las entradas del `enum`, en este curso utilizaremos **UpperCamelCase**.

```kotlin
enum class UserRole {
    Admin,
    User,
    Guest
}
```

Otro ejemplo:

```kotlin
enum class TrafficLight {
    Red,
    Yellow,
    Green
}
```

Y:

```kotlin
enum class PaymentMethod {
    CreditCard,
    DebitCard,
    Cash
}
```

### ¿Por qué no utilizamos SCREAMING_SNAKE_CASE?

Kotlin permite tanto:

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

como:

```kotlin
enum class Direction {
    North,
    South,
    East,
    West
}
```

En este curso elegiremos **UpperCamelCase para las entradas de los `enum`**, y reservaremos **SCREAMING_SNAKE_CASE para las constantes de tiempo de compilación**.

De esta manera diferenciamos visualmente ambas cosas:

```kotlin
const val MAX_USERS = 100

enum class UserRole {
    Admin,
    User,
    Guest
}
```

### Regla

> **Clase `enum` → UpperCamelCase**  
> **Entrada de `enum` → UpperCamelCase**  
> **Constante `const val` → SCREAMING_SNAKE_CASE**

---

# 11. Paquetes

Los nombres de paquetes se escriben en **minúsculas**.

No se utilizan guiones bajos.

```kotlin
package com.example.app

package es.rafapuig.students

package com.example.myproject
```

### Incorrecto

```kotlin
package com.example.MyProject

package com.example.my_project
```

### Regla

> **Paquetes → minúsculas, sin guiones bajos**

---

# 12. Archivos

Los nombres de los archivos deben ser descriptivos.

Cuando el archivo contiene principalmente una clase, normalmente utilizaremos el nombre de esa clase.

Por ejemplo:

```text
Person.kt
Student.kt
BankAccount.kt
UserRepository.kt
```

Si contiene una clase:

```kotlin
class Student
```

el archivo puede llamarse:

```text
Student.kt
```

Para archivos que contienen varias funciones relacionadas, utilizaremos un nombre descriptivo en **UpperCamelCase**:

```text
MathUtils.kt
StringUtils.kt
FileUtils.kt
```

### Regla

> **Archivos → nombre descriptivo, normalmente UpperCamelCase**

---

# 13. Parámetros de tipo genérico

Los parámetros de tipo genérico suelen utilizar una sola letra mayúscula cuando el significado es suficientemente claro.

```kotlin
class Box<T>
```

```kotlin
fun <T> printValue(value: T) {
    println(value)
}
```

Son habituales:

```text
T
E
K
V
R
```

Por ejemplo:

- `T` → Type
- `E` → Element
- `K` → Key
- `V` → Value
- `R` → Return

Cuando el tipo necesita un nombre más descriptivo, puede utilizarse **UpperCamelCase**:

```kotlin
class Repository<Entity>
```

### Regla

> **Tipos genéricos → normalmente una letra mayúscula (`T`, `E`, `K`, `V`) o un nombre descriptivo en UpperCamelCase**

---

# 14. Acrónimos

Los acrónimos deben seguir las reglas normales de nombres de Kotlin.

Para acrónimos cortos, se pueden mantener las letras en mayúscula.

```kotlin
class IOStream
```

Para acrónimos de más de dos letras, normalmente solo se escribe en mayúscula la primera letra:

```kotlin
class XmlParser

class HttpClient

class JsonReader
```

No:

```kotlin
class XMLParser
class HTTPClient
class JSONReader
```

cuando el nombre se ajusta a la convención de Kotlin.

Por ejemplo:

```kotlin
val httpClient = HttpClient()

val jsonReader = JsonReader()
```

### Regla

> **Acrónimos → seguir las convenciones de `camelCase` / `UpperCamelCase`**

---

# 15. Propiedades privadas de respaldo

Kotlin utiliza una convención especial para las **backing properties**: un guion bajo delante del nombre.

Por ejemplo:

```kotlin
private var _items = mutableListOf<String>()

val items: List<String>
    get() = _items
```

Aquí:

- `_items` es la propiedad privada utilizada internamente;
- `items` es la propiedad pública expuesta.

El guion bajo inicial se utiliza específicamente para diferenciar la propiedad interna de la propiedad pública relacionada.

---

# 16. Parámetros que no se utilizan

Cuando un parámetro de una función no se utiliza, podemos utilizar `_`.

Por ejemplo:

```kotlin
list.forEachIndexed { index, _ ->
    println(index)
}
```

El `_` indica que el segundo parámetro no nos interesa.

También puede utilizarse en otras situaciones en las que queramos indicar explícitamente que un valor no se utiliza.

---

# 17. `val` frente a `var`

Aunque esto no es estrictamente una convención de nombres, es una buena práctica de Kotlin:

> Utiliza `val` siempre que no necesites modificar el valor.

Por ejemplo:

```kotlin
val name = "Ana"
val age = 20
```

En lugar de:

```kotlin
var name = "Ana"
var age = 20
```

Utilizaremos `var` cuando realmente necesitemos modificar el valor:

```kotlin
var score = 0

score = 100
```

Esto hace que el código sea más fácil de entender y reduce modificaciones accidentales.

---

# 18. Resumen de convenciones

| Elemento | Convención | Ejemplo |
|---|---|---|
| Clase | UpperCamelCase | `BankAccount` |
| Interfaz | UpperCamelCase | `Drawable` |
| `object` | UpperCamelCase | `DatabaseManager` |
| Función | lowerCamelCase | `calculateTotal()` |
| Variable | lowerCamelCase | `totalPrice` |
| Propiedad | lowerCamelCase | `firstName` |
| Parámetro | lowerCamelCase | `birthYear` |
| Booleano | `is` / `has` / `can` / `should` | `isActive` |
| `const val` | SCREAMING_SNAKE_CASE | `MAX_USERS` |
| Clase `enum` | UpperCamelCase | `UserRole` |
| Entrada de `enum` | UpperCamelCase | `Admin` |
| Paquete | minúsculas | `com.example.app` |
| Archivo | UpperCamelCase | `UserRepository.kt` |
| Tipo genérico | Mayúscula / UpperCamelCase | `T`, `Entity` |
| Backing property | `_` + nombre | `_items` |

---

# 19. Ejemplo completo

Aplicando todas estas convenciones:

```kotlin
package com.example.game

const val MAX_PLAYERS = 4

enum class PlayerRole {
    Warrior,
    Mage,
    Archer
}

class Player(
    val playerName: String,
    var score: Int,
    val role: PlayerRole
) {

    var isAlive = true
        private set

    fun addScore(points: Int) {
        score += points
    }

    fun canPlay(): Boolean {
        return isAlive && score >= 0
    }
}
```

Podemos identificar fácilmente cada tipo de elemento:

```text
MAX_PLAYERS     → constante de tiempo de compilación
PlayerRole      → clase enum
Warrior         → entrada del enum
Player          → clase
playerName      → propiedad
score           → propiedad
role            → propiedad
isAlive         → propiedad booleana
addScore()      → función
points          → parámetro
canPlay()       → función
```

La idea fundamental es mantener **una convención coherente**:

```text
Clases          → UpperCamelCase
Funciones       → lowerCamelCase
Variables       → lowerCamelCase
Propiedades     → lowerCamelCase
Parámetros      → lowerCamelCase
Booleanos       → is / has / can / should
const val       → SCREAMING_SNAKE_CASE
Enum            → UpperCamelCase
Enum entries    → UpperCamelCase
Paquetes        → minúsculas
```

Así, en este curso **SCREAMING_SNAKE_CASE queda reservado para las constantes de tiempo de compilación**, mientras que las entradas de los `enum` siguen la convención `UpperCamelCase`.