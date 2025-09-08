package func.expression.body

/**
 * Si el cuerpo consiste en una única expresión
 * se usa la expresión como el cuerpo
 * eliminar los {} y el return
 * colocar la expresión después de la declaración y un signo =
 *
 * Usar el conversor entre expression body y block body de IntelliJ IDEA (Alt+ENTER con cursor en el =
 */
fun max(a: Int, b: Int): Int = if (a > b) a else b

/**
 * Uso en expresiones if, when, try
  */
