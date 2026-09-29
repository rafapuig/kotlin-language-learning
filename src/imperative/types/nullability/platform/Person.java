package imperative.types.nullability.platform;

public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    // getName puede devolver null?
    // El compilador de Kotlin no sabe nada sobre la anulabilidad del tipo String en este caso
    // por tantom, es un tipo plataforma y podemos tratarlo de ambas maneras en Kotlin
    public String getName() {
        return name;
    }
}
