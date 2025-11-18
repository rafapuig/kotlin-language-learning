package coroutines.scopes

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Cada corrutina pertenece a un ámbito de corrutina (coroutine scope)
 *
 * Los scopes ayudan a establecer relaciones padre-hijo entre corrutinas
 *
 * Las funciones builder launch y async son en realidad funciones de extensión
 * del interface CoroutineScope
 *
 * Cuando creamos una nueva corrutina mediante launch o async dentro del cuerpo
 * de otro builder de corrutinas, esta nueva corrutina se convierte automáticamente
 * en hija de la corrutina padre creada por el builder
 */

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

fun main() {
    /**
     * El parámetro block de la función builder es de tipo función de extensión
     * para receptores de tipo CoroutineScope
     * Por ello la expresión lambda tiene un receptor implícito this de tipo CoroutineScope
     * Este scope es el nuevo scope que se crea con cada nueva corrutina
     */
    runBlocking {//#1
        log("Iniciando currutina padre (runBlocking)...")
        /**
         * Lanzamos la corrutina #2 que será hija de la creada al llamar al builder runBlocking #1
         * (Se crea inmediatamente al iniciar la corrutina padre creada por runBlocking)
         */
        launch {//#2
            log("Iniciando currutina hija 1 ...")
            delay(1.seconds)
            /**
             * Al llamar a launch se crea una corrutina #3 que será hija de la creada por
             * la función builder launch en cuyo cuerpo se realiza esta llamada #2
             * Por tanto, será hija de la corrutina hija 1 de la corrutina padre creada por runBlocking
             * es decir, será nieta de la corrutina #1
             * (Esta llamada se producirá cuando la corrutina hija 1 (#2) se retome un segundo
             * después de haber sido suspendida)
             */

            this.launch {//#4
                log("Iniciando currutina nieta ...")
                delay(250.milliseconds)
                log("Corrutina Nieta terminada")
            }
            log("Corrutina hija 1 terminada")
        }
        /**
         * Lanzamos otra corrutina dentro del cuerpo de la lambda de con la que llamamos a runBlocking
         * Por eso será hija (segunda hija) de la creada por runBlocking
         * (Se crea inmediatamente a continuación de haber creado la hija 1)
         */
        this.launch {//#3
            log("Iniciando currutina hija 2 ...")
            delay(500.milliseconds)
            log("Corrutina hija 2 terminada")
        }
        /**
         * Tras lanzar las 2 corrutinas hijas (#2 y #3) la corrutina padre #1 termina
         * (pero eso no provoca que se aborten a medio terminar las corrutinas hijas)
         * El programa no termina hasta que todas las corrutinas hijas hayan terminado
         * Esto es posible gracias a la denominada concurrencia estructurada
         */
        log("Corrutina padre terminada")
    }
    log("Vuelta al mundo secuencial!")
}