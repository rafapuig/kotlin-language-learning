# Ejercicios: argumentos posicionales, argumentos con nombre y valores por defecto en Kotlin

En estos ejercicios practicarás diferentes formas de llamar a una función en Kotlin.

Trabajaremos exclusivamente estos conceptos:

- Parámetros de una función.
- Argumentos posicionales.
- Argumentos con nombre.
- Parámetros con valor por defecto.
- Combinación de argumentos posicionales y con nombre.
- Omisión de parámetros mediante valores por defecto.
- Orden de los argumentos en una llamada.

> **Importante:** no debes modificar las declaraciones de las funciones salvo que el ejercicio lo indique. La práctica se centra principalmente en **cómo realizar las llamadas**.

---

# 1. Parámetros y argumentos posicionales

Recuerda que en una función como:

```kotlin
fun greet(name: String, age: Int) {
    println("$name has $age years")
}
```

los valores se pueden proporcionar de forma posicional:

```kotlin
greet("Laura", 25)
```

El primer argumento corresponde al primer parámetro y el segundo al segundo parámetro.

---

## Ejercicio 1

Dada la función:

```kotlin
fun showPerson(name: String, age: Int) {
    println("$name is $age years old")
}
```

Realiza una llamada que muestre:

```text
Laura is 25 years old
```

Utiliza argumentos posicionales.

---

## Ejercicio 2

Dada:

```kotlin
fun add(first: Int, second: Int) {
    println(first + second)
}
```

Realiza una llamada que muestre:

```text
35
```

---

## Ejercicio 3

Dada:

```kotlin
fun showProduct(name: String, price: Double, quantity: Int) {
    println("$name: $price x $quantity")
}
```

Realiza una llamada para representar:

```text
Keyboard: 49.99 x 2
```

Utiliza únicamente argumentos posicionales.

---

## Ejercicio 4

Dada:

```kotlin
fun createAddress(street: String, number: Int, city: String) {
    println("$street $number, $city")
}
```

Realiza una llamada que produzca:

```text
Main Street 25, Madrid
```

---

# 2. Identificar el orden de los parámetros

## Ejercicio 5

Observa:

```kotlin
fun calculateTotal(price: Double, quantity: Int) {
    println(price * quantity)
}
```

Realiza una llamada utilizando:

```text
price = 12.5
quantity = 4
```

---

## Ejercicio 6

Observa:

```kotlin
fun showDate(day: Int, month: Int, year: Int) {
    println("$day/$month/$year")
}
```

Realiza una llamada para representar:

```text
6/9/2026
```

---

## Ejercicio 7

Dada:

```kotlin
fun createProfile(name: String, age: Int, city: String) {
    println("$name, $age, $city")
}
```

Realiza una llamada para:

```text
Carlos, 30, Valencia
```

Después realiza otra llamada cambiando únicamente los valores.

---

## Ejercicio 8

Sin ejecutar el programa, indica qué valores recibe cada parámetro:

```kotlin
fun showValues(first: Int, second: Int, third: Int) {
    println("$first $second $third")
}

showValues(10, 20, 30)
```

---

# 3. Argumentos con nombre

Kotlin permite indicar explícitamente el nombre del parámetro:

```kotlin
showPerson(
    name = "Laura",
    age = 25
)
```

## Ejercicio 9

Dada:

```kotlin
fun showPerson(name: String, age: Int) {
    println("$name is $age years old")
}
```

Realiza la misma llamada del ejercicio 1, pero utilizando argumentos con nombre.

---

## Ejercicio 10

Dada:

```kotlin
fun add(first: Int, second: Int) {
    println(first + second)
}
```

Realiza una llamada utilizando:

```text
first = 10
second = 25
```

Utiliza argumentos con nombre.

---

## Ejercicio 11

Dada:

```kotlin
fun showProduct(name: String, price: Double, quantity: Int) {
    println("$name: $price x $quantity")
}
```

Realiza una llamada utilizando argumentos con nombre.

---

## Ejercicio 12

Dada:

```kotlin
fun createAddress(street: String, number: Int, city: String) {
    println("$street $number, $city")
}
```

Realiza una llamada utilizando argumentos con nombre.

---

# 4. Cambiar el orden mediante argumentos con nombre

Una ventaja importante de los argumentos con nombre es que permiten indicar explícitamente qué valor corresponde a cada parámetro.

## Ejercicio 13

Dada:

```kotlin
fun showPerson(name: String, age: Int) {
    println("$name is $age years old")
}
```

Realiza una llamada utilizando argumentos con nombre y escribe primero:

```kotlin
age = 25
```

y después:

```kotlin
name = "Laura"
```

Comprueba si Kotlin permite ese orden.

---

## Ejercicio 14

Dada:

```kotlin
fun showProduct(name: String, price: Double, quantity: Int) {
    println("$name: $price x $quantity")
}
```

Realiza una llamada proporcionando los argumentos en este orden:

```text
quantity
name
price
```

Utiliza argumentos con nombre.

---

## Ejercicio 15

Dada:

```kotlin
fun createAddress(street: String, number: Int, city: String) {
    println("$street $number, $city")
}
```

Realiza una llamada proporcionando los argumentos en el siguiente orden:

```text
city
number
street
```

Utiliza argumentos con nombre.

---

## Ejercicio 16

Explica qué ventaja tiene utilizar argumentos con nombre en una función que tiene varios parámetros del mismo tipo.

Puedes utilizar como referencia:

```kotlin
fun createDate(day: Int, month: Int, year: Int)
```

---

# 5. Parámetros con valor por defecto

Kotlin permite definir un valor por defecto:

```kotlin
fun greet(name: String, greeting: String = "Hello") {
    println("$greeting, $name")
}
```

En este caso, `greeting` puede omitirse al llamar a la función.

---

## Ejercicio 17

Dada:

```kotlin
fun greet(name: String, greeting: String = "Hello") {
    println("$greeting, $name")
}
```

Realiza una llamada proporcionando únicamente `name`.

---

## Ejercicio 18

Utiliza la misma función para conseguir:

```text
Hello, Laura
```

---

## Ejercicio 19

Utiliza la misma función para conseguir:

```text
Good morning, Laura
```

Debes proporcionar el segundo parámetro explícitamente.

---

## Ejercicio 20

Dada:

```kotlin
fun showPrice(price: Double, currency: String = "EUR") {
    println("$price $currency")
}
```

Realiza una llamada que muestre:

```text
25.5 EUR
```

sin proporcionar explícitamente `currency`.

---

## Ejercicio 21

Utiliza la misma función para mostrar:

```text
25.5 USD
```

---

# 6. Varios parámetros con valores por defecto

## Ejercicio 22

Dada:

```kotlin
fun createUser(
    name: String,
    age: Int = 18,
    city: String = "Madrid"
) {
    println("$name, $age, $city")
}
```

Realiza una llamada proporcionando únicamente el nombre.

---

## Ejercicio 23

Utiliza la misma función para crear:

```text
Laura, 25, Madrid
```

---

## Ejercicio 24

Utiliza la misma función para crear:

```text
Laura, 18, Valencia
```

Debes aprovechar el valor por defecto de `age`.

---

## Ejercicio 25

Utiliza la misma función para crear:

```text
Laura, 25, Valencia
```

---

# 7. El problema de los parámetros opcionales intermedios

Este es uno de los casos más importantes.

Dada:

```kotlin
fun configure(
    name: String,
    age: Int = 18,
    city: String = "Madrid"
) {
    println("$name, $age, $city")
}
```

Queremos proporcionar `name` y `city`, pero utilizar el valor por defecto de `age`.

## Ejercicio 26

Realiza la llamada necesaria para obtener:

```text
Laura, 18, Valencia
```

No cambies la declaración de la función.

---

## Ejercicio 27

Realiza la misma llamada utilizando un argumento con nombre para `city`.

---

## Ejercicio 28

Explica por qué esta llamada:

```kotlin
configure("Laura", "Valencia")
```

no es válida.

---

## Ejercicio 29

Modifica únicamente la llamada para conseguir:

```text
Laura, 18, Valencia
```

Utiliza el valor por defecto de `age`.

---

# 8. Posicionales y nombres juntos

Kotlin permite combinar argumentos posicionales y argumentos con nombre.

Por ejemplo:

```kotlin
fun createUser(
    name: String,
    age: Int,
    city: String
) {
    println("$name, $age, $city")
}
```

Una llamada puede proporcionar inicialmente argumentos posicionales y posteriormente argumentos con nombre.

---

## Ejercicio 30

Dada la función anterior, realiza una llamada utilizando:

- `name` como argumento posicional.
- `age` como argumento con nombre.
- `city` como argumento con nombre.

---

## Ejercicio 31

Dada:

```kotlin
fun showProduct(
    name: String,
    price: Double,
    quantity: Int
) {
    println("$name: $price x $quantity")
}
```

Realiza una llamada utilizando:

- `name` posicionalmente.
- `price` mediante nombre.
- `quantity` mediante nombre.

---

## Ejercicio 32

Dada:

```kotlin
fun createAddress(
    street: String,
    number: Int,
    city: String
) {
    println("$street $number, $city")
}
```

Realiza una llamada utilizando:

- `street` posicionalmente.
- `number` mediante nombre.
- `city` mediante nombre.

---

# 9. Posicionales + nombres + valores por defecto

Ahora combinaremos los tres conceptos.

## Ejercicio 33

Dada:

```kotlin
fun createUser(
    name: String,
    age: Int = 18,
    city: String = "Madrid"
) {
    println("$name, $age, $city")
}
```

Realiza una llamada que utilice:

- `name` como argumento posicional.
- el valor por defecto de `age`.
- `city` mediante nombre.

El resultado debe ser:

```text
Laura, 18, Valencia
```

---

## Ejercicio 34

Utiliza la misma función para obtener:

```text
Carlos, 25, Madrid
```

Utiliza:

- `name` posicionalmente.
- `age` mediante nombre.
- el valor por defecto de `city`.

---

## Ejercicio 35

Utiliza la misma función para obtener:

```text
Carlos, 25, Valencia
```

Utiliza:

- `name` posicionalmente.
- `age` mediante nombre.
- `city` mediante nombre.

---

## Ejercicio 36

Dada:

```kotlin
fun configure(
    width: Int = 800,
    height: Int = 600,
    title: String = "Window",
    fullscreen: Boolean = false
) {
    println("$width x $height - $title - $fullscreen")
}
```

Realiza una llamada que:

- utilice el ancho por defecto;
- utilice el alto por defecto;
- cambie únicamente `title`.

---

## Ejercicio 37

Utiliza la misma función para:

```text
1024 x 600 - Game - false
```

Utiliza:

- `width` mediante nombre.
- el valor por defecto de `height`.
- `title` mediante nombre.
- el valor por defecto de `fullscreen`.

---

## Ejercicio 38

Utiliza la misma función para:

```text
1024 x 768 - Game - true
```

Utiliza argumentos con nombre únicamente cuando sea necesario.

---

# 10. Elegir la forma de llamada

En estos ejercicios debes decidir si conviene utilizar argumentos posicionales, argumentos con nombre o una combinación.

## Ejercicio 39

Dada:

```kotlin
fun printColor(red: Int, green: Int, blue: Int) {
    println("$red $green $blue")
}
```

Realiza una llamada para:

```text
255 128 64
```

Utiliza argumentos posicionales.

Después realiza la misma llamada utilizando argumentos con nombre.

---

## Ejercicio 40

Dada:

```kotlin
fun createDate(
    day: Int,
    month: Int,
    year: Int
) {
    println("$day/$month/$year")
}
```

Realiza una llamada utilizando argumentos con nombre.

Explica por qué en este caso los nombres pueden hacer que la llamada sea más fácil de entender.

---

## Ejercicio 41

Dada:

```kotlin
fun configureText(
    text: String,
    size: Int = 16,
    bold: Boolean = false,
    italic: Boolean = false
) {
    println("$text - $size - $bold - $italic")
}
```

Realiza una llamada que:

- utilice el texto `"Hello"`;
- mantenga el tamaño por defecto;
- active `bold`;
- mantenga `italic` con su valor por defecto.

---

## Ejercicio 42

Utiliza la misma función para:

```text
Hello - 24 - false - true
```

---

## Ejercicio 43

Utiliza la misma función para:

```text
Hello - 24 - true - true
```

---

# 11. Analizar llamadas

En estos ejercicios debes determinar si la llamada es válida.

## Ejercicio 44

¿Es válida esta llamada?

```kotlin
fun greet(name: String, greeting: String = "Hello") {
    println("$greeting, $name")
}

greet("Laura")
```

---

## Ejercicio 45

¿Es válida?

```kotlin
greet(
    greeting = "Good morning",
    name = "Laura"
)
```

---

## Ejercicio 46

¿Es válida?

```kotlin
greet(
    "Laura",
    greeting = "Good morning"
)
```

---

## Ejercicio 47

¿Es válida?

```kotlin
greet(
    name = "Laura",
    "Good morning"
)
```

Si no lo es, explica por qué.

---

## Ejercicio 48

Dada:

```kotlin
fun configure(
    width: Int = 800,
    height: Int = 600,
    title: String = "Window"
) {
    println("$width $height $title")
}
```

Analiza:

```kotlin
configure(
    title = "Game"
)
```

¿Qué valores reciben los tres parámetros?

---

## Ejercicio 49

Analiza:

```kotlin
configure(
    1024,
    title = "Game"
)
```

¿Qué valores reciben los tres parámetros?

---

## Ejercicio 50

Analiza:

```kotlin
configure(
    width = 1024,
    height = 768
)
```

¿Qué valor recibe `title`?

---

# 12. Corregir llamadas

## Ejercicio 51

La siguiente llamada no funciona:

```kotlin
fun createUser(
    name: String,
    age: Int = 18,
    city: String = "Madrid"
) {
    println("$name, $age, $city")
}

createUser("Laura", "Valencia")
```

Corrige únicamente la llamada para obtener:

```text
Laura, 18, Valencia
```

---

## Ejercicio 52

Corrige:

```kotlin
createUser(
    city = "Valencia",
    "Laura"
)
```

sin modificar la función.

---

## Ejercicio 53

Corrige la llamada para obtener:

```text
Carlos, 25, Madrid
```

utilizando el mínimo número de argumentos escritos explícitamente.

---

# 13. Retos de aplicación

## Ejercicio 54 — Configuración de jugador

Dada:

```kotlin
fun createPlayer(
    name: String,
    level: Int = 1,
    score: Int = 0,
    lives: Int = 3
) {
    println("$name - level $level - score $score - lives $lives")
}
```

Realiza una llamada para crear:

```text
Rafael - level 1 - score 500 - lives 3
```

Utiliza el valor por defecto de `level` y `lives`.

---

## Ejercicio 55

Utiliza la misma función para crear:

```text
Laura - level 5 - score 0 - lives 3
```

Utiliza los valores por defecto siempre que sea posible.

---

## Ejercicio 56

Utiliza la misma función para crear:

```text
Carlos - level 10 - score 2500 - lives 5
```

---

## Ejercicio 57 — Configuración de una ventana

Dada:

```kotlin
fun createWindow(
    width: Int = 800,
    height: Int = 600,
    title: String = "Game",
    fullscreen: Boolean = false
) {
    println("$width x $height - $title - $fullscreen")
}
```

Realiza una llamada para:

```text
800 x 600 - Game - false
```

utilizando únicamente los valores por defecto.

---

## Ejercicio 58

Realiza una llamada para:

```text
1920 x 1080 - Game - false
```

utilizando valores por defecto siempre que sea posible.

---

## Ejercicio 59

Realiza una llamada para:

```text
1920 x 1080 - Game - true
```

---

# 14. Reto final

## Ejercicio 60

Dada:

```kotlin
fun configureGame(
    width: Int = 800,
    height: Int = 600,
    title: String = "My Game",
    fullscreen: Boolean = false,
    volume: Int = 100
) {
    println("$width x $height")
    println(title)
    println("Fullscreen: $fullscreen")
    println("Volume: $volume")
}
```

Realiza las siguientes llamadas.

### A

Utiliza todos los valores por defecto.

---

### B

Cambia únicamente el título a:

```text
Space Game
```

---

### C

Cambia únicamente la resolución a:

```text
1920 x 1080
```

---

### D

Cambia únicamente el volumen a:

```text
50
```

---

### E

Cambia:

```text
width = 1280
height = 720
volume = 75
```

manteniendo el resto de valores por defecto.

---

### F

Cambia:

```text
title = "Retro Game"
fullscreen = true
```

manteniendo todos los demás valores por defecto.

---

### G

Cambia:

```text
width = 1920
height = 1080
title = "Space Game"
fullscreen = true
volume = 80
```

Utiliza argumentos con nombre.

---

# Resumen de conceptos

## Argumentos posicionales

Los valores se asignan según su posición:

```kotlin
createUser("Laura", 25, "Valencia")
```

---

## Argumentos con nombre

Se especifica explícitamente el parámetro:

```kotlin
createUser(
    name = "Laura",
    age = 25,
    city = "Valencia"
)
```

---

## Valores por defecto

Un parámetro puede tener un valor que se utiliza cuando no se proporciona un argumento:

```kotlin
fun greet(
    name: String,
    greeting: String = "Hello"
)
```

Por tanto:

```kotlin
greet("Laura")
```

utiliza automáticamente `"Hello"`.

---

## Combinación

Los tres conceptos pueden utilizarse conjuntamente:

```kotlin
createUser(
    "Laura",
    city = "Valencia"
)
```

En este caso:

- `"Laura"` es un argumento posicional.
- `age` utiliza su valor por defecto.
- `"Valencia"` es un argumento con nombre.

---

# Regla fundamental

Una situación especialmente importante es cuando queremos **saltar un parámetro que tiene valor por defecto** para proporcionar uno posterior.

Por ejemplo:

```kotlin
fun configure(
    width: Int = 800,
    height: Int = 600,
    title: String = "Game"
)
```

Si queremos cambiar solamente `title`, no podemos hacer:

```kotlin
configure("My Game")
```

porque `"My Game"` corresponde a `width`.

Debemos utilizar el nombre:

```kotlin
configure(title = "My Game")
```

Esta es una de las principales razones para utilizar **argumentos con nombre**.

---

# Objetivo final

Al terminar estos ejercicios, el alumno debe ser capaz de mirar una función como:

```kotlin
fun configure(
    width: Int = 800,
    height: Int = 600,
    title: String = "Game",
    fullscreen: Boolean = false
)
```

y decidir correctamente cómo llamarla para modificar **solo los parámetros que necesita**, aprovechando los valores por defecto y utilizando argumentos con nombre cuando sea necesario.