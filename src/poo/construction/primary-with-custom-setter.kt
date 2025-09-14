package poo.construction.constructor.primary.setter

/**
 * El constructor primario se define
 * después del nombre de la clase
 *
 * El constructor primario de la clase Circle
 * declara un parámetro radius de tipo Double
 */
class Circle constructor(radius: Double) {

    /**
     * El campo de respaldo de la propiedad radius se inicializa aquí
     * no se inicializa en el bloque init
     * En el bloque init si se asigna la propiedad se está haciendo uso del setter
     */
    var radius: Double = radius
        set(value) {
            println("Mutamos el campo de respaldo de la propiedad radius")
            field = value
        }

    /**
     * El bloque de inicialización
     *
     * Tiene acceso a las propiedades declaradas más arriba
     * y a los parámetros declarados en el constructor primario
     */
    init {
        /**
         * Mediante el valor del parámetro radius
         * (en este caso) NO se inicializa el campo de respaldo
         *
         * como hemos definido un setter personalizado para la propiedad
         * se produce una llamada al setter, no la inicialización del campo de respaldo
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