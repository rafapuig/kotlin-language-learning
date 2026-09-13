# Ejercicios de Kotlin — Data classes

Colección progresiva de ejercicios para practicar las **data classes** de Kotlin.

Los ejercicios están pensados para alumnos de **DAM** y avanzan desde la declaración básica de una `data class` hasta el uso de:

- `toString()`
- `equals()`
- `hashCode()`
- `copy()`
- destructuring declarations
- colecciones
- objetos inmutables
- `copy()` para modificar objetos
- `data class` anidadas
- restricciones de las `data class`
- interacción con clases normales

---

# Nivel 1 — Creación de data classes

## Ejercicio 1 — Persona

Crea una `data class` llamada `Person` con las siguientes propiedades:

- `name: String`
- `age: Int`
- `email: String`

Crea varias personas y muéstralas por consola.

Por ejemplo:

```kotlin
val person = Person("Ana", 25, "ana@example.com")

println(person)
```

Observa qué información muestra Kotlin automáticamente al imprimir el objeto.

### Objetivo

Comprobar que una `data class` proporciona automáticamente una representación textual útil del objeto.

---

## Ejercicio 2 — Producto

Crea una `data class` llamada `Product` con:

- `name: String`
- `price: Double`
- `stock: Int`

Crea tres productos y muéstralos por consola.

Prueba también:

```kotlin
println(product1)
println(product2)
println(product3)
```

Observa la diferencia respecto a una clase normal que no implemente `toString()`.

---

# Nivel 2 — `equals()`

## Ejercicio 3 — Comparar personas

Utiliza la siguiente clase:

```kotlin
data class Person(
    val name: String,
    val age: Int
)
```

Crea:

```kotlin
val person1 = Person("Ana", 25)
val person2 = Person("Ana", 25)
val person3 = Person("Ana", 30)
```

Comprueba:

```kotlin
println(person1 == person2)
println(person1 == person3)
```

### Pregunta

¿Por qué `person1 == person2` es `true` aunque sean dos objetos diferentes?

---

## Ejercicio 4 — Data class frente a clase normal

Crea:

```kotlin
class Product(
    val name: String,
    val price: Double
)
```

y:

```kotlin
data class DataProduct(
    val name: String,
    val price: Double
)
```

Crea dos objetos de cada tipo con exactamente los mismos datos.

Compara:

```kotlin
product1 == product2
dataProduct1 == dataProduct2
```

### Objetivo

Comprender una de las diferencias fundamentales entre una clase normal y una `data class`.

---

# Nivel 3 — `copy()`

## Ejercicio 5 — Copiar una persona

Utiliza:

```kotlin
data class Person(
    val name: String,
    val age: Int,
    val city: String
)
```

Crea:

```kotlin
val person1 = Person("Ana", 25, "Madrid")
```

Utiliza `copy()` para crear otra persona con la misma información pero con una edad diferente:

```kotlin
val person2 = person1.copy(age = 26)
```

Muestra ambos objetos.

### Objetivo

Practicar la creación de nuevos objetos a partir de objetos existentes.

---

## Ejercicio 6 — Copiar un producto

Crea:

```kotlin
data class Product(
    val name: String,
    val price: Double,
    val stock: Int
)
```

A partir del siguiente producto:

```kotlin
val product = Product("Laptop", 999.0, 5)
```

crea mediante `copy()`:

1. El mismo producto con otro precio.
2. El mismo producto con otro stock.
3. Un producto con otro precio y otro stock.

No modifiques directamente el objeto original.

---

## Ejercicio 7 — Objetos inmutables

Utiliza:

```kotlin
data class Person(
    val name: String,
    val age: Int
)
```

Explica por qué no podemos hacer:

```kotlin
person.age = 30
```

y cómo podemos conseguir el mismo efecto mediante `copy()`:

```kotlin
val olderPerson = person.copy(age = 30)
```

### Objetivo

Comprender la relación entre `data class`, `val` e inmutabilidad.

---

# Nivel 4 — Destructuring

## Ejercicio 8 — Descomponer una persona

Dada:

```kotlin
data class Person(
    val name: String,
    val age: Int,
    val city: String
)
```

y:

```kotlin
val person = Person("Ana", 25, "Madrid")
```

utiliza una declaración de destructuring:

```kotlin
val (...) = person
```

para obtener las tres propiedades en variables independientes.

Después, muéstralas por consola.

---

## Ejercicio 9 — Destructuring en un bucle

Crea:

```kotlin
data class Student(
    val name: String,
    val grade: Double
)
```

Crea una lista de alumnos:

```kotlin
val students = listOf(
    Student("Ana", 8.5),
    Student("Luis", 6.2),
    Student("Marta", 9.1),
    Student("Carlos", 4.8)
)
```

Recorre la lista utilizando destructuring.

El resultado debe ser similar a:

```text
Ana -> 8.5
Luis -> 6.2
Marta -> 9.1
Carlos -> 4.8
```

---

# Nivel 5 — Data classes y colecciones

## Ejercicio 10 — Buscar productos

Crea:

```kotlin
data class Product(
    val id: Int,
    val name: String,
    val price: Double
)
```

Crea una lista de productos.

Utiliza las funciones de colecciones de Kotlin para:

- Obtener los productos que cuesten más de 100 €.
- Obtener el producto con mayor precio.
- Obtener todos los nombres.
- Calcular el precio medio.
- Ordenar los productos por precio.

Evita utilizar bucles tradicionales siempre que puedas.

---

## Ejercicio 11 — Eliminar duplicados

Crea:

```kotlin
data class User(
    val username: String,
    val email: String
)
```

Crea una lista que contenga usuarios repetidos:

```kotlin
val users = listOf(
    User("ana", "ana@example.com"),
    User("luis", "luis@example.com"),
    User("ana", "ana@example.com"),
    User("marta", "marta@example.com"),
    User("luis", "luis@example.com")
)
```

Utiliza las características de las `data class` y las colecciones de Kotlin para eliminar los usuarios duplicados.

### Pregunta

¿Por qué funciona `distinct()` correctamente en este caso?

---

# Nivel 6 — `hashCode()` y colecciones

## Ejercicio 12 — `HashSet`

Utiliza:

```kotlin
data class User(
    val username: String,
    val email: String
)
```

Crea un `HashSet<User>` e intenta introducir varias veces el mismo usuario.

Comprueba el tamaño del conjunto.

Después crea una clase normal equivalente:

```kotlin
class NormalUser(
    val username: String,
    val email: String
)
```

y repite el experimento.

### Objetivo

Comprender la relación entre:

- `equals()`
- `hashCode()`
- `data class`
- `HashSet`

---

## Ejercicio 13 — `HashMap`

Crea:

```kotlin
data class Coordinate(
    val x: Int,
    val y: Int
)
```

Utiliza objetos `Coordinate` como claves de un `HashMap`.

Por ejemplo:

```kotlin
val cities = mutableMapOf(
    Coordinate(40, -3) to "Madrid",
    Coordinate(41, 2) to "Barcelona"
)
```

Comprueba que puedes recuperar un valor utilizando otra instancia con las mismas coordenadas:

```kotlin
println(cities[Coordinate(40, -3)])
```

### Pregunta

¿Por qué funciona aunque `Coordinate(40, -3)` sea una instancia diferente?

---

# Nivel 7 — Data classes con objetos

## Ejercicio 14 — Dirección y persona

Crea:

```kotlin
data class Address(
    val street: String,
    val city: String,
    val zipCode: String
)

data class Person(
    val name: String,
    val address: Address
)
```

Crea una persona con una dirección.

Después utiliza `copy()` para crear otra persona que viva en otra dirección.

Por ejemplo:

```kotlin
val person2 = person1.copy(
    address = person1.address.copy(
        city = "Barcelona"
    )
)
```

### Objetivo

Practicar `copy()` cuando una `data class` contiene otras `data class`.

---

## Ejercicio 15 — Pedido

Crea:

```kotlin
data class Product(
    val id: Int,
    val name: String,
    val price: Double
)

data class OrderItem(
    val product: Product,
    val quantity: Int
)

data class Order(
    val id: Int,
    val items: List<OrderItem>
)
```

Crea un pedido con varios productos.

Después utiliza las funciones de colecciones para:

- Obtener todos los nombres de productos.
- Calcular el número total de unidades.
- Calcular el importe total.
- Encontrar el producto más caro.
- Obtener únicamente los productos cuya cantidad sea mayor que 1.

---

# Nivel 8 — Propiedades que no participan en `equals()`

## Ejercicio 16 — Propiedad fuera del constructor

Observa:

```kotlin
data class User(
    val username: String,
    val email: String
) {
    var loginCount: Int = 0
}
```

Crea:

```kotlin
val user1 = User("ana", "ana@example.com")
val user2 = User("ana", "ana@example.com")
```

Modifica:

```kotlin
user1.loginCount = 10
```

y comprueba:

```kotlin
println(user1 == user2)
```

### Pregunta

¿Por qué `loginCount` no afecta a `equals()`?

Investiga qué propiedades utiliza Kotlin para generar:

- `equals()`
- `hashCode()`
- `toString()`
- `componentN()`
- `copy()`

---

# Nivel 9 — Restricciones de las data classes

## Ejercicio 17 — ¿Qué puede heredar una data class?

Investiga y experimenta con diferentes declaraciones.

Comprueba cuáles de las siguientes situaciones son posibles:

### A

```kotlin
data class Person(
    val name: String
)
```

### B

```kotlin
open data class Person(
    val name: String
)
```

### C

```kotlin
data class Person(
    val name: String
) : SomeInterface
```

### D

```kotlin
data class Person(
    val name: String
) : SomeClass()
```

Determina cuáles son válidas y cuáles no.

### Objetivo

Conocer las restricciones de las `data class` y su relación con:

- herencia;
- interfaces;
- clases `open`;
- generación automática de métodos.

---

# Nivel 10 — Data classes y herencia

## Ejercicio 18 — Jerarquía de figuras

Crea una interfaz:

```kotlin
interface Shape {
    fun area(): Double
}
```

Crea varias `data class` que implementen la interfaz:

```kotlin
data class Rectangle(
    val width: Double,
    val height: Double
) : Shape

data class Circle(
    val radius: Double
) : Shape
```

Implementa `area()`.

Crea una lista:

```kotlin
val shapes: List<Shape>
```

que contenga diferentes figuras.

Recórrela y muestra el área de cada una.

### Objetivo

Comprobar que una `data class` puede implementar interfaces y utilizar polimorfismo.

---

# Nivel 11 — Data classes genéricas

## Ejercicio 19 — Resultado genérico

Crea una `data class` genérica:

```kotlin
data class Result<T>(
    val value: T,
    val success: Boolean
)
```

Utilízala con diferentes tipos:

```kotlin
val result1 = Result(10, true)
val result2 = Result("Hello", true)
val result3 = Result(listOf(1, 2, 3), false)
```

Utiliza `result1`, `result2` y `result3` para practicar la inferencia de tipos genéricos.

---

## Ejercicio 20 — Pair personalizado

Crea una `data class` genérica:

```kotlin
data class PairOf<A, B>(
    val first: A,
    val second: B
)
```

Crea pares de diferentes tipos:

```kotlin
val pair1 = PairOf("Age", 25)
val pair2 = PairOf("Weight", 75.5)
val pair3 = PairOf(10, true)
```

Utiliza destructuring para obtener los valores.

---

# Nivel 12 — Data classes y transformación de datos

## Ejercicio 21 — DTO de usuario

Crea:

```kotlin
data class UserDto(
    val id: Int,
    val username: String,
    val email: String
)
```

y:

```kotlin
data class User(
    val username: String,
    val email: String
)
```

Crea una función:

```kotlin
fun UserDto.toUser(): User
```

que transforme un `UserDto` en un `User`.

Después crea una lista de `UserDto` y conviértela en una lista de `User`.

### Objetivo

Introducir el uso de `data class` como objetos para transportar datos.

---

# Nivel 13 — `copy()` y actualizaciones inmutables

## Ejercicio 22 — Carrito de compra

Crea:

```kotlin
data class CartItem(
    val product: String,
    val quantity: Int,
    val price: Double
)

data class ShoppingCart(
    val items: List<CartItem>
)
```

Crea un carrito.

Ahora implementa funciones que reciban un `ShoppingCart` y devuelvan **otro carrito**, sin modificar el original:

```kotlin
fun addItem(
    cart: ShoppingCart,
    item: CartItem
): ShoppingCart
```

y:

```kotlin
fun removeItem(
    cart: ShoppingCart,
    product: String
): ShoppingCart
```

Utiliza `copy()`.

### Objetivo

Practicar un estilo de programación basado en objetos inmutables.

---

# Nivel 14 — Data class con comportamiento

## Ejercicio 23 — Vector 2D

Crea:

```kotlin
data class Vector2D(
    val x: Double,
    val y: Double
)
```

Añade métodos:

```kotlin
fun length(): Double
fun normalized(): Vector2D
fun scale(factor: Double): Vector2D
```

Además, implementa:

```kotlin
operator fun plus(other: Vector2D): Vector2D
operator fun minus(other: Vector2D): Vector2D
operator fun times(value: Double): Vector2D
```

Ejemplo:

```kotlin
val a = Vector2D(10.0, 5.0)
val b = Vector2D(2.0, 3.0)

println(a + b)
println(a - b)
println(a * 2.0)
```

### Objetivo

Comprender que una `data class` puede contener comportamiento además de datos.

---

# Nivel 15 — Data classes para modelar estados

## Ejercicio 24 — Estado de un personaje

Crea:

```kotlin
data class Player(
    val name: String,
    val health: Int,
    val level: Int
)
```

Implementa funciones que no modifiquen el jugador original:

```kotlin
fun damage(player: Player, amount: Int): Player
fun heal(player: Player, amount: Int): Player
fun levelUp(player: Player): Player
```

Utiliza `copy()`.

Ejemplo:

```kotlin
val player1 = Player("Aragorn", 100, 5)

val player2 = damage(player1, 20)
val player3 = heal(player2, 10)
val player4 = levelUp(player3)
```

Comprueba que `player1` sigue teniendo sus valores originales.

---

# Nivel 16 — Reto: data class y `copy()`

## Ejercicio 25 — Editor de configuración

Crea:

```kotlin
data class Configuration(
    val host: String,
    val port: Int,
    val username: String,
    val useSsl: Boolean,
    val timeout: Int
)
```

Crea una configuración inicial:

```kotlin
val defaultConfiguration = Configuration(
    host = "localhost",
    port = 8080,
    username = "admin",
    useSsl = false,
    timeout = 30
)
```

Utiliza `copy()` para crear diferentes configuraciones:

- Configuración de producción.
- Configuración de desarrollo.
- Configuración con SSL.
- Configuración con otro puerto.

No crees manualmente cada objeto desde cero.

---

# Nivel 17 — Reto avanzado

## Ejercicio 26 — Sistema de inventario

Diseña un sistema de inventario utilizando varias `data class`.

Como mínimo, utiliza:

```kotlin
data class Item(
    val id: Int,
    val name: String,
    val weight: Double
)
```

```kotlin
data class InventoryItem(
    val item: Item,
    val quantity: Int
)
```

```kotlin
data class Inventory(
    val items: List<InventoryItem>
)
```

Implementa funciones para:

- Añadir un objeto.
- Eliminar un objeto.
- Modificar su cantidad.
- Obtener el peso total.
- Buscar un objeto por ID.
- Obtener los objetos cuyo peso supere un determinado valor.

Todas las operaciones deben devolver un nuevo `Inventory` en lugar de modificar el original.

---

# Ejercicio 27 — Reto final: sistema de estudiantes

Diseña un pequeño sistema académico utilizando `data class`.

Crea:

```kotlin
data class Student(
    val id: Int,
    val name: String,
    val age: Int
)
```

```kotlin
data class Subject(
    val code: String,
    val name: String,
    val credits: Int
)
```

```kotlin
data class Enrollment(
    val student: Student,
    val subject: Subject,
    val grade: Double?
)
```

Crea una lista de matrículas.

Utiliza las operaciones de colecciones de Kotlin para:

1. Obtener todos los alumnos.
2. Obtener todas las asignaturas.
3. Obtener los alumnos que han aprobado.
4. Obtener la nota media.
5. Obtener la asignatura con mayor número de matrículas.
6. Obtener las asignaturas en las que está matriculado un alumno.
7. Agrupar las matrículas por asignatura.
8. Agrupar las matrículas por alumno.
9. Obtener los alumnos que tienen alguna asignatura suspensa.
10. Obtener los alumnos que han aprobado todas sus asignaturas.

### Objetivo

Combinar:

- `data class`;
- `equals()`;
- `hashCode()`;
- `copy()`;
- colecciones;
- `map`;
- `filter`;
- `groupBy`;
- `flatMap`;
- `distinct`;
- `associate`;
- `fold` o `sumOf`;
- objetos anidados.

---

# Reto final avanzado — Modelar una API

## Ejercicio 28 — Respuesta de una API

Imagina que una aplicación recibe la siguiente información de un servidor:

```json
{
    "id": 15,
    "name": "Rafael",
    "email": "rafael@example.com",
    "address": {
        "street": "Gran Vía",
        "city": "Madrid",
        "zipCode": "28013"
    }
}
```

Modela esta información utilizando `data class`.

Crea:

```kotlin
data class Address(
    val street: String,
    val city: String,
    val zipCode: String
)

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val address: Address
)
```

Después:

1. Crea varios usuarios.
2. Busca usuarios por ciudad.
3. Obtén únicamente sus nombres.
4. Crea una copia de un usuario cambiando su dirección.
5. Comprueba cómo funciona `equals()`.
6. Utiliza un `Set<User>` para eliminar usuarios duplicados.

### Ampliación

Investiga cómo estas mismas `data class` pueden utilizarse posteriormente con una librería de serialización como `kotlinx.serialization`.

---

# Resumen de conceptos

| Ejercicio | Conceptos principales |
|---|---|
| 1–2 | Declaración de `data class` |
| 3–4 | `equals()` |
| 5–7 | `copy()` e inmutabilidad |
| 8–9 | Destructuring |
| 10–11 | Colecciones |
| 12–13 | `hashCode()`, `HashSet`, `HashMap` |
| 14–15 | Data classes anidadas |
| 16 | Propiedades fuera del constructor primario |
| 17–18 | Restricciones e interfaces |
| 19–20 | Data classes genéricas |
| 21 | Transformación de objetos |
| 22 | Actualizaciones inmutables |
| 23 | Data class con comportamiento y operadores |
| 24 | Modelado de estados |
| 25 | `copy()` avanzado |
| 26 | Modelado de estructuras complejas |
| 27 | Data classes + colecciones |
| 28 | Modelado de datos de una API |

## Objetivo final

Al finalizar los ejercicios, el alumno debería comprender que una `data class` está especialmente orientada a **representar datos**, y conocer las funcionalidades que Kotlin proporciona automáticamente:

```text
equals()
hashCode()
toString()
copy()
component1()
component2()
...
```

También debería saber cuándo resulta apropiado utilizar una `data class` y cuándo es preferible utilizar una clase normal.