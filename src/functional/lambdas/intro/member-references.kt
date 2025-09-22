package functional.lambdas.memeber.references

data class Person(val name: String, val age: Int)

val getAge = { p: Person -> p.age }

val getAgeFunBB = fun(p: Person): Int { return p.age }

val getAgeFunEB = fun(p: Person) = p.age

val getAgeMR = Person::age

fun greet() { print("Hola!") }

fun sendMail(person: Person, message: String) {}

/**
 * Si una lambda lo único que hace es delegar en función que recibe como argumentos
 * los parámetros declarados en la lambda
 */
val action = { person:Person , message:String ->
    sendMail(person,message)
}

/**
 * Es mejor usar la referencia a la función
 */

val actionMR = ::sendMail

/**
 * Referencia al constructor de una clase
 */
val createPerson = ::Person


/**
 * También podemos tener referencias a funciones de extensión
 */
fun Person.isAdult() = age >= 18

val isPersonAdult =  Person::isAdult

fun main() {
    val person = Person("Raul", 29)
    println(getAge(person))
    println(getAgeFunBB(person))
    println(getAgeFunEB(person))
    println(getAgeMR(person))

    /**
     * Podemos tener una referencia a una función declara a nivel de paquete
     */
    val greetFun = ::greet
    println(greetFun())
    run(greetFun)
    run(::greet)

    val p = createPerson("Perico", 33)
    println(p)

    println(isPersonAdult(p))
}