# Ejercicios: clases e interfaces genéricas en Kotlin

## Objetivos

En estos ejercicios practicarás:

* Declaración de clases genéricas.
* Uso de tipos genéricos como propiedades y parámetros.
* Instanciación de clases genéricas con diferentes tipos.
* Clases con uno y varios parámetros de tipo.
* Interfaces genéricas.
* Implementación de interfaces genéricas.
* Métodos genéricos dentro de clases.
* Restricciones sobre tipos genéricos.
* Uso de `where` para establecer restricciones.
* Diseño de clases reutilizables mediante tipos genéricos.

---

# 1. Caja genérica

Crea una clase genérica `Box<T>` que permita almacenar un único objeto.

Debe tener:

* Una propiedad `value` de tipo `T`.
* Un método `getValue()` que devuelva el contenido.
* Un método `setValue()` que permita sustituir el contenido.

Comprueba su funcionamiento almacenando:

* Un `Int`.
* Un `String`.
* Un objeto de una clase creada por ti.

### Ejemplo de uso

```kotlin
val numberBox = Box(25)
val textBox = Box("Hello")
```

---

# 2. Pareja de objetos

Crea una clase genérica `PairBox<T, U>` que permita almacenar dos objetos de tipos diferentes.

Debe disponer de:

* Una propiedad para el primer objeto.
* Una propiedad para el segundo objeto.
* Un método que permita obtener el primer objeto.
* Un método que permita obtener el segundo objeto.

Prueba la clase utilizando combinaciones como:

```text
Int + String
String + Double
Person + Int
```

---

# 3. Contenedor genérico

Crea una clase genérica `Container<T>` que represente un contenedor capaz de almacenar un objeto.

Debe disponer de:

```kotlin
fun contains(value: T): Boolean
```

El método debe indicar si el objeto almacenado coincide con el objeto recibido.

Añade también:

```kotlin
fun replace(value: T)
```

para sustituir el objeto almacenado.

---

# 4. Resultado de una operación

Crea una clase genérica:

```kotlin
Result<T>
```

que pueda representar el resultado de una operación.

Debe almacenar:

* Un valor de tipo `T`.
* Un mensaje de tipo `String`.

Por ejemplo:

```text
Result(25, "Operation completed")
Result("file.txt", "File loaded")
```

Añade métodos para obtener cada uno de los valores.

Después crea varios objetos `Result` utilizando diferentes tipos.

---

# 5. Repositorio genérico

Crea una clase:

```kotlin
Repository<T>
```

que permita almacenar objetos de cualquier tipo.

Debe proporcionar:

```kotlin
fun add(item: T)
fun get(): T?
fun remove(): T?
```

El repositorio solo debe contener un objeto al mismo tiempo.

Prueba el repositorio con:

```kotlin
Repository<Int>
Repository<String>
Repository<Person>
```

---

# 6. Dos tipos relacionados

Crea una clase genérica:

```kotlin
Entry<K, V>
```

que represente una entrada formada por:

* Una clave de tipo `K`.
* Un valor de tipo `V`.

Por ejemplo:

```text
Entry(1, "Rafael")
Entry("username", "rafa")
Entry("age", 49)
```

Añade métodos para consultar y modificar tanto la clave como el valor.

---

# 7. Interfaz almacenable

Crea una interfaz genérica:

```kotlin
interface Storable<T>
```

Debe declarar:

```kotlin
fun store(value: T)
fun retrieve(): T?
```

Crea una clase `MemoryStorage<T>` que implemente la interfaz.

La clase debe almacenar internamente un único objeto.

Prueba la implementación con diferentes tipos.

---

# 8. Interfaz de conversión

Crea una interfaz genérica:

```kotlin
interface Converter<T, R>
```

Debe declarar:

```kotlin
fun convert(value: T): R
```

Crea diferentes implementaciones:

* `StringToIntConverter`
* `IntToStringConverter`
* `DoubleToStringConverter`

Por ejemplo:

```text
"25" → 25
25 → "25"
3.14 → "3.14"
```

---

# 9. Interfaz de comparación

Crea una interfaz genérica:

```kotlin
interface Comparator<T>
```

con un método:

```kotlin
fun compare(first: T, second: T): Int
```

El resultado debe seguir estas reglas:

```text
< 0 → first es menor que second
0   → son equivalentes
> 0 → first es mayor que second
```

Crea implementaciones para:

* `Int`
* `String`
* Una clase `Person` que tenga una edad.

---

# 10. Procesador genérico

Crea una interfaz:

```kotlin
interface Processor<T>
```

con el método:

```kotlin
fun process(value: T)
```

Crea tres implementaciones:

* Un procesador de `String` que muestre el texto.
* Un procesador de `Int` que muestre su cuadrado.
* Un procesador de `Person` que muestre su nombre.

Crea un programa que utilice los tres procesadores.

---

# 11. Clase genérica con método genérico

Crea una clase:

```kotlin
Printer<T>
```

que almacene un objeto de tipo `T`.

Además, debe disponer de un método genérico:

```kotlin
fun <R> printOther(value: R)
```

El método debe poder recibir un objeto de cualquier tipo independientemente del tipo `T` de la clase.

Comprueba que sea posible hacer:

```kotlin
val printer = Printer("Hello")

printer.printOther(25)
printer.printOther(3.14)
printer.printOther(true)
```

---

# 12. Interfaz genérica con dos tipos

Crea una interfaz:

```kotlin
interface Mapper<T, R>
```

con:

```kotlin
fun map(value: T): R
```

Crea una implementación que transforme:

```text
Int → String
```

y otra que transforme:

```text
String → Int
```

Después crea una tercera implementación que transforme:

```text
Person → String
```

La cadena resultante debe contener información relevante de la persona.

---

# 13. Restricción de tipo

Crea una clase genérica:

```kotlin
NumberBox<T>
```

pero establece una restricción para que `T` solamente pueda ser un tipo numérico.

Debe ser posible:

```kotlin
NumberBox(10)
NumberBox(3.14)
```

pero no:

```kotlin
NumberBox("Hello")
```

Investiga qué sintaxis de Kotlin permite establecer esta restricción.

---

# 14. Calculadora genérica

Crea una interfaz:

```kotlin
interface Calculator<T>
```

que permita realizar una operación entre dos objetos de tipo `T`.

Debe declarar:

```kotlin
fun calculate(first: T, second: T): T
```

Crea implementaciones para:

* Sumar `Int`.
* Multiplicar `Int`.
* Concatenar `String`.

Por ejemplo:

```text
SumCalculator.calculate(5, 3) → 8
MultiplyCalculator.calculate(5, 3) → 15
StringConcatCalculator.calculate("Hello ", "World") → "Hello World"
```

---

# 15. Validador genérico

Crea una interfaz:

```kotlin
interface Validator<T>
```

con:

```kotlin
fun isValid(value: T): Boolean
```

Crea diferentes validadores:

* `PositiveIntValidator`
* `NonEmptyStringValidator`
* `AdultPersonValidator`

Para el último caso, crea una clase `Person` con una propiedad `age`.

---

# 16. Contenedor con restricción múltiple

Crea una clase genérica cuyo tipo `T` tenga que cumplir dos condiciones.

Define dos interfaces:

```kotlin
interface Identifiable {
    val id: Int
}

interface Printable {
    fun print()
}
```

Después crea una clase:

```kotlin
Registry<T>
```

que solamente pueda trabajar con tipos que implementen **ambas interfaces**.

El registro debe permitir almacenar objetos de tipo `T`.

Investiga cómo utilizar `where` para expresar esta condición.

---

# 17. Almacén genérico

Diseña una interfaz:

```kotlin
interface Storage<T>
```

con las operaciones:

```kotlin
fun save(value: T)
fun load(): T?
fun clear()
```

Después crea dos implementaciones:

### MemoryStorage

Almacena el objeto en memoria.

### EmptyStorage

No almacena realmente el objeto y siempre devuelve `null` al cargar.

Crea un programa que pueda trabajar con cualquiera de las dos implementaciones.

---

# 18. Sistema genérico de transformación

Crea una interfaz:

```kotlin
interface Transformer<T, R>
```

con:

```kotlin
fun transform(value: T): R
```

Crea un sistema que permita transformar objetos `Person` en diferentes representaciones.

Por ejemplo:

```text
Person → String
Person → Int
Person → Boolean
```

Para cada transformación deberás crear una implementación diferente.

La misma persona debería poder transformarse de diferentes maneras dependiendo del `Transformer` utilizado.

---

# 19. Ejercicio de diseño: sistema de mensajes

Diseña un sistema genérico de mensajes.

Crea:

```kotlin
interface Message<T>
```

que permita obtener el contenido del mensaje:

```kotlin
fun getContent(): T
```

Crea diferentes tipos de mensajes:

* `TextMessage`
* `NumberMessage`
* `PersonMessage`

Todos deberán implementar la misma interfaz genérica.

Después crea una clase:

```kotlin
MessageProcessor<T>
```

que reciba un `Message<T>` y procese su contenido.

---

# 20. Proyecto final: sistema genérico de procesamiento

Diseña un pequeño sistema de procesamiento genérico.

Debe existir una interfaz:

```kotlin
interface Processor<T, R>
```

con:

```kotlin
fun process(value: T): R
```

El sistema debe permitir crear diferentes procesadores.

Implementa como mínimo:

### Person → String

Convierte una persona en una descripción textual.

### String → Int

Devuelve la longitud de una cadena.

### Int → Boolean

Indica si un número es par.

### Double → String

Devuelve el número con un formato determinado.

Después crea una clase genérica:

```kotlin
Pipeline<T, R>
```

que reciba un `Processor<T, R>` y permita ejecutar el procesamiento.

El objetivo es que el mismo `Pipeline` pueda utilizarse con todos los procesadores anteriores.

---

# Reto adicional

Modifica el ejercicio anterior para permitir encadenar dos procesadores.

Por ejemplo:

```text
Person
   ↓
Person → String
   ↓
String → Int
   ↓
Int
```

De esta forma, una persona podría transformarse primero en un `String` y posteriormente ese `String` en un `Int`.

El reto consiste en diseñar las clases e interfaces genéricas necesarias para que el encadenamiento sea posible **sin utilizar casts**.
