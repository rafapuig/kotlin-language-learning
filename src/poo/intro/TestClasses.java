package poo.intro;

public class TestClasses {

    public static void main(String[] args) {
        testPerson();
        testPerson1();
    }

    private static void testPerson() {
        var person = new Person("Rafa Puig");
        System.out.println(person);
        System.out.println(person.getName());
    }

    static void testPerson1() {
        final var person = new Person1("Rafa Puig", true);
        System.out.println(person);
        System.out.println(person.getName());
        System.out.println(person.isStudent());
        person.setStudent(false);
        System.out.println(person.isStudent());
    }

}
