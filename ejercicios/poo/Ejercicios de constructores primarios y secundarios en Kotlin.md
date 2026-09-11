# Ejercicios de constructores primarios y secundarios en Kotlin

## Objetivos

En estos ejercicios practicarás:

- Constructores primarios.
- Parámetros del constructor.
- Propiedades declaradas en el constructor mediante `val` y `var`.
- Valores por defecto.
- Constructores secundarios.
- Delegación entre constructores mediante `this(...)`.
- Diferencias entre constructores primarios y secundarios.
- Elección del mecanismo más adecuado para crear objetos.

---

# 1. Persona

Crea una clase `Person` que tenga:

- `name: String`
- `age: Int`

Los dos valores deben recibirse mediante el **constructor primario**.

Después:

1. Crea un objeto de tipo `Person`.
2. Muestra su nombre y edad por consola.

---

# 2. Producto

Crea una clase `Product` con un constructor primario que reciba:

- `name: String`
- `price: Double`

Crea tres productos y muestra por consola su nombre y precio.

---

# 3. Coche

Crea una clase `Car` cuyo constructor primario reciba:

- `brand: String`
- `model: String`
- `year: Int`

Crea un objeto y muestra una descripción como:

```text
Toyota Corolla (2020)
```

---

# 4. ¿Parámetro o propiedad?

Analiza la siguiente clase:

```kotlin
class Person(name: String, age: Int)
```

Intenta crear una persona y acceder posteriormente a su nombre y edad.

Comprueba qué ocurre.

A continuación, modifica la clase para que `name` y `age` sean propiedades de la clase.

Compara:

```kotlin
class Person(name: String, age: Int)
```

con:

```kotlin
class Person(val name: String, val age: Int)
```

## Preguntas

1. ¿Cuál es la diferencia entre `name` y `val name`?
2. ¿Se puede acceder a `name` desde fuera de la clase en el primer caso?
3. ¿Qué función cumplen `val` y `var` cuando aparecen en el constructor?

---

# 5. Propiedades modificables

Crea una clase `BankAccount` con un constructor primario que reciba:

- `owner: String`
- `balance: Double`

El propietario no debe poder cambiarse después de crear la cuenta, pero el saldo sí.

Después:

1. Crea una cuenta.
2. Cambia su saldo.
3. Muestra los datos de la cuenta.

---

# 6. Usuario con valor por defecto

Crea una clase `User` con:

- `username: String`
- `email: String`
- `active: Boolean`

La propiedad `active` debe tener `true` como valor por defecto.

Debe ser posible crear usuarios de estas dos formas:

```kotlin
User("rafa", "rafa@email.com")
```

y:

```kotlin
User("rafa", "rafa@email.com", false)
```

Prueba ambas posibilidades.

---

# 7. Rectángulo con valor por defecto

Crea una clase `Rectangle` con:

- `width: Double`
- `height: Double`

La altura debe tener `1.0` como valor por defecto.

Debe ser posible crear objetos de estas dos formas:

```kotlin
Rectangle(10.0)
```

y:

```kotlin
Rectangle(10.0, 5.0)
```

Añade una función `area()` que devuelva el área del rectángulo.

---

# 8. Persona con constructor secundario

Crea una clase `Person` con el siguiente constructor primario:

```kotlin
class Person(
    val name: String,
    val age: Int
)
```

Añade un **constructor secundario** que permita crear una persona indicando solamente el nombre:

```kotlin
Person("Rafael")
```

Cuando se utilice este constructor, la edad será `0`.

Por tanto, deben funcionar las dos formas:

```kotlin
val person1 = Person("Ana", 20)
val person2 = Person("Luis")
```

---

# 9. Producto con constructor secundario

Crea una clase `Product` cuyo constructor primario reciba:

- `name`
- `price`

Añade un constructor secundario que permita crear un producto proporcionando solamente el nombre.

En ese caso, el precio será `0.0`.

Deben funcionar:

```kotlin
val product1 = Product("Laptop", 999.99)
val product2 = Product("Mouse")
```

---

# 10. Libro

Crea la siguiente clase:

```kotlin
class Book(
    val title: String,
    val author: String,
    val pages: Int
)
```

Añade un constructor secundario que permita crear un libro proporcionando únicamente:

- título
- autor

En ese caso, el número de páginas será `0`.

## Condición

El constructor secundario debe delegar en el constructor primario mediante:

```kotlin
this(...)
```

---

# 11. Coche con constructor secundario

Crea una clase `Car` con:

- `brand`
- `model`
- `year`

El constructor primario debe recibir los tres datos.

Añade un constructor secundario que reciba únicamente:

- `brand`
- `model`

En ese caso, el año será `0`.

Después crea coches utilizando ambas formas.

---

# 12. Usuario con varios constructores secundarios

Crea una clase `User` con:

- `username`
- `email`
- `age`

El constructor primario debe recibir los tres datos.

Añade dos constructores secundarios.

## Primer constructor secundario

Debe recibir:

- `username`
- `email`

La edad será `0`.

## Segundo constructor secundario

Debe recibir únicamente:

- `username`

En este caso:

```text
email = "unknown"
age = 0
```

Deben ser posibles las tres formas:

```kotlin
User("ana", "ana@email.com", 25)

User("luis", "luis@email.com")

User("maria")
```

---

# 13. Constructor secundario o valor por defecto

Se quiere representar una temperatura.

Debe ser posible crear temperaturas de estas formas:

```kotlin
Temperature(25.0)
```

y:

```kotlin
Temperature(25.0, "C")
```

Cuando no se indique la unidad, debe utilizarse `"C"`.

## Pregunta

¿Utilizarías un constructor secundario o un valor por defecto en el constructor primario?

Implementa la solución que consideres más apropiada.

## Después responde

1. ¿Por qué has elegido esa solución?
2. ¿Podrías resolverlo utilizando un constructor secundario?
3. ¿Qué solución resulta más sencilla?
4. ¿Qué ventajas tiene utilizar un valor por defecto en este caso?

---

# 14. ¿Compila?

Indica cuáles de los siguientes ejemplos son correctos y cuáles producen un error de compilación.

Justifica cada respuesta.

## A

```kotlin
class Person(val name: String, val age: Int) {
    constructor(name: String) : this(name, 0)
}
```

## B

```kotlin
class Person(val name: String, val age: Int) {
    constructor(name: String) {
        this.name = name
        this.age = 0
    }
}
```

## C

```kotlin
class Person(val name: String, val age: Int) {
    constructor() : this("Unknown", 0)
}
```

## D

```kotlin
class Person(val name: String, val age: Int) {
    constructor(name: String, age: Int) : this(name, age)
}
```

## Preguntas

Para cada caso indica:

- ¿Compila?
- Si no compila, ¿por qué?
- Si compila, ¿qué constructor se utiliza?
- ¿El constructor secundario delega correctamente en el primario?

---

# 15. Videojuego

Crea una clase `Game` con las siguientes propiedades:

- `title: String`
- `genre: String`
- `price: Double`
- `online: Boolean`

El constructor primario debe recibir todos los datos.

Añade un constructor secundario que permita crear juegos proporcionando:

- título
- género
- precio

En este caso, `online` será `false`.

Por ejemplo:

```kotlin
Game("Minecraft", "Sandbox", 29.99)
```

También debe ser posible crear un juego indicando únicamente el título:

```kotlin
Game("Minecraft")
```

En este último caso:

```text
genre = "Unknown"
price = 0.0
online = false
```

## Condiciones

Debes utilizar:

- Un constructor primario.
- Dos constructores secundarios.
- Delegación mediante `this(...)`.

Después crea varios objetos utilizando las diferentes formas de construcción.

---

# 16. Empleados

Crea una clase `Employee` con:

- `name`
- `department`
- `salary`

El constructor primario debe recibir los tres datos.

Debe ser posible crear empleados de las siguientes maneras.

## Empleado completo

```kotlin
Employee("Ana", "Development", 2500.0)
```

## Sin salario

```kotlin
Employee("Luis", "Development")
```

En este caso:

```text
salary = 0.0
```

## Solo nombre

```kotlin
Employee("Maria")
```

En este caso:

```text
department = "Unknown"
salary = 0.0
```

## Condiciones

Debes utilizar:

- Un constructor primario.
- Dos constructores secundarios.
- Delegación mediante `this(...)`.

---

# 17. Preguntas sobre constructores

Responde a las siguientes preguntas.

### 17.1

¿Qué es el constructor primario de una clase Kotlin?

### 17.2

¿Dónde se declara normalmente el constructor primario?

### 17.3

¿Qué diferencia existe entre estos dos casos?

```kotlin
class Person(name: String)
```

```kotlin
class Person(val name: String)
```

### 17.4

¿Qué diferencia existe entre:

```kotlin
val name: String
```

y:

```kotlin
var name: String
```

cuando aparecen en el constructor?

### 17.5

¿Qué es un constructor secundario?

### 17.6

¿Qué palabra reservada se utiliza para declarar un constructor secundario?

### 17.7

¿Cómo puede un constructor secundario llamar al constructor primario?

### 17.8

¿Por qué un constructor secundario debe delegar en otro constructor cuando existe un constructor primario?

### 17.9

¿Qué diferencia existe entre utilizar:

```kotlin
class Person(
    val name: String,
    val age: Int = 0
)
```

y:

```kotlin
class Person(
    val name: String,
    val age: Int
) {
    constructor(name: String) : this(name, 0)
}
```

### 17.10

¿En qué situaciones podría ser más apropiado utilizar un constructor secundario?

---

# 18. Película

Crea una clase `Movie` que represente una película.

Debe contener:

- `title`
- `director`
- `year`
- `duration`

El constructor primario debe recibir todos los datos.

Diseña como mínimo **dos constructores secundarios** que permitan crear una película proporcionando diferentes cantidades de información.

Por ejemplo, deberían poder existir formas como:

```kotlin
Movie(
    "Interstellar",
    "Christopher Nolan",
    2014,
    169
)
```

```kotlin
Movie(
    "Interstellar",
    "Christopher Nolan",
    2014
)
```

y:

```kotlin
Movie("Interstellar")
```

Define valores razonables para los datos que no se proporcionen.

## Condición

Antes de escribir el código, decide:

1. Qué datos deben pertenecer al constructor primario.
2. Qué situaciones justifican utilizar constructores secundarios.
3. Qué valores deben utilizarse cuando no se proporciona determinada información.

---

# 19. Diseña tus propios constructores

Crea una clase que represente un objeto de tu elección.

Algunas posibilidades son:

- `Student`
- `Book`
- `Computer`
- `Car`
- `Phone`
- `Game`
- `Product`
- `Course`

La clase debe tener:

- Al menos tres propiedades.
- Un constructor primario.
- Al menos dos constructores secundarios.

Los constructores deben permitir crear objetos proporcionando diferentes cantidades de información.

## Condiciones

Debes utilizar correctamente:

- `val`
- `var`
- Constructor primario.
- Constructores secundarios.
- `this(...)`.

Después crea al menos tres objetos utilizando constructores diferentes.

---

# 20. Reto final — Diseña la clase

Diseña una clase `Student` para representar a un alumno.

Debe almacenar como mínimo:

- nombre
- edad
- curso
- nota media

El alumno debe poder crearse de diferentes formas.

Por ejemplo:

```kotlin
Student("Ana", 20, "DAM", 8.5)
```

También:

```kotlin
Student("Luis", 21, "DAM")
```

En este caso, la nota media será `0.0`.

Y:

```kotlin
Student("Maria")
```

En este caso, debes establecer valores apropiados para el resto de propiedades.

## Requisitos

El ejercicio debe contener:

- Un constructor primario.
- Dos constructores secundarios.
- Delegación mediante `this(...)`.
- Al menos una propiedad `val`.
- Al menos una propiedad `var`.

## Preguntas

Después de implementar la clase, responde:

1. ¿Qué constructor se ejecuta en cada caso?
2. ¿Qué constructor acaba inicializando todas las propiedades?
3. ¿Por qué los constructores secundarios delegan en otro constructor?
4. ¿Qué ocurriría si un constructor secundario no llamase a otro constructor?
5. ¿Podrías solucionar el ejercicio utilizando valores por defecto?
6. ¿Qué solución elegirías en un programa real?
7. ¿Por qué?

---

# Reto adicional — Constructor secundario que delega en otro secundario

Crea una clase `Product` con:

- `name`
- `price`
- `category`

El constructor primario debe recibir las tres propiedades.

Crea un constructor secundario que reciba:

```text
name
price
```

y establezca:

```text
category = "Unknown"
```

Después crea **otro constructor secundario** que reciba solamente:

```text
name
```

Este constructor debe delegar en el **otro constructor secundario**, y no directamente en el primario.

El resultado debe permitir:

```kotlin
Product("Laptop", 999.99, "Computer")
```

```kotlin
Product("Mouse", 25.99)
```

```kotlin
Product("Keyboard")
```

## Pregunta

Dibuja o explica la cadena de llamadas entre los tres constructores.

Por ejemplo:

```text
constructor(name)
       ↓
constructor(name, price)
       ↓
constructor(name, price, category)
```

---

# Reto final — ¿Qué solución elegirías?

Considera las siguientes dos implementaciones.

## Opción A

```kotlin
class Person(
    val name: String,
    val age: Int = 0
)
```

## Opción B

```kotlin
class Person(
    val name: String,
    val age: Int
) {
    constructor(name: String) : this(name, 0)
}
```

Ambas permiten:

```kotlin
Person("Ana", 20)
```

y:

```kotlin
Person("Luis")
```

## Preguntas

1. ¿Qué diferencias existen entre ambas soluciones?
2. ¿Cuál tiene menos código?
3. ¿Cuál utilizarías si únicamente quieres proporcionar un valor alternativo para un parámetro?
4. ¿En qué situación podría tener sentido utilizar el constructor secundario?
5. ¿Qué ventajas y desventajas encuentras en cada solución?

---

# Resumen de conceptos

Al finalizar estos ejercicios deberías ser capaz de reconocer y utilizar correctamente:

## Constructor primario

```kotlin
class Person(
    val name: String,
    val age: Int
)
```

## Constructor primario con valor por defecto

```kotlin
class Person(
    val name: String,
    val age: Int = 0
)
```

## Constructor secundario

```kotlin
class Person(
    val name: String,
    val age: Int
) {
    constructor(name: String) : this(name, 0)
}
```

## Varios constructores secundarios

```kotlin
class Person(
    val name: String,
    val age: Int,
    val email: String
) {
    constructor(name: String, age: Int) :
        this(name, age, "unknown")

    constructor(name: String) :
        this(name, 0, "unknown")
}
```

## Delegación entre constructores secundarios

```kotlin
class Person(
    val name: String,
    val age: Int,
    val email: String
) {
    constructor(name: String, age: Int) :
        this(name, age, "unknown")

    constructor(name: String) :
        this(name, 0)
}
```

El objetivo final es comprender no solamente **cómo se escribe un constructor**, sino también **qué constructor se ejecuta, cómo se inicializan las propiedades y cuándo resulta apropiado utilizar un constructor secundario frente a un valor por defecto**.