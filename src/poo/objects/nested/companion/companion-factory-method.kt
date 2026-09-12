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

class UserFM private constructor(val nickname: String) {

    companion object Factory {

        fun createSubscribingUser(email: String): UserFM {
            return UserFM(Email(email).recipient)
        }

        fun createSocialUser(accountId: Int) : UserFM {
            return UserFM(accountId.toString())
        }
    }
}


fun main() {

    val user1 = User("perico@palotes.es")
    println(user1.nickname)

    val user2 = User(12345)
    println(user2.nickname)

    val user3 = UserFM.createSubscribingUser("perico@palotes.com")
    println(user3.nickname)

    val user4 = UserFM.createSocialUser(54321)
    println(user4.nickname)

}