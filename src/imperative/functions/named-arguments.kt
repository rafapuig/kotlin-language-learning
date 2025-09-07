package imperative.functions

/**
 * Se puede especificar el nombre del parámetro al especificar su valor argumento en la llamada
 *
 * Si se hace esto se puede pasar los argumentos en cualquier orden al realizar la llamada a la función
 */

fun printPersonInfo(firstName: String, lastName: String) {
    println("Nombre: $firstName Apellidos: $lastName")
}

fun main() {
    printPersonInfo("Rafa", "Puig") // Llamaba basada en el orden de los parámetros de la función (posicionales)
    printPersonInfo(firstName = "Rafa", lastName =  "Puig") // equivalente con argumentos con nombre
    printPersonInfo(lastName = "Puig", firstName = "Rafa") // Podemos especificar los argumentos en el orden que queramos

    // Si mezclamos argumentos posicionales y nombrados
    // Los posicionados deber ir primero
}
