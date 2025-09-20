package generics

// Interfaz genérica para una notificación
interface Notification<T> {
    fun getContent(): T
    fun display(): String
}

// Notificación obligatoria (no nullable)
class RequiredNotification<T : Any>(private val content: T) : Notification<T> {
    override fun getContent(): T = content
    override fun display(): String = "Required Notification: $content"
}

// Notificación opcional (nullable)
class OptionalNotification<T : Any?>(private val content: T) : Notification<T> {
    override fun getContent(): T = content
    fun isEmpty(): Boolean = content == null
    override fun display(): String =
        if (content == null) "Optional Notification is empty" else "Optional Notification: $content"
}

// Ejemplo de uso
fun main() {
    val notif1: Notification<String> = RequiredNotification("Server is up!")
    val notif2 = OptionalNotification<String?>(null)
    val notif3 = OptionalNotification("You have a new message!")

    val notifications = listOf(notif1, notif2, notif3)

    notifications.forEach { notif ->
        println(notif.display())
        // Si es OptionalNotification, podemos chequear si es vacío
        if (notif is OptionalNotification<*>) {
            println("Is empty? ${notif.isEmpty()}")
        }
        println("---")
    }
}
