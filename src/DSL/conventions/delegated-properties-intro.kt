package DSL.conventions

/**
 * Propiedades delegadas
 *
 * Esta característica permite implementar fácilmente propiedades
 * cuya labor vaya más alla de almacenar de guardar valores
 * en campos de respaldo
 * Sin duplicar la lógica en cada accesor
 *
 * Por ejemplo,
 * una propiedad puede almacenar su valor
 * - en una tabla de una base de datos
 * - en una sesión del navegador
 * - en un mapa...
 *
 * La delegación de propiedades se basa en la delegación
 * Un patrón de diseño donde un objeto en lugar de realizar
 * una tarea delega esa tarea a otro objeto ayudante.
 * El objeto ayudante se denomina delegado.
 * Ya lo vimos con la delegación de clase
 *
 * Ahora lo aplicaremos a las propiedades de una clase o interface
 * que delegarán la lógica de sus accesores get y set
 * a un objeto ayudante (el delegado)
 */

/**
 * Sintaxis general de una propiedad delegada
 *
 * var p : Type by Delegate()
 *
 * La propiedad p delega la lógica de sus accesores a otro objeto
 * en este caso una nueva instancia de la clase Delegate
 * La referencia al objeto delegado se obtiene de evaluar
 * la expresión situada a continuación de la palabra clave by
 *
 * Internamente el compilador crea una propiedad privada oculta
 * para referir al delegado
 * private val delegate = Delegate()
 *
 * Y genera unos accesores que delegan en el objeto delegado
 * var p : Type
 *  get() = delegate.getValue(/* ... */)
 *  set(value:Type) = delegate.setValue(/*...*/), value)
 *
 *  Por tanto, por convención la clase Delegate del delegado
 *  - debe tener las funciones operador getValue y setValue
 *  (setValue solamente si la propiedad es mutable, definida como var) *
 *  - adicionalmente, (pero opcional), proporcionar la implementación
 *  de la función operador provideDelegate:
 *      - realizar la lógica de validación
 *      - cambiar la manera en que es instanciado el delegado
 *
 * Nota: Estas tres funciones pueden ser miembros de la clase
 * o también funciones de extension (si la propia clase no las implementa)
 *
 * class Delegate {
 *  operator fun getValue(/*...*/) { /*...*/}
 *  operator fun setValue(/*...*/, value:Type) {/*...*/}
 *  operator fun provideDelegate(/*...*/): Delegate {/*...*/}
 * }
 *
 * class Foo {
 *  var:p Type by Delegate()
 * }
 *
 * fun main() {
 *  val foo = Foo() // Crea la clase con una prop delegada, llamar a provideDelegate
 *  val oldValue = foo.p // llama al getter, que llama a delegate.getValue
 *  foo.p = newValue // llama al setter, que llama delegate.setValue(..., newValue)
 */

