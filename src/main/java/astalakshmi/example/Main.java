package astalakshmi.example;


import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static <Perdicate> void main(String[] args) {

        List<Person> people = List.of(new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true));

        PersonProcessor processor = new PersonProcessor();
        // Lambdas Rules
        PersonRule isActive = Person::isActive;
        PersonRule isAdult = person -> person.getAge() >= 18;
        PersonRule isStockholmResidentRule = person -> "Stockholm".equals(person.getCity());

        System.out.println("Active People :" + filterPeople(people, isActive));
        System.out.println("Adults :" + filterPeople(people, isAdult));
        System.out.println("Stockholm Residents :" + filterPeople(people, isStockholmResidentRule));

        // Actions to print name and send email
        PersonAction printNameAction = person -> System.out.println("Name: " + person.getName());
        PersonAction sendEmailAction = person -> System.out.println("Sending email to: " + person.getName());


        //Options

        // Rule Composition - Active and Adult
        PersonRule activeAndAdult = person -> isActive.apply(person) && isAdult.apply(person);
        System.out.println("Active Adults :" + filterPeople(people, activeAndAdult));

        // Rule Composition - Active or Stockholm Resident
        PersonRule activeOrStockholmResident = person -> isActive.apply(person) || isStockholmResidentRule.apply(person);
        System.out.println("Active or Stockholm Residents :" + filterPeople(people, activeOrStockholmResident));

        // Rule Negation - Not Active
        PersonRule notActive = person -> !isActive.apply(person);
        System.out.println("Not Active People :" + filterPeople(people, notActive));
    }

    // Predicate and Consumer functional interfaces
    Predicate<Person> isActivePredicate = Person::isActive;
    Consumer<Person> printNameConsumer = person -> System.out.println("Name: " + person.getName());


    private static String filterPeople(List<Person> people, PersonRule isActive) {
        PersonProcessor processor = new PersonProcessor();
        List<Person> filteredPeople = processor.findPeople(people, isActive, person -> {
            // No action needed for filtering
        });
        return filteredPeople.toString();
    }
}




