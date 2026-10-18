# Soluciones: patrón Decorator y delegación de clases en Kotlin

## Ejercicio 1. Cafetería: añadir ingredientes

```kotlin
interface Beverage {
    fun getDescription(): String
    fun getCost(): Double
}

class Coffee : Beverage {
    override fun getDescription() = "Coffee"

    override fun getCost() = 1.5
}

class MilkDecorator(
    private val beverage: Beverage
) : Beverage by beverage {

    override fun getDescription() =
        "${beverage.getDescription()} + Milk"

    override fun getCost() =
        beverage.getCost() + 0.30
}

class ChocolateDecorator(
    private val beverage: Beverage
) : Beverage by beverage {

    override fun getDescription() =
        "${beverage.getDescription()} + Chocolate"

    override fun getCost() =
        beverage.getCost() + 0.50
}

fun main() {
    val coffee = Coffee()

    val coffeeWithMilk: Beverage =
        MilkDecorator(coffee)

    val coffeeWithMilkAndChocolate: Beverage =
        ChocolateDecorator(coffeeWithMilk)

    println(coffeeWithMilk.getDescription())
    println("Cost: ${coffeeWithMilk.getCost()}")

    println()

    println(coffeeWithMilkAndChocolate.getDescription())
    println("Cost: ${coffeeWithMilkAndChocolate.getCost()}")
}
```

**Salida esperada:**

```text
Coffee + Milk
Cost: 1.8

Coffee + Milk + Chocolate
Cost: 2.3
```

**Explicación:** cada decorador recibe un objeto `Beverage`, implementa la misma interfaz y añade su propio comportamiento. El segundo decorador envuelve al primero, por lo que ambos incrementos se acumulan.

---

## Ejercicio 2. Sistema de notificaciones

```kotlin
interface Notifier {
    fun send(message: String)
}

class EmailNotifier : Notifier {
    override fun send(message: String) {
        println("Sending email: $message")
    }
}

class SmsDecorator(
    private val notifier: Notifier
) : Notifier by notifier {

    override fun send(message: String) {
        notifier.send(message)
        println("Sending SMS: $message")
    }
}

class LoggingDecorator(
    private val notifier: Notifier
) : Notifier by notifier {

    override fun send(message: String) {
        println("[LOG] Preparing notification")
        notifier.send(message)
    }
}

fun main() {
    val emailNotifier = EmailNotifier()

    val smsNotifier: Notifier =
        SmsDecorator(emailNotifier)

    val notifier: Notifier =
        LoggingDecorator(smsNotifier)

    notifier.send("Your order has been shipped")
}
```

**Salida esperada:**

```text
[LOG] Preparing notification
Sending email: Your order has been shipped
Sending SMS: Your order has been shipped
```

**Explicación:** `LoggingDecorator` registra la operación y después delega en el notificador recibido. Como ese notificador es un `SmsDecorator`, la llamada llega al correo y después se envía el SMS.

El orden de anidamiento determina el orden en que se ejecutan las operaciones adicionales.

---

## Ejercicio 3. Tienda online: aplicar descuentos

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

class PercentageDiscountDecorator(
    private val product: Product,
    private val percentage: Double
) : Product by product {

    init {
        require(percentage in 0.0..100.0)
    }

    override fun getPrice(): Double =
        product.getPrice() * (1 - percentage / 100)
}

class FixedDiscountDecorator(
    private val product: Product,
    private val discount: Double
) : Product by product {

    init {
        require(discount >= 0.0)
    }

    override fun getPrice(): Double =
        (product.getPrice() - discount).coerceAtLeast(0.0)
}

fun main() {
    val product: Product =
        BasicProduct("Laptop", 100.0)

    val discountedProduct: Product =
        FixedDiscountDecorator(
            PercentageDiscountDecorator(product, 20.0),
            10.0
        )

    println("Product: ${discountedProduct.getName()}")
    println("Original price: ${product.getPrice()}")
    println("Final price: ${discountedProduct.getPrice()}")
}
```

**Salida esperada:**

```text
Product: Laptop
Original price: 100.0
Final price: 70.0
```

### ¿Qué ocurre si cambiamos el orden?

Con el orden anterior:

1. El descuento del 20 % reduce 100 € a 80 €.
2. El descuento fijo de 10 € reduce 80 € a 70 €.

Si primero aplicamos 10 € y después el 20 %:

```kotlin
val discountedProduct: Product =
    PercentageDiscountDecorator(
        FixedDiscountDecorator(product, 10.0),
        20.0
    )
```

El resultado será 72 €:

1. 100 € − 10 € = 90 €.
2. 90 € − 20 % = 72 €.

Por tanto, **el orden de los decoradores puede modificar el resultado final**.

---

## Ejercicio 4. Personajes de un videojuego

```kotlin
interface Character {
    fun getName(): String
    fun getAttackPower(): Int
}

class Warrior(
    private val name: String
) : Character {

    override fun getName() = name

    override fun getAttackPower() = 10
}

class SwordDecorator(
    private val character: Character
) : Character by character {

    override fun getAttackPower() =
        character.getAttackPower() + 15
}

class MagicRingDecorator(
    private val character: Character
) : Character by character {

    override fun getAttackPower() =
        character.getAttackPower() + 5
}

fun main() {
    val warrior: Character = Warrior("Aragorn")

    val warriorWithSword: Character =
        SwordDecorator(warrior)

    val warriorWithSwordAndRing: Character =
        MagicRingDecorator(warriorWithSword)

    println("Warrior: ${warrior.getName()}")
    println("Attack power: ${warrior.getAttackPower()}")
    println()

    println("Warrior: ${warriorWithSword.getName()}")
    println("Attack power: ${warriorWithSword.getAttackPower()}")
    println()

    println("Warrior: ${warriorWithSwordAndRing.getName()}")
    println("Attack power: ${warriorWithSwordAndRing.getAttackPower()}")
}
```

**Salida esperada:**

```text
Warrior: Aragorn
Attack power: 10

Warrior: Aragorn
Attack power: 25

Warrior: Aragorn
Attack power: 30
```

**Explicación:** no necesitamos crear una clase para cada combinación de equipamiento. Podemos añadir o quitar decoradores y combinarlos en tiempo de ejecución.

---

## Ejercicio 5. Sistema de almacenamiento

En esta solución, los decoradores simulan el cifrado y la compresión mediante mensajes. Los datos se guardan sin transformar, tal como permite el enunciado.

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

class CompressionDecorator(
    private val storage: Storage
) : Storage by storage {

    override fun save(data: String) {
        println("Compressing data")
        storage.save(data)
    }
}

class EncryptionDecorator(
    private val storage: Storage
) : Storage by storage {

    override fun save(data: String) {
        println("Encrypting data")
        storage.save(data)
    }
}

fun main() {
    val storage: Storage =
        EncryptionDecorator(
            CompressionDecorator(
                MemoryStorage()
            )
        )

    storage.save("Important information")

    println("Stored data: ${storage.read()}")
}
```

**Salida esperada:**

```text
Encrypting data
Compressing data
Stored data: Important information
```

**Explicación:**

- `MemoryStorage` se encarga de guardar y recuperar la información.
- `EncryptionDecorator` añade el paso de cifrado simulado.
- `CompressionDecorator` añade el paso de compresión simulado.
- Ambos delegan en el objeto que envuelven.

El método `read()` no está sobrescrito, por lo que se delega automáticamente hasta llegar a `MemoryStorage`.

**Importante:** esta solución no cifra ni comprime realmente los datos; solo simula esas operaciones.

---

## Ejercicio final. Ejemplo de solución: reproductor multimedia

```kotlin
interface MediaPlayer {
    fun play()
    fun getDescription(): String
}

class BasicMediaPlayer(
    private val fileName: String
) : MediaPlayer {

    override fun play() {
        println("Playing $fileName")
    }

    override fun getDescription() = fileName
}

class SubtitlesDecorator(
    private val player: MediaPlayer
) : MediaPlayer by player {

    override fun play() {
        player.play()
        println("Showing subtitles")
    }

    override fun getDescription() =
        "${player.getDescription()} with subtitles"
}

class EqualizerDecorator(
    private val player: MediaPlayer
) : MediaPlayer by player {

    override fun play() {
        println("Applying equalizer")
        player.play()
    }

    override fun getDescription() =
        "${player.getDescription()} with equalizer"
}

fun main() {
    val player: MediaPlayer =
        BasicMediaPlayer("movie.mp4")

    val playerWithSubtitles: MediaPlayer =
        SubtitlesDecorator(player)

    val enhancedPlayer: MediaPlayer =
        EqualizerDecorator(playerWithSubtitles)

    println(enhancedPlayer.getDescription())
    enhancedPlayer.play()
}
```

**Salida esperada:**

```text
movie.mp4 with subtitles with equalizer
Applying equalizer
Playing movie.mp4
Showing subtitles
```

### Análisis de la solución

1. `BasicMediaPlayer` implementa el comportamiento original.
2. `SubtitlesDecorator` añade los subtítulos después de reproducir el archivo.
3. `EqualizerDecorator` añade la ecualización antes de reproducirlo.
4. Ambos decoradores implementan `MediaPlayer` y utilizan `by` para delegar las operaciones que no sobrescriben.

---

## Respuestas a las cuestiones teóricas

### 1. ¿Qué problema resuelve el patrón Decorator?

Permite añadir responsabilidades a un objeto de forma dinámica sin modificar su clase original y sin tener que crear una subclase para cada combinación de funcionalidades.

### 2. ¿Qué ventajas aporta la delegación mediante `by`?

Kotlin genera automáticamente las implementaciones de los métodos delegados al objeto recibido. Así evitamos escribir código repetitivo para todos los métodos que no necesitamos modificar.

### 3. ¿Por qué el decorador implementa la misma interfaz?

Porque así puede utilizarse en cualquier lugar donde se espere el tipo original. Además, permite envolver tanto objetos concretos como otros decoradores.

### 4. ¿Qué diferencia hay entre delegar y sobrescribir?

- **Delegar:** Kotlin reenvía automáticamente la llamada al objeto delegado.
- **Sobrescribir:** la clase proporciona una implementación propia, que puede modificar el comportamiento, añadir operaciones o decidir cuándo delegar.

### 5. ¿Qué ventajas tiene frente a la herencia?

La composición mediante decoradores permite combinar funcionalidades de forma flexible, incluso en tiempo de ejecución, sin crear numerosas subclases para representar cada combinación posible.