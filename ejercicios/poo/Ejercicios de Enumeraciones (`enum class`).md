# Ejercicios de Kotlin — Enumeraciones (`enum class`)

Colección progresiva de ejercicios para practicar las enumeraciones de Kotlin, desde su uso más sencillo hasta características avanzadas.

---

# Nivel 1 — Enumeraciones básicas

## Ejercicio 1 — Días de la semana

Crea un enum `Day` que represente los siete días de la semana:

```kotlin
enum class Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

Crea un programa que:

1. Declare una variable de tipo `Day`.
2. Muestre su valor por consola.
3. Cambie su valor a otro día.
4. Utilice un `when` para indicar si es un día laborable o de fin de semana.

Ejemplo:

```text
MONDAY -> Working day
SATURDAY -> Weekend
```

---

## Ejercicio 2 — Semáforo

Crea un enum `TrafficLight` con:

- `RED`
- `YELLOW`
- `GREEN`

Escribe una función:

```kotlin
fun action(light: TrafficLight): String
```

que indique qué debe hacer un conductor.

Por ejemplo:

```text
RED    -> Stop
YELLOW -> Slow down
GREEN  -> Go
```

Utiliza `when`.

---

## Ejercicio 3 — Meses del año

Crea un enum `Month` con los doce meses.

Escribe una función:

```kotlin
fun season(month: Month): String
```

que devuelva:

- `Winter`
- `Spring`
- `Summer`
- `Autumn`

según el mes recibido.

---

# Nivel 2 — Propiedades y métodos

## Ejercicio 4 — Mes con número

Modifica el ejercicio anterior para que cada mes tenga asociado su número:

```kotlin
enum class Month(val number: Int) {
    JANUARY(1),
    FEBRUARY(2),
    // ...
}
```

Haz que sea posible escribir:

```kotlin
println(Month.MARCH.number)
```

y obtener:

```text
3
```

---

## Ejercicio 5 — Días del mes

Amplía `Month` para almacenar el número de días que tiene cada mes.

Por ejemplo:

```kotlin
enum class Month(val number: Int, val days: Int) {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    // ...
}
```

Añade un método:

```kotlin
fun hasThirtyDays(): Boolean
```

que indique si el mes tiene exactamente 30 días.

---

## Ejercicio 6 — Enumeración con métodos

Crea:

```kotlin
enum class TrafficLight
```

pero esta vez cada constante debe proporcionar directamente la acción que corresponde.

El objetivo es poder escribir:

```kotlin
println(TrafficLight.RED.action())
println(TrafficLight.GREEN.action())
```

y obtener:

```text
Stop
Go
```

Intenta evitar un `when` externo.

---

# Nivel 3 — Constructores y propiedades calculadas

## Ejercicio 7 — Niveles de dificultad

Crea:

```kotlin
enum class Difficulty(
    val multiplier: Double
)
```

con los siguientes niveles:

- `EASY` → `0.5`
- `NORMAL` → `1.0`
- `HARD` → `1.5`
- `EXTREME` → `2.0`

Añade una función:

```kotlin
fun damage(baseDamage: Int): Int
```

que calcule el daño final aplicando el multiplicador.

Ejemplo:

```kotlin
println(Difficulty.HARD.damage(100))
```

Resultado:

```text
150
```

---

## Ejercicio 8 — Rangos de edad

Crea un enum `AgeGroup`:

- `CHILD`
- `TEENAGER`
- `ADULT`
- `SENIOR`

Cada constante debe almacenar la edad mínima y máxima correspondiente.

Añade:

```kotlin
fun contains(age: Int): Boolean
```

para comprobar si una edad pertenece al grupo.

Ejemplo:

```kotlin
println(AgeGroup.TEENAGER.contains(15))
```

---

## Ejercicio 9 — Operaciones matemáticas

Crea un enum:

```kotlin
enum class Operation
```

con:

- `ADD`
- `SUBTRACT`
- `MULTIPLY`
- `DIVIDE`

Cada constante debe implementar una operación.

Debe ser posible escribir:

```kotlin
println(Operation.ADD.calculate(10, 5))
println(Operation.MULTIPLY.calculate(10, 5))
```

Resultado:

```text
15
50
```

Controla también la división entre cero.

---

# Nivel 4 — `entries`, `values` y `valueOf`

## Ejercicio 10 — Recorrer un enum

Utilizando el enum `Month`, muestra todos sus valores por consola.

Investiga y utiliza:

```kotlin
Month.entries
```

para recorrerlos.

El resultado debe ser similar a:

```text
JANUARY
FEBRUARY
MARCH
...
DECEMBER
```

Como ampliación, muestra también el número y los días de cada mes.

---

## Ejercicio 11 — Buscar una constante

Crea un programa que solicite al usuario el nombre de un mes:

```text
Enter a month:
```

y convierta el texto introducido en una constante `Month`.

Investiga el funcionamiento de:

```kotlin
Month.valueOf(...)
```

Controla correctamente el caso en que el usuario introduzca un valor que no corresponda con ninguna constante.

---

## Ejercicio 12 — Enum y entrada por consola

Crea un enum:

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

Solicita al usuario una dirección y muestra hacia dónde se desplazará un personaje.

Haz que la entrada sea independiente de mayúsculas y minúsculas.

Por ejemplo:

```text
Enter direction: north
Moving north
```

---

# Nivel 5 — Enum con `companion object`

## Ejercicio 13 — Buscar por código

Crea:

```kotlin
enum class HttpStatus(
    val code: Int
)
```

con algunos códigos HTTP habituales:

- `OK(200)`
- `CREATED(201)`
- `BAD_REQUEST(400)`
- `UNAUTHORIZED(401)`
- `FORBIDDEN(403)`
- `NOT_FOUND(404)`
- `INTERNAL_SERVER_ERROR(500)`

Añade un `companion object` con:

```kotlin
fun fromCode(code: Int): HttpStatus?
```

De esta manera:

```kotlin
val status = HttpStatus.fromCode(404)
```

debe devolver:

```kotlin
HttpStatus.NOT_FOUND
```

Si el código no existe, debe devolver `null`.

---

## Ejercicio 14 — Buscar por nombre

Crea un enum `Planet` con los planetas del sistema solar.

Añade:

```kotlin
companion object {
    fun fromName(name: String): Planet?
}
```

La búsqueda debe ser independiente de mayúsculas y minúsculas.

Por ejemplo:

```kotlin
Planet.fromName("earth")
Planet.fromName("EARTH")
Planet.fromName("Earth")
```

deben devolver la misma constante.

---

# Nivel 6 — Enum implementando interfaces

## Ejercicio 15 — Figuras geométricas

Crea una interfaz:

```kotlin
interface Shape {
    fun area(): Double
}
```

Crea un enum `RegularPolygon` que implemente `Shape`.

Incluye:

- `TRIANGLE`
- `SQUARE`
- `PENTAGON`
- `HEXAGON`

Cada constante tendrá asociado el número de lados.

Como todos los polígonos tendrán el mismo tamaño de lado, utiliza una propiedad para representar la longitud del lado.

Investiga cómo puede implementarse `area()` utilizando las propiedades del enum.

---

## Ejercicio 16 — Unidades de tiempo

Crea una interfaz:

```kotlin
interface TimeUnit {
    fun toSeconds(value: Long): Long
}
```

Crea un enum:

```kotlin
enum class Unit : TimeUnit
```

con:

- `SECOND`
- `MINUTE`
- `HOUR`
- `DAY`

Cada constante debe implementar `toSeconds()` de manera apropiada.

Ejemplo:

```kotlin
println(Unit.HOUR.toSeconds(2))
```

Resultado:

```text
7200
```

---

# Nivel 7 — Comportamiento diferente para cada constante

## Ejercicio 17 — Operaciones matemáticas avanzadas

Modifica el ejercicio de `Operation` para que cada constante implemente su propio comportamiento.

El objetivo es conseguir algo conceptualmente parecido a:

```kotlin
enum class Operation {
    ADD {
        override fun calculate(a: Int, b: Int) = a + b
    },

    SUBTRACT {
        override fun calculate(a: Int, b: Int) = a - b
    },

    MULTIPLY {
        override fun calculate(a: Int, b: Int) = a * b
    },

    DIVIDE {
        override fun calculate(a: Int, b: Int) = a / b
    };

    abstract fun calculate(a: Int, b: Int): Int
}
```

No utilices un `when` para determinar qué operación realizar.

### Objetivo

Comprender que **cada constante de un enum puede tener su propia implementación de métodos**.

---

## Ejercicio 18 — Estados de un pedido

Crea:

```kotlin
enum class OrderStatus
```

con:

- `CREATED`
- `PAID`
- `SHIPPED`
- `DELIVERED`
- `CANCELLED`

Añade un método:

```kotlin
fun canCancel(): Boolean
```

Cada estado debe decidir por sí mismo si permite cancelar el pedido.

Por ejemplo:

```kotlin
OrderStatus.CREATED.canCancel()    // true
OrderStatus.PAID.canCancel()       // true
OrderStatus.SHIPPED.canCancel()    // false
OrderStatus.DELIVERED.canCancel()  // false
OrderStatus.CANCELLED.canCancel()  // false
```

Evita utilizar un `when`.

---

# Nivel 8 — Enums con estado

## Ejercicio 19 — Planetas

Crea un enum `Planet` donde cada planeta tenga:

- `mass`
- `radius`

Añade una propiedad calculada:

```kotlin
val surfaceGravity: Double
```

que calcule la gravedad superficial utilizando:

```text
g = G × mass / radius²
```

Define la constante gravitacional necesaria.

Después añade:

```kotlin
fun weightOnPlanet(weight: Double): Double
```

que calcule cuánto pesaría una persona en ese planeta.

Por ejemplo:

```kotlin
println(Planet.MARS.weightOnPlanet(80.0))
```

---

## Ejercicio 20 — Cartas de una baraja

Crea:

```kotlin
enum class Suit
```

con:

- `CLUBS`
- `DIAMONDS`
- `HEARTS`
- `SPADES`

Y:

```kotlin
enum class Rank
```

con:

- `TWO`
- `THREE`
- ...
- `TEN`
- `JACK`
- `QUEEN`
- `KING`
- `ACE`

Cada `Rank` debe tener asociado un valor numérico.

Después crea:

```kotlin
data class Card(
    val suit: Suit,
    val rank: Rank
)
```

Finalmente, crea una función que genere una baraja completa utilizando:

```kotlin
Suit.entries
Rank.entries
```

El resultado debe contener exactamente 52 cartas.

---

# Nivel 9 — Enums y funciones de orden superior

## Ejercicio 21 — Modos de ordenación

Crea un enum:

```kotlin
enum class SortOrder
```

con:

- `ASCENDING`
- `DESCENDING`

Crea una función que reciba una lista de números y un `SortOrder` y devuelva la lista ordenada según el modo indicado.

Ejemplo:

```kotlin
sort(listOf(5, 2, 8, 1), SortOrder.ASCENDING)
```

Resultado:

```text
[1, 2, 5, 8]
```

Como ampliación, intenta almacenar dentro de cada constante la función necesaria para realizar la ordenación.

---

# Nivel 10 — Enums avanzados

## Ejercicio 22 — Sistema de permisos

Crea:

```kotlin
enum class Permission
```

con:

- `READ`
- `WRITE`
- `DELETE`
- `ADMIN`

Cada permiso debe tener asociado un nivel de importancia.

Después crea:

```kotlin
class User(
    val name: String,
    val permissions: Set<Permission>
)
```

Añade una función:

```kotlin
fun hasPermission(permission: Permission): Boolean
```

que permita comprobar si el usuario dispone de un permiso.

Como ampliación, haz que `ADMIN` implique automáticamente todos los demás permisos.

---

## Ejercicio 23 — Estados de una máquina

Crea una máquina que pueda encontrarse en diferentes estados:

```kotlin
enum class MachineState {
    OFF,
    STARTING,
    RUNNING,
    STOPPING,
    ERROR
}
```

Cada estado debe definir qué transiciones son posibles.

Por ejemplo:

```text
OFF       -> STARTING
STARTING  -> RUNNING, ERROR
RUNNING   -> STOPPING, ERROR
STOPPING  -> OFF
ERROR     -> OFF
```

Crea:

```kotlin
fun transitionTo(state: MachineState): Boolean
```

que compruebe si una transición es válida.

### Reto

Intenta almacenar dentro de cada constante el conjunto de estados a los que puede realizar una transición:

```kotlin
private val allowedTransitions: Set<MachineState>
```

De esta manera, la propia enumeración contiene las reglas de transición.

---

# Nivel 11 — Enum con propiedades y comportamiento complejo

## Ejercicio 24 — Clases de personaje

Crea:

```kotlin
enum class CharacterClass
```

con:

- `WARRIOR`
- `MAGE`
- `ROGUE`
- `ARCHER`

Cada clase debe tener:

- `baseHealth`
- `baseMana`
- `baseStrength`
- `baseIntelligence`
- `baseSpeed`

Además, cada clase debe proporcionar un método:

```kotlin
fun attack(): String
```

que tenga un comportamiento diferente.

Por ejemplo:

```text
WARRIOR -> Performs a powerful sword attack
MAGE    -> Casts a magic spell
ROGUE   -> Performs a fast attack
ARCHER  -> Shoots an arrow
```

Evita utilizar un `when` externo.

---

# Nivel 12 — Reto final

## Ejercicio 25 — Sistema completo de pedidos

Diseña un pequeño sistema de pedidos utilizando enums.

Crea:

### `OrderStatus`

```text
CREATED
PAID
PREPARING
SHIPPED
DELIVERED
CANCELLED
```

### `PaymentMethod`

```text
CREDIT_CARD
PAYPAL
BANK_TRANSFER
CASH
```

Cada método de pago debe proporcionar una descripción.

### `ShippingMethod`

```text
STANDARD
EXPRESS
PICKUP
```

Cada método debe tener:

- precio
- número estimado de días

### `Order`

Crea una clase:

```kotlin
class Order(
    val id: Int,
    val paymentMethod: PaymentMethod,
    val shippingMethod: ShippingMethod
)
```

El pedido debe comenzar siempre en estado `CREATED`.

Añade métodos para:

```kotlin
pay()
prepare()
ship()
deliver()
cancel()
```

Cada operación debe comprobar si la transición es válida.

Por ejemplo:

```text
CREATED -> PAID
PAID -> PREPARING
PREPARING -> SHIPPED
SHIPPED -> DELIVERED
```

Un pedido entregado no puede volver a enviarse.

Un pedido cancelado no puede modificarse.

### Reto adicional

Haz que `OrderStatus` sea responsable de determinar qué transiciones están permitidas, de forma que `Order` no necesite conocer todos los detalles de los estados.

---

# Reto final avanzado — Enum como estrategia

## Ejercicio 26 — Sistema de descuentos

Crea:

```kotlin
enum class CustomerType
```

con:

- `REGULAR`
- `PREMIUM`
- `VIP`
- `EMPLOYEE`

Cada tipo de cliente debe calcular su descuento de manera diferente.

Por ejemplo:

```text
REGULAR  -> 0%
PREMIUM  -> 10%
VIP      -> 20%
EMPLOYEE -> 30%
```

Crea:

```kotlin
fun finalPrice(price: Double): Double
```

de manera que:

```kotlin
CustomerType.VIP.finalPrice(100.0)
```

devuelva:

```text
80.0
```

### Restricción

No utilices `when`.

Cada constante del enum debe proporcionar su propio comportamiento.

---

# Reto final avanzado — Enum implementando una interfaz

## Ejercicio 27 — Sistema de notificaciones

Define:

```kotlin
interface NotificationChannel {
    fun send(message: String)
}
```

Crea un enum:

```kotlin
enum class Channel : NotificationChannel
```

con:

- `EMAIL`
- `SMS`
- `PUSH`
- `WHATSAPP`

Cada constante debe implementar `send()` de manera diferente.

Por ejemplo:

```kotlin
Channel.EMAIL.send("Hello")
Channel.SMS.send("Hello")
```

deberían producir mensajes diferentes por consola.

### Reto adicional

Haz que cada canal tenga además:

- un límite máximo de caracteres;
- un coste por mensaje;
- una descripción.

Por ejemplo:

```kotlin
Channel.SMS.maxLength
Channel.EMAIL.cost
Channel.PUSH.description
```

---

# Reto experto — Enum con comportamiento y `companion object`

## Ejercicio 28 — Parser de comandos

Crea un enum:

```kotlin
enum class Command
```

con:

- `START`
- `STOP`
- `PAUSE`
- `RESUME`
- `RESTART`

Cada comando debe tener:

- un código;
- una descripción;
- una acción.

Por ejemplo:

```kotlin
Command.START.code
Command.START.description
Command.START.execute()
```

Añade además:

```kotlin
companion object {
    fun fromCode(code: String): Command?
}
```

De manera que:

```kotlin
Command.fromCode("START")
```

devuelva:

```kotlin
Command.START
```

### Objetivo

Combinar:

- propiedades;
- métodos;
- constructores;
- comportamiento específico por constante;
- `companion object`;
- búsqueda dentro de `entries`;
- valores nullable.

---

# Reto experto final — Máquina de estados mediante enum

## Ejercicio 29 — Máquina de estados de un reproductor

Crea un reproductor multimedia cuyos estados sean:

```text
STOPPED
PLAYING
PAUSED
```

Cada estado debe definir qué acciones son válidas.

Las acciones serán:

```text
PLAY
PAUSE
STOP
```

Diseña el enum para que sea posible consultar:

```kotlin
PlayerState.PLAYING.canExecute(Action.PAUSE)
PlayerState.STOPPED.canExecute(Action.PLAY)
```

Después crea:

```kotlin
enum class Action
```

y una clase `Player` que utilice ambos enums.

El objetivo final es que las reglas de la máquina de estados estén contenidas en los propios enums y que `Player` se limite a coordinar el funcionamiento.

### Reto adicional

Haz que cada `Action` pueda producir un nuevo `PlayerState` dependiendo del estado actual.

Por ejemplo:

```text
STOPPED + PLAY  -> PLAYING
PLAYING + PAUSE -> PAUSED
PAUSED + PLAY   -> PLAYING
PLAYING + STOP  -> STOPPED
PAUSED + STOP   -> STOPPED
```

De esta manera, los enums pasan de ser simples conjuntos de constantes a representar **datos + comportamiento + reglas del dominio**.

---

# Conceptos que se practican

Los ejercicios recorren progresivamente las principales posibilidades de `enum class` en Kotlin:

| Nivel | Conceptos |
|---|---|
| 1 | `enum class`, constantes |
| 2 | `when` sobre enums |
| 3 | Propiedades |
| 4 | Constructores |
| 5 | Métodos |
| 6 | Propiedades calculadas |
| 7 | `entries` |
| 8 | `valueOf()` |
| 9 | `companion object` |
| 10 | Interfaces |
| 11 | Implementación específica por constante |
| 12 | Estado interno |
| 13 | Colecciones de enums |
| 14 | Enums + funciones de orden superior |
| 15 | Máquinas de estados |
| 16 | Enums como estrategia |
| 17 | Enums con comportamiento complejo |
| 18 | Combinación de todas las características |

## Objetivo final

Al terminar la colección, el alumno debería entender que un `enum class` en Kotlin **no es simplemente una lista de constantes**. Una enumeración puede contener:

- propiedades;
- constructores;
- métodos;
- propiedades calculadas;
- `companion object`;
- implementación de interfaces;
- comportamiento diferente para cada constante;
- colecciones;
- reglas de negocio;
- e incluso participar en el diseño de máquinas de estados y patrones de estrategia.