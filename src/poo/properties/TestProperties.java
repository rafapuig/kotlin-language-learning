package poo.properties;

/**
 * En esta clase probamos la clase Person definida en Kotlin
 * creando una programa en Java que crea una instancia y accede a sus propiedades
 * tanto para leer su valor (getter) como para mutarlo (setter)
 */
public class TestProperties {
    public static void main(String[] args) {
        Person person = new Person("Rafael", 18);
        System.out.println(person.getName()); // a la propiedad name se accede para lectura mediante getName()
        System.out.println(person.getAge());
        System.out.println(person);
        person.setName("Rafa"); // para mutar la propiedad name se llama al setter setName()
        person.setAge(48);
        System.out.println(person);
    }
}
