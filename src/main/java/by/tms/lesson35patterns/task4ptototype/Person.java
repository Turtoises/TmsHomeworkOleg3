package by.tms.lesson35patterns.task4ptototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Person implements Prototyping<Person> {

    private String name;
    private String surname;
    private Integer age;

    public Person(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.age = person.getAge();
    }

    @Override
    public Person creatPrototype() {
        return new Person(this);
    }
}
