package flows.operations.intermediate

/**
 * 1️⃣ Transformaciones básicas
 *
 * map { } → transforma cada elemento.
 *
 * mapNotNull { } → transforma y descarta nulls.
 *
 * mapLatest { } → transforma solo el último valor, cancela anteriores.
 *
 * transform { } → permite emitir cero, uno o varios valores por elemento.
 *
 * runningFold(initial) { acc, value -> } → acumulación que emite cada estado parcial.
 *
 * scan(initial) { acc, value -> } → alias de runningFold.
 *
 *
 * 2️⃣ Filtrado
 *
 * filter { } → solo elementos que cumplen la condición.
 *
 * filterNot { } → elementos que no cumplen.
 *
 * filterNotNull() → elimina nulls.
 *
 * take(n) → solo los primeros n elementos.
 *
 * takeWhile { } → hasta que la condición deje de cumplirse.
 *
 * drop(n) → ignora los primeros n elementos.
 *
 * dropWhile { } → ignora mientras la condición se cumpla.
 *
 * distinctUntilChanged() → descarta valores consecutivos repetidos.
 *
 *
 * 3️⃣ Combinación de Flows
 *
 * zip(otherFlow) { a, b -> } → combina elementos por posición.
 *
 * combine(otherFlow) { a, b -> } → combina los últimos valores de cada Flow.
 *
 * flatMapConcat { } → concatena Flows generados por cada valor.
 *
 * flatMapMerge(concurrency = ...) { } → fusiona Flows generados, ejecutando en paralelo.
 *
 * flatMapLatest { } → como merge pero cancela Flows anteriores al llegar uno nuevo.
 *
 *
 * 4️⃣ Acciones / efectos secundarios
 *
 * onEach { } → ejecuta acción por cada valor, sin consumirlo.
 *
 * onStart { } → acción antes de emitir el primer valor.
 *
 * onCompletion { cause -> } → acción al terminar, con excepción si ocurre.
 *
 * catch { } → captura excepciones dentro del Flow y permite continuar o emitir valores.
 *
 *
 * 5️⃣ Operadores de temporización
 *
 * debounce(time) → espera hasta que no llegue un nuevo valor en el tiempo dado.
 *
 * sample(time) → emite el último valor cada intervalo de tiempo.
 *
 * conflate() → descarta valores intermedios si el collector está lento.
 *
 * buffer(capacity) → permite que el Flow emita sin esperar al collector, creando un buffer.
 *
 *
 * 6️⃣ Control de concurrencia / contextos
 *
 * flowOn(context) → cambia el dispatcher donde se ejecuta upstream.
 *
 * cancellable() → permite que la recolección sea cancelable.
 */

