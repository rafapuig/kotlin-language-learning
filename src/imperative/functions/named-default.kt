package imperative.functions

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
    // Only base price (uses discount=0.0 and tax=0.21)
    val price1 = calculatePrice(100.0)
    println("Final price: $price1") // 121.0

    // Price with 10% discount
    val price2 = calculatePrice(basePrice = 100.0, discount = 0.10)
    println("Final price: $price2") // 108.9

    // Price with 10% discount and reduced tax (10%)
    val price3 = calculatePrice(basePrice = 100.0, tax = 0.10, discount = 0.10)
    println("Final price: $price3") // 99.0

    val price4 = calculatePrice(100.0, tax = 0.23)
    println("Final price: $price4") // 123.0
}