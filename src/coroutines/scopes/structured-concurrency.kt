package coroutines.scopes

/**
 * CONCURRECIA ESTRUCTURADA
 *
 * Existe una relación padre-hijo entre corrutinas
 *
 * En realidad cada corrutina tiene asociado un objeto Job
 *
 * Un objeto Job guarda una referencia a un Job padre
 * y una lista de Jobs (sus Job hijas)
 */