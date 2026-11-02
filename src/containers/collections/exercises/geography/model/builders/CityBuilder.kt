package containers.collections.exercises.geography.model.builders

import containers.collections.exercises.geography.model.City
import containers.collections.exercises.geography.model.Population

class CityBuilder {
    // Recopila el nombre que le queremos poner a la ciudad
    var name: String? = null
    // Recopila valor entero del número de habitantes de la ciudad
    var population: Int? = null

    fun build() = run {

        // Requisito: El nombre no puede ser nulo o en blanco
        // Si no se ha proporcionado un nombre a la ciudad
        // no se crea el objeto City
        // se lanza IllegalArgumentException con el mensaje
        require(!name.isNullOrBlank()) {
            "El nombre de la ciudad po puede ser nulo o vacío"
        }
        // Creamos la instancia de City con los datos name y population
        // recopilados por el CapitalBuilder
        City(
            name = name!!, // Llegados aquí el name seguro que no es nulo (ni blanco)
            // Creamos un objeto Population solamente si population no es nulo
            population = population?.let { Population(it) }
        )
    }
}