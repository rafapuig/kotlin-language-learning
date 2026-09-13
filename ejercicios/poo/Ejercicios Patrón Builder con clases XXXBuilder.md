# Ejercicios Kotlin — Patrón Builder con clases `XXXBuilder`

Estos ejercicios están diseñados para practicar el patrón **Builder** en Kotlin utilizando clases `XXXBuilder` para construir objetos de forma progresiva.

El objetivo es pasar de una construcción directa mediante constructores a una construcción más flexible mediante un objeto Builder.

---

## Ejercicio 1 — `PersonBuilder`

Crea una clase `Person` con las siguientes propiedades:

- `name: String`
- `age: Int`
- `email: String`
- `phone: String`

Crea una clase `PersonBuilder` que permita construir objetos `Person` mediante propiedades configurables.

El uso esperado debe ser similar a:

```kotlin
val person = PersonBuilder()
    .name("Ana")
    .age(25)
    .email("ana@example.com")
    .phone("600123456")
    .build()
```

El método `build()` debe devolver una instancia de `Person`.

### Objetivos

- Crear una clase Builder.
- Mantener el estado del objeto que se está construyendo.
- Encadenar llamadas.
- Separar la construcción de la creación del objeto.

---

## Ejercicio 2 — `BookBuilder`

Crea una clase `Book` con las siguientes propiedades:

- `title: String`
- `author: String`
- `isbn: String`
- `pages: Int`
- `price: Double`

Crea una clase `BookBuilder` para construir libros progresivamente.

Debe ser posible escribir:

```kotlin
val book = BookBuilder()
    .title("1984")
    .author("George Orwell")
    .isbn("9780451524935")
    .pages(328)
    .price(12.95)
    .build()
```

Haz que `title` y `author` sean obligatorios, mientras que `isbn`, `pages` y `price` puedan tener valores predeterminados.

---

## Ejercicio 3 — `ComputerBuilder`

Crea una clase `Computer` con:

- `processor: String`
- `ram: Int`
- `storage: Int`
- `graphicsCard: String`
- `operatingSystem: String`

Crea `ComputerBuilder`.

El alumno debe poder construir configuraciones como:

```kotlin
val computer = ComputerBuilder()
    .processor("Intel Core i7")
    .ram(32)
    .storage(1000)
    .graphicsCard("RTX 4070")
    .operatingSystem("Windows 11")
    .build()
```

El Builder debe proporcionar valores predeterminados razonables para aquellas características que no se especifiquen.

Por ejemplo:

```kotlin
val computer = ComputerBuilder()
    .processor("AMD Ryzen 7")
    .ram(16)
    .build()
```

---

## Ejercicio 4 — `PizzaBuilder`

Crea una clase `Pizza` con:

- `size: String`
- `dough: String`
- `cheese: Boolean`
- `tomato: Boolean`
- `ingredients: List<String>`

Crea `PizzaBuilder`.

El Builder debe permitir configurar la pizza mediante métodos como:

```kotlin
val pizza = PizzaBuilder()
    .size("large")
    .dough("thin")
    .cheese(true)
    .tomato(true)
    .addIngredient("ham")
    .addIngredient("mushrooms")
    .addIngredient("olives")
    .build()
```

### Objetivo adicional

El método `addIngredient()` debe modificar una colección interna del Builder.

---

## Ejercicio 5 — `CarBuilder`

Crea una clase `Car` con:

- `brand`
- `model`
- `year`
- `color`
- `engine`
- `automatic`

Crea `CarBuilder`.

Debe permitir construir distintos vehículos:

```kotlin
val car = CarBuilder()
    .brand("Toyota")
    .model("Corolla")
    .year(2026)
    .color("white")
    .engine("1.8 Hybrid")
    .automatic(true)
    .build()
```

Haz que algunas propiedades tengan valores por defecto.

Por ejemplo, si no se especifica `automatic`, el coche será manual.

---

## Ejercicio 6 — `GameCharacterBuilder`

Crea una clase `GameCharacter` con:

- `name`
- `health`
- `strength`
- `defense`
- `speed`
- `weapon`
- `armor`

Crea `GameCharacterBuilder`.

Debe permitir crear personajes como:

```kotlin
val warrior = GameCharacterBuilder()
    .name("Conan")
    .health(150)
    .strength(20)
    .defense(18)
    .speed(8)
    .weapon("Sword")
    .armor("Heavy armor")
    .build()
```

El Builder debe permitir configurar las distintas características del personaje.

---

## Ejercicio 7 — `HouseBuilder`

Crea una clase `House` con:

- `address`
- `rooms`
- `bathrooms`
- `floors`
- `garage`
- `garden`
- `pool`

Crea `HouseBuilder`.

Por ejemplo:

```kotlin
val house = HouseBuilder()
    .address("Calle Mayor 25")
    .rooms(4)
    .bathrooms(2)
    .floors(2)
    .garage(true)
    .garden(true)
    .pool(false)
    .build()
```

Haz que `garage`, `garden` y `pool` tengan valores predeterminados.

---

## Ejercicio 8 — Builder con validación

Crea una clase `User`:

```kotlin
class User(
    val username: String,
    val password: String,
    val email: String,
    val age: Int
)
```

Crea `UserBuilder`.

El método `build()` debe comprobar que:

- `username` no esté vacío.
- `password` tenga al menos 8 caracteres.
- `email` contenga `@`.
- `age` esté entre 18 y 120.

Si alguna condición no se cumple, `build()` debe lanzar una `IllegalArgumentException`.

Ejemplo:

```kotlin
val user = UserBuilder()
    .username("rafa")
    .password("secret123")
    .email("rafa@example.com")
    .age(30)
    .build()
```

### Objetivo

Comprobar que el método `build()` no tiene por qué limitarse a llamar al constructor. También puede garantizar que el objeto construido sea válido.

---

## Ejercicio 9 — Builder con objetos relacionados

Crea las siguientes clases:

```kotlin
class Address(
    val street: String,
    val city: String,
    val zipCode: String
)

class Person(
    val name: String,
    val age: Int,
    val address: Address?
)
```

Crea:

- `AddressBuilder`
- `PersonBuilder`

Debe ser posible escribir:

```kotlin
val person = PersonBuilder()
    .name("Ana")
    .age(28)
    .address(
        AddressBuilder()
            .street("Gran Vía")
            .city("Madrid")
            .zipCode("28013")
            .build()
    )
    .build()
```

### Objetivo

Practicar Builders que trabajan con otros objetos construidos mediante Builders.

---

## Ejercicio 10 — Builder mediante bloque lambda

Modifica `PersonBuilder` para permitir una sintaxis como:

```kotlin
val person = PersonBuilder()
    .name("Ana")
    .age(28)
    .address {
        street("Gran Vía")
        city("Madrid")
        zipCode("28013")
    }
    .build()
```

El método `address()` deberá crear internamente un `AddressBuilder`, ejecutar el bloque recibido sobre él y finalmente construir el `Address`.

### Objetivo

Relacionar el patrón Builder con:

- Lambdas con receptor.
- Funciones de extensión, si resultan útiles.
- DSLs de Kotlin.

---

## Ejercicio 11 — Builder reutilizable

Crea un `EmailBuilder` para construir objetos de la siguiente clase:

```kotlin
class Email(
    val from: String,
    val to: List<String>,
    val subject: String,
    val body: String,
    val attachments: List<String>
)
```

El Builder debe permitir:

```kotlin
val email = EmailBuilder()
    .from("alice@example.com")
    .to("bob@example.com")
    .to("charlie@example.com")
    .subject("Meeting")
    .body("We meet at 10:00")
    .attachment("report.pdf")
    .build()
```

Después, analiza la siguiente cuestión:

> ¿Qué ocurre si queremos utilizar el mismo `EmailBuilder` para crear dos correos diferentes?

Investiga qué estado debería reiniciarse después de llamar a `build()`.

### Objetivo

Reflexionar sobre:

- El estado interno del Builder.
- Builders reutilizables.
- Builders de un solo uso.

---

# Ejercicio 12 — Reto final: `CharacterBuilder`

Crea un Builder para un personaje de un videojuego.

La clase `Character` tendrá las siguientes propiedades:

```kotlin
class Character(
    val name: String,
    val race: String,
    val characterClass: String,
    val level: Int,
    val strength: Int,
    val intelligence: Int,
    val dexterity: Int,
    val weapons: List<String>,
    val skills: List<String>,
    val equipment: List<String>
)
```

El Builder deberá proporcionar métodos como:

```kotlin
name(...)
race(...)
characterClass(...)
level(...)
strength(...)
intelligence(...)
dexterity(...)
addWeapon(...)
addSkill(...)
addEquipment(...)
build()
```

El objetivo es conseguir una construcción similar a:

```kotlin
val character = CharacterBuilder()
    .name("Aragorn")
    .race("Human")
    .characterClass("Ranger")
    .level(10)
    .strength(18)
    .intelligence(14)
    .dexterity(17)
    .addWeapon("Sword")
    .addWeapon("Bow")
    .addSkill("Tracking")
    .addSkill("Archery")
    .addEquipment("Cloak")
    .build()
```

### Reto adicional

H