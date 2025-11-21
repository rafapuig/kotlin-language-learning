package flows

/**
 * Flows
 * Una abstracción construida sobre las corrutinas
 * que permite trabajar con multiples valores secuenciales generados a lo largo del tiempo
 * aprovechando la maquinaria de concurrencia de Kotlin
 *
 * Un flow modela un flujo secuencial de valores
 *
 * Hay diferentes tipos de flows
 * Las operaciones con flows consisten en crear, transformar y consumir
 */

/**
 * Tipos de flows
 *
 * Cold flows:
 * Representa un flujo de datos asíncronos que solamente empieza a emitir elementos
 * cuando sus elementos están siendo consumidos por un recolector individual.
 *
 * Hot flows:
 * Produce elementos independientemente de si los elementos estos elementos estan siendo
 * realmente consumidos o no, operando mediante difusión (broadcast)
 */