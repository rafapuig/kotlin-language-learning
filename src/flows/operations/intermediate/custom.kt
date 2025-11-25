package flows.operations.intermediate

import coroutines.log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.runBlocking

fun <E> E.toDouble() = toString().toDoubleOrNull() ?: 0.0

fun <T : Any> Flow<T>.smooth(alpha: Double, initial: T? = null) = flow {

    var old: Double? = initial?.toDouble() ?: 0.0
    collect {
        old?.let { prev ->
            val smoothed = alpha * it.toDouble() + (1 - alpha) * prev
            emit(smoothed)

            old = smoothed // it.toDouble()
        }
    }
}

/**
 * scan es un alias de runningFold
 */
fun <T> Flow<T>.smooth2(alpha: Number, initial: Number) = scan(
    initial = initial.toDouble(),
    operation = { old, new ->
        alpha.toDouble() * new.toDouble() + (1.0 - alpha.toDouble()) * old
    }
)

fun main() = runBlocking<Unit> {

    flowOf(10, 0, 10, 0, 10, 5, 0, 9)
        .smooth(0.15, initial = 5)
        .collect { value ->
            log("$value")
        }

    flowOf(10, 0, 10, 0, 10, 5, 0, 9)
        .smooth2(0.15, initial = 5)
        .collect { value ->
            log("$value")
        }


}