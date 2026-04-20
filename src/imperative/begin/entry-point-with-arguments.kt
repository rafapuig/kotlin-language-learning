package imperative.begin
//main con argumentos

/**
 * En el IDE IntelliJ IDEA se pueden especificar los argumentos de ejecución
 * del programa editando la running configuration.
 *
 * ![Running Configuration Program Arguments](/assets/runningconf.png)
 */

/**
 * La función main puede declararse con un parámetro de tipo array de elementos String
 *
 * Este array contiene los valores proporcionados por el usuario
 * mediante la línea de comandos
 * al invocar la ejecución del programa
 */
fun main(args: Array<String>) {
    println(args.contentToString())
}