# EXAMEN DE KOTLIN – UNIDAD 4
## Genéricos, varianza y Scope Functions

**Ciclo:** 2.º DAM  
**Módulo:** Programación  
**Número de preguntas:** 40  
**Tipo:** Test (4 opciones, una única respuesta correcta)

**Nombre y apellidos:** ______________________________________

**Fecha:** __________________

---

## PARTE 1. GENÉRICOS: FUNCIONES Y TIPOS

**Pregunta 1.** ¿Qué permite hacer la programación genérica en Kotlin?

A) Crear funciones que solo trabajan con tipos numéricos.

B) Crear clases y funciones que trabajan con distintos tipos manteniendo la seguridad de tipos.

C) Evitar completamente la comprobación de tipos.

D) Convertir automáticamente cualquier tipo en `Any`.

---

**Pregunta 2.** ¿Cuál de las siguientes declaraciones define correctamente una función genérica?

A)
```kotlin
fun <T> identity(value: T): T = value
```

B)
```kotlin
fun identity<T>(value: T): T = value
```

C)
```kotlin
fun identity(value: T): T = value
```

D)
```kotlin
<T> fun identity(value): T = value
```

---

**Pregunta 3.** ¿Qué resultado produce el siguiente código?

```kotlin
fun <T> identity(value: T): T = value

val result = identity("Kotlin")
println(result)
```

A) `null`

B) Error de compilación.

C) `Kotlin`

D) `Any`

---

**Pregunta 4.** ¿Qué representa el parámetro `T` en la siguiente declaración?

```kotlin
class Box<T>(val value: T)
```

A) Una variable global.

B) Un parámetro de tipo.

C) Una función genérica.

D) Una instancia de la clase `T`.

---

**Pregunta 5.** ¿Cuál es la forma correcta de crear una instancia de `Box` que almacene un `Int`?

```kotlin
class Box<T>(val value: T)
```

A) `val box = Box<Int>(10)`

B) `val box = Box(10)` no es válido porque siempre hay que indicar el tipo.

C) `val box = Box<T>(10)` sin declarar previamente `T`.

D) `val box: Box = Box(10)` es obligatorio.

---
**Pregunta 6.** ¿Qué indica la siguiente restricción?

```kotlin
fun <T : Number> doubleValue(value: T): Double {
    return value.toDouble() * 2
}
```

A) `T` debe ser exactamente `Double`.

B) `T` debe ser un subtipo de `Number` o el propio `Number`.

C) `T` no puede ser un tipo numérico.

D) `T` debe implementar una interfaz llamada `Number`.

---

**Pregunta 7.** ¿Qué sucede al ejecutar este código?

```kotlin
fun <T> printType(value: T) {
    println(value)
}

printType(25)
printType("Hola")
```

A) Solo funciona con el primer argumento.

B) Solo funciona con cadenas.

C) Imprime `25` y después `Hola`.

D) Produce un error porque una función genérica solo puede utilizarse una vez.

---

**Pregunta 8.** ¿Cuál es la finalidad de la palabra clave `where` en una declaración genérica?

A) Definir restricciones adicionales sobre los parámetros de tipo.

B) Indicar dónde se almacena el objeto.

C) Declarar una variable local.

D) Convertir un tipo genérico en nullable.



## PARTE 2. COVARIANZA Y CONTRAVARIANZA

**Pregunta 9.** ¿Qué significa que un parámetro genérico sea covariante?

A) Permite utilizar un tipo más general donde se espera uno más específico.

B) Permite utilizar un tipo más específico donde se espera uno más general.

C) Impide utilizar tipos derivados.

D) Convierte automáticamente los tipos en `Any`.

---

**Pregunta 10.** ¿Qué palabra clave permite declarar covarianza en Kotlin?

A) `in`

B) `out`

C) `var`

D) `where`

---

**Pregunta 11.** ¿Qué representa la declaración `out T`?

A) El tipo `T` solo puede utilizarse como entrada.

B) El tipo `T` puede producirse como salida, pero no recibirse como parámetro de entrada.

C) El tipo `T` no puede utilizarse como tipo de retorno.

D) El tipo `T` debe ser nullable.

---

**Pregunta 12.** Observa las siguientes declaraciones:

```kotlin
open class Animal
class Dog : Animal()

class Producer<out T>(val value: T)
```

¿Qué ocurre en el siguiente código?

```kotlin
val dogProducer: Producer<Dog> = Producer(Dog())
val animalProducer: Producer<Animal> = dogProducer
```

A) Se produce un error porque `Dog` y `Animal` son tipos diferentes.

B) Es válido gracias a la covarianza.

C) Es válido únicamente si `Animal` es una interface.

D) Se produce un error porque `out` no permite herencia.

---

**Pregunta 13.** ¿Qué significa que un parámetro genérico sea contravariante?

A) Permite utilizar un tipo más específico donde se espera uno más general.

B) Permite utilizar un tipo más general donde se espera uno más específico.

C) Impide recibir parámetros de tipo genérico.

D) Hace que todos los tipos sean equivalentes.

---

**Pregunta 14.** ¿Qué palabra clave permite declarar contravarianza en Kotlin?

A) `out`

B) `in`

C) `as`

D) `is`

---

**Pregunta 15.** Observa el siguiente código:

```kotlin
open class Animal
class Dog : Animal()

class Consumer<in T> {
    fun consume(value: T) {
        println(value)
    }
}
```

¿Qué ocurre aquí?

```kotlin
val animalConsumer: Consumer<Animal> = Consumer()
val dogConsumer: Consumer<Dog> = animalConsumer
```

A) Es válido gracias a la contravarianza.

B) Es inválido porque `Animal` es más general que `Dog`.

C) Es inválido porque `in` no permite funciones.

D) Es válido únicamente si `Dog` hereda de una interfaz.

---

**Pregunta 16.** ¿Cuál de las siguientes afirmaciones es correcta?

A) La covarianza se declara con `in` y la contravarianza con `out`.

B) La covarianza se declara con `out` y la contravarianza con `in`.

C) Ambas se declaran con `out`.

D) Ambas se declaran con `in`.

---

## PARTE 3. DECLARACIONES USE-SITE Y PROYECCIÓN ESTRELLA

**Pregunta 17.** ¿Qué es una declaración de varianza use-site?

A) Una declaración que establece la varianza al utilizar un tipo genérico, en lugar de declararla en la propia clase.

B) Una declaración que elimina los parámetros genéricos.

C) Una declaración que convierte una clase en abstracta.

D) Una declaración que permite crear objetos sin constructor.

---

**Pregunta 18.** ¿Qué indica la siguiente declaración?

```kotlin
fun process(values: List<out Number>) {
    // ...
}
```

A) Que la función puede modificar libremente los elementos de la lista.
B) Que se utiliza una proyección de salida para el tipo genérico.
C) Que `Number` es una variable.
D) Que la lista solo puede contener valores de tipo `Double`.

---

**Pregunta 19.** ¿Qué significa utilizar `in` en una proyección use-site?

A) Que el tipo genérico se utiliza como entrada.

B) Que el tipo genérico se utiliza exclusivamente como salida.

C) Que el tipo genérico se convierte en nullable.

D) Que se elimina la comprobación de tipos.

---

**Pregunta 20.** ¿Qué representa la proyección estrella `*` en Kotlin?

A) Un tipo genérico que acepta exclusivamente `String`.

B) Una proyección que representa un tipo genérico cuyo argumento concreto se desconoce.

C) Una referencia a cualquier objeto mutable.

D) Un comodín que permite insertar cualquier valor sin restricciones.

---

**Pregunta 21.** ¿Qué ocurre con el siguiente código?

```kotlin
val values: List<*> = listOf(10, "Hola", true)
println(values[0])
```

A) Error porque una lista no puede mezclar tipos.

B) Imprime `10`.

C) Imprime `null`.

D) Error porque `List<*>` no permite leer elementos.

---

**Pregunta 22.** ¿Qué tipo de valor podemos añadir a una lista declarada como `MutableList<*>`?

A) Cualquier objeto.

B) Únicamente valores `String`.

C) Únicamente valores `Int`.

D) No podemos añadir ningún valor no nulo de forma segura, porque desconocemos el tipo concreto.

---

**Pregunta 23.** ¿Cuál es la diferencia principal entre `List<Any>` y `List<*>`?

A) Son exactamente equivalentes.

B) `List<Any>` representa una lista de elementos de tipo `Any`; `List<*>` representa una lista cuyo tipo de elemento se desconoce.

C) `List<*>` solo admite números.

D) `List<Any>` no permite almacenar cadenas.

---

**Pregunta 24.** ¿Qué sucede al ejecutar el siguiente código?

```kotlin
fun printValues(values: List<*>) {
    for (value in values) {
        println(value)
    }
}

printValues(listOf(1, "Kotlin", true))
```

A) Produce un error porque la lista contiene distintos tipos.

B) Imprime los tres elementos.

C) Solo imprime el primer elemento.

D) No se puede utilizar un bucle `for` con `List<*>`.

---

## PARTE 4. REIFIED Y TIPOS GENÉRICOS

**Pregunta 25.** ¿Qué problema resuelve principalmente `reified` en Kotlin?

A) Permite acceder al tipo genérico en tiempo de ejecución dentro de una función inline.

B) Permite crear clases abstractas.

C) Evita tener que declarar parámetros genéricos.

D) Permite heredar de cualquier clase.

---

**Pregunta 26.** ¿En qué tipo de función se puede utilizar un parámetro de tipo `reified`?

A) En cualquier función.

B) En una función `inline`.

C) Exclusivamente en funciones suspendidas.

D) Exclusivamente en constructores.

---

**Pregunta 27.** ¿Cuál de las siguientes declaraciones es correcta?

A)
```kotlin
fun <reified T> isType(value: Any): Boolean = value is T
```

B)
```kotlin
inline fun <reified T> isType(value: Any): Boolean = value is T
```

C)
```kotlin
inline fun <T> isType(value: Any): Boolean = value is T
```

D)
```kotlin
reified inline fun <T> isType(value: Any): Boolean = value is T
```

---

**Pregunta 28.** ¿Qué resultado produce el siguiente código?

```kotlin
inline fun <reified T> isType(value: Any): Boolean {
    return value is T
}

println(isType<String>("Kotlin"))
println(isType<Int>("Kotlin"))
```

A)
```text
false
true
```

B)
```text
true
false
```

C)
```text
true
true
```

D)
```text
false
false
```

---

## PARTE 5. SCOPE FUNCTIONS

**Pregunta 29.** ¿Cuál es la principal finalidad de las *scope functions* de Kotlin?

A) Crear clases genéricas.

B) Ejecutar un bloque de código dentro del contexto de un objeto.

C) Sustituir todas las estructuras de control.

D) Evitar el uso de variables.

---

**Pregunta 30.** ¿Qué devuelve normalmente la función `let`?

A) El propio objeto receptor.

B) El resultado de la última expresión del bloque.

C) Siempre `Unit`.

D) Siempre un valor nullable.

---

**Pregunta 31.** ¿Qué devuelve normalmente la función `apply`?

A) El resultado de la última expresión del bloque.

B) El propio objeto receptor.

C) Siempre `Unit`.

D) Un objeto de tipo `Pair`.

---

**Pregunta 32.** ¿Qué devuelve normalmente la función `also`?

A) El propio objeto receptor.

B) El resultado de la última expresión del bloque.

C) Siempre `Boolean`.

D) Siempre `Unit`.

---

**Pregunta 33.** ¿Qué devuelve normalmente la función `run`?

A) El propio objeto receptor.

B) El resultado de la última expresión del bloque.

C) Siempre `Unit`.

D) Un valor nullable.

---

**Pregunta 34.** ¿Qué devuelve normalmente la función `with`?

A) El propio objeto receptor.

B) El resultado de la última expresión del bloque.

C) Siempre `Unit`.

D) Una lista con los resultados del bloque.

---

**Pregunta 35.** ¿Qué referencia se utiliza normalmente dentro de `let` y `also` para acceder al objeto receptor?

A) `this`

B) `it`

C) `super`

D) `self`

---

**Pregunta 36.** ¿Qué referencia se utiliza normalmente dentro de `run`, `with` y `apply` para acceder al objeto receptor?

A) `it`

B) `this`

C) `self`

D) `super`

---

**Pregunta 37.** ¿Qué imprime el siguiente código?

```kotlin
val result = "Kotlin".let {
    it.uppercase()
}

println(result)
```

A) `Kotlin`

B) `kotlin`

C) `KOTLIN`

D) `Unit`

---

**Pregunta 38.** ¿Qué imprime el siguiente código?

```kotlin
data class User(var name: String, var age: Int)

val user = User("Ana", 20).apply {
    name = "Laura"
    age = 25
}

println(user)
```

A) `User(name=Ana, age=20)`

B) `User(name=Laura, age=25)`

C) `Laura`

D) `Unit`

---

**Pregunta 39.** ¿Qué imprime el siguiente código?

```kotlin
val result = "Hola".also {
    println(it)
}.length

println(result)
```

A)
```text
Hola
4
```

B)
```text
4
Hola
```

C)
```text
Hola
Hola
```

D)
```text
Unit
4
```

**Pregunta 40.** ¿Qué afirmación describe correctamente el uso habitual de las cinco *scope functions*?

A) `let` y `also` utilizan normalmente `it`; `run`, `with` y `apply` utilizan normalmente `this`. `apply` y `also` devuelven el objeto receptor.

B) Todas utilizan `it` y devuelven siempre el objeto receptor.

C) Todas utilizan `this` y devuelven siempre el resultado del bloque.

D) `let` y `run` devuelven siempre el objeto receptor, mientras que `apply` y `also` devuelven el resultado del bloque.

---

# PLANTILLA DE RESPUESTAS

| Pregunta | Respuesta | Pregunta | Respuesta |
|---|---|---|---|
| 1 | | 21 | |
| 2 | | 22 | |
| 3 | | 23 | |
| 4 | | 24 | |
| 5 | | 25 | |
| 6 | | 26 | |
| 7 | | 27 | |
| 8 | | 28 | |
| 9 | | 29 | |
| 10 | | 30 | |
| 11 | | 31 | |
| 12 | | 32 | |
| 13 | | 33 | |
| 14 | | 34 | |
| 15 | | 35 | |
| 16 | | 36 | |
| 17 | | 37 | |
| 18 | | 38 | |
| 19 | | 39 | |
| 20 | | 40 | |

---

# SOLUCIONES PARA EL PROFESOR

| Pregunta | Correcta | Concepto evaluado |
|---|---|---|
| 1 | B | Finalidad de los genéricos |
| 2 | A | Sintaxis de funciones genéricas |
| 3 | C | Inferencia de tipos |
| 4 | B | Parámetros de tipo |
| 5 | A | Instanciación de tipos genéricos |
| 6 | B | Restricciones de tipos |
| 7 | C | Reutilización de funciones genéricas |
| 8 | A | Restricciones múltiples con `where` |
| 9 | B | Covarianza |
| 10 | B | Palabra clave `out` |
| 11 | B | Productores de valores |
| 12 | B | Asignación covariante |
| 13 | B | Contravarianza |
| 14 | B | Palabra clave `in` |
| 15 | A | Asignación contravariante |
| 16 | B | Diferencias entre `in` y `out` |
| 17 | A | Varianza use-site |
| 18 | B | Proyección de salida |
| 19 | A | Proyección de entrada |
| 20 | B | Proyección estrella |
| 21 | B | Lectura de `List<*>` |
| 22 | D | Escritura segura en tipos desconocidos |
| 23 | B | Diferencias entre `List<Any>` y `List<*>` |
| 24 | B | Recorrido de una lista con proyección estrella |
| 25 | A | Reified y borrado de tipos |
| 26 | B | Restricción de `reified` |
| 27 | B | Sintaxis de funciones inline con reified |
| 28 | B | Comprobación de tipos en tiempo de ejecución |
| 29 | B | Finalidad de las scope functions |
| 30 | B | Retorno de `let` |
| 31 | B | Retorno de `apply` |
| 32 | A | Retorno de `also` |
| 33 | B | Retorno de `run` |
| 34 | B | Retorno de `with` |
| 35 | B | Referencia `it` |
| 36 | B | Referencia `this` |
| 37 | C | Uso de `let` |
| 38 | B | Uso de `apply` |
| 39 | A | Uso de `also` |
| 40 | A | Comparación de scope functions |

---

# CRITERIOS DE CORRECCIÓN

- Respuesta correcta: **+0,25 puntos**.
- Respuesta incorrecta: **−0,0625 puntos**.
- Pregunta sin responder: **0 puntos**.

**Puntuación máxima:** 10 puntos.

La nota se obtiene aplicando la siguiente fórmula:

`Nota = (Aciertos × 0,25) − (Errores × 0,0625)`

---

# DISTRIBUCIÓN DE CONTENIDOS

| Bloque | Preguntas | Número |
|---|---:|---:|
| Genéricos: funciones y tipos | 1-8 | 8 |
| Covarianza y contravarianza | 9-16 | 8 |
| Declaraciones use-site y proyección estrella | 17-24 | 8 |
| Reified | 25-28 | 4 |
| Scope functions | 29-40 | 12 |
| **Total** | **1-40** | **40** |