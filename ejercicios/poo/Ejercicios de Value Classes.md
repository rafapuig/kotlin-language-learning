# Ejercicios de Kotlin: Value Classes

## Objetivos

Con estos ejercicios practicarás:

- La declaración de `value class`.
- El uso de `@JvmInline`.
- La diferencia entre un tipo primitivo y un tipo con significado propio.
- La creación de tipos seguros para evitar mezclar valores.
- Constructores y validación en value classes.
- Propiedades y funciones miembro.
- Uso de value classes como parámetros y valores de retorno.
- Nullable y *boxing*.
- Uso de value classes con interfaces.
- Limitaciones de las value classes.
- Diferencias entre `value class`, `data class` y `typealias`.
- Diseño de APIs más seguras mediante tipos de dominio.

> **Nota:** En Kotlin/JVM, las value classes se declaran normalmente con `@JvmInline value class` y deben tener una única propiedad en el constructor primario.

---

## 1. Primera value class

Crea una value class llamada `UserId` que almacene un `Int`.

Debe ser posible escribir:

```kotlin
val id = UserId(42)

println(id)
```

### Objetivos

- Practicar la sintaxis básica de una value class.
- Comprender que `UserId` es un tipo diferente de `Int`.

### Preguntas

¿Qué ocurre si intentas hacer esto?

```kotlin
val id: UserId = 42
```

¿Y esto?

```kotlin
val number: Int = id
```

---

# 2. Evitar mezclar identificadores

Crea estas tres value classes:

```kotlin
UserId
ProductId
OrderId
```

Todas deben almacenar un `Int`.

Después crea:

```kotlin
fun loadUser(id: UserId)
fun loadProduct(id: ProductId)
fun loadOrder(id: OrderId)
```

El programa debe impedir llamadas como:

```kotlin
loadUser(productId)
```

### Objetivo

Comprobar una de las principales ventajas de las value classes:

> Dos valores pueden tener la misma representación interna, pero representar conceptos diferentes.

---

# 3. Value class sobre String

Crea:

```kotlin
@JvmInline
value class Email(val value: String)
```

Utilízala en:

```kotlin
fun sendEmail(to: Email)
```

Prueba a crear:

```kotlin
val email = Email("rafa@example.com")
sendEmail(email)
```

### Pregunta

¿Qué ventaja tiene utilizar `Email` en lugar de:

```kotlin
fun sendEmail(to: String)
```

---

# 4. Validación en la creación

Modifica `Email` para que no permita crear direcciones vacías.

Por ejemplo:

```kotlin
Email("")
```

debe producir una excepción.

Puedes utilizar:

```kotlin
require(...)
```

### Ampliación

Comprueba también que la dirección contiene:

```text
@
```

Por ejemplo:

```text
rafa@example.com
```

es válida, mientras que:

```text
rafaexample.com
```

no lo es.

---

# 5. Propiedades calculadas

Crea:

```kotlin
@JvmInline
value class Celsius(val value: Double)
```

Añade una propiedad:

```kotlin
val fahrenheit: Double
```

que convierta la temperatura utilizando:

```text
F = C × 9 / 5 + 32
```

Ejemplo:

```kotlin
val temperature = Celsius(20.0)

println(temperature.fahrenheit)
```

---

# 6. Funciones miembro

Crea:

```kotlin
@JvmInline
value class Meters(val value: Double)
```

Añade:

```kotlin
fun toKilometers(): Double
```

y:

```kotlin
fun toCentimeters(): Double
```

Prueba:

```kotlin
val distance = Meters(1500.0)
```

---

# 7. Value classes para unidades

Crea las siguientes value classes:

```kotlin
Meters
Kilometers
Seconds
Minutes
```

Implementa funciones de conversión.

Por ejemplo:

```kotlin
Meters(2500.0).toKilometers()
Minutes(5.0).toSeconds()
```

### Objetivo

Evitar que una función pueda recibir accidentalmente una unidad incorrecta.

Por ejemplo:

```kotlin
fun calculateSpeed(distance: Meters, time: Seconds)
```

debería ser imposible de llamar con `Kilometers` o `Minutes` accidentalmente.

---

# 8. Value class frente a `typealias`

Considera:

```kotlin
typealias UserId = Int
```

y:

```kotlin
@JvmInline
value class UserId(val value: Int)
```

Crea un pequeño programa donde puedas comprobar que:

```kotlin
typealias UserId = Int
```

no crea realmente un tipo nuevo.

Después comprueba que la value class sí proporciona seguridad de tipos.

### Pregunta

¿Por qué una value class resulta más apropiada para representar un identificador de usuario?

---

# 9. Value class frente a data class

Crea:

```kotlin
data class ProductCodeData(val value: String)

@JvmInline
value class ProductCodeValue(val value: String)
```

Utiliza ambas para representar un código de producto.

Compara:

- declaración;
- creación;
- `toString()`;
- `equals()`;
- `hashCode()`;
- posibilidad de tener varias propiedades.

### Pregunta

¿Qué diferencia conceptual existe entre una `data class` y una `value class`?

---

# 10. Crear una API con value classes

Diseña un sistema de pagos.

Crea:

```kotlin
@JvmInline
value class AccountId(val value: String)

@JvmInline
value class Amount(val value: Double)

@JvmInline
value class Currency(val value: String)
```

Después crea:

```kotlin
fun transfer(
    from: AccountId,
    to: AccountId,
    amount: Amount,
    currency: Currency
)
```

Escribe varias llamadas correctas.

Después intenta realizar llamadas incorrectas intercambiando los parámetros.

### Objetivo

Comprobar cómo las value classes hacen más expresiva una API.

---

# 11. Propiedad adicional

Crea:

```kotlin
@JvmInline
value class UserId(val value: Int)
```

Añade una propiedad:

```kotlin
val isGuest: Boolean
```

Considera que los usuarios cuyo identificador sea `0` representan usuarios invitados.

Ejemplo:

```kotlin
val id = UserId(0)

println(id.isGuest)
```

### Pregunta

¿La propiedad `isGuest` necesita almacenarse físicamente?

---

# 12. Funciones de extensión sobre value classes

Crea:

```kotlin
@JvmInline
value class Meters(val value: Double)
```

Después crea funciones de extensión:

```kotlin
fun Meters.toFeet(): Double
fun Meters.isLongerThan(other: Meters): Boolean
```

Ejemplo:

```kotlin
val a = Meters(10.0)
val b = Meters(5.0)

println(a.toFeet())
println(a.isLongerThan(b))
```

### Objetivo

Comparar:

- funciones miembro;
- funciones de extensión.

---

# 13. Value class nullable

Crea:

```kotlin
@JvmInline
value class UserId(val value: Int)
```

Prueba:

```kotlin
val id: UserId? = UserId(10)
```

y:

```kotlin
val empty: UserId? = null
```

Después crea:

```kotlin
fun findUser(id: UserId?): String
```

que devuelva:

```text
"User 10"
```

cuando existe un identificador y:

```text
"No user"
```

cuando es `null`.

### Pregunta

Investiga qué ocurre internamente cuando una value class se utiliza como tipo nullable.

---

# 14. Boxing y unboxing

Utiliza:

```kotlin
@JvmInline
value class UserId(val value: Int)
```

y experimenta con funciones como:

```kotlin
fun printId(id: UserId)
```

y:

```kotlin
fun printNullableId(id: UserId?)
```

También prueba:

```kotlin
val ids = listOf(
    UserId(1),
    UserId(2),
    UserId(3)
)
```

### Preguntas

Investiga y explica:

1. ¿Qué significa *boxing*?
2. ¿Qué significa *unboxing*?
3. ¿Por qué una value class puede necesitar boxing?
4. ¿Qué relación tiene esto con los tipos nullable?
5. ¿Qué relación tiene con genéricos?

---

# 15. Value class y `List`

Crea:

```kotlin
@JvmInline
value class ProductId(val value: Int)
```

Después:

```kotlin
val products = listOf(
    ProductId(10),
    ProductId(20),
    ProductId(30)
)
```

Realiza operaciones utilizando:

- `filter`;
- `map`;
- `first`;
- `find`;
- `any`.

Por ejemplo:

```kotlin
products.find { it.value == 20 }
```

---

# 16. Value class como clave de un `Map`

Crea:

```kotlin
@JvmInline
value class UserId(val value: Int)
```

Utilízala como clave:

```kotlin
val users = mapOf(
    UserId(1) to "Ana",
    UserId(2) to "Luis",
    UserId(3) to "Marta"
)
```

Implementa:

```kotlin
fun findUser(
    users: Map<UserId, String>,
    id: UserId
): String?
```

### Objetivo

Utilizar value classes en estructuras de datos y observar su comportamiento con `equals()` y `hashCode()`.

---

# 17. Implementar una interfaz

Crea:

```kotlin
interface Identifiable {
    val id: String
}
```

Después crea una value class:

```kotlin
@JvmInline
value class UserId(val value: String)
```

Haz que implemente la interfaz.

Por ejemplo:

```kotlin
val userId = UserId("USR-001")

println(userId.id)
```

### Pregunta

¿Qué valor debe devolver `id`?

---

# 18. Value class con comportamiento

Crea:

```kotlin
@JvmInline
value class Percentage(val value: Double)
```

Debe representar un porcentaje entre `0` y `100`.

Añade:

```kotlin
fun asDecimal(): Double
fun isComplete(): Boolean
```

Ejemplo:

```kotlin
val progress = Percentage(75.0)

println(progress.asDecimal())   // 0.75
println(progress.isComplete())  // false
```

La creación de un porcentaje fuera del rango válido debe producir una excepción.

---

# 19. Modelar dinero

Crea:

```kotlin
@JvmInline
value class Euros(val value: Double)
```

Implementa:

```kotlin
fun Euros.plus(other: Euros): Euros
fun Euros.minus(other: Euros): Euros
fun Euros.multiply(factor: Double): Euros
```

Ejemplo:

```kotlin
val price = Euros(19.99)
val tax = Euros(4.20)

val total = price.plus(tax)
```

### Ampliación

Añade:

```kotlin
fun Euros.isGreaterThan(other: Euros): Boolean
```

---

# 20. Evitar errores de dominio

Imagina:

```kotlin
fun createUser(
    name: String,
    age: Int,
    salary: Double
)
```

Esta API permite pasar cualquier `Int` como edad y cualquier `Double` como salario.

Rediseñala utilizando:

```kotlin
Age
Salary
```

como value classes.

Por ejemplo:

```kotlin
fun createUser(
    name: String,
    age: Age,
    salary: Salary
)
```

### Objetivo

Convertir valores primitivos genéricos en tipos con significado de dominio.

---

# 21. Value classes para datos de contacto

Diseña:

```kotlin
Email
PhoneNumber
PostalCode
```

Cada una debe:

- almacenar un `String`;
- validar su contenido;
- proporcionar al menos una propiedad o función útil.

Después crea:

```kotlin
data class Customer(
    val name: String,
    val email: Email,
    val phone: PhoneNumber,
    val postalCode: PostalCode
)
```

### Objetivo

Combinar `data class` y `value class`.

---

# 22. Varias value classes con la misma representación

Crea:

```kotlin
@JvmInline
value class Meters(val value: Double)

@JvmInline
value class Kilometers(val value: Double)

@JvmInline
value class Miles(val value: Double)
```

Todas tienen exactamente la misma representación interna:

```text
Double
```

Sin embargo, deben ser tipos incompatibles.

Crea:

```kotlin
fun travel(distance: Kilometers)
```

e intenta pasar:

```kotlin
Meters(10.0)
Miles(10.0)
```

### Pregunta

¿Por qué es especialmente útil una value class cuando varios conceptos tienen la misma representación primitiva?

---

# 23. Diseñar una pequeña API de URLs

Crea:

```kotlin
@JvmInline
value class Url(val value: String)
```

Debe validar que la URL empiece por:

```text
http://
```

o:

```text
https://
```

Añade:

```kotlin
val host: String
```

que permita obtener el dominio.

Por ejemplo:

```kotlin
val url = Url("https://www.example.com/products")

println(url.host)
```

---

# 24. Value class y funciones de orden superior

Crea:

```kotlin
@JvmInline
value class UserId(val value: Int)
```

y:

```kotlin
fun processUser(
    id: UserId,
    action: (UserId) -> Unit
)
```

Después utiliza:

```kotlin
processUser(UserId(10)) {
    println("Processing user ${it.value}")
}
```

### Objetivo

Combinar:

- value classes;
- lambdas;
- funciones de orden superior.

---

# 25. Analizar las limitaciones

Escribe ejemplos para comprobar cuáles de las siguientes cosas son posibles:

### A

Una value class con dos propiedades:

```kotlin
@JvmInline
value class Point(
    val x: Int,
    val y: Int
)
```

### B

Una value class que herede de otra clase.

### C

Una value class que implemente una interfaz.

### D

Una value class con funciones miembro.

### E

Una value class con propiedades calculadas.

### F

Una value class genérica.

Para cada caso:

1. intenta escribir el código;
2. comprueba si compila;
3. explica por qué.

---

# 26. `value class` frente a `data class` frente a `typealias`

Completa esta tabla:

| Característica | `typealias` | `value class` | `data class` |
|---|---|---|---|
| Crea un nuevo tipo | ? | ? | ? |
| Tiene identidad propia como clase | ? | ? | ? |
| Puede tener funciones | ? | ? | ? |
| Puede tener varias propiedades | ? | ? | ? |
| Puede proporcionar seguridad de tipos | ? | ? | ? |
| Puede ser nullable | ? | ? | ? |
| Puede representar un valor de dominio | ? | ? | ? |
| Está pensada para evitar un objeto envoltorio en muchos casos | ? | ? | ? |

Después escribe un ejemplo en el que utilizarías cada una de las tres.

---

# 27. Reto final: sistema de pedidos

Diseña un pequeño modelo para un sistema de pedidos utilizando value classes.

Debes crear como mínimo:

```kotlin
UserId
ProductId
OrderId
Money
Quantity
Email
```

Cada una debe representar un concepto diferente.

Después crea:

```kotlin
data class Product(
    val id: ProductId,
    val name: String,
    val price: Money
)
```

y:

```kotlin
data class OrderLine(
    val productId: ProductId,
    val quantity: Quantity
)
```

y:

```kotlin
data class Order(
    val id: OrderId,
    val userId: UserId,
    val lines: List<OrderLine>
)
```

Implementa funciones para:

- calcular el precio de una línea;
- calcular el total del pedido;
- buscar un producto por `ProductId`;
- buscar un usuario por `UserId`;
- crear un pedido;
- añadir productos;
- calcular el total final.

### Restricción

No debes utilizar `Int`, `Double` o `String` directamente cuando el valor represente un concepto de dominio que pueda tener su propia value class.

Por ejemplo, evita:

```kotlin
fun createOrder(
    userId: Int,
    productId: Int,
    quantity: Int
)
```

y utiliza:

```kotlin
fun createOrder(
    userId: UserId,
    productId: ProductId,
    quantity: Quantity
)
```

---

# Reto final avanzado: API bancaria

Diseña una API para realizar transferencias bancarias.

Crea value classes para:

```text
AccountId
Iban
Money
Percentage
TransactionId
```

La API debería permitir:

```kotlin
transfer(
    from = AccountId(...),
    to = AccountId(...),
    amount = Money(...),
    commission = Percentage(...)
)
```

El sistema debe impedir mediante el sistema de tipos errores como:

```kotlin
transfer(
    from = Money(...),
    to = AccountId(...),
    amount = AccountId(...),
    commission = Percentage(...)
)
```

Además:

- `Money` no puede representar cantidades negativas.
- `Percentage` debe estar entre `0` y `100`.
- `Iban` debe validar su formato básico.
- `AccountId` y `TransactionId` deben ser tipos diferentes aunque ambos almacenen `String`.

### Preguntas finales

1. ¿Qué errores puede evitar el compilador gracias a las value classes?
2. ¿Qué errores siguen necesitando validación en tiempo de ejecución?
3. ¿Por qué una `value class` es más apropiada que un `typealias` en este caso?
4. ¿Cuándo preferirías una `data class`?
5. ¿Qué ventajas aporta este diseño a una API grande?
6. ¿Qué relación existe entre las value classes y el concepto de **Domain-Driven Design (DDD)**?

---

## Resumen de conceptos

Al terminar los ejercicios deberías ser capaz de reconocer este patrón:

```kotlin
@JvmInline
value class UserId(val value: Int)
```

como una forma de crear un **tipo de dominio basado en un único valor**, evitando que conceptos diferentes que utilizan la misma representación puedan mezclarse accidentalmente.

La idea fundamental es pasar de:

```kotlin
fun transfer(
    userId: Int,
    amount: Double
)
```

a:

```kotlin
fun transfer(
    userId: UserId,
    amount: Money
)
```

No se trata simplemente de "envolver un `Int` o un `Double` en una clase", sino de **hacer que el propio sistema de tipos exprese las reglas y conceptos del dominio**.