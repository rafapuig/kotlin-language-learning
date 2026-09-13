# Ejercicios: Builders con `buildXXX { ... }` en Kotlin

## Objetivo

Practicar la creación de objetos mediante funciones `buildXXX` que reciben un bloque de código con receptor (`XXX.() -> Unit`).

El objetivo es aprender a construir objetos de forma declarativa y a comprender cómo funcionan las lambdas con receptor en Kotlin.

---

## Ejercicio 1 — Construcción de una `Person`

Define una clase:

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0
}
```

Crea una función:

```kotlin
fun buildPerson(block: Person.() -> Unit): Person
```

La función debe crear una instancia de `Person`, ejecutar sobre ella el bloque recibido y devolverla.

El objetivo es poder escribir:

```kotlin
val person = buildPerson {
    name = "Ana"
    age = 25
}
```

**Objetivo:** practicar las lambdas con receptor y la creación encapsulada de objetos.

---

## Ejercicio 2 — Construcción de un `Book`

Define una clase `Book` con las propiedades:

- `title`
- `author`
- `pages`
- `price`

Crea:

```kotlin
fun buildBook(block: Book.() -> Unit): Book
```

Debe permitir:

```kotlin
val book = buildBook {
    title = "El Quijote"
    author = "Miguel de Cervantes"
    pages = 863
    price = 19.95
}
```

Añade una función `printInfo()` a `Book` y prueba que el objeto se ha construido correctamente.

---

## Ejercicio 3 — Construcción de una `Car`

Define una clase `Car` con las propiedades:

- `brand`
- `model`
- `year`
- `color`
- `automatic`

Crea:

```kotlin
fun buildCar(block: Car.() -> Unit): Car
```

Debe poder utilizarse así:

```kotlin
val car = buildCar {
    brand = "Toyota"
    model = "Corolla"
    year = 2025
    color = "White"
    automatic = true
}
```

Después añade una función:

```kotlin
fun description(): String
```

que devuelva una descripción del vehículo.

---

## Ejercicio 4 — Construcción de una `Computer`

Define una clase `Computer` con las propiedades:

- `processor`
- `ram`
- `storage`
- `graphicsCard`

Crea `buildComputer`.

El bloque debe permitir construir configuraciones como:

```kotlin
val computer = buildComputer {
    processor = "Ryzen 7"
    ram = 32
    storage = 2000
    graphicsCard = "RTX 5070"
}
```

Haz que `ram` represente GB y `storage` GB.

### Ampliación

Añade una función `isGamingComputer()` que determine si tiene al menos 16 GB de RAM y tarjeta gráfica.

---

## Ejercicio 5 — Construcción de una `Pizza`

Define una clase:

```kotlin
class Pizza {
    var size: String = ""
    var cheese: Boolean = false
    var ham: Boolean = false
    var mushrooms: Boolean = false
    var pepperoni: Boolean = false
}
```

Crea:

```kotlin
fun buildPizza(block: Pizza.() -> Unit): Pizza
```

De forma que pueda escribirse:

```kotlin
val pizza = buildPizza {
    size = "Large"
    cheese = true
    ham = true
    mushrooms = true
}
```

Añade `description()` para mostrar los ingredientes seleccionados.

### Ampliación

Crea funciones dentro de `Pizza` como:

```kotlin
fun addHam()
fun addMushrooms()
fun addPepperoni()
```

y permite:

```kotlin
val pizza = buildPizza {
    size = "Large"
    addHam()
    addMushrooms()
    addPepperoni()
}
```

---

## Ejercicio 6 — Construcción de un `Character`

Crea una clase `Character` para un videojuego con las propiedades:

- `name`
- `health`
- `attack`
- `defense`
- `level`

Implementa:

```kotlin
fun buildCharacter(block: Character.() -> Unit): Character
```

Debe permitir:

```kotlin
val warrior = buildCharacter {
    name = "Arthas"
    health = 150
    attack = 25
    defense = 20
    level = 5
}
```

Añade métodos como:

```kotlin
fun increaseHealth(amount: Int)
fun increaseAttack(amount: Int)
fun increaseDefense(amount: Int)
```

De esta manera:

```kotlin
val warrior = buildCharacter {
    name = "Arthas"
    health = 100
    increaseHealth(50)
    attack = 20
    increaseAttack(5)
}
```

---

## Ejercicio 7 — Construcción de un `Address`

Define una clase:

```text
Address
    street
    number
    city
    postalCode
    country
```

Crea `buildAddress`.

Después define:

```kotlin
class Person {
    var name: String = ""
    var address: Address? = null
}
```

El objetivo es poder hacer:

```kotlin
val person = buildPerson {
    name = "Ana"

    address = buildAddress {
        street = "Calle Mayor"
        number = 25
        city = "Valencia"
        postalCode = "46001"
        country = "Spain"
    }
}
```

Este ejercicio permite introducir la **composición de builders**.

---

## Ejercicio 8 — Construcción de un `Order`

Define:

```kotlin
class Order {
    var customer: String = ""
    var shippingAddress: Address? = null
    val products = mutableListOf<Product>()
}
```

Y:

```kotlin
class Product {
    var name: String = ""
    var price: Double = 0.0
    var quantity: Int = 1
}
```

Crea:

```kotlin
fun buildOrder(block: Order.() -> Unit): Order
fun buildProduct(block: Product.() -> Unit): Product
```

Debería ser posible escribir:

```kotlin
val order = buildOrder {
    customer = "Ana"

    shippingAddress = buildAddress {
        street = "Calle Mayor"
        number = 25
        city = "Valencia"
        postalCode = "46001"
        country = "Spain"
    }

    products += buildProduct {
        name = "Keyboard"
        price = 49.95
        quantity = 1
    }

    products += buildProduct {
        name = "Mouse"
        price = 24.95
        quantity = 2
    }
}
```

Añade una función:

```kotlin
fun total(): Double
```

que calcule el precio total del pedido.

---

## Ejercicio 9 — Diseñar el propio builder

Como ejercicio final, diseña tu propio producto.

Debes elegir una clase apropiada, por ejemplo:

- `Movie`
- `House`
- `Student`
- `Game`
- `Recipe`
- `Trip`

Debes proporcionar:

1. La clase del producto.
2. La función `buildXXX`.
3. Al menos cinco propiedades.
4. Al menos dos funciones de comportamiento.
5. Un programa principal que construya **tres instancias diferentes** utilizando el builder.

### Restricción

**No se permite utilizar directamente el constructor de la clase desde `main`.**

Todas las instancias deben crearse mediante una función `buildXXX { ... }`.

Por ejemplo:

```kotlin
val movie = buildMovie {
    title = "Interstellar"
    director = "Christopher Nolan"
    year = 2014
    duration = 169
}
```

---

## Progresión recomendada

Los ejercicios están ordenados de menor a mayor dificultad:

1. `Person` — Lambda con receptor básica.
2. `Book` — Mismo patrón con más propiedades.
3. `Car` — Builder y comportamiento.
4. `Computer` — Builder y lógica.
5. `Pizza` — Builder con funciones de configuración.
6. `Character` — Configuración mediante propiedades y métodos.
7. `Address` — Composición de builders.
8. `Order` — Builders anidados y colecciones.
9. Diseño libre — Aplicación autónoma del patrón.
