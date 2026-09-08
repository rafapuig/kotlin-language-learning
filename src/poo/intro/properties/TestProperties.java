/**
 * En esta clase probamos la clase Person definida en Kotlin
 * creando una programa en Java que crea una instancia y accede a sus propiedades
 * tanto para leer su valor (getter) como para mutarlo (setter)
 */

import poo.intro.properties.Person;

void main() {

    // Crea una instancia mediante el operador new y la llamada al constructor secundario con argumentos "Rafael", 18
    Person person = new Person("Rafael", 18);

    /**
     * Por cada propiedad declarada en una clase en Kotlin
     * si es declarada como val en Java se accede mediante un getter getXXX() donde XXX es el nombre de la propiedad
     * si es declara como var entonces también se puede mutar mediante un setter setXXX(valor)
     *
     * Si la propiedad empieza por is (por convención para propiedades booleanas) entonces el getter no añade prefijo get
     */

    IO.println(person.getName()); // a la propiedad name se accede para lectura mediante el getter getName()

    IO.println(person.getAge()); // a la propiedad age se accede para su lectura mediante el getter getAge()

    IO.println(person.isEmployed());

    IO.println(person);

    /* Modificamos las propiedades del objeto mediante los setters */
    person.setName("Rafa"); // para mutar la propiedad name se llama al setter setName()
    person.setAge(48);
    person.setEmployed(true);

    IO.println(person);

    // Llamar al metodo turnOneYearOlder
    person.turnOneYearOlder();
    IO.println(person);
}

