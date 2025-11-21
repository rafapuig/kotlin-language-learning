package coroutines.scopes

/**
 * CONCURRENCIA ESTRUCTURADA
 *
 * Es la habilidad para gestionar y seguir la pista de la jerarquía de corrutinas
 * y su tiempo de vida dentro de una aplicación
 *
 * Cada corrutina pertenece a un ámbito (CorrutineScope)
 *
 * En realidad lo que necesitamos para lanzar un corrutina con launch o async
 * es un scope:
 * scope.launch()
 * scope.async()
 *
 * Existe una relación padre-hijo entre corrutinas
 *
 * En realidad cada corrutina tiene asociado un objeto Job
 *
 * Un objeto Job guarda una referencia a un Job padre
 * y una lista de Jobs (a sus Jobs hijas)
 */