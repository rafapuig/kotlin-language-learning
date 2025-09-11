package poo.contruction

/**
Hay situaciones en las que nos interesa crear una única instancia de la clase y reutilizarla
Los motivos pueden ser diversos.
- Uno de ellos podría ser, que la creación de la instancia es muy costosa en recursos (CPU, IO, etc)
- Otro sería, centralizar toda la responsabilidad de control sobre un objeto dado que representa una entidad única
Para ello, contamos con el patrón de diseño SINGLETON
El singleton se refiere a la ánica instancia existente del objeto
 */
/**
En Kotlin el patron singleton está integrado en el propio lenguaje de programación
Solamente tenemos que utilizar la palabra clave object en lugar de class
 */

/**
 * Los object no pueden declarar constructores con parámetros
 */

object God {

    init {
        println("Acabas de crear a Dios")
    }

    val miracles = listOf(
        "te quiere hacer ganar la Lotería, pero por favor, compra el décimo",
        "te resucita, pero no vuelvas a pillar otra como la de anoche",
        "procede a multiplicar los panes y los peces, si tienes cero de cada, te fastidias",
        "te cura de una enfermedad terminal, no tiene mucha prisa por verte",
        "te convierte el agua en vino… pero no en gasolina",
        "te multiplica los panes y los peces… pero no las vacaciones",
        "te abre el mar en dos… pero no la cola del supermercado",
        "te hace caminar sobre el agua… pero no sobre el piso recién fregado",
        "te resucita de entre los muertos… pero no tu vieja laptop",
        "te sana la ceguera… pero no de las ganas de mirar el móvil cada minuto",
        "te expulsa demonios… pero no los anuncios de YouTube",
        "te calma la tormenta… pero no los grupos de WhatsApp familiares",
        "te multiplica la fe… pero no el saldo en el banco",
        "te sana la ceguera… pero no gafas nuevas cuando se rayan",
        "te abre puertas imposibles… pero no la del WiFi del vecino.",
        "te hace hablar en lenguas… pero no inglés fluido para la entrevista",
        "te devuelve la salud… pero no las ganas de ir al gimnasio",
        "te calma el hambre… pero no la ansiedad de medianoche",
        "te quita las cadenas… pero no la suscripción al gimnasio que no usas",
        "te multiplica la esperanza… pero no los gigas de datos",
        "te saca del desierto… pero no del atasco de tráfico",
        "te ilumina el camino… pero no la pantalla del móvil cuando se apaga",
        "te resucita la fe… pero no el celular cuando se moja"
    )

    fun performMiracle() = println("Dios ${miracles.random()}")
}

fun main() {
    println("Comienzo del programa...")
    God.performMiracle() // La primera petición de milagro crea a Dios
    God.performMiracle()
    God.performMiracle()
    God.performMiracle()

    //val dios = God() // Blasfemia !!! Solo existe un Dios
}