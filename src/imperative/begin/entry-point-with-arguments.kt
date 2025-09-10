//maina

/**
 * LA función main puede declararse con un parámetro de tipo array de elementos String
 *
 * Este array contiene los valores proporcionados por el usuario mediante la linea de comandos
 * al invocar la ejecución del programa
 */
fun main(args: Array<String>) {
    println(args.contentToString())
}