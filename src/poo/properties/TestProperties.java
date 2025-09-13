package poo.properties;

public class TestProperties {
    public static void main(String[] args) {
        Person person = new Person("Rafael", 18);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person);
        person.setName("Rafa");
        person.setAge(48);
        System.out.println(person);
    }
}
