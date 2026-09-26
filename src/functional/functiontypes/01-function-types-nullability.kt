package functional.functiontypes.nullability


fun nullability() {

    /**
     * Anulabilidad del tipo de retorno en el tipo de función
     */
    // El tipo de datos de la variable es una función que recibe 2 Int y que puede devolver un Int? (un Int o null)
    var canReturnNull: (Int, Int) -> Int? = { x, y -> if (x == y) x else null }
    // canReturnNull = null // error, la variable no puede contener el valor null

    /**
     * Anulabilidad del propio tipo de función
     */
    // La propia variable puede almacenar una función o el valor null (pero la función no devuelve null)
    var funOrNull: ((Int, Int) -> Int)? = null
    // funOrNull = { x, y -> if (x == y) x else null } // error, no podemos asignar una función que puede devolver null

    /**
     * Anulabilidad de ambas
     */
    // Tanto la variable puede valer null cono tener asignada una función que devuelve null
    var funCanReturnNullOrNull: ((Int, Int) -> Int?)? = null
    funCanReturnNullOrNull = {x,y -> if (x > y) x else null }
}


fun main() {
    nullability()
}

