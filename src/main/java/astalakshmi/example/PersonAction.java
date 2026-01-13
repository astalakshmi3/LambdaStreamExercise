package astalakshmi.example;

import java.util.List;

@FunctionalInterface
public interface PersonAction {
    void execute(Person person);

    static void performActionOnPeople(List<Person> people) {
        PersonAction printName = person -> System.out.println("Name: " + person.getName());
        PersonAction sendEmail = person -> System.out.println("Sending email to: " + person.getName());
         for (Person person : people) {
             printName.execute(person);
             sendEmail.execute(person);
         }
    }
}

