package imperative.types.nullability.platform

/**
 * Un tipo de plataforma (platform type)
 *
 * es un tipo para el cual Kotlin no tiene información acerca de su anulabilidad
 *
 * Podemos trabajar con el tratándolo como si se tratara de un tipo anulable o no anulable.
 * El compilador permitirá todas las operaciones.
 *
 * Como en Java
 * - Si sabemos que el valor podría ser null podemos comprobarlo antes de usarlo.
 * - Si sabemos que no puede ser null podemos usarlo directamente.
 *
 */

/**
 * No se puede declarar ua variable en Kotlin del tipo plataforma,
 * estos tipos provienen de código en Java.
 */