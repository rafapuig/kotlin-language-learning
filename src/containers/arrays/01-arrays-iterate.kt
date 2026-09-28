package containers.arrays

/**
 * Un array en Kotlin es una clase genérica con un parámetro de tipo
 * que corresponde con el tipo de los elementos del array
 */

// Crea un array de elementos de tipo Int (Integer envolvente) inicializados con el valor 0
val integerArray = Array<Int>(5) {0}

// Crea una array de elementos de tipo String inicializados con el texto vacío ""
val stringArray = Array<String>(2) {""}


fun main() {
    val names = arrayOf<String>("Rafael", "Pablo", "Emilio")



    // ToString no imprime el contenido de un Array
    println(names.toString())

    // Para que se impriman los elementos de un array hay que convertir su contenido en un String
    println(names.contentToString())


    /**
     * Iterar sobre los elementos de un array
     */

    for (name in names)
        println(name)

    // Usando la propiedad size para crear un rango desde 0 hasta size-1
    for(i in 0..<names.size) {
        println(names[i])
    }

    // Usando la propiedad de extension lastIndex de la clase Array para iterar con indexación
    for(i in 0..names.lastIndex) {
        println(names[i])
    }

    // Usando la propiedad de extension índices de la clase Array para iterar sobre el rango de indices
    for(i in names.indices) {
        println(names[i])
    }

    names.forEach {
        println(it)
    }

    names.forEachIndexed { index, element ->
        println("index: $index")
        println("element: $element")
        println("names[$index] ${names[index]}")
    }

}