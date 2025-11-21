package coroutines

/**
 * Una corrutina es un bloque de código
 * que se ejecuta de forma asíncrona
 * sin bloquear el hilo en el cual ha sido lanzada
 */

/**
 * Las corrutinas existen en la programación desde los años 60
 * y se basan en el modelo conocido como Communicating Sequential Processes (CSP)
 */


/**
 * Podemos emplear la metáfora de pensar en una corrutina como si fuera un cliente
 * de un supermercado
 * Los trabajadores (cajeras) del supermercado son los hilos
 * Un hilo trabaja cuando ejecuta instrucciones que requieren cálculos de CPU
 * lo que equivaldría a pasar por el lector de código de barras los productos (instrucciones
 * del código de la corrutina) que el cliente le pone en la cinta (la corrutina entrega al hilo)
 *
 * Si de repente un cliente recibe una llamada al móvil y pasa a atenderla (comunicación / operación
 * de entrada-salida IO) deja de poner artículos en la cinta transportadora de la caja (hilo)
 * por lo que la cajera (hilo) queda ociosa y no realiza ningún trabajo util durante ese tiempo
 * que podría aprovecharse para otros clientes (corrutinas) que están en la cola de la misma caja.
 *
 * Para ello el cliente (corrutina) debería retirarse de la caja (suspenderse) mientras atiende
 * la llamada y dejar la caja libre (el hilo) para que pueda pasar los artículos del cliente
 * que le sigue en la cola (las instrucciones de otra corrutina)
 */