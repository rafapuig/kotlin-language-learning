package poo.objects.expression

interface SoundEmitter {
    fun emitSound()
}

/**
 * Un objeto expresión que implementa la interface SoundEmitter
 * La expresión inicializa la variable ambulance, que guardará la referencia al objeto creado
 */
val ambulance = object: SoundEmitter {
    override fun emitSound() {
        println("Ni no ni no ni no ....")
    }
}

/**
 * Se crea un objeto de tipo anónimo,
 * pero como implementa la interfaz SoundEmitter
 * podremos usar la referencia para llamar a los metodos de la interface implementada
 */
val buzzer = object: SoundEmitter {
    override fun emitSound() {
        println("Piiiiiiiii ...")
    }
}

fun main() {
    ambulance.emitSound()
    buzzer.emitSound()

    // Crea un objeto de tipo anonimo implementador de SoundEmitter
    val cat = object: SoundEmitter {
        override fun emitSound() {
            println("Miau!")
        }
    }

    cat.emitSound()

    // Imprimir el nombre de los tipos de los objetos anónimos creados
    println(ambulance.javaClass.name)
    println(buzzer.javaClass.name)
    println(cat.javaClass.name)
}