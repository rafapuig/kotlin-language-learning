package fields

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class Demo {
    val elems: List<String>
        field = mutableListOf<String>("HOla")

    fun add(elem: String) {
        elems.add(elem)
    }

    val name: StateFlow<String>
        field = MutableStateFlow("")

    fun updateName(newName: String) {
        name.value = newName
        name.update { newName }
    }
}

fun main() {
    val demo = Demo()
    demo.add("Asi bien")
    //demo.elems.add("Asi no se puede")
    demo.updateName("Perico")
    //demo.name.value = "Jose"
    //demo.name.update { "Pepe" }
}