# Ejercicios: Interfaces funcionales en Kotlin

## Objetivos

En estos ejercicios practicarás:

* Declaración de interfaces funcionales mediante `fun interface`.
* El método abstracto único de una interfaz funcional.
* Implementación mediante clases.
* Creación de instancias mediante lambdas.
* Uso de interfaces funcionales como parámetros.
* Uso de interfaces funcionales como propiedades.
* Diferencias entre una interfaz funcional y un tipo función.
* Interfaces funcionales con métodos adicionales.
* Interfaces funcionales genéricas.

> **Restricción:** no utilices colecciones (`List`, `Set`, `Map`, etc.). El objetivo es trabajar específicamente con interfaces funcionales.

---

# 1. Primera interfaz funcional

Declara una interfaz funcional llamada `Calculator` que tenga un único método abstracto:

```kotlin
fun calculate(a: Int, b: Int): Int
```

Después:

1. Crea una implementación mediante una clase.
2. Haz que la implementación sume los dos números.
3. Utiliza la instancia para realizar una suma.

El resultado debería ser equivalente a:

```text
10 + 5 = 15
```

---

# 2. Implementar una interfaz funcional con lambda

Utiliza la interfaz `Calculator` del ejercicio anterior.

Crea una instancia utilizando una lambda en lugar de crear una clase:

```kotlin
val calculator = Calculator { a, b ->
    a + b
}
```

Prueba diferentes implementaciones:

* suma;
* resta;
* multiplicación;
* división.

Observa que la lambda proporciona la implementación del único método abstracto de la interfaz.

---

# 3. Calculadora configurable

Crea una función:

```kotlin
fun calculate(
    a: Int,
    b: Int,
    calculator: Calculator
): Int
```

La función debe utilizar el objeto `Calculator` recibido para realizar la operación.

Ejemplo:

```kotlin
val result = calculate(
    10,
    5,
    Calculator { a, b -> a * b }
)

println(result)
```

### Ampliación

Crea funciones independientes:

```kotlin
fun add(a: Int, b: Int): Int
fun subtract(a: Int, b: Int): Int
fun multiply(a: Int, b: Int): Int
```

Investiga si puedes utilizar referencias a estas funciones para crear el `Calculator`.

---

# 4. Validador

Declara:

```kotlin
fun interface Validator {
    fun validate(value: Int): Boolean
}
```

Crea diferentes validadores mediante lambdas:

* números positivos;
* números pares;
* números mayores que 100;
* números comprendidos entre 10 y 20.

Ejemplo:

```kotlin
val positiveValidator = Validator {
    it > 0
}
```

Prueba cada validador con diferentes valores.

---

# 5. Función que recibe un validador

Crea:

```kotlin
fun check(
    value: Int,
    validator: Validator
): Boolean
```

La función debe utilizar el `Validator` recibido.

Debe ser posible escribir:

```kotlin
val result = check(
    20,
    Validator { it % 2 == 0 }
)
```

### Pregunta

¿Por qué es posible pasar una lambda como `Validator`?

Explica qué relación existe entre:

```kotlin
fun interface Validator
```

y:

```kotlin
Validator { it % 2 == 0 }
```

---

# 6. Conversor

Declara:

```kotlin
fun interface Converter<T, R> {
    fun convert(value: T): R
}
```

Crea diferentes conversores:

* `Int` → `String`
* `String` → `Int`
* `Double` → `Int`
* `String` → `String`

Ejemplo:

```kotlin
val converter = Converter<Int, String> {
    "Number: $it"
}
```

Prueba los diferentes conversores.

---

# 7. Procesador

Declara:

```kotlin
fun interface Processor<T> {
    fun process(value: T): T
}
```

Crea procesadores para:

* duplicar un número;
* elevar un número al cuadrado;
* convertir una cadena a mayúsculas;
* eliminar espacios al principio y al final de una cadena.

Ejemplo:

```kotlin
val processor = Processor<Int> {
    it * 2
}
```

---

# 8. Encadenar dos procesadores

Utiliza `Processor<T>` del ejercicio anterior.

Crea una función:

```kotlin
fun <T> process(
    value: T,
    first: Processor<T>,
    second: Processor<T>
): T
```

Debe aplicar primero `first` y después `second`.

Por ejemplo:

```kotlin
val double = Processor<Int> {
    it * 2
}

val increment = Processor<Int> {
    it + 1
}

println(process(5, double, increment))
```

El resultado debe ser:

```text
11
```

---

# 9. Ejecutar una acción

Declara:

```kotlin
fun interface Action {
    fun execute()
}
```

Crea una función:

```kotlin
fun execute(action: Action)
```

que ejecute la acción recibida.

Debe poder utilizarse así:

```kotlin
execute(
    Action {
        println("Hello")
    }
)
```

### Ampliación

Crea diferentes acciones:

```text
Mostrar un mensaje
Mostrar la fecha actual
Mostrar una línea de separación
Mostrar una despedida
```

---

# 10. Acción con parámetro

Modifica la interfaz anterior para que reciba un valor:

```kotlin
fun interface Action<T> {
    fun execute(value: T)
}
```

Crea acciones para:

* imprimir un número;
* imprimir un nombre;
* mostrar si un número es positivo o negativo;
* mostrar la longitud de una cadena.

Ejemplo:

```kotlin
val printNumber = Action<Int> {
    println("Number: $it")
}
```

---

# 11. Comparar con un tipo función

Considera estas dos declaraciones:

```kotlin
fun interface Validator {
    fun validate(value: Int): Boolean
}
```

y:

```kotlin
typealias ValidatorFunction = (Int) -> Boolean
```

Crea una función para cada caso:

```kotlin
fun checkWithInterface(
    value: Int,
    validator: Validator
): Boolean
```

y:

```kotlin
fun checkWithFunction(
    value: Int,
    validator: ValidatorFunction
): Boolean
```

Utiliza ambas con la misma condición:

```kotlin
it > 10
```

### Preguntas

1. ¿Qué tienen en común ambas soluciones?
2. ¿Qué diferencia existe entre `Validator` y `ValidatorFunction`?
3. ¿Cuál de las dos representa un objeto con un tipo propio?
4. ¿Puede `Validator` tener propiedades y métodos adicionales?

---

# 12. Interfaz funcional con métodos adicionales

Declara:

```kotlin
fun interface Formatter {
    fun format(value: String): String

    fun formatUpperCase(value: String): String {
        return format(value).uppercase()
    }
}
```

Crea una instancia mediante lambda.

Después utiliza tanto:

```kotlin
format(...)
```

como:

```kotlin
formatUpperCase(...)
```

### Objetivo

Comprobar que una interfaz funcional puede tener métodos concretos además de su único método abstracto.

---

# 13. Interfaz funcional con propiedades

Crea:

```kotlin
fun interface DiscountCalculator {
    fun calculate(price: Double): Double
}
```

Crea una clase que implemente la interfaz y que tenga una propiedad:

```kotlin
class PercentageDiscount(
    val percentage: Double
) : DiscountCalculator {
    ...
}
```

Haz que calcule el precio después de aplicar el descuento.

Después crea una instancia equivalente utilizando una lambda:

```kotlin
val discount = DiscountCalculator {
    ...
}
```

### Pregunta

¿Qué información puede almacenar la clase `PercentageDiscount` que no está almacenada directamente en la lambda?

---

# 14. Referencias a funciones

Utiliza:

```kotlin
fun interface Converter<T, R> {
    fun convert(value: T): R
}
```

Crea estas funciones:

```kotlin
fun intToText(value: Int): String
fun textLength(value: String): Int
fun square(value: Int): Int
```

Crea `Converter` utilizando referencias:

```kotlin
val converter = Converter(::intToText)
```

Haz lo mismo con las otras funciones.

---

# 15. Filtro sin colecciones

Crea una interfaz funcional:

```kotlin
fun interface Selector<T> {
    fun select(value: T): Boolean
}
```

Crea una función:

```kotlin
fun printIf(
    value: Int,
    selector: Selector<Int>
)
```

La función debe imprimir el valor solamente cuando `selector` devuelva `true`.

Ejemplo:

```kotlin
printIf(20, Selector { it % 2 == 0 })
```

Prueba diferentes selectores.

> No utilices `filter` ni colecciones.

---

# 16. Generador de operaciones

Crea:

```kotlin
fun interface Operation {
    fun execute(a: Double, b: Double): Double
}
```

Después crea una función:

```kotlin
fun createOperation(
    name: String
): Operation
```

Debe devolver una operación dependiendo del nombre recibido:

```text
"add"
"subtract"
"multiply"
"divide"
```

Ejemplo:

```kotlin
val operation = createOperation("multiply")

println(operation.execute(5.0, 4.0))
```

### Ampliación

Haz que la operación `"divide"` controle el caso de división entre cero.

---

# 17. Interfaz funcional genérica con resultado diferente

Crea:

```kotlin
fun interface Mapper<T, R> {
    fun map(value: T): R
}
```

Implementa una función:

```kotlin
fun <T, R> applyMapper(
    value: T,
    mapper: Mapper<T, R>
): R
```

Prueba:

```kotlin
applyMapper(
    25,
    Mapper { "Value: $it" }
)
```

y:

```kotlin
applyMapper(
    "Kotlin",
    Mapper { it.length }
)
```

---

# 18. Sistema de comandos

Crea:

```kotlin
fun interface Command {
    fun execute()
}
```

Crea una función:

```kotlin
fun runCommand(command: Command)
```

Crea varios comandos mediante lambdas:

```text
Mostrar "Starting..."
Mostrar "Processing..."
Mostrar "Finished!"
```

Después crea una clase que implemente `Command` para representar un comando más complejo.

### Objetivo

Comparar:

* implementación mediante lambda;
* implementación mediante una clase.

---

# 19. Estado y comportamiento

Crea:

```kotlin
fun interface Generator {
    fun generate(): Int
}
```

Crea una clase:

```kotlin
class Counter(
    private var value: Int
) : Generator {
    override fun generate(): Int {
        value++
        return value
    }
}
```

Utiliza el objeto:

```kotlin
val generator = Counter(0)

println(generator.generate())
println(generator.generate())
println(generator.generate())
```

Después crea un `Generator` mediante lambda que genere siempre el mismo valor.

### Pregunta

¿Por qué una clase puede mantener un estado interno entre llamadas mientras que una lambda no necesita hacerlo explícitamente?

---

# 20. Reto final: motor de reglas

Diseña un pequeño motor de reglas.

Declara:

```kotlin
fun interface Rule<T> {
    fun matches(value: T): Boolean
}
```

y:

```kotlin
fun interface Handler<T> {
    fun handle(value: T)
}
```

Crea una función:

```kotlin
fun <T> executeRule(
    value: T,
    rule: Rule<T>,
    handler: Handler<T>
)
```

La función debe ejecutar `handler` solamente cuando `rule.matches(value)` sea `true`.

Ejemplo:

```kotlin
executeRule(
    20,
    Rule { it > 10 },
    Handler { println("The number is greater than 10") }
)
```

### Reto adicional

Crea diferentes reglas y handlers para números:

* positivo;
* negativo;
* par;
* impar;
* mayor que 100.

Después crea una clase que implemente `Rule<Int>` en lugar de utilizar una lambda.

---

# 21. Reto final: ¿interfaz funcional o función?

Para cada situación decide si utilizarías:

* un tipo función;
* una interfaz funcional (`fun interface`);
* una clase convencional.

Justifica tu decisión.

### Situaciones

**A.** Una función recibe una operación matemática sencilla.

**B.** Necesitas representar un comportamiento que tenga un nombre propio dentro del dominio de la aplicación.

**C.** Necesitas almacenar estado asociado al comportamiento.

**D.** Necesitas que varias implementaciones compartan métodos concretos.

**E.** Solamente necesitas pasar una pequeña lambda como parámetro.

**F.** Quieres que el comportamiento pueda ser implementado tanto mediante una clase como mediante una lambda.

---

# 22. Ejercicio de análisis

Analiza el siguiente código:

```kotlin
fun interface Validator {
    fun validate(value: Int): Boolean

    fun description(): String {
        return "Validator"
    }
}
```

Y:

```kotlin
val validator = Validator {
    it > 10
}
```

Responde:

1. ¿Cuántos métodos abstractos tiene `Validator`?
2. ¿Por qué puede utilizarse una lambda para crear `validator`?
3. ¿Qué método implementa realmente la lambda?
4. ¿Se puede llamar a `description()` sobre `validator`?
5. ¿Podría añadirse otro método abstracto a `Validator`?
6. ¿Qué ocurriría si se añadiera?

---

# 23. Reto de diseño

Diseña una pequeña API para procesar números.

Debe permitir:

```kotlin
process(
    25,
    ...
)
```

y recibir un objeto que permita:

1. transformar el número;
2. comprobar una condición;
3. producir un mensaje.

Decide qué interfaces funcionales necesitas.

Por ejemplo, podrías necesitar comportamientos equivalentes a:

```text
Transformer
Validator
Formatter
```

No se proporciona la solución: debes decidir las firmas de las interfaces y de la función `process`.

### Requisitos

* Utiliza `fun interface`.
* Permite implementar los comportamientos mediante lambdas.
* No utilices colecciones.
* Intenta que las interfaces sean genéricas cuando tenga sentido.
* Después crea al menos una implementación mediante una clase.
