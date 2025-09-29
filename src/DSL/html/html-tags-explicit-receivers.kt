package DSL.html.explicit.receivers

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        // Inicializa el objeto hijo
        child.init() // Invoca la función de extension usando como receptor el child
        // Y lo añade a su lista de hijos
        children.add(child)
    }

    override fun toString(): String =
        children.joinToString("", "<$name>", "</$name>")

}

class TD : Tag("td")

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TABLE : Tag("table") {
    /**
     * la función tr crea un objeto TR
     * y lo pasa como argumento del primer parámetro de doInit
     * Como argumento para el segundo parámetro pasa la función init
     */
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

/**
 * función builder de una tabla
 * Crea el objeto tabla y la inicializa con el init
 * init es de tipo función de extension con receptor de tipo TABLE
 * El cuerpo de la function table hace uso de la scope function apply
 * El receptor de apply es un objeto TABLE construido
 * dentro de apply se ejecuta el código de la función init
 * usando como receptor el objeto TABLE
 * y se devuelve finalmente el resultado de apply que es el receptor
 * que se le proporcionó
 */
fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

/**
 * Si usáramos lambdas regulares en lugar de lambdas con receivers
 * la sintaxis se volvería tan ilegible como está en la que usamos
 * la referencia this@funcion para explicitar el receiver
 * usaríamos la referencia it para llamar a los métodos de creación de etiquetas
 */
fun createTable() =
    table {
        this@table.tr {
            this@tr.td {  }
            this@tr.td {  }
        }
        this.tr {
            this.td {  }
            this.td {  }
        }
    }

fun main() {
    println(createTable())
}