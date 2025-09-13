package poo.interfaces

interface Choices {


    companion object {
        const val Yes = "Yes"
        const val No = "No"
    }

}

fun main() {
    Choices.Yes
    Choices.No
}