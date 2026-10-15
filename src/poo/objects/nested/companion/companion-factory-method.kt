package poo.objects.nested.companion

/**
 * El objeto companion tiene acceso a todos los miembros privados de la clase contenedora
 * incluido el constructor privado
 * Esto la hace ideal para implementar el patrón de diseño: Metodo factoría
 */

@JvmInline
value class Email(val value: String)

val Email.recipient get() = value.substringBefore('@')


class User {
    val nickname: String

    constructor(email: String) {
        this.nickname = Email(email).recipient
    }

    constructor(id: Int) {
        this.nickname = id.toString()
    }
}

/**
 * Clase UserFM
 * que usa el patron Factory Method para la creación de nuevas instancias de objetos UserFM
 * - El constructor es privado
 */
class UserFM private constructor(val nickname: String) {

    companion object Factory {

        /**
         * Un metodo factoría, se encarga de crear una instancia de un objeto
         * y devolver una referencia a este objeto creado
         *
         * Para crear la instancia deben poder llamar al constructor,
         * que como en este caso es privado, no se puede llamar fuera de la clase
         * pero si por el companion object porque es un objeto anidado dentro de la clase
         * y tiene acceso a los miembros privados
         */

        /**
         * Metodo factoría que crea un usuario a partir de su email
         */
        fun createSubscribingUser(email: String): UserFM {
            return UserFM(Email(email).recipient)
        }

        /**
         * Metodo factoría que crea un usuario a partir de su ID
         */
        fun createSocialUser(accountId: Int) : UserFM {
            return UserFM(accountId.toString())
        }
    }
}


fun main() {

    /* Creación de usuarios mediante el constructor */

    // Crea un usuario a partir de su email
    val user1 = User("perico@palotes.es")
    println(user1.nickname)

    // Crea un usuario a partir de su ID
    val user2 = User(12345)
    println(user2.nickname)


    /* Creación de usuarios mediante el metodo factoría */

    val user3 = UserFM.createSubscribingUser("perico@palotes.com")
    println(user3.nickname)

    val user4 = UserFM.createSocialUser(54321)
    println(user4.nickname)

    //val userFMWrong = UserFM("perico") // ERROR, no se puede llamar al constructor porque es privado
}