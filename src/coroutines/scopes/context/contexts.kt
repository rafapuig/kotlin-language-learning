package coroutines.scopes

import coroutines.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Que ocurre con el contexto de una corrutina cuando iniciamos una nueva corrutina
 *
 * 1) la corrutina hija hereda el contexto de la corruina padre
 * 2) la nueva corrutina (hija) crea un nuevo objeto Job resposanble de establecer la
 *    relación padre-hija
 * 3) se aplican los elementos porporcionados para el contexto como argumento en el builder
 *    que podrían reemplazar los heredados
 */

/**
 * Usar la opción de -Dkotlinx.coroutines.debug en la JVM
 */

fun main() {
    runBlocking(Dispatchers.Default) {
        log(coroutineContext)
        /**
         * Al no especificar ningun elemento
         * usa como contexto el mismo dispatcher que la corrutina padre (Dispatchers.Default)
         * y el mismo nombre "coroutine"
         * Crea un nuevo Job de tipo Standalone y establece la relación padre-hija
         */
        launch() {
            log(coroutineContext)
            /**
             * Ahora si se especifican elementos de contexto:
             * - nombre de la corrutina: Perica -- reemplaza a --> coroutine
             * - el dispatcher: Dispatchers.IO -- reemplzada a --> Dispatchers.Default
             * que reemplazaran a los valores de los elementos de contexto heredados
             */
            launch(Dispatchers.IO + CoroutineName("Perica")) {
                log(coroutineContext)
            }
        }
    }
}