package poo.construction.constructors.primary

/**
 * El constructor primario
 * se define después del nombre de la clase
 * mediante la palabra constructor y la lista de parámetros
 * (la palabra constructor no es necesaria a no ser que se declare modificadores de acceso o anotaciones)
 *
 * El constructor primario de la clase Circle
 * declara un parámetro de nombre radius de tipo Double
 */
class Circle constructor(radius: Double) {

    /**
     * La propiedad radius, en este codigo, no se inicializa en la declaración
     * se inicializa en el bloque init
     *
     * El bloque init puede hacer uso del valor proporcionado en parámetro radius
     * del constructor primario
     */
    var radius: Double

    /**
     * El bloque de inicialización
     *
     * Tiene acceso a las propiedades declaradas más arriba
     * y a los parámetros declarados en el constructor primario
     */
    init {
        // Si comentamos esta instrucción que inicializa
        // el campo de respaldo de la propiedad
        // se produce un error de compilación en la línea: var radius: Double
        /**
         * Mediante el valor del parámetro radius del constructor primario
         * se inicializa el campo de respaldo
         *
         * si hubiéramos definido un setter para la propiedad
         * lo que se haría es llamar al setter, no inicializar el campo de respaldo
         */
        this.radius = radius
    }

}

fun main() {
    // Para construir un objeto Circle
    // se proporciona un argumento de llamada
    // para el parámetro radius del constructor
    val circle = Circle(4.0)

    println("Circulo de radio ${circle.radius}")
}