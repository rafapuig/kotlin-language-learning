package coroutines.scopes

import coroutines.log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Ajustamos el ejemplo de la intro (scope-intro)
 * pero esta vez usamos la instancia GlobalScope como ámbito para lanzar las
 * corrutinas
 *
 * Este programa termina inmediatamente, son esperar a que terminen las corrutinas
 * lanzadas en el GlobalScope
 *
 * Esto sucede porque al usar GlobalScope se rompe la relación padre-hija
 * y, por tanto, la jerarquía establecida entre corrutinas que obtenemos al usar
 * concurrencia estructurada
 */

/**
 * Anotación especial para avisar que GlobalScope es delicado (usar con cuidado)
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() {

    // Corrutina 1 (no tiene corrutinas hijas esta vez)
    runBlocking {

        // Corrutina 2 (ya no es hija de la 1)
        GlobalScope.launch {
            delay(1.seconds)

            // Corrutina 3 (ya no es hija de la 2)
            GlobalScope.launch {
                delay(250.milliseconds)
                log("Corrutina Nieta terminada")
            }
            log("Corrutina hija 1 terminada")
        }

        // Corrutina 4 (ya no es hija de la 1)
        GlobalScope.launch {
            delay(500.milliseconds)
            log("Corrutina hija 2 terminada")
        }

        log("Corrutina padre terminada")
    }
}