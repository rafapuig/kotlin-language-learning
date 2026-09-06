package imperative.functions

/**
 * El uso combinado de parámetros por defecto
 * y llamar a función con argumentos con nombre
 * permite omitir algunos argumentos en mitad de la lista de parámetros
 * y especificar solamente aquellos que necesitamos
 * y hacerlo además en el cualquier orden que queramos
 */

fun calculatePrice(
    basePrice: Double,
    discount: Double = 0.0,   // Discount percentage (0 to 1)
    tax: Double = 0.21        // Default tax: 21%
): Double {
    val priceWithDiscount = basePrice * (1 - discount)
    val finalPrice = priceWithDiscount * (1 + tax)
    return finalPrice
}

fun main() {
    // Si solo proporcionamos el precio (se usa un descuento de 0% y un IVA del 21%)
    val price1 = calculatePrice(100.0)
    println("Final price: $price1") // 121.0

    // Precio con un 10% de descuento (el IVA que se aplicará será el valor por defecto del 21%)
    val price2 = calculatePrice(basePrice = 100.0, discount = 0.10)
    println("Final price: $price2") // 108.9

    // Precio con un 10% de descuento y un IVA reducido del 10%
    val price3 = calculatePrice(basePrice = 100.0, tax = 0.10, discount = 0.10)
    println("Final price: $price3") // 99.0

    // Precio sin descuento pero aplicando un IVA del 23%
    val price4 = calculatePrice(100.0, tax = 0.23)
    println("Final price: $price4") // 123.0
}