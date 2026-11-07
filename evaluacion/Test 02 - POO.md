# TEST 2 – PROGRAMACIÓN ORIENTADA A OBJETOS EN KOTLIN

**Ciclo:** 2.º de Desarrollo de Aplicaciones Multiplataforma (DAM)  
**Módulo:** Programación  
**Unidad:** Programación orientada a objetos en Kotlin  
**Número de preguntas:** 40  
**Tipo:** Respuesta múltiple (una única respuesta correcta)

**Nombre y apellidos:** __________________________________

**Fecha:** __________________

---

# Preguntas

### Pregunta 1. Propiedades de una clase

Dada la siguiente clase:

```kotlin
class Person {
    var name: String = "Desconocido"
    val age: Int = 18
}
```

¿Cuál de las siguientes afirmaciones es correcta?

A) Ambas propiedades pueden modificarse porque pertenecen a una clase.

B) `name` puede modificarse, pero `age` solamente puede consultarse.

C) `name` solamente puede consultarse, pero `age` puede modificarse.

D) Ninguna de las dos propiedades puede modificarse.

---

### Pregunta 2. Propiedades con getters y setters personalizados

¿Qué sucede al ejecutar el siguiente código?

```kotlin
class Temperature {
    var celsius: Double = 0.0
        set(value) {
            field = value
            println("Temperatura modificada")
        }
}

fun main() {
    val temperature = Temperature()
    temperature.celsius = 25.0
}
```

A) Se produce un error de compilación porque una propiedad no puede tener un setter personalizado.

B) Se imprime `Temperatura modificada`.

C) Se imprime `25.0`.

D) No se ejecuta el setter porque `celsius` tiene un valor inicial.

---

### Pregunta 3. Propiedad calculada

¿Qué característica tiene la siguiente propiedad?

```kotlin
class Rectangle(
    val width: Double,
    val height: Double
) {
    val area: Double
        get() = width * height
}
```

A) Almacena su valor en memoria y solamente se calcula una vez.

B) Es una propiedad de solo lectura cuyo valor se calcula cuando se consulta.

C) No es una propiedad válida porque no tiene inicializador.

D) Solamente puede consultarse desde el constructor.

---

### Pregunta 4. Constructores primarios

¿Qué afirmación describe correctamente el siguiente código?

```kotlin
class Person(
    val name: String,
    var age: Int
)
```

A) Declara una clase con dos constructores secundarios.

B) Declara un constructor primario que inicializa dos propiedades.

C) Declara dos parámetros locales que no pueden utilizarse después de construir el objeto.

D) Es incorrecto porque todas las propiedades deben declararse dentro de un bloque `init`.

---

### Pregunta 5. Constructores secundarios

¿Qué requisito debe cumplir un constructor secundario cuando una clase tiene un constructor primario?

A) Debe utilizar obligatoriamente `super()`.

B) Debe delegar directa o indirectamente en el constructor primario mediante `this(...)`.

C) No puede recibir parámetros.

D) Debe tener exactamente los mismos parámetros que el constructor primario.

---

### Pregunta 6. Bloques init

¿Qué se imprime al ejecutar el siguiente código?

```kotlin
class User(val name: String) {
    init {
        println("Inicializando usuario")
    }

    init {
        println("Usuario creado: $name")
    }
}

fun main() {
    User("Ana")
}
```

A) Solamente `Usuario creado: Ana`.

B) Solamente `Inicializando usuario`.

C) Primero `Inicializando usuario` y después `Usuario creado: Ana`.

D) Primero `Usuario creado: Ana` y después `Inicializando usuario`.

---

### Pregunta 7. Data classes

¿Cuál de las siguientes declaraciones es válida para definir una `data class`?

A)

```kotlin
data class Person {
    val name: String
}
```

B)

```kotlin
data class Person(name: String)
```

C)

```kotlin
data class Person(val name: String)
```

D)

```kotlin
data class Person() {
    val name: String
}
```

---

### Pregunta 8. Método toString de una data class

¿Qué resultado produce el siguiente código?

```kotlin
data class Product(
    val name: String,
    val price: Double
)

fun main() {
    val product = Product("Teclado", 49.99)
    println(product)
}
```

A) Imprime la dirección de memoria del objeto.

B) Imprime `Product(name=Teclado, price=49.99)`.

C) Imprime únicamente `Teclado`.

D) Se produce un error porque no se ha sobrescrito `toString()`.

---

### Pregunta 9. Método copy de una data class

¿Qué valor contiene `second.age` después de ejecutar el siguiente código?

```kotlin
data class Person(
    val name: String,
    val age: Int
)

fun main() {
    val first = Person("Ana", 20)
    val second = first.copy(age = 25)

    println(second.age)
}
```

A) 20.

B) 25.

C) 0.

D) Se produce un error porque `copy()` no permite modificar argumentos.

---

### Pregunta 10. Copia de objetos mediante copy()

¿Qué tipo de copia realiza el método `copy()` generado para una `data class`?

A) Una copia profunda de todos los objetos relacionados.

B) Una copia superficial, en la que las referencias a otros objetos se comparten.

C) Una copia que modifica también el objeto original.

D) Una copia que solamente funciona con propiedades primitivas.

---

### Pregunta 11. Desestructuración de data classes

¿Qué valores se muestran por consola?

```kotlin
data class Point(
    val x: Int,
    val y: Int
)

fun main() {
    val point = Point(10, 20)
    val (a, b) = point

    println("$a $b")
}
```

A) `20 10`.

B) `10 20`.

C) `Point(10, 20)`.

D) Se produce un error porque Kotlin no permite desestructurar objetos.

---

### Pregunta 12. Funciones componentN()

¿Qué relación existe entre las funciones `component1()`, `component2()`, etc., y la desestructuración de una `data class`?

A) Son funciones que se generan automáticamente y permiten obtener los valores de las propiedades declaradas en el constructor primario, en su orden de declaración.

B) Son funciones que se generan exclusivamente para comparar objetos.

C) Son funciones que permiten modificar las propiedades de una clase.

D) Solamente existen cuando la clase implementa una interfaz.

---

### Pregunta 13. Interfaces

¿Cuál de las siguientes afirmaciones sobre las interfaces de Kotlin es correcta?

A) Una clase solamente puede implementar una interfaz.

B) Una interfaz puede declarar funciones con implementación por defecto.

C) Una interfaz siempre debe tener un constructor primario.

D) Una interfaz no puede declarar propiedades.

---

### Pregunta 14. Propiedades en interfaces

¿Qué afirmación es correcta sobre las propiedades declaradas en una interfaz Kotlin?

A) Todas las propiedades deben tener un valor inicial.

B) Una interfaz puede declarar propiedades abstractas y propiedades con getter implementado, pero no almacenar estado mediante un campo de respaldo propio.

C) Las propiedades de una interfaz siempre son `private`.

D) Una interfaz solamente puede declarar propiedades de tipo `val`.

---

### Pregunta 15. Herencia en Kotlin

Dada la siguiente declaración:

```kotlin
class Animal

class Dog : Animal()
```

¿Qué sucede?

A) El código es correcto porque todas las clases de Kotlin permiten herencia.

B) Se produce un error porque las clases son finales por defecto.

C) Se produce un error porque una clase no puede heredar de otra clase.

D) El código es correcto solamente si `Dog` es una `data class`.

---

### Pregunta 16. Modificador open

¿Qué modificación permite que una clase pueda ser heredada?

A) Declararla como `public`.

B) Declararla como `open`.

C) Declararla como `internal`.

D) Declararla como `final`.

---

### Pregunta 17. Sobrescritura de métodos

¿Qué sucede al ejecutar el siguiente código?

```kotlin
open class Animal {
    open fun makeSound() {
        println("Sonido de animal")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        println("Guau")
    }
}

fun main() {
    val animal: Animal = Dog()
    animal.makeSound()
}
```

A) Se imprime `Sonido de animal`.

B) Se imprime `Guau`.

C) Se produce un error porque el tipo declarado de la variable es `Animal`.

D) No se imprime nada.

---

### Pregunta 18. Herencia y constructores

¿Qué función cumple la expresión `: Animal(name)` en la siguiente declaración?

```kotlin
open class Animal(val name: String)

class Dog(name: String) : Animal(name)
```

A) Invoca el constructor de la clase derivada.

B) Invoca el constructor de la clase base, pasando el argumento `name`.

C) Declara una propiedad privada llamada `Animal`.

D) Implementa una interfaz denominada `Animal`.

---

### Pregunta 19. Clases abstractas

¿Cuál de las siguientes afirmaciones es correcta?

A) Una clase abstracta puede instanciarse directamente.

B) Una clase abstracta puede declarar funciones abstractas que las clases derivadas deben implementar.

C) Una clase abstracta no puede tener propiedades.

D) Una clase abstracta no puede tener constructores.

---

### Pregunta 20. Delegación de clases mediante by

¿Qué permite realizar la delegación de clases mediante `by`?

A) Delegar automáticamente la creación de objetos al compilador.

B) Delegar la implementación de una interfaz en otro objeto.

C) Heredar de varias clases al mismo tiempo.

D) Convertir una clase en un singleton.

---

### Pregunta 21. Delegación de interfaces

¿Qué imprime el siguiente código?

```kotlin
interface Printer {
    fun print()
}

class ConsolePrinter : Printer {
    override fun print() {
        println("Imprimiendo...")
    }
}

class DocumentPrinter(
    private val printer: Printer
) : Printer by printer

fun main() {
    val printer = DocumentPrinter(ConsolePrinter())
    printer.print()
}
```

A) Se produce un error porque `DocumentPrinter` no implementa `print()`.

B) Se imprime `Imprimiendo...`.

C) No se imprime nada.

D) Se produce una excepción porque `by` necesita una clase abstracta.

---

### Pregunta 22. Delegación y comportamiento adicional

¿Qué afirmación es correcta sobre la delegación de interfaces mediante `by`?

A) No permite sobrescribir los métodos delegados.

B) Permite sobrescribir determinados métodos y proporcionar una implementación propia, manteniendo la delegación de los demás.

C) Obliga a implementar manualmente todos los métodos de la interfaz.

D) Solamente funciona con interfaces que no tienen métodos.

---

### Pregunta 23. Objetos singleton

¿Qué característica tiene una declaración `object` como la siguiente?

```kotlin
object Database {
    fun connect() {
        println("Conectando...")
    }
}
```

A) Cada vez que se utiliza `Database` se crea un objeto diferente.

B) Define un único objeto que puede utilizarse directamente mediante su nombre.

C) Define una clase que necesita ser instanciada mediante `Database()`.

D) Define una interfaz con métodos estáticos.

---

### Pregunta 24. Inicialización de objetos singleton

¿Qué sucede con el siguiente código?

```kotlin
object Counter {
    var value = 0

    init {
        println("Counter inicializado")
    }
}

fun main() {
    println(Counter.value)
    println(Counter.value)
}
```

A) Se imprime dos veces `Counter inicializado`.

B) Se imprime una vez `Counter inicializado` y después dos veces `0`.

C) Se produce un error porque un objeto singleton no puede tener propiedades.

D) Se imprime únicamente `0`.

---

### Pregunta 25. Expresiones object

¿Qué permite hacer una expresión `object`?

A) Crear una clase abstracta.

B) Crear un objeto anónimo que puede implementar interfaces o heredar de clases.

C) Declarar una constante de compilación.

D) Crear automáticamente un singleton global con nombre obligatorio.

---

### Pregunta 26. Expresiones object e interfaces

¿Qué imprime el siguiente código?

```kotlin
interface Greeting {
    fun sayHello()
}

fun main() {
    val greeting = object : Greeting {
        override fun sayHello() {
            println("Hola")
        }
    }

    greeting.sayHello()
}
```

A) `Hola`.

B) `Greeting`.

C) Se produce un error porque no se puede instanciar una interfaz.

D) No se imprime nada.

---

### Pregunta 27. Enumeraciones

¿Cuál es la forma correcta de declarar una enumeración con tres valores?

A)

```kotlin
enum Color {
    RED, GREEN, BLUE
}
```

B)

```kotlin
enum class Color {
    RED, GREEN, BLUE
}
```

C)

```kotlin
class enum Color {
    RED, GREEN, BLUE
}
```

D)

```kotlin
sealed enum Color {
    RED, GREEN, BLUE
}
```

---

### Pregunta 28. Enumeraciones con propiedades

¿Qué imprime el siguiente código?

```kotlin
enum class Direction(val angle: Int) {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270)
}

fun main() {
    println(Direction.WEST.angle)
}
```

A) `WEST`.

B) `270`.

C) `90`.

D) Se produce un error porque los enums no pueden tener constructores.

---

### Pregunta 29. Herencia por composición

¿Cuál de las siguientes afirmaciones describe mejor la composición?

A) Consiste en crear una clase que hereda de varias clases base.

B) Consiste en construir una clase utilizando objetos de otras clases como parte de su implementación.

C) Consiste en declarar todas las propiedades como `open`.

D) Consiste en sustituir todas las clases por interfaces.

---

### Pregunta 30. Composición frente a herencia

Dado el siguiente código:

```kotlin
class Engine {
    fun start() {
        println("Motor arrancado")
    }
}

class Car(
    private val engine: Engine
) {
    fun start() {
        engine.start()
    }
}
```

¿Qué relación existe entre `Car` y `Engine`?

A) `Car` hereda de `Engine`.

B) `Engine` hereda de `Car`.

C) `Car` utiliza un objeto `Engine` mediante composición.

D) `Car` implementa la interfaz `Engine`.

---

### Pregunta 31. Value classes

¿Cuál es la declaración correcta de una `value class` en Kotlin?

A)

```kotlin
value class UserId {
    val value: Int
}
```

B)

```kotlin
@JvmInline
value class UserId(val value: Int)
```

C)

```kotlin
data value class UserId(val value: Int)
```

D)

```kotlin
inline class UserId {
    var value: Int
}
```

---

### Pregunta 32. Características de las value classes

¿Cuál de las siguientes afirmaciones describe correctamente una `value class`?

A) Siempre se representa en memoria como un objeto independiente.

B) Permite crear un tipo específico a partir de una propiedad subyacente, pudiendo evitar algunas asignaciones de objetos mediante optimizaciones del compilador.

C) Puede declarar cualquier número de propiedades en su constructor primario.

D) No puede utilizarse como tipo de parámetro de una función.

---

### Pregunta 33. Clases selladas

¿Qué característica principal tiene una `sealed class`?

A) No puede tener subclases.

B) Restringe las clases que pueden heredar directamente de ella, permitiendo conocer el conjunto de subtipos directos.

C) Todas sus propiedades son automáticamente privadas.

D) Solamente puede utilizarse para representar enumeraciones.

---

### Pregunta 34. Clases selladas y when

¿Qué afirmación es correcta sobre el siguiente código?

```kotlin
sealed class Result

class Success : Result()
class Error : Result()

fun process(result: Result) {
    when (result) {
        is Success -> println("Correcto")
        is Error -> println("Error")
    }
}
```

A) Es obligatorio añadir `else` porque `when` siempre necesita una rama por defecto.

B) El compilador puede comprobar que se contemplan todos los subtipos directos conocidos de `Result`, por lo que no es necesario `else`.

C) Se produce un error porque `when` no admite comprobaciones con `is`.

D) Una clase sellada no puede utilizarse como tipo de parámetro.

---

### Pregunta 35. Interfaces selladas

¿Qué afirmación describe correctamente una `sealed interface`?

A) Es una interfaz que no puede ser implementada por ninguna clase.

B) Es una interfaz que restringe sus implementaciones directas y permite que el compilador conozca sus posibles subtipos directos.

C) Es una interfaz que solamente puede contener propiedades.

D) Es equivalente a una interfaz normal, sin ninguna restricción adicional.

---

### Pregunta 36. Clases anidadas e internas

Dada la siguiente declaración:

```kotlin
class Outer {
    private val message = "Hola"

    class Nested {
        fun show() {
            // ¿Puede acceder directamente a message?
        }
    }
}
```

¿Qué afirmación es correcta?

A) Sí, porque todas las clases anidadas tienen acceso automático a las propiedades de la clase externa.

B) No, porque una clase anidada normal no mantiene una referencia a una instancia de la clase externa.

C) Sí, pero solamente si `message` es una propiedad `val`.

D) No, porque Kotlin no permite declarar clases dentro de otras clases.

---

### Pregunta 37. Clases inner

¿Qué diferencia existe entre una clase anidada normal y una clase declarada con `inner`?

A) Una clase `inner` puede acceder a los miembros de una instancia de la clase externa porque mantiene una referencia a ella.

B) Una clase `inner` no puede tener constructores.

C) Una clase `inner` es automáticamente un singleton.

D) Una clase `inner` no puede declarar funciones.

---

### Pregunta 38. Companion objects

¿Qué afirmación es correcta sobre un `companion object`?

A) Es un objeto asociado a la clase que permite definir miembros accesibles utilizando el nombre de la clase.

B) Es una clase que debe instanciarse siempre mediante un constructor secundario.

C) Permite declarar únicamente constantes de compilación.

D) Es exactamente lo mismo que una clase `inner`.

---

### Pregunta 39. Métodos factoría

¿Qué caracteriza a un método factoría?

A) Es un método que siempre devuelve un valor de tipo `Unit`.

B) Es un método que permite crear y devolver objetos, pudiendo ocultar o controlar los detalles de su construcción.

C) Es un constructor que debe llamarse obligatoriamente `factory`.

D) Es un método que solamente puede declararse dentro de una interfaz.

---

### Pregunta 40. Métodos factoría y companion objects

¿Qué imprime el siguiente código?

```kotlin
class User private constructor(
    val name: String
) {
    companion object {
        fun create(name: String): User {
            return User(name)
        }
    }
}

fun main() {
    val user = User.create("Ana")
    println(user.name)
}
```

A) Se produce un error porque el constructor es privado y no puede utilizarse desde ningún lugar.

B) Se imprime `Ana`.

C) Se imprime `User`.

D) Se produce un error porque los companion objects no pueden declarar funciones.

---

# Plantilla de respuestas

| Pregunta | Respuesta | Pregunta | Respuesta |
|:---:|:---:|:---:|:---:|
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

# SOLUCIONARIO PARA EL PROFESOR

**Este apartado no debe incluirse en la copia que se entregue al alumnado.**

| Pregunta | Respuesta correcta | Concepto evaluado |
|:---:|:---:|---|
| 1 | B | Propiedades `val` y `var` |
| 2 | B | Setters personalizados |
| 3 | B | Propiedades calculadas |
| 4 | B | Constructor primario |
| 5 | B | Constructores secundarios |
| 6 | C | Bloques `init` |
| 7 | C | Declaración de data classes |
| 8 | B | Método `toString()` |
| 9 | B | Método `copy()` |
| 10 | B | Copia superficial |
| 11 | B | Desestructuración |
| 12 | A | Funciones `componentN()` |
| 13 | B | Interfaces |
| 14 | B | Propiedades en interfaces |
| 15 | B | Herencia y clases finales |
| 16 | B | Modificador `open` |
| 17 | B | Sobrescritura de métodos |
| 18 | B | Invocación del constructor de la clase base |
| 19 | B | Clases abstractas |
| 20 | B | Delegación de clases |
| 21 | B | Delegación mediante `by` |
| 22 | B | Sobrescritura de métodos delegados |
| 23 | B | Objetos singleton |
| 24 | B | Inicialización de objetos |
| 25 | B | Expresiones `object` |
| 26 | A | Objetos anónimos e interfaces |
| 27 | B | Enumeraciones |
| 28 | B | Propiedades en enums |
| 29 | B | Composición |
| 30 | C | Relación entre objetos |
| 31 | B | Declaración de value classes |
| 32 | B | Características de value classes |
| 33 | B | Clases selladas |
| 34 | B | Exhaustividad de `when` |
| 35 | B | Interfaces selladas |
| 36 | B | Clases anidadas |
| 37 | A | Clases `inner` |
| 38 | A | Companion objects |
| 39 | B | Patrón Factory |
| 40 | B | Métodos factoría y companion objects |

---

## Criterios de corrección

Se propone la siguiente puntuación:

- Respuesta correcta: **+0,25 puntos**.
- Respuesta incorrecta: **−0,0625 puntos**.
- Pregunta sin responder: **0 puntos**.

La puntuación máxima del test es de **10 puntos**.

La fórmula de cálculo sería:

`Nota = (Aciertos × 0,25) − (Errores × 0,0625)`

Donde:

- Aciertos: número de respuestas correctas.
- Errores: número de respuestas incorrectas.
- Las preguntas sin responder no suman ni restan.

---

## Distribución de contenidos evaluados

| Bloque | Preguntas | Número |
|---|---|:---:|
| Propiedades y constructores | 1-6 | 6 |
| Data classes | 7-12 | 6 |
| Interfaces | 13-14 | 2 |
| Herencia y clases abstractas | 15-19 | 5 |
| Delegación mediante `by` | 20-22 | 3 |
| Objetos singleton y expresiones object | 23-26 | 4 |
| Enumeraciones | 27-28 | 2 |
| Composición | 29-30 | 2 |
| Value classes | 31-32 | 2 |
| Clases e interfaces selladas | 33-35 | 3 |
| Clases anidadas e inner | 36-37 | 2 |
| Companion objects y métodos factoría | 38-40 | 3 |
| **Total** | | **40** |

---

## Observaciones didácticas

Este segundo test pretende comprobar que el alumnado comprende los mecanismos fundamentales de la programación orientada a objetos en Kotlin, prestando especial atención a las características propias del lenguaje.

Se evalúan cuatro niveles de conocimiento:

1. **Conocimiento conceptual:** comprender las características de las clases, objetos, interfaces y mecanismos de reutilización.
2. **Conocimiento sintáctico:** identificar declaraciones correctas de clases, constructores, propiedades y objetos.
3. **Comprensión del código:** interpretar fragmentos de Kotlin y anticipar su comportamiento.
4. **Razonamiento:** distinguir mecanismos similares, como herencia y composición, clases anidadas e internas, o declaraciones `object` y expresiones `object`.

Se ha dado especial importancia a las características específicas de Kotlin, como la delegación mediante `by`, las `data class`, las `value class`, las clases selladas y los `companion object`.