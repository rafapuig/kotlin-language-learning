import poo.intro.properties2.Person;

void main() {
    // Creamos en Java una instancia de la clase Person definida en Kotlin
    var person = new Person("Perico Palotes", true);
    IO.println(person);
    IO.println(person.getName());
    IO.println(person.isStudent());

    person.setStudent(false);
    IO.println(person.isStudent());
}