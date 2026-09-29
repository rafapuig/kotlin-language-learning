package poo.classes.properties;

public class Person {

    // Campo de respaldo de la "propiedad" name
    private String name;
    public String getName() { // Getter trivial que devuelve el valor del campo de respaldo de la "propiedad" name
        return name;
    }
    public void setName(String value) { // Setter trivial que asigna el valor al campo de respaldo de name
        name = value;
    }

    // Campo de respaldo de la "propiedad" age
    private int age;
    public int getAge() { // Getter trivial que devuelve el valor del campo de respaldo de la "propiedad" age
        return age;
    }
    public void setAge(int value) { // Setter trivial que asigna el valor al campo de respaldo de age
        age = value;
    }

    public Person(String name, int age) {
        this.name = name; // Inicialización del campo de respaldo de la propiedad name
        this.age = age; // Inicialización del campo de respaldo de la propiedad name
    }
}

