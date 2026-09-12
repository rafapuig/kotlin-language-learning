# Ejercicios de delegación de interfaces con `by`

En Kotlin podemos hacer que una clase delegue la implementación de una interfaz en otro objeto utilizando `by`.

Por ejemplo:

```kotlin
class PrinterController(
    private val printer: Printer
) : Printer by printer
```

La clase `PrinterController` implementa `Printer`, pero no tiene que escribir de nuevo los métodos de la interfaz: los delega al objeto `printer`.

---

## 1. Delegar una interfaz sencilla

Crea la interfaz:

```kotlin
interface Printable {
    fun print()
}
```

Crea una clase `Document` que implemente `Printable`.

El método `print()` debe mostrar el título del documento.

Después crea una clase `Report` que también implemente `Printable`, pero que **delegue la implementación en un objeto `Document`**.

Debe poder utilizarse así:

```kotlin
val report = Report(
    Document("Annual report")
)

report.print()
```

### Restricción

No implementes `print()` manualmente en `Report`.

---

## 2. Delegar varios métodos

Crea:

```kotlin
interface Player {
    fun play()
    fun pause()
    fun stop()
}
```

Implementa la interfaz mediante una clase:

```kotlin
class MusicPlayer : Player
```

Haz que cada método muestre un mensaje diferente.

Después crea:

```kotlin
class CarMusicSystem(
    ...
) : Player by ...
```

`CarMusicSystem` debe delegar todos los métodos en un `MusicPlayer`.

Debe ser posible:

```kotlin
val system = CarMusicSystem(
    MusicPlayer()
)

system.play()
system.pause()
system.stop()
```

### Objetivo

Comprender que una sola declaración `by` puede delegar **todos los métodos de una interfaz**.

---

## 3. Delegar parcialmente una interfaz

Modifica el ejercicio anterior.

`CarMusicSystem` debe:

- delegar `play()` en `MusicPlayer`;
- delegar `stop()` en `MusicPlayer`;
- implementar `pause()` directamente.

Cuando se llame a `pause()`, debe mostrar:

```text
Pausing car music system...
```

### Objetivo

Comprender que la clase delegada proporciona una implementación por defecto, pero la clase que delega puede **sobrescribir determinados métodos**.

---

## 4. Delegar una interfaz de registro

Crea:

```kotlin
interface Logger {
    fun info(message: String)
    fun error(message: String)
}
```

Implementa:

```kotlin
class ConsoleLogger : Logger
```

`ConsoleLogger` debe mostrar:

```text
[INFO] Application started
```

o:

```text
[ERROR] Something went wrong
```

Después crea:

```kotlin
class Application(
    ...
) : Logger by ...
```

La aplicación debe delegar la implementación de `Logger` en `ConsoleLogger`.

Debe poder hacerse:

```kotlin
val app = Application(
    ConsoleLogger()
)

app.info("Application started")
app.error("Something went wrong")
```

---

## 5. Delegar dos interfaces diferentes

Crea las interfaces:

```kotlin
interface Scanner {
    fun scan()
}

interface Printer {
    fun print()
}
```

Crea:

```kotlin
class DocumentScanner : Scanner
class DocumentPrinter : Printer
```

Después crea:

```kotlin
class MultifunctionPrinter(
    ...
) : Scanner by ...,
    Printer by ...
```

`MultifunctionPrinter` debe delegar:

- `Scanner` en `DocumentScanner`.
- `Printer` en `DocumentPrinter`.

Debe ser posible:

```kotlin
val device = MultifunctionPrinter(
    DocumentScanner(),
    DocumentPrinter()
)

device.scan()
device.print()
```

### Objetivo

Practicar la delegación de **varias interfaces mediante `by`**.

---

## 6. Delegación y sustitución de implementaciones

Crea:

```kotlin
interface NotificationService {
    fun send(message: String)
}
```

Implementa dos versiones:

```kotlin
class EmailNotificationService : NotificationService

class SmsNotificationService : NotificationService
```

Cada una debe mostrar un mensaje diferente cuando se llama a `send()`.

Después crea:

```kotlin
class UserAccount(
    ...
) : NotificationService by ...
```

La cuenta de usuario debe poder recibir cualquier implementación de `NotificationService`.

Por ejemplo:

```kotlin
val emailAccount = UserAccount(
    EmailNotificationService()
)

val smsAccount = UserAccount(
    SmsNotificationService()
)
```

Ambos objetos deben poder utilizar:

```kotlin
emailAccount.send("Hello")
smsAccount.send("Hello")
```

### Objetivo

Comprender cómo la delegación permite cambiar fácilmente la implementación utilizada.

---

## 7. Delegación de una interfaz de almacenamiento

Crea:

```kotlin
interface Storage {
    fun save(key: String, value: String)
    fun load(key: String): String?
    fun delete(key: String)
}
```

Implementa:

```kotlin
class MemoryStorage : Storage
```

Utiliza un `MutableMap` para almacenar los datos.

Después crea:

```kotlin
class UserRepository(
    ...
) : Storage by ...
```

`UserRepository` debe delegar las operaciones de `Storage` en `MemoryStorage`.

Debe ser posible:

```kotlin
val repository = UserRepository(
    MemoryStorage()
)

repository.save("name", "Rafael")

println(repository.load("name"))

repository.delete("name")
```

### Pregunta

¿Qué ventaja tiene utilizar composición y delegación en lugar de hacer que `UserRepository` herede de `MemoryStorage`?

---

## 8. Delegación y modificación del comportamiento

Partiendo del ejercicio anterior, modifica `UserRepository`.

Cuando se llame a:

```kotlin
repository.save("name", "Rafael")
```

`UserRepository` debe mostrar antes:

```text
Saving user data...
```

y después delegar realmente la operación `save()` en `MemoryStorage`.

Los métodos `load()` y `delete()` deben continuar delegándose directamente.

### Objetivo

Practicar una situación muy habitual:

- **delegar la mayor parte del comportamiento**;
- **personalizar solamente aquello que necesita un comportamiento diferente**.

---

# Reto final — Centro multimedia

Diseña un pequeño sistema utilizando exclusivamente **delegación de interfaces**.

Crea estas interfaces:

```kotlin
interface Player {
    fun play()
    fun pause()
    fun stop()
}

interface VolumeControl {
    var volume: Int
}

interface Equalizer {
    fun setBass(value: Int)
    fun setTreble(value: Int)
}
```

Crea tres clases:

```kotlin
BasicPlayer
BasicVolumeControl
BasicEqualizer
```

Cada clase debe implementar una de las interfaces anteriores.

Después crea:

```kotlin
class MediaCenter(
    ...
) : Player by ...,
    VolumeControl by ...,
    Equalizer by ...
```

`MediaCenter` debe delegar cada responsabilidad en el objeto correspondiente.

Debe poder utilizarse así:

```kotlin
val mediaCenter = MediaCenter(
    BasicPlayer(),
    BasicVolumeControl(),
    BasicEqualizer()
)

mediaCenter.play()

mediaCenter.volume = 50

mediaCenter.setBass(10)
mediaCenter.setTreble(5)

mediaCenter.stop()
```

### Reto adicional

Haz que `MediaCenter` proporcione su propia implementación de `play()`:

```text
Starting media center...
```

y después delegue la reproducción en `BasicPlayer`.

Los demás métodos deben continuar delegándose directamente.

---

# Progresión

| Ejercicio | Concepto |
|---|---|
| 1 | Delegación básica de una interfaz |
| 2 | Delegación de varios métodos |
| 3 | Delegación parcial |
| 4 | Delegación de una interfaz de servicio |
| 5 | Delegación de varias interfaces |
| 6 | Sustitución de implementaciones |
| 7 | Delegación para composición |
| 8 | Personalizar parte del comportamiento |
| Reto final | Varias interfaces y varias delegaciones |