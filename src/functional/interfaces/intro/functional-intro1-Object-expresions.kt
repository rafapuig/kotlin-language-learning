package functional.intro1

interface IntToInt {
    fun apply(number: Int) : Int
}


fun testInToIntInterfaceWithObjectExpresion1() {

    // Mediante un objeto expresión creamos una instancia de un objeto que implementa la interface
    // al mismo tiempo que indicamos la implementación del metodo abstracto de la interface
    val triple: IntToInt = object : IntToInt {
        override fun apply(number: Int): Int {
            return number * 3
        }
    }

    val result = triple.apply(4)
    println(result) // 4 * 3 = 12
}


fun testInToIntInterfaceWithObjectExpresion2() {

    val square: IntToInt = object : IntToInt {
        override fun apply(number: Int): Int {
            return number * number
        }
    }

    val result = square.apply(5)
    println(result)
}


fun main() {
    testInToIntInterfaceWithObjectExpresion1()
    testInToIntInterfaceWithObjectExpresion2()
}

