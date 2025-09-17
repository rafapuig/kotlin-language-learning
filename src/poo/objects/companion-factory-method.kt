package poo.objects

/**
 * El objeto companion tiene acceso a todos los miembros privados de la clase contenedora
 * incluido el constructor privado
 * Esto la hace ideal para implementar el patron método factoría
 */

class User {
    val nickname: String

    constructor(email: String) {
        this.nickname = email.substringBefore('@')
    }

    constructor(id: Int) {
        this.nickname = id.toString()
    }
}

class UserFM private constructor(val nickname: String) {

    companion object {
        fun newSubscribingUser(email: String): User {
            return User(email.substringBefore('@'))
        }
        fun newSocialUSer(accountId: Int) : User {
            return User(accountId.toString())
        }
    }
}