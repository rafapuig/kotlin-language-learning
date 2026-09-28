# Ejercicios: Delegación de propiedades en Kotlin

En estos ejercicios practicarás la **delegación de propiedades** de Kotlin mediante la palabra clave `by`.

Los ejercicios están ordenados de menor a mayor dificultad.

---

## 1. Propiedad inicializada de forma diferida con `lazy`

Crea una clase `User` con las siguientes propiedades:

* `name: String`
* `email: String`
* `description: String`

La propiedad `description` debe calcularse únicamente la primera vez que se consulte.

Por ejemplo:

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
```

### Tareas

1. Crea una instancia de `User`.
2. Accede dos veces a `description`.
3. Observa cuántas veces se ejecuta el código del bloque `lazy`.

### Objetivo

Comprender la **inicialización diferida** mediante `lazy`.

---

## 2. `lazy` con una operación costosa

Crea una clase `Configuration` que tenga una propiedad:

```kotlin
val databaseUrl: String
```

El valor debe obtenerse mediante una operación que simule una tarea costosa:

```kotlin
Thread.sleep(2000)
```

Haz que la operación solamente se ejecute cuando se consulte por primera vez la propiedad.

### Tareas

Muestra por consola:

```text
Creando configuración...
Configuración creada
Consultando URL...
jdbc:mysql://localhost:3306/app
Consultando URL de nuevo...
jdbc:mysql://localhost:3306/app
```

Comprueba que la espera de dos segundos solamente se produce una vez.

---

## 3. `Delegates.observable`

Crea una clase `Person` con una propiedad:

```kotlin
var name: String
```

Utiliza `Delegates.observable` para mostrar un mensaje cada vez que cambie su valor.

Por ejemplo:

```text
El nombre ha cambiado de Ana a Laura
```

### Tareas

Realiza varias asignaciones:

```kotlin
person.name = "Laura"
person.name = "Carlos"
person.name = "Marta"
```

Comprueba que el delegado recibe tanto el valor anterior como el nuevo.

---

## 4. Observar cambios en una propiedad numérica

Crea una clase `Player` con una propiedad:

```kotlin
var score: Int
```

Utiliza `Delegates.observable` para mostrar:

```text
Puntuación: 10 -> 20
```

cada vez que cambie la puntuación.

### Tarea adicional

Haz que cuando la puntuación alcance o supere `100` se muestre:

```text
¡Puntuación máxima alcanzada!
```

---

## 5. `Delegates.vetoable`

Crea una clase `BankAccount` con una propiedad:

```kotlin
var balance: Double
```

Utiliza `Delegates.vetoable` para impedir que el saldo sea negativo.

Por ejemplo:

```kotlin
account.balance = 500.0
account.balance = 200.0
account.balance = -100.0
```

El último cambio debe ser rechazado.

### Resultado esperado

Después de intentar asignar `-100.0`, el saldo debe continuar siendo:

```text
200.0
```

---

## 6. Controlar una edad

Crea una clase `Person` con una propiedad:

```kotlin
var age: Int
```

Utiliza `Delegates.vetoable` para impedir:

* edades negativas;
* edades superiores a `120`.

### Ejemplo

```kotlin
person.age = 25
person.age = 40
person.age = -5
person.age = 150
```

Solamente las asignaciones válidas deben modificar la propiedad.

---

## 7. Crear un delegado que escriba los cambios

Crea un delegado denominado:

```kotlin
LoggingDelegate
```

que pueda utilizarse con propiedades `var`.

Cada vez que se modifique la propiedad deberá mostrar:

```text
Asignando valor: 10
```

### Ejemplo de uso

```kotlin
class Product {
    var price: Double by LoggingDelegate()
}
```

Al ejecutar:

```kotlin
product.price = 19.99
```

deberá aparecer un mensaje por consola.

### Restricción

El delegado debe implementar la lógica necesaria para proporcionar los métodos `getValue` y `setValue`.

---

## 8. Delegado genérico para valores

Modifica el ejercicio anterior para que `LoggingDelegate` sea genérico.

Debe poder utilizarse con propiedades de diferentes tipos:

```kotlin
var name: String by LoggingDelegate()
var age: Int by LoggingDelegate()
var active: Boolean by LoggingDelegate()
```

### Objetivo

Practicar la creación de **delegados genéricos de propiedades**.

---

## 9. Delegado que almacena el valor

Crea un delegado genérico:

```kotlin
StoredValue<T>
```

que almacene internamente el valor de una propiedad.

Debe permitir:

```kotlin
class Person {
    var name: String by StoredValue("")
    var age: Int by StoredValue(0)
}
```

### Tareas

Implementa:

* `getValue`
* `setValue`

y consigue que cada propiedad tenga su propio valor almacenado.

---

## 10. Delegado de solo lectura

Crea un delegado:

```kotlin
ConstantValue<T>
```

que pueda utilizarse para definir propiedades de solo lectura.

Ejemplo:

```kotlin
class Game {
    val title: String by ConstantValue("Kotlin Game")
}
```

La propiedad debe poder consultarse, pero no modificarse.

### Objetivo

Practicar la diferencia entre:

```kotlin
ReadOnlyProperty
```

y

```kotlin
ReadWriteProperty
```

---

## 11. Delegado para valores por defecto

Crea un delegado denominado:

```kotlin
DefaultValue<T>
```

que permita definir una propiedad con un valor inicial.

Por ejemplo:

```kotlin
class Configuration {
    var timeout: Int by DefaultValue(30)
    var host: String by DefaultValue("localhost")
}
```

### Tareas

1. Implementa el delegado.
2. Permite modificar los valores.
3. Comprueba que inicialmente se utilizan los valores proporcionados.

---

## 12. Delegado para propiedades restringidas

Crea un delegado genérico que permita restringir los valores asignables mediante una función.

Por ejemplo:

```kotlin
var age: Int by ValidatedValue(0) { it in 0..120 }
```

La asignación solamente debe realizarse si la función devuelve `true`.

### Ejemplo

```kotlin
person.age = 25
person.age = 200
```

El segundo valor debe rechazarse.

### Ampliación

Permite proporcionar también un mensaje de error:

```kotlin
ValidatedValue(0, "La edad no es válida") { it in 0..120 }
```

---

## 13. Delegado para propiedades no vacías

Crea un delegado:

```kotlin
NonEmptyString
```

que pueda utilizarse de esta forma:

```kotlin
class User {
    var username: String by NonEmptyString()
}
```

No debe permitir asignar:

* `""`
* `"   "`

pero sí:

```kotlin
"rafa"
"john123"
"admin"
```

### Objetivo

Crear un delegado especializado para un tipo concreto.

---

## 14. Delegado para convertir automáticamente valores

Crea un delegado que permita almacenar internamente un `String`, pero exponerlo como un `Int`.

Por ejemplo:

```kotlin
class Configuration {
    var port: Int by StringToIntDelegate("8080")
}
```

El delegado debe convertir el valor almacenado cuando se obtiene la propiedad.

### Ampliación

Haz que también permita modificar la propiedad mediante un `Int`.

---

## 15. Delegado para limitar valores

Crea un delegado genérico:

```kotlin
RangeDelegate
```

que permita limitar una propiedad numérica a un intervalo.

Ejemplo:

```kotlin
class Volume {
    var level: Int by RangeDelegate(0, 100, 50)
}
```

Si se intenta:

```kotlin
volume.level = 75
```

se almacena `75`.

Si se intenta:

```kotlin
volume.level = 150
```

el delegado debe impedir la asignación.

### Ampliación

Haz que también funcione con `Double`.

---

## 16. Delegado reutilizable con `ReadWriteProperty`

Reescribe el ejercicio anterior utilizando:

```kotlin
ReadWriteProperty<Any?, T>
```

en lugar de implementar manualmente toda la interfaz del delegado.

### Objetivo

Comprender cuándo resulta útil implementar las interfaces estándar de delegación de Kotlin.

---

## 17. Delegado para valores calculados

Crea un delegado de solo lectura que reciba una función:

```kotlin
() -> T
```

y calcule el valor de la propiedad cuando se consulta.

Ejemplo:

```kotlin
class Rectangle(
    val width: Double,
    val height: Double
) {
    val area: Double by ComputedValue {
        width * height
    }
}
```

### Tareas

Crea también:

```kotlin
val perimeter: Double
```

utilizando el mismo delegado.

---

## 18. Delegado que memoriza el resultado

Modifica el ejercicio anterior para que el cálculo solamente se realice una vez.

Por ejemplo:

```kotlin
val expensiveCalculation: Int by MemoizedValue {
    println("Calculando...")
    42
}
```

La primera consulta debe mostrar:

```text
Calculando...
42
```

Las siguientes consultas solamente deben mostrar:

```text
42
```

### Objetivo

Implementar manualmente un comportamiento similar a `lazy`.

---

## 19. Delegado con `provideDelegate`

Crea un delegado que compruebe el nombre de la propiedad durante la creación del delegado.

Utiliza:

```kotlin
operator fun provideDelegate(...)
```

El delegado debe impedir que se utilicen determinados nombres.

Por ejemplo:

```kotlin
class User {
    val username: String by NameCheckedDelegate()
    val password: String by NameCheckedDelegate()
}
```

El delegado debe mostrar el nombre de la propiedad que está siendo delegada.

### Objetivo

Investigar y utilizar `provideDelegate` para comprender que el delegado puede intervenir durante la resolución de la propiedad.

---

## 20. Delegado para propiedades de configuración

Crea una clase:

```kotlin
Configuration
```

que permita definir propiedades mediante delegados.

Debe poder utilizarse de forma similar a:

```kotlin
class AppConfig {
    var host: String by ConfigValue("localhost")
    var port: Int by ConfigValue(8080)
    var debug: Boolean by ConfigValue(false)
}
```

El delegado debe almacenar los valores internamente.

### Requisitos

* Debe ser genérico.
* Debe permitir lectura.
* Debe permitir escritura.
* Cada propiedad debe mantener su propio valor.
* Debe mostrar el nombre de la propiedad cuando se modifica.

---

# Ejercicios de aplicación

## 21. Clase `UserSettings`

Crea una clase:

```kotlin
UserSettings
```

con las siguientes propiedades:

```text
username
language
fontSize
darkMode
```

Utiliza delegados para conseguir:

* `username`: no puede estar vacío.
* `language`: solamente puede ser `"es"`, `"en"` o `"fr"`.
* `fontSize`: debe estar entre `8` y `32`.
* `darkMode`: debe informar mediante consola cuando cambie.

No puedes implementar estas validaciones directamente en los setters de las propiedades.

---

## 22. Sistema de configuración de un videojuego

Crea una clase:

```kotlin
GameSettings
```

con:

```text
resolution
volume
difficulty
fullscreen
```

Utiliza delegación de propiedades para implementar las siguientes restricciones:

* `volume`: entre `0` y `100`.
* `difficulty`: `"EASY"`, `"NORMAL"` o `"HARD"`.
* `resolution`: no puede estar vacía.
* `fullscreen`: debe informar cuando cambie.

### Objetivo

Combinar diferentes delegados dentro de una misma clase.

---

## 23. Sistema de propiedades observables

Crea una clase:

```kotlin
Player
```

con:

```text
name
health
score
level
```

Implementa mediante delegación:

* `health`: entre `0` y `100`.
* `score`: no puede disminuir.
* `level`: debe mostrar un mensaje cuando aumente.
* `name`: no puede estar vacío.

### Ejemplo

```text
Player level increased: 3 -> 4
```

### Restricción

No puedes utilizar setters personalizados para implementar las reglas.

---

## 24. Implementar tu propio `lazy`

Implementa un delegado:

```kotlin
MyLazy<T>
```

que reproduzca el comportamiento básico de:

```kotlin
by lazy { ... }
```

Debe aceptar una función:

```kotlin
() -> T
```

y almacenar el resultado de la primera ejecución.

### Ejemplo

```kotlin
val number: Int by MyLazy {
    println("Calculando...")
    100
}
```

La función solamente debe ejecutarse una vez.

---

## 25. Proyecto final: sistema de propiedades delegadas

Diseña un pequeño sistema de gestión de usuarios.

Crea:

```kotlin
class User
```

con las propiedades:

```text
username
email
age
role
active
```

Utiliza diferentes delegados para implementar:

* `username`: no puede estar vacío.
* `email`: debe contener `@`.
* `age`: entre `0` y `120`.
* `role`: solamente `"USER"`, `"ADMIN"` o `"MODERATOR"`.
* `active`: debe informar cuando cambie.
* Una propiedad calculada debe mostrar una descripción del usuario.
* La descripción debe calcularse de forma diferida.

### Condiciones

1. No utilizar setters personalizados.
2. Crear al menos **tres delegados propios**.
3. Utilizar al menos una vez `Delegates.observable`.
4. Utilizar al menos una vez `Delegates.vetoable`.
5. Utilizar `lazy` para la propiedad calculada.
6. Los delegados propios deben ser reutilizables.

### Ejemplo de uso

```kotlin
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
```

---

# Reto final

Crea un delegado genérico:

```kotlin
Validated<T>
```

que permita definir propiedades de esta forma:

```kotlin
var age: Int by Validated(0) {
    it in 0..120
}

var username: String by Validated("") {
    it.isNotBlank()
}
```

El delegado deberá:

* almacenar el valor;
* permitir obtenerlo;
* validar cualquier nuevo valor;
* rechazar valores inválidos;
* ser reutilizable con diferentes tipos;
* mostrar el nombre de la propiedad cuando se produzca un intento de asignación.

### Ejemplo esperado

```text
Changing age: 20 -> 30
Changing age: 30 -> 150
Invalid value for age
```

Como ampliación, permite proporcionar una función que genere el mensaje de error:

```kotlin
Validated(0, { value -> "Edad no válida: $value" }) {
    it in 0..120
}
```

---

# Objetivos de aprendizaje

Al finalizar los ejercicios, deberías saber:

* Utilizar `by` para delegar propiedades.
* Utilizar `lazy`.
* Utilizar `Delegates.observable`.
* Utilizar `Delegates.vetoable`.
* Crear delegados propios.
* Implementar `getValue` y `setValue`.
* Utilizar `ReadOnlyProperty`.
* Utilizar `ReadWriteProperty`.
* Crear delegados genéricos.
* Utilizar `provideDelegate`.
* Separar la lógica de una propiedad mediante delegación.
* Crear delegados reutilizables para validación, almacenamiento y cálculo.
