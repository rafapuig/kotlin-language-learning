package poo.intro.pojo;

/**
 * Plain old Java Object POJO
 *
 * Demasiado Boilerplate
 */
public class Person {

    private final String name;

    /**
     * El constructor simplemente asigna los parámetros a los campos con el nombre correspondiente:
     * parámetro name al campo name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Se debe proporcionar un getter para el campo name para devolver el contenido del campo
     */
    public String getName() {
        return name;
    }
}
