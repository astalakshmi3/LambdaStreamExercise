package astalakshmi.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {

    List<Person> people = List.of(new Person("Amina", 22, "Stockholm", true),
            new Person("Erik", 17, "Uppsala", true),
            new Person("Noah", 34, "Stockholm", false),
            new Person("Sara", 29, "Gothenburg", true),
            new Person("Lina", 41, "Malmö", false),
            new Person("Omar", 19, "Stockholm", true));


    PersonProcessor processor = new PersonProcessor();
    // Rules using Custom Functional Interface
    List<Person> activePeople = processor.findPeople(people, Person::isActive);
    System.out.println("Active People: " + activePeople);
    List<Person> stockholmResidents = processor.findPeople(people, person -> "Stockholm".equals(person.getCity()));
    System.out.println("Stockholm Residents: " + stockholmResidents);
    List<Person> adults = processor.findPeople(people, person -> person.getAge() >= 18);
    System.out.println("Adults: " + adults);

    // Rules using Prebuilt Functional Interface - Predicate
    List<Person> activePeoplePredicate = processor.findPeoplePredicate(people, Person::isActive);
    System.out.println("Active People (Predicate): " + activePeoplePredicate);
    List<Person> stockholmResidentsPredicate = processor.findPeoplePredicate(people, person -> "Stockholm".equals(person.getCity()));
    System.out.println("Stockholm Residents (Predicate): " + stockholmResidentsPredicate);
    List<Person> adultsPredicate = processor.findPeoplePredicate(people, person -> person.getAge() >= 18);
    System.out.println("Adults (Predicate): " + adultsPredicate);

    // Actions using Prebuilt Functional Interface - Consumer
    System.out.println("Performing actions on all people:");
    processor.findPeopleConsumer(people, person -> System.out.println("Name: " + person.getName()));
    processor.findPeopleConsumer(people, person -> System.out.println("Sending email to: " + person.getName()));

// Prebuilt Functional Interface - Consumer with filtering
    System.out.println("Performing actions on active adults:");
    processor.findPeopleConsumer(people, person -> {
        if (person.isActive() && person.getAge() >= 18) {
            System.out.println("Name: " + person.getName());
            System.out.println("Sending email to: " + person.getName());
        }
    });


    /*    // Example usage of filterPeople method using lambda expressions
        List<Person> activePeople = filterPeople(Person::isActive);
        System.out.println("Active People: " + activePeople);

        List<Person> stockholmResidents = filterPeople(person -> "Stockholm".equals(person.getCity()));
        System.out.println("Stockholm Residents: " + stockholmResidents);

        List<Person> adults = filterPeople(person -> person.getAge() >= 18);
        System.out.println("Adults: " + adults);
    }

   static List<Person> filterPeople(PersonRule rule) {
        Main main = new Main();
        List<Person> result = new java.util.ArrayList<>();
        for (Person person : main.people) {
            if (rule.apply(person)) {
                result.add(person);
            }
        }
        return result;
    }
    static List<Person> filterPeoplePredicate(java.util.function.Predicate<Person> predicate) {
        Main main = new Main();
        List<Person> result = new java.util.ArrayList<>();
        for (Person person : main.people) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
    static List<Person> filterPeopleConsumer(java.util.function.Consumer<Person> consumer) {
        Main main = new Main();
        List<Person> result = new java.util.ArrayList<>();
        for (Person person : main.people) {
            consumer.accept(person);
        }
        return result;
    }
    static void applyToMatchingPeople(PersonRule rule, PersonAction action) {
        Main main = new Main();
        for (Person person : main.people) {
            if (rule.apply(person)) {
                action.execute(person);
            }
        }*/
    }

}
