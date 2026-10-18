# Ejercicios de Kotlin: patrón Decorator y delegación de clases

## Objetivos

- Comprender el patrón de diseño **Decorator**.
- Utilizar interfaces para definir comportamientos comunes.
- Aplicar la delegación de clases de Kotlin mediante `by`.
- Añadir funcionalidades a un objeto sin modificar su clase original.
- Combinar varios decoradores para construir comportamientos dinámicos.

## Ejercicio 1. Cafetería: añadir ingredientes

### Enunciado

Una cafetería dispone de una interfaz `Beverage` que representa una bebida. Todas las bebidas deben proporcionar una descripción y su precio.

Se parte de la siguiente implementación:

```kotlin
interface Beverage {
    fun getDescription(): String
    fun getCost(): Double
}

class Coffee : Beverage {
    override fun getDescription() = "Coffee"

    override fun getCost() = 1.5
}
```

El objetivo es permitir que los clientes añadan ingredientes a su café sin modificar la clase `Coffee`.

### Tareas

1. Crea una clase `MilkDecorator` que reciba una bebida y añada `" + Milk"` a su descripción. El precio adicional será de 0,30 €.
2. Crea una clase `ChocolateDecorator` que añada `" + Chocolate"` a la descripción y 0,50 € al precio.
3. Utiliza la delegación de clases mediante `by` para delegar en la bebida recibida.
4. Crea un café con leche y otro café con leche y chocolate.
5. Muestra por pantalla la descripción y el precio de cada bebida.

### Resultado esperado

```text
Coffee + Milk
Cost: 1.8

Coffee + Milk + Chocolate
Cost: 2.3
```

**Condición:** las clases decoradoras deben implementar `Beverage` y utilizar `by` para delegar el comportamiento que no necesiten modificar.

---

## Ejercicio 2. Sistema de notificaciones

### Enunciado

Una aplicación envía notificaciones a través de una interfaz `Notifier`.

```kotlin
interface Notifier {
    fun send(message: String)
}

class EmailNotifier : Notifier {
    override fun send(message: String) {
        println("Sending email: $message")
    }
}
```

Se desea ampliar el sistema para enviar notificaciones por varios canales sin modificar `EmailNotifier`.

### Tareas

1. Implementa `SmsDecorator`, que delegue en un objeto `Notifier` y, además, muestre un mensaje indicando que se ha enviado un SMS.
2. Implementa `LoggingDecorator`, que muestre un registro antes de enviar la notificación y delegue después la operación.
3. Utiliza `by` en ambas clases.
4. Crea un notificador que envíe un correo y un SMS.
5. Combina los dos decoradores y comprueba el orden en el que se ejecutan las operaciones.

### Ejemplo de salida

```text
[LOG] Preparing notification
Sending email: Your order has been shipped
Sending SMS: Your order has been shipped
```

**Pista:** el decorador SMS tendrá que sobrescribir `send()`, porque debe realizar una operación adicional además de la delegación.

---

## Ejercicio 3. Tienda online: aplicar descuentos

### Enunciado

Una tienda online utiliza la siguiente interfaz para representar productos:

```kotlin
interface Product {
    fun getName(): String
    fun getPrice(): Double
}

class BasicProduct(
    private val name: String,
    private val price: Double
) : Product {
    override fun getName() = name

    override fun getPrice() = price
}
```

La tienda necesita aplicar descuentos sin modificar la clase `BasicProduct`.

### Tareas

1. Crea `PercentageDiscountDecorator`, que aplique un descuento porcentual al precio del producto.
2. Crea `FixedDiscountDecorator`, que reste una cantidad fija al precio.
3. Ambos decoradores deben delegar en el producto original mediante `by`.
4. Comprueba qué ocurre al combinar ambos decoradores.
5. Evita que el precio final sea negativo.
6. Crea un producto de 100 € y aplica un descuento del 20 % y otro descuento fijo de 10 €.

### Resultado esperado

```text
Product: Laptop
Original price: 100.0
Final price: 70.0
```

**Pregunta de reflexión:** ¿el resultado sería el mismo si se aplicaran primero los 10 € de descuento fijo y después el 20 %? Razona tu respuesta.

---

## Ejercicio 4. Personajes de un videojuego

### Enunciado

En un videojuego, todos los personajes implementan la interfaz `Character`.

```kotlin
interface Character {
    fun getName(): String
    fun getAttackPower(): Int
}
```

Existe una clase `Warrior` que representa a un guerrero básico con una fuerza de ataque de 10 puntos.

Se quiere permitir que los personajes equipen objetos que aumenten sus capacidades sin tener que crear una clase distinta para cada combinación de equipamiento.

### Tareas

1. Implementa la clase `Warrior`.
2. Crea `SwordDecorator`, que aumente el ataque en 15 puntos.
3. Crea `MagicRingDecorator`, que aumente el ataque en 5 puntos.
4. Utiliza delegación de clases con `by`.
5. Crea un guerrero básico, uno con espada y otro con espada y anillo mágico.
6. Muestra el nombre y la fuerza de ataque de cada personaje.

### Resultado esperado

```text
Warrior: Aragorn
Attack power: 10

Warrior: Aragorn
Attack power: 25

Warrior: Aragorn
Attack power: 30
```

### Pregunta adicional

¿Por qué resulta más flexible combinar decoradores que crear clases como `WarriorWithSword`, `WarriorWithRing` y `WarriorWithSwordAndRing`?

---

## Ejercicio 5. Sistema de almacenamiento

### Enunciado

Una aplicación guarda información mediante una interfaz `Storage`.

```kotlin
interface Storage {
    fun save(data: String)
    fun read(): String
}

class MemoryStorage : Storage {
    private var content = ""

    override fun save(data: String) {
        content = data
    }

    override fun read() = content
}
```

Se desea incorporar funcionalidades adicionales al almacenamiento sin modificar `MemoryStorage`.

### Tareas

1. Implementa `CompressionDecorator`, que simule la compresión mostrando un mensaje antes de guardar los datos.
2. Implementa `EncryptionDecorator`, que simule el cifrado mostrando un mensaje antes de guardar los datos.
3. Utiliza `by` para delegar las operaciones que no se sobrescriban.
4. Combina los decoradores para que los datos pasen por ambos antes de guardarse.
5. Comprueba que la información se puede recuperar utilizando `read()`.
6. Explica qué responsabilidades corresponden al almacenamiento y cuáles a los decoradores.

**Importante:** la compresión y el cifrado pueden simularse mediante mensajes por consola; no es necesario implementar algoritmos reales.

---

## Ejercicio final. Diseña tu propio decorador

Diseña una pequeña aplicación que utilice el patrón Decorator y la delegación de clases en Kotlin.

Puedes elegir uno de estos contextos:

- Un reproductor multimedia que añade subtítulos y ecualización.
- Un sistema de transporte que añade servicios adicionales a un viaje.
- Un editor de texto que añade resaltado y numeración de líneas.
- Un sistema de impresión que añade color y marcas de agua.

### Requisitos

1. Define una interfaz con al menos dos operaciones.
2. Implementa una clase concreta que represente el comportamiento básico.
3. Crea al menos dos decoradores diferentes.
4. Utiliza `by` en los decoradores.
5. Permite combinar los decoradores en distinto orden.
6. Incluye un programa principal que demuestre el funcionamiento.

### Cuestiones teóricas

Responde a las siguientes preguntas:

1. ¿Qué problema resuelve el patrón Decorator?
2. ¿Qué ventajas aporta la delegación de clases de Kotlin?
3. ¿Por qué un decorador implementa la misma interfaz que el objeto que envuelve?
4. ¿Qué diferencia hay entre delegar una operación y sobrescribirla?
5. ¿Qué ventajas ofrece este diseño frente a la herencia para añadir combinaciones de funcionalidades?