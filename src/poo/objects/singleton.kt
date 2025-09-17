package poo.objects

/**
 * Los objetos singleton pueden contener declaraciones de propiedades, métodos, bloques de inicialización,etc
 * Los que NO pueden tener son constructores (primario o secundario)
 */

object Logger {
    fun log(message: String) {
        println("Log: $message")
    }
}

fun main() {
    Logger.log("Iniciando la aplicación...")
    Logger.log("Aplicación inicializada correctamente")
}