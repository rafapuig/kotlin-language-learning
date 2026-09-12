# Ejercicios de propiedades en clases Kotlin

## Objetivo

En estos ejercicios practicarás las **propiedades de las clases en Kotlin**.

Aprenderás progresivamente a trabajar con:

- propiedades declaradas en el constructor principal;
- propiedades declaradas dentro del cuerpo de la clase;
- `val` y `var`;
- propiedades con valores iniciales;
- propiedades con valores por defecto;
- diferencia entre parámetros y propiedades;
- acceso y modificación de propiedades;
- propiedades `private`;
- `private set`;
- getters personalizados;
- setters personalizados;
- propiedades calculadas;
- propiedades de solo lectura;
- *backing properties*.

---

# Nivel 1 — Primeras propiedades

## Ejercicio 1 — Una clase `Person`

Crea una clase `Person` que tenga las siguientes propiedades:

- `name` de tipo `String`.
- `age` de tipo `Int`.

Ambas propiedades deben poder modificarse después de crear el objeto.

Crea un objeto y modifica su edad.

### Resultado esperado

El programa debe poder hacer algo similar a:

```kotlin
val person = Person("Ana", 20)

println(person.name)
println(person.age)

person.age = 21

println(person.age)
```

---

## Ejercicio 2 — `val` frente a `var`

Crea una clase `Book` con:

- `title`: no debe poder modificarse después de crear el objeto.
- `author`: no debe poder modificarse.
- `pages`: sí debe poder modificarse.

Prueba a modificar las tres propiedades.

### Pregunta

¿Qué intentos de modificación producen un error de compilación?

---

## Ejercicio 3 — Propiedades en el constructor

Crea una clase `Student` con estas propiedades:

```text
name
course
age
```

Las tres deben declararse directamente en el constructor principal.

Crea dos alumnos diferentes y muestra sus datos.

---

## Ejercicio 4 — Propiedades y parámetros

Observa este código:

```kotlin
class Person(name: String, age: Int)
```

Crea un objeto:

```kotlin
val person = Person("Ana", 20)
```

Intenta hacer:

```kotlin
println(person.name)
```

### Preguntas

1. ¿Por qué no funciona?
2. ¿Qué diferencia hay entre `name` y `age` y una propiedad?
3. Modifica la clase para que `name` y `age` sean propiedades.

---

# Nivel 2 — Propiedades dentro del cuerpo de la clase

## Ejercicio 5 — Propiedad con valor inicial

Crea una clase `Player` que tenga:

- `name`: propiedad recibida mediante el constructor.
- `score`: propiedad de tipo `Int` que inicialmente vale `0`.

Debe ser posible hacer:

```kotlin
val player = Player("Mario")

println(player.score)

player.score = 100
```

---

## Ejercicio 6 — Propiedad calculada

Crea una clase `Rectangle` con:

```text
width
height
```

Añade una propiedad:

```text
area
```

que devuelva el área del rectángulo.

Debe ser posible hacer:

```kotlin
val rectangle = Rectangle(10.0, 5.0)

println(rectangle.area)
```

### Importante

`area` no debe almacenar un valor independiente.

Debe calcularse a partir de `width` y `height`.

---

## Ejercicio 7 — Propiedad calculada con otras propiedades

Crea una clase `Person` con:

```text
firstName
lastName
```

Añade una propiedad:

```text
fullName
```

que devuelva:

```text
firstName + " " + lastName
```

Por ejemplo:

```kotlin
val person = Person("Ana", "García")

println(person.fullName)
```

Debe mostrar:

```text
Ana García
```

Comprueba qué ocurre si modificas `firstName` o `lastName`.

---

## Ejercicio 8 — Propiedad `val` o `var`

Para cada una de las siguientes propiedades decide si debería ser `val` o `var`:

### A

```text
nombre de una persona
```

### B

```text
edad de una persona
```

### C

```text
fecha de nacimiento
```

### D

```text
puntuación de un jugador
```

### E

```text
número de identificación de una persona
```

### F

```text
precio actual de un producto
```

Después crea una clase que contenga varias de ellas.

---

# Nivel 3 — Propiedades privadas

## Ejercicio 9 — Propiedad privada

Crea una clase `BankAccount` con una propiedad:

```text
balance
```

El saldo no debe poder modificarse directamente desde fuera de la clase.

Por tanto, esto no debería ser posible:

```kotlin
account.balance = 1000.0
```

Sin embargo, la clase debe tener una función:

```text
deposit(amount)
```

que permita ingresar dinero.

Ejemplo:

```kotlin
val account = BankAccount()

account.deposit(500.0)
```

### Objetivo

Practicar la diferencia entre:

- una propiedad pública;
- una propiedad privada;
- modificar una propiedad desde dentro de la clase.

---

## Ejercicio 10 — `private set`

Crea una clase `GameCharacter` con:

```text
name
health
```

`health` debe poder consultarse desde fuera:

```kotlin
println(character.health)
```

pero no debe poder modificarse directamente:

```kotlin
// No debe estar permitido
character.health = 50
```

La clase debe proporcionar una función:

```text
takeDamage(amount)
```

que reduzca la vida.

Por ejemplo:

```kotlin
character.takeDamage(20)
```

### Pista

Puedes utilizar:

```kotlin
var health: Int = ...
    private set
```

---

## Ejercicio 11 — `private set` y modificación controlada

Modifica el ejercicio anterior para añadir:

```text
heal(amount)
```

La vida nunca debe superar `100`.

Por ejemplo:

```kotlin
character.heal(30)
```

Si tenía `80` puntos de vida, debe quedarse en `100`.

### Objetivo

La propiedad puede consultarse desde fuera, pero solamente la clase puede modificarla.

---

# Nivel 4 — Getters personalizados

## Ejercicio 12 — Temperatura

Crea una clase `Temperature` con una propiedad:

```text
celsius
```

Añade una propiedad calculada:

```text
fahrenheit
```

La conversión es:

```text
°F = °C × 9 / 5 + 32
```

Ejemplo:

```kotlin
val temperature = Temperature(20.0)

println(temperature.fahrenheit)
```

---

## Ejercicio 13 — Propiedad `isEmpty`

Crea una clase `ShoppingCart` que tenga una propiedad:

```text
itemCount
```

Añade una propiedad calculada:

```text
isEmpty
```

Debe devolver `true` cuando no haya ningún artículo y `false` cuando haya alguno.

Por ejemplo:

```kotlin
val cart = ShoppingCart()

println(cart.isEmpty)
```

Después añade una función:

```text
addItem()
```

que incremente `itemCount`.

---

## Ejercicio 14 — Nombre completo

Crea una clase:

```text
Person
```

con:

```text
firstName
lastName
```

Añade:

```text
fullName
```

como propiedad calculada.

Después modifica `firstName` y comprueba que `fullName` cambia automáticamente.

### Pregunta

¿Por qué no es necesario actualizar manualmente `fullName`?

---

# Nivel 5 — Setters personalizados

## Ejercicio 15 — Edad válida

Crea una clase `Person` con una propiedad:

```text
age
```

La edad solamente puede estar entre `0` y `120`.

Si alguien intenta asignar un valor fuera de ese rango, la propiedad no debe aceptar el nuevo valor.

Por ejemplo:

```kotlin
val person = Person()

person.age = 30
println(person.age)

person.age = 150
println(person.age)
```

Investiga cómo se puede utilizar un `setter` personalizado para controlar la asignación.

---

## Ejercicio 16 — Nombre no vacío

Crea una clase `User` con una propiedad:

```text
username
```

El `username` no puede ser una cadena vacía.

Si se intenta asignar:

```kotlin
user.username = ""
```

la propiedad debe rechazar el valor.

### Objetivo

Practicar un `setter` personalizado.

---

## Ejercicio 17 — Precio positivo

Crea una clase `Product` con una propiedad:

```text
price
```

El precio debe ser siempre mayor o igual que `0`.

Debe ser posible:

```kotlin
product.price = 25.0
```

pero no:

```kotlin
product.price = -10.0
```

Implementa la validación mediante un `setter`.

---

# Nivel 6 — Propiedades y encapsulación

## Ejercicio 18 — Cuenta bancaria

Crea una clase `BankAccount`.

Debe tener:

```text
owner
balance
```

Requisitos:

- `owner` se establece al crear la cuenta.
- `balance` inicialmente vale `0`.
- `balance` se puede consultar desde fuera.
- `balance` no se puede modificar directamente desde fuera.
- `deposit(amount)` permite ingresar dinero.
- `withdraw(amount)` permite retirar dinero.
- No se puede retirar más dinero del saldo disponible.
- No se pueden ingresar cantidades negativas.
- No se pueden retirar cantidades negativas.

Ejemplo:

```kotlin
val account = BankAccount("Ana")

account.deposit(1000.0)
account.withdraw(300.0)

println(account.balance)
```

---

## Ejercicio 19 — Producto

Crea una clase `Product` con:

```text
name
price
stock
```

Requisitos:

- `name` no se puede modificar.
- `price` puede modificarse, pero nunca puede ser negativo.
- `stock` puede consultarse desde fuera.
- `stock` solamente puede modificarse mediante métodos de la clase.

Añade:

```text
increaseStock(amount)
decreaseStock(amount)
```

No se debe poder reducir el stock por debajo de `0`.

---

# Nivel 7 — Propiedades derivadas

## Ejercicio 20 — Rectángulo completo

Crea una clase `Rectangle` con:

```text
width
height
```

Añade las siguientes propiedades calculadas:

```text
area
perimeter
isSquare
```

Donde:

```text
area = width × height

perimeter = 2 × (width + height)

isSquare = width == height
```

Ejemplo:

```kotlin
val rectangle = Rectangle(10.0, 5.0)

println(rectangle.area)
println(rectangle.perimeter)
println(rectangle.isSquare)
```

---

## Ejercicio 21 — Círculo

Crea una clase `Circle` con una propiedad:

```text
radius
```

Añade:

```text
diameter
area
circumference
```

Todas deben ser propiedades calculadas.

Utiliza:

```text
diámetro = 2 × radio

área = π × radio²

circunferencia = 2 × π × radio
```

No almacenes estos valores en variables independientes.

---

# Nivel 8 — Backing properties

## Ejercicio 22 — Lista de alumnos

Crea una clase `Classroom`.

Internamente debe mantener una lista privada de alumnos.

Desde fuera de la clase se debe poder consultar la lista, pero no modificarla directamente.

La clase debe proporcionar:

```text
addStudent(name)
removeStudent(name)
```

El objetivo es que desde fuera sea posible:

```kotlin
classroom.addStudent("Ana")

println(classroom.students)
```

pero no:

```kotlin
classroom.students.add("Pedro")
```

### Objetivo

Investigar y utilizar una **backing property**.

---

## Ejercicio 23 — Lista de productos

Crea una clase `ShoppingCart`.

Internamente debe tener una lista mutable de productos.

Desde fuera solamente debe exponerse una versión de solo lectura de la lista.

Debe ser posible:

```kotlin
cart.addProduct("Keyboard")
cart.addProduct("Mouse")

println(cart.products)
```

pero no modificar directamente la colección desde fuera.

### Pista

Puedes utilizar una propiedad privada mutable y otra propiedad pública de solo lectura.

---

# Nivel 9 — Ejercicios de análisis

## Ejercicio 24 — ¿Propiedad o parámetro?

Indica cuáles de los siguientes identificadores son propiedades de la clase:

```kotlin
class Student(
    val name: String,
    age: Int
) {
    var grade = 0

    fun printInfo(course: String) {
        println(name)
        println(age)
        println(grade)
        println(course)
    }
}
```

Para cada uno:

```text
name
age
grade
course
```

indica si es:

- propiedad;
- parámetro del constructor;
- parámetro de función.

---

## Ejercicio 25 — Detecta los errores

El siguiente código tiene varios problemas:

```kotlin
class Person(
    name: String,
    var age: Int
) {
    val fullName = name

    fun birthday() {
        age++
    }
}
```

Responde:

1. ¿`name` es una propiedad?
2. ¿`age` es una propiedad?
3. ¿`fullName` es una propiedad?
4. ¿Qué ocurre si después queremos cambiar el nombre?
5. ¿Cómo harías para que `fullName` siempre utilizase el nombre actual?

---

## Ejercicio 26 — ¿`val`, `var` o propiedad calculada?

Diseña una clase `Car` y decide cómo implementar cada una de estas características:

```text
brand
model
year
mileage
age
```

Para cada una debes decidir:

- `val`;
- `var`;
- propiedad calculada.

### Pregunta adicional

Justifica cada decisión.

---

# Nivel 10 — Reto final

## Ejercicio 27 — Sistema de estudiantes

Crea una clase `Student`.

Debe tener:

### Propiedades

```text
name
id
age
```

Además:

```text
grades
```

que contenga las notas del alumno.

La lista no debe poder modificarse directamente desde fuera de la clase.

Añade una propiedad calculada:

```text
average
```

que devuelva la media de las notas.

Añade también:

```text
hasPassed
```

que devuelva `true` si la media es igual o superior a `5`.

### Métodos

Implementa:

```text
addGrade(grade)
removeGrade(grade)
```

Las notas deben estar entre `0` y `10`.

### Ejemplo

El siguiente código debería ser posible:

```kotlin
val student = Student("Ana", 1234, 20)

student.addGrade(7.0)
student.addGrade(8.0)
student.addGrade(6.0)

println(student.average)
println(student.hasPassed)
```

Pero no debería ser posible modificar directamente la colección de notas desde fuera.

---

# Nivel 11 — Reto avanzado

## Ejercicio 28 — Sistema de pedidos

Crea una clase `Order`.

Debe tener:

```text
id
customerName
```

y una colección privada de productos.

Cada producto tendrá:

```text
name
price
quantity
```

La clase `Order` debe proporcionar:

```text
addProduct(product)
removeProduct(product)
```

Y las siguientes propiedades calculadas:

```text
totalItems
subtotal
discount
total
```

Reglas:

- `totalItems` indica el número total de unidades.
- `subtotal` es el precio total antes del descuento.
- Si el subtotal es inferior a `100 €`, no hay descuento.
- Si el subtotal es de `100 €` o más, se aplica un 10 % de descuento.
- `total` es el precio final después del descuento.
- La lista de productos no debe poder modificarse directamente desde fuera.

### Ejemplo

```kotlin
val order = Order(1, "Ana")

order.addProduct(
    Product("Keyboard", 80.0, 1)
)

order.addProduct(
    Product("Mouse", 30.0, 2)
)

println(order.totalItems)
println(order.subtotal)
println(order.discount)
println(order.total)
```

---

# Reto final — Diseña tu propia clase

Diseña una clase relacionada con algo que te interese.

Algunas ideas:

- `VideoGame`
- `Movie`
- `Book`
- `Car`
- `BankAccount`
- `Character`
- `Product`
- `Recipe`
- `Employee`
- `Course`

Tu clase debe tener como mínimo:

- 3 propiedades;
- al menos una `val`;
- al menos una `var`;
- una propiedad booleana;
- una propiedad calculada;
- una propiedad que no pueda modificarse directamente desde fuera;
- al menos dos funciones que modifiquen el estado del objeto.

### Además

Explica por qué has elegido `val` o `var` para cada propiedad.

---

# Checklist

Antes de entregar los ejercicios, comprueba que sabes responder a estas preguntas:

- [ ] ¿Qué diferencia hay entre un parámetro y una propiedad?
- [ ] ¿Cómo se declara una propiedad en el constructor?
- [ ] ¿Cómo se declara una propiedad dentro del cuerpo de una clase?
- [ ] ¿Qué diferencia hay entre `val` y `var`?
- [ ] ¿Cuándo utilizarías una propiedad `private`?
- [ ] ¿Qué hace `private set`?
- [ ] ¿Qué es un getter personalizado?
- [ ] ¿Qué es un setter personalizado?
- [ ] ¿Qué es una propiedad calculada?
- [ ] ¿Qué es una *backing property*?
- [ ] ¿Cómo puedes impedir que una colección interna sea modificada directamente desde fuera de una clase?