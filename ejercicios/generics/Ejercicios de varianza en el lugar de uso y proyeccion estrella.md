# Ejercicios: use-site variance y star projections en Kotlin

## Objetivos

En estos ejercicios practicarás:

* Covarianza en el lugar de uso mediante `out`.
* Contravarianza en el lugar de uso mediante `in`.
* Diferencias entre declaration-site variance y use-site variance.
* Proyecciones de tipos genéricos.
* Star projections (`*`).
* Restricciones de lectura y escritura producidas por las proyecciones.
* Uso de `List<out T>`, `MutableList<out T>`, `MutableList<in T>`, etc.
* Diseño de funciones genéricas utilizando proyecciones.

---

# 1. Use-site variance con una clase invariante

Partimos de:

```kotlin
open class Animal

class Dog : Animal()

class Cat : Animal()

class Box<T>(
    val value: T
)
```

La clase `Box` es **invariante**.

Intenta:

```kotlin
val dogBox: Box<Dog> = Box(Dog())

val animalBox: Box<Animal> = dogBox
```

### Tarea

Modifica solamente el tipo de la variable `animalBox` para conseguir que la asignación sea válida.

No puedes modificar la declaración de `Box`.

### Preguntas

1. ¿Qué has tenido que escribir?
2. ¿Qué significa `out` en ese lugar?
3. ¿La clase `Box` se ha convertido en covariante?

---

# 2. Leer de una proyección `out`

Utiliza:

```kotlin
class Box<T>(
    val value: T
)
```

Crea:

```kotlin
val dogBox: Box<Dog> = Box(Dog())

val animalBox: Box<out Animal> = dogBox
```

Después intenta:

```kotlin
val animal: Animal = animalBox.value
```

### Tarea

Comprueba que funciona.

Después intenta modificar la clase para que tenga:

```kotlin
fun setValue(value: T)
```

y analiza qué ocurre cuando intentas utilizar ese método a través de:

```kotlin
Box<out Animal>
```

### Objetivo

Comprender que una proyección `out` permite **leer** como `Animal`, pero restringe la escritura de valores.

---

# 3. Use-site covariance frente a declaration-site covariance

Compara:

### Opción A

```kotlin
class Box<out T>(
    val value: T
)
```

### Opción B

```kotlin
class Box<T>(
    val value: T
)
```

utilizando:

```kotlin
Box<out Animal>
```

### Preguntas

1. ¿Qué diferencia existe entre ambas soluciones?
2. ¿En cuál de ellas la covarianza forma parte de la declaración de la clase?
3. ¿En cuál solamente se aplica en una utilización concreta?
4. ¿Qué ventajas tiene poder decidir la varianza en el lugar de uso?

---

# 4. Proyección `out` con una lista mutable

Crea:

```kotlin
val dogs: MutableList<Dog> = mutableListOf()
```

Intenta asignarla a:

```kotlin
val animals: MutableList<out Animal> = dogs
```

Después comprueba estas operaciones:

```kotlin
val animal = animals[0]

animals.add(Dog())
animals.add(Cat())
animals.add(Animal())
```

### Tareas

Indica cuáles de las operaciones son permitidas por el compilador y cuáles no.

### Pregunta

¿Por qué una lista que originalmente permite añadir `Dog` deja de permitir añadir objetos a través de `MutableList<out Animal>`?

---

# 5. Función que recibe una proyección `out`

Crea:

```kotlin
fun printAnimals(animals: MutableList<out Animal>) {
    // ...
}
```

La función debe recorrer la lista y mostrar cada animal.

Comprueba que puede recibir:

```kotlin
MutableList<Dog>
MutableList<Cat>
MutableList<Animal>
```

### Objetivo

Diseñar una función que pueda trabajar con listas mutables de diferentes subtipos sin modificar la declaración de `MutableList`.

---

# 6. Proyección `in`

Partimos de:

```kotlin
class Consumer<T> {
    fun consume(value: T) {
        println(value)
    }
}
```

Crea:

```kotlin
val animalConsumer = Consumer<Animal>()
```

Ahora intenta:

```kotlin
val dogConsumer: Consumer<in Dog> = animalConsumer
```

### Tareas

Comprueba qué operaciones puedes realizar mediante `dogConsumer`.

Por ejemplo:

```kotlin
dogConsumer.consume(Dog())
dogConsumer.consume(Cat())
dogConsumer.consume(Animal())
```

### Pregunta

¿Por qué `Consumer<in Dog>` puede recibir un `Dog`, pero el compilador no puede garantizar que pueda recibir cualquier `Animal`?

---

# 7. Función con parámetro `in`

Crea una función:

```kotlin
fun sendDogs(consumer: Consumer<in Dog>) {
    consumer.consume(Dog())
}
```

Prueba a pasar:

```kotlin
Consumer<Dog>()
Consumer<Animal>()
```

### Tarea

Crea también:

```kotlin
Consumer<Cat>()
```

y comprueba si puede utilizarse.

Explica por qué.

---

# 8. Diferenciar `out` e `in` en el uso

Dadas las siguientes clases:

```kotlin
class Producer<T> {
    fun produce(): T
}

class Consumer<T> {
    fun consume(value: T)
}
```

Completa las declaraciones:

```kotlin
fun useProducer(producer: Producer<_____ Animal>) {
}

fun useConsumer(consumer: Consumer<_____ Dog>) {
}
```

### Objetivo

Determinar qué proyección necesita cada función sin modificar las clases originales.

---

# 9. Proyección `out` y tipos desconocidos

Crea:

```kotlin
fun getAnimal(box: Box<out Animal>): Animal
```

Prueba con:

```kotlin
Box(Dog())
Box(Cat())
Box(Animal())
```

### Preguntas

1. ¿Por qué la función puede devolver `Animal` independientemente del tipo concreto?
2. ¿Qué información se conserva?
3. ¿Qué información se pierde mediante `out`?

---

# 10. Proyección `in` y tipos desconocidos

Crea:

```kotlin
fun sendDog(consumer: Consumer<in Dog>) {
    consumer.consume(Dog())
}
```

Prueba diferentes instancias de `Consumer`.

### Pregunta

En este caso, ¿qué información sobre el tipo concreto del consumidor deja de estar disponible para la función?

Compara la respuesta con el ejercicio anterior.

---

# 11. Primera star projection

Crea:

```kotlin
class Box<T>(
    val value: T
)
```

Después:

```kotlin
val intBox: Box<Int> = Box(10)

val unknownBox: Box<*> = intBox
```

Intenta obtener:

```kotlin
val value = unknownBox.value
```

### Preguntas

1. ¿Qué tipo tiene `value`?
2. ¿Puedes asignarlo directamente a `Int`?
3. ¿Puedes hacer:

```kotlin
unknownBox.value = 20
```

si `Box` fuera mutable?

Explica qué significa `Box<*>`.

---

# 12. Star projection con diferentes tipos

Crea:

```kotlin
val intBox: Box<Int> = Box(10)
val stringBox: Box<String> = Box("Hello")
val dogBox: Box<Dog> = Box(Dog())
```

Guárdalas en variables de tipo:

```kotlin
Box<*>
```

### Tarea

Crea una función:

```kotlin
fun printBox(box: Box<*>) {
    // ...
}
```

que muestre el contenido de cualquier `Box`.

Debe poder recibir las tres cajas.

### Objetivo

Comprender cuándo resulta útil una star projection.

---

# 13. `MutableList<*>`

Crea:

```kotlin
val numbers: MutableList<Int> = mutableListOf(1, 2, 3)

val values: MutableList<*> = numbers
```

Comprueba:

```kotlin
val value = values[0]
```

y después intenta:

```kotlin
values.add(4)
values.add(null)
```

### Preguntas

1. ¿Qué puedes leer?
2. ¿Qué puedes escribir?
3. ¿Por qué `null` tiene un tratamiento diferente?
4. ¿Qué información sobre el tipo de la lista se ha perdido?

---

# 14. `List<*>` frente a `List<Any>`

Compara:

```kotlin
fun printValues(values: List<*>) {
    // ...
}
```

con:

```kotlin
fun printValues(values: List<Any>) {
    // ...
}
```

Comprueba qué ocurre al llamar a ambas funciones con:

```kotlin
List<Int>
List<String>
List<Dog>
```

### Preguntas

1. ¿Cuál de las dos funciones acepta todos esos tipos?
2. ¿Por qué?
3. ¿Es `List<*>` equivalente a `List<Any>`?

---

# 15. Star projection con una clase covariante

Crea:

```kotlin
class Producer<out T>(
    private val value: T
) {
    fun produce(): T = value
}
```

Utiliza:

```kotlin
val producer: Producer<*> = Producer(Dog())
```

Comprueba qué tipo devuelve:

```kotlin
producer.produce()
```

### Pregunta

¿Por qué puedes leer el valor, pero solamente puedes tratarlo como `Any?`?

---

# 16. Star projection con una clase contravariante

Crea:

```kotlin
class Consumer<in T> {
    fun consume(value: T) {
        println(value)
    }
}
```

Utiliza:

```kotlin
val consumer: Consumer<*> = Consumer<Animal>()
```

Intenta:

```kotlin
consumer.consume(Dog())
```

### Pregunta

¿Por qué una star projection no permite simplemente asumir que podemos pasar cualquier objeto?

---

# 17. Comprender `*` mediante equivalencias

Para cada caso, investiga qué significa la star projection:

```kotlin
Producer<*>
Consumer<*>
Box<*>
```

Relaciona cada uno con las siguientes ideas:

```text
Tipo desconocido que se puede producir.
Tipo desconocido que se puede consumir.
Tipo desconocido cuyo uso debe restringirse.
```

### Objetivo

Comprender que `*` no significa simplemente `Any`.

---

# 18. Función genérica frente a star projection

Compara:

```kotlin
fun <T> printBox(box: Box<T>) {
    println(box.value)
}
```

con:

```kotlin
fun printBox(box: Box<*>) {
    println(box.value)
}
```

Prueba ambas funciones con diferentes `Box`.

### Preguntas

1. ¿Qué información conoce la primera función?
2. ¿Qué información conoce la segunda?
3. ¿Cuándo utilizarías una u otra?
4. ¿Es necesario conocer el tipo concreto para simplemente leer el contenido?

---

# 19. ¿`out Any` o `*`?

Compara:

```kotlin
Box<out Any>
```

con:

```kotlin
Box<*>
```

Investiga las diferencias, especialmente en relación con `null`.

Prueba con:

```kotlin
Box(10)
Box("Hello")
Box(null)
```

### Objetivo

Comprender que:

```text
out Any
```

y:

```text
*
```

no representan exactamente lo mismo.

---

# 20. Analizar código

Determina cuáles de estas operaciones son válidas:

```kotlin
val values: MutableList<*> = mutableListOf(1, 2, 3)

val a: Any? = values[0]
```

```kotlin
values.add(4)
```

```kotlin
values.add(null)
```

```kotlin
val numbers: MutableList<out Number> = mutableListOf(1, 2, 3)
```

```kotlin
numbers.add(4)
```

```kotlin
val number: Number = numbers[0]
```

Explica cada respuesta.

---

# 21. Diseñar una función que solo lea

Crea:

```kotlin
fun printAll(values: List<*>) {
    // ...
}
```

La función debe mostrar todos los elementos.

### Restricción

No puedes conocer el tipo concreto de los elementos.

Después crea una versión equivalente utilizando un parámetro genérico:

```kotlin
fun <T> printAll(values: List<T>) {
    // ...
}
```

### Pregunta

¿Cuál es la diferencia conceptual entre ambas soluciones?

---

# 22. Diseñar una función que consuma

Crea:

```kotlin
fun addDogs(
    dogs: MutableList<in Dog>
) {
    dogs.add(Dog())
}
```

Comprueba qué listas pueden pasarse:

```text
MutableList<Dog>
MutableList<Animal>
MutableList<Any>
MutableList<Cat>
```

### Objetivo

Utilizar contravarianza en el lugar de uso para expresar:

> "Necesito una lista en la que pueda introducir `Dog`."

---

# 23. Diseñar una función que produzca

Crea:

```kotlin
fun getAnimals(
    animals: MutableList<out Animal>
): List<Animal>
```

La función debe copiar todos los elementos de `animals` a una nueva lista de `Animal`.

Comprueba que puede recibir:

```text
MutableList<Dog>
MutableList<Cat>
MutableList<Animal>
```

### Pregunta

¿Por qué `MutableList<out Animal>` es apropiado cuando solamente necesitamos leer?

---

# 24. Combinar `in`, `out` y `*`

Crea:

```kotlin
interface Transformer<T, R> {
    fun transform(value: T): R
}
```

No modifiques la declaración de la interfaz.

Diseña una función que reciba un:

```kotlin
Transformer<in Dog, out Animal>
```

y comprueba qué implementaciones pueden utilizarse.

Después crea una función que reciba:

```kotlin
Transformer<*, *>
```

### Preguntas

1. ¿Qué operaciones puedes realizar con el primer tipo?
2. ¿Qué operaciones puedes realizar con el segundo?
3. ¿Qué información pierdes utilizando `*`?
4. ¿Cuándo sería apropiado utilizar cada uno?

---

# 25. Reto final: sistema de procesamiento

Diseña un pequeño sistema compuesto por:

```kotlin
interface Source<T> {
    fun get(): T
}

interface Processor<T, R> {
    fun process(value: T): R
}

interface Sink<T> {
    fun send(value: T)
}
```

No puedes modificar las interfaces.

Crea una función:

```kotlin
fun process(
    source: Source<out Dog>,
    processor: Processor<in Dog, out Animal>,
    sink: Sink<in Animal>
)
```

La función debe:

1. Obtener un `Dog` del `Source`.
2. Pasarlo al `Processor`.
3. Obtener un `Animal`.
4. Enviarlo al `Sink`.

Después crea varias implementaciones y comprueba qué combinaciones son válidas.

---

# 26. Reto final: ¿qué usarías?

Para cada situación decide si utilizarías:

* `T`
* `out T`
* `in T`
* `*`

### Caso A

Una función solamente necesita leer objetos de una colección, pero no le importa su tipo concreto.

### Caso B

Una función necesita recibir una lista de `Dog` y añadir perros a ella.

### Caso C

Una función necesita aceptar una lista de cualquier subtipo de `Animal` y leer los animales.

### Caso D

Una función necesita transformar `Dog` en `Animal`.

### Caso E

Una función recibe un objeto genérico, pero no necesita conocer cuál es su tipo concreto.

### Caso F

Una clase genérica debe poder producir valores de `T` y queremos permitir subtipos mediante la declaración de la clase.

Justifica cada elección.

---

# 27. Reto de análisis: `*` frente a `out` e `in`

Analiza las siguientes declaraciones:

```kotlin
fun f1(values: List<out Number>)
```

```kotlin
fun f2(values: List<*>)
```

```kotlin
fun f3(values: MutableList<in Number>)
```

```kotlin
fun f4(values: MutableList<out Number>)
```

Para cada una responde:

1. ¿Qué tipos de argumentos acepta?
2. ¿Qué puede leer?
3. ¿Qué puede escribir?
4. ¿Qué información sobre el tipo concreto conserva?
5. ¿Para qué tipo de función resulta apropiada?

---

# 28. Reto final de razonamiento

Sin ejecutar el código, determina si cada asignación es válida:

```kotlin
val a: List<out Animal> = listOf(Dog())
```

```kotlin
val b: MutableList<out Animal> = mutableListOf(Dog())
```

```kotlin
val c: MutableList<in Dog> = mutableListOf<Animal>()
```

```kotlin
val d: List<*> = listOf(Dog())
```

```kotlin
val e: MutableList<*> = mutableListOf(Dog())
```

Después analiza qué operaciones serían posibles sobre `a`, `b`, `c`, `d` y `e`.

### Objetivo

Ser capaz de razonar sobre las proyecciones sin necesidad de probar el código en el compilador.

---

# 29. Ejercicio final de diseño

Crea una clase genérica:

```kotlin
class Box<T>
```

sin utilizar `in` ni `out` en su declaración.

Después diseña tres funciones:

```kotlin
fun readBox(...)
fun writeBox(...)
fun copyBox(...)
```

que utilicen **use-site variance** para expresar correctamente sus necesidades.

Las funciones deben representar:

### `readBox`

Solo necesita leer el contenido.

### `writeBox`

Solo necesita escribir objetos de un determinado tipo.

### `copyBox`

Debe copiar elementos desde una caja productora a una caja consumidora.

El objetivo es conseguir un diseño donde las restricciones de tipo estén expresadas **en los parámetros de las funciones**, no en la declaración de `Box`.

---

# 30. Gran reto: copiar entre tipos relacionados

Crea:

```kotlin
class Box<T> {
    // ...
}
```

Implementa:

```kotlin
fun <T> copy(
    source: Box<out T>,
    destination: Box<in T>
)
```

La función debe copiar el contenido de `source` a `destination`.

Después prueba:

```text
Box<Dog> → Box<Animal>
Box<Dog> → Box<Any>
Box<Animal> → Box<Dog>
Box<Cat> → Box<Animal>
```

### Preguntas finales

1. ¿Qué combinaciones son válidas?
2. ¿Por qué `source` utiliza `out`?
3. ¿Por qué `destination` utiliza `in`?
4. ¿Qué papel juega el parámetro genérico `T`?
5. ¿Qué problema resolvería este diseño que no podríamos resolver con `Box<T>` sin proyecciones?

---

# Resumen conceptual

Al terminar los ejercicios deberías poder distinguir:

| Sintaxis            | Idea principal                                             |
| ------------------- | ---------------------------------------------------------- |
| `Box<T>`            | Tipo invariante                                            |
| `Box<out T>`        | Solo necesitamos producir/leer `T`                         |
| `Box<in T>`         | Solo necesitamos consumir/escribir `T`                     |
| `Box<*>`            | No conocemos el tipo concreto                              |
| `fun <T>`           | Conocemos un mismo `T` y podemos relacionar varios valores |
| `List<out T>`       | Proyección covariante en el uso                            |
| `MutableList<in T>` | Proyección contravariante en el uso                        |

La idea fundamental que debes ser capaz de aplicar es:

**`out` → quiero obtener valores como `T`.**

**`in` → quiero proporcionar valores como `T`.**

**`*` → no necesito conocer cuál es el tipo concreto.**
