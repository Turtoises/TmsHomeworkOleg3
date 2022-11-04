package by.tms.lesson35patterns.task4ptototype;

public class MainPrototype {

    public static void main(String[] args) {

        Person person = Person.builder()
                .name("Ivan")
                .surname("Ivanov")
                .age(20)
                .build();

        Person personCopy = person.creatPrototype();

        System.out.println(person);
        System.out.println(personCopy);

        person.setName("Petr");
        person.setSurname("Krilov");

        System.out.println(person);
        System.out.println(personCopy);

        Person man = Man.builder()
                .name("Dima")
                .surname("Li")
                .age(20)
                .weight(50.0)
                .high(180.0)
                .build();

        Person manCopy = man.creatPrototype();

        System.out.println(man);
        System.out.println(manCopy);

        man.setName("Pasha");
        man.setSurname("Penrov");

        System.out.println(man);
        System.out.println(manCopy);

    }
}
