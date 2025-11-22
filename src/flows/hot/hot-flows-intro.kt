package flows.hot

/**
 * Un hot flow comparte los items emitidos entre varios recolectores (subscriptores)
 * (en lugar de que cada recolector inicie la ejecución de la lógica del flow
 * de manera independiente)
 *
 * Su usan cuando emitimos eventos o cambios de estado que suceden independientemente
 * sin depender de que haya un recolector (subscriptor).
 *
 * Aunque no haya recolector los hot flows están activados y emiten.
 *
 * Existen dos tipos de hot flow
 * - Shared flows (se usan para difundir (broadcast) valores)
 * - State flows (para el caso especial de comunicar estado)
 */