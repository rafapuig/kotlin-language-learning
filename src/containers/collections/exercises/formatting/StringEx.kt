package containers.collections.exercises.formatting

fun String.padCenter(length: Int, padChar: Char = ' '): String {

    if (length < this.length) return this

    val totalPadding = length - this.length
    val leftPadding = totalPadding / 2
    //val rightPadding = totalPadding - leftPadding

    return padStart(this.length + leftPadding, padChar)
        .padEnd(length, padChar)
}