# Ejercicios: varianza y contravarianza en Kotlin

## Objetivos

En estos ejercicios practicarás:

* Invariancia de los tipos genéricos.
* Covarianza mediante `out`.
* Contravarianza mediante `in`.
* Diferencia entre producir y consumir valores.
* Asignaciones entre tipos genéricos.
* Uso de `out` en interfaces y clases.
* Uso de `in` en interfaces y clases.
* Restricciones que impone la varianza sobre los métodos.
* Diseño de APIs genéricas.
* Combinación de tipos covariantes y contravariantes.

---

# 1. El problema de la invariancia

Crea dos clases:

```kotlin
open class Animal

class Dog : Animal()

class Cat : Animal()
```

Después crea:

```kotlin
class Box<T>(val value: T)
```

Intenta realizar las siguientes asignaciones:

```kotlin
val dogBox: Box<Dog> = Box(Dog())
val animalBox: Box<Animal> = dogBox
```

### Preguntas

1. ¿Permite Kotlin la segunda asignación?
2. ¿Por qué `Box<Dog>` no es un subtipo de `Box<Animal>`?
3. ¿Qué problema podría producirse si Kotlin permitiera esa asignación?

---

# 2. ¿Qué ocurriría si Box fuera covariante?

Modifica la clase anterior:

```kotlin
class Box<out T>(val value: T)
```

Vuelve a intentar:

```kotlin
val dogBox: Box<Dog> = Box(Dog())
val animalBox: Box<Animal> = dogBox
```

### Preguntas

1. ¿Ahora se permite la asignación?
2. ¿Por qué tiene sentido que `Box<Dog>` pueda utilizarse como `Box<Animal>`?
3. ¿Qué operaciones puede realizar una clase `Box<out T>` con valores de tipo `T`?

---

# 3. Una caja que produce valores

Crea una interfaz:

```kotlin
interface Producer<T> {
    fun produce(): T
}
```

Crea:

```kotlin
class DogProducer : Producer<Dog>
```

que produzca objetos `Dog`.

Comprueba si puedes hacer:

```kotlin
val producer: Producer<Animal> = DogProducer()
```

Si no es posible, modifica la interfaz para que sea covariante.

### Objetivo

Comprender que un objeto que **solo produce** valores de tipo `T` puede ser covariante.

---

# 4. ¿Por qué `out` restringe los métodos?

Modifica la interfaz:

```kotlin
interface Producer<out T> {
    fun produce(): T
}
```

Ahora intenta añadir:

```kotlin
fun consume(value: T)
```

Observa el error del compilador.

### Preguntas

1. ¿Por qué Kotlin no permite utilizar `T` como parámetro de una función?
2. ¿En qué posición aparece `T` en `produce()`?
3. ¿En qué posición aparece en `consume()`?
4. Relaciona esto con los conceptos **producer** y **consumer**.

---

# 5. Producer genérico

Crea una interfaz:

```kotlin
interface Producer<out T> {
    fun produce(): T
}
```

Implementa:

```text
DogProducer
CatProducer
AnimalProducer
```

Después crea una función:

```kotlin
fun printAnimal(producer: Producer<Animal>)
```

Comprueba que puedas pasarle:

```kotlin
DogProducer()
CatProducer()
AnimalProducer()
```

### Objetivo

Practicar la utilización de una interfaz covariante desde el código cliente.

---

# 6. El consumidor

Crea ahora:

```kotlin
interface Consumer<T> {
    fun consume(value: T)
}
```

Implementa:

```kotlin
class AnimalConsumer : Consumer<Animal>
```

Después intenta:

```kotlin
val dogConsumer: Consumer<Dog> = AnimalConsumer()
```

Observa si Kotlin permite la asignación.

---

# 7. Convertir un consumidor en contravariante

Modifica la interfaz anterior:

```kotlin
interface Consumer<in T> {
    fun consume(value: T)
}
```

Vuelve a probar:

```kotlin
val dogConsumer: Consumer<Dog> = AnimalConsumer()
```

### Preguntas

1. ¿Ahora se permite la asignación?
2. ¿Por qué un `Consumer<Animal>` puede utilizarse como `Consumer<Dog>`?
3. ¿Puede un consumidor de `Dog` utilizarse como consumidor de `Animal`?

---

# 8. ¿Por qué `in` restringe las posiciones?

Partiendo de:

```kotlin
interface Consumer<in T> {
    fun consume(value: T)
}
```

intenta añadir:

```kotlin
fun get(): T
```

Observa el error.

### Preguntas

1. ¿Por qué `T` puede aparecer como parámetro?
2. ¿Por qué no puede aparecer como tipo de retorno?
3. Relaciona el comportamiento con el concepto de **consumer**.

---

# 9. Comparar `in` y `out`

Completa las siguientes interfaces indicando si `T` debe ser `in`, `out` o ninguno:

```kotlin
interface Producer<T> {
    fun produce(): T
}
```

```kotlin
interface Consumer<T> {
    fun consume(value: T)
}
```

```kotlin
interface Transformer<T> {
    fun transform(value: T): T
}
```

### Pregunta

¿Por qué `Transformer<T>` no puede declararse simplemente como covariante o contravariante?

---

# 10. Función que recibe un producer

Crea:

```kotlin
fun printAnimals(producer: Producer<Animal>)
```

El método debe llamar varias veces a `produce()` y mostrar el resultado.

Crea productores de:

* `Dog`
* `Cat`
* `Animal`

Haz que todos puedan utilizarse con `printAnimals()`.

### Objetivo

Utilizar covarianza para diseñar una función que acepte productores de diferentes subtipos.

---

# 11. Función que recibe un consumer

Crea:

```kotlin
fun sendDog(consumer: Consumer<Dog>)
```

La función debe crear un `Dog` y enviarlo al consumidor.

Después crea consumidores de:

* `Dog`
* `Animal`

Haz que ambos puedan utilizarse con `sendDog()`.

### Objetivo

Utilizar contravarianza para diseñar una función que acepte consumidores de tipos compatibles.

---

# 12. Sistema de impresión

Crea:

```kotlin
interface Printer<T> {
    fun print(value: T)
}
```

Crea:

```text
AnimalPrinter
DogPrinter
```

Haz que `AnimalPrinter` pueda utilizarse allí donde se espera un:

```kotlin
Printer<Dog>
```

### Pregunta

¿Debería `Printer<T>` ser covariante o contravariante?

Modifica la interfaz para conseguirlo.

---

# 13. Sistema de lectura

Crea:

```kotlin
interface Reader<T> {
    fun read(): T
}
```

Implementa:

```text
DogReader
AnimalReader
```

Haz que un `DogReader` pueda utilizarse donde se espera un:

```kotlin
Reader<Animal>
```

### Pregunta

¿Qué modificación necesita la interfaz?

Explica por qué.

---

# 14. Sistema de transformación

Crea una interfaz:

```kotlin
interface Transformer<T, R> {
    fun transform(value: T): R
}
```

Crea una implementación:

```text
AnimalToStringTransformer
```

que transforme cualquier `Animal` en un `String`.

Investiga qué declaración de varianza permite utilizar este transformer cuando se necesita:

```kotlin
Transformer<Dog, String>
```

### Pista

Uno de los parámetros de tipo es consumido y el otro es producido.

---

# 15. Transformer de animales

Utiliza:

```kotlin
interface Transformer<in T, out R> {
    fun transform(value: T): R
}
```

Crea:

```kotlin
class AnimalToString : Transformer<Animal, String>
```

Comprueba si puedes asignarlo a:

```kotlin
val transformer: Transformer<Dog, Any> = AnimalToString()
```

### Preguntas

Explica por separado por qué:

* `Animal` puede utilizarse como `Dog` en el primer parámetro.
* `String` puede utilizarse como `Any` en el segundo.

---

# 16. Comparador genérico

Crea:

```kotlin
interface Comparator<T> {
    fun compare(first: T, second: T): Int
}
```

Determina qué varianza debería utilizar.

Después implementa:

```text
AnimalComparator
DogComparator
```

Comprueba qué asignaciones son válidas.

### Objetivo

Reconocer que un tipo genérico puede recibir `T` varias veces como entrada y seguir siendo contravariante.

---

# 17. Selector genérico

Crea:

```kotlin
interface Selector<T> {
    fun select(): T
}
```

Implementa:

```text
DogSelector
AnimalSelector
```

Determina qué asignaciones deberían ser válidas.

Modifica la interfaz para conseguir el comportamiento correcto.

---

# 18. Clase genérica mutable

Partimos de:

```kotlin
class MutableBox<T>(
    var value: T
)
```

Intenta convertirla en:

```kotlin
class MutableBox<out T>(
    var value: T
)
```

Observa los errores.

Después intenta:

```kotlin
class MutableBox<in T>(
    var value: T
)
```

### Preguntas

1. ¿Por qué ninguna de las dos soluciones funciona?
2. ¿Qué tiene de especial una propiedad mutable?
3. ¿Por qué una clase que permite tanto leer como escribir `T` no puede ser simplemente covariante o contravariante?

---

# 19. Interfaces separadas

A partir del ejercicio anterior, separa las responsabilidades:

```kotlin
interface Reader<T> {
    fun read(): T
}

interface Writer<T> {
    fun write(value: T)
}
```

Aplica la varianza adecuada a cada interfaz.

Después crea:

```kotlin
class DogStorage
```

que implemente ambas interfaces para `Dog`.

### Objetivo

Comprender cómo separar una interfaz mutable en una interfaz productora y otra consumidora para poder aprovechar la varianza.

---

# 20. Combinar producer y consumer

Crea:

```kotlin
interface Processor<T> {
    fun process(value: T): T
}
```

Analiza si `Processor<T>` puede ser:

```text
covariante
contravariante
invariante
```

Justifica tu respuesta.

Después divide la funcionalidad en dos interfaces:

```kotlin
interface Input<...>
interface Output<...>
```

y aplica la varianza correspondiente.

---

# 21. Analizar asignaciones

Sin ejecutar el código, determina cuáles de estas asignaciones son válidas:

```kotlin
val a: Producer<Animal> = DogProducer()
```

```kotlin
val b: Producer<Dog> = AnimalProducer()
```

```kotlin
val c: Consumer<Dog> = AnimalConsumer()
```

```kotlin
val d: Consumer<Animal> = DogConsumer()
```

Supón que:

```kotlin
interface Producer<out T>
interface Consumer<in T>
```

### Objetivo

Justificar cada respuesta utilizando la relación de subtipo entre:

```text
Dog <: Animal
```

---

# 22. Detectar errores de diseño

Analiza las siguientes interfaces:

```kotlin
interface Producer<out T> {
    fun produce(): T
    fun save(value: T)
}
```

```kotlin
interface Consumer<in T> {
    fun consume(value: T)
    fun current(): T
}
```

Las dos contienen errores relacionados con la varianza.

### Tareas

1. Localiza los errores.
2. Explica por qué se producen.
3. Propón una solución de diseño.
4. Divide las responsabilidades si es necesario.

---

# 23. API genérica de procesamiento

Diseña una API formada por:

```kotlin
interface Source<out T>
```

que produzca elementos, y:

```kotlin
interface Sink<in T>
```

que consuma elementos.

Crea:

```text
DogSource
AnimalSource
DogSink
AnimalSink
```

Después crea una función:

```kotlin
fun connect(
    source: Source<Dog>,
    sink: Sink<Dog>
)
```

Analiza qué combinaciones de `Source` y `Sink` pueden utilizarse.

### Objetivo

Aplicar simultáneamente covarianza y contravarianza.

---

# 24. Reto final: Pipeline genérico

Diseña un pipeline formado por dos interfaces:

```kotlin
interface Producer<out T> {
    fun produce(): T
}

interface Consumer<in T> {
    fun consume(value: T)
}
```

Crea una función:

```kotlin
fun <T> connect(
    producer: Producer<T>,
    consumer: Consumer<T>
)
```

Debe obtener un objeto del productor y enviarlo al consumidor.

Después prueba diferentes combinaciones:

```text
DogProducer + DogConsumer
DogProducer + AnimalConsumer
AnimalProducer + AnimalConsumer
```

Analiza cuáles funcionan y por qué.

---

# 25. Reto final: diseño de una API

Diseña una pequeña API genérica para procesar animales.

Debe incluir:

```kotlin
interface Source<out T>
interface Processor<in T, out R>
interface Sink<in T>
```

El sistema debe permitir construir un flujo:

```text
Source
   ↓
Processor
   ↓
Sink
```

Por ejemplo:

```text
DogSource
   ↓
AnimalToStringProcessor
   ↓
StringSink
```

La API debe aprovechar `in` y `out` para permitir que los componentes trabajen también con tipos relacionados mediante herencia.

### Preguntas finales

1. ¿Por qué `Source` es covariante?
2. ¿Por qué `Sink` es contravariante?
3. ¿Por qué `Processor` necesita ambas variantes?
4. ¿Qué asignaciones adicionales permite la varianza?
5. ¿Qué problemas de seguridad de tipos evita Kotlin al imponer las restricciones de `in` y `out`?
6. ¿Qué diferencia conceptual existe entre:

    * producir un `Dog`
    * consumir un `Dog`
    * transformar un `Dog` en un `Animal`?
