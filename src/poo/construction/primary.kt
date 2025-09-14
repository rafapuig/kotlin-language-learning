package poo.construction.primary

/**
 * El constructor primario se define
 * después del nombre de la clase
 *
 * El constructor primario de la clase Circle
 * declara un parámetro radius de tipo Double
 */
class Circle constructor(radius: Double) {

    /**
     * La propiedad radius no se inicializa aquí
     * se inicializa en el bloque init
     * para hacer uso del valor proporcionado en parámetro radius
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
        // se produce un error de compilación en la linea 5
        /**
         * Mediante el valor del parámetro radius
         * se inicializa el campo de respaldo
         *
         * si hubiéramos definido un setter para la propiedad
         * lo que se haría en llamar al setter, no inicializar el campo
         */
        this.radius = radius
    }

}

fun main() {
    // Para instanciar un objeto Circle
    // se proporciona un argumento de llamada
    // para el parámetro radius del constructor
    val circle = Circle(4.0)

    println("Circulo de radio ${circle.radius}")
}