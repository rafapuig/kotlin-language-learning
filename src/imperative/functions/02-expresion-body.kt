package func.expression.body

/**
 * En Kotlin podemos hacer que la definición de una función sea más concisa
 *
 * Cuando en una función escribimos el cuerpo entre {} decimos que la función tiene cuerpo de bloque (block body).
 *
 * Si el cuerpo de la función consiste en una única expresión
 * se puede usar directamente la expresión como el cuerpo
 *
 * - eliminar los {} y la instrucción `return`
 * - colocar la expresión después de la declaración y de un signo `=`
 *
 * Si escribimos la función de esta manera entonces la función tiene cuerpo de expresión (expression body)
 *
 * Usar el conversor entre expression body y block body de IntelliJ IDEA (Alt+ENTER con cursor en el =
 */
fun max(a: Int, b: Int): Int = if (a > b) a else b

/**
 * Uso en expresiones if, when, try
  */
