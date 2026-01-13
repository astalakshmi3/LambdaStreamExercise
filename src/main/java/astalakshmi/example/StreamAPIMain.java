package astalakshmi.example;

import java.util.List;

public class StreamAPIMain {
    public static void main(String[] args) {
        System.out.println("Stream API Example Main");
        List<Person> people = List.of(new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true));

        // Filter all active people from a list using Stream API
        List<Person> activePeople = people.stream()
                .filter(Person::isActive)
                .toList();
        System.out.println("Active People: " + activePeople);

        // Map all names from the list of people using Stream API
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
        System.out.println("Names: " + names);

        // Count all adults (age >= 18) using Stream API
        long adultCount = people.stream()
                .filter(person -> person.getAge() >= 18)
                .count();
        System.out.println("Number of Adults: " + adultCount);

        // Sort people by age using Stream API
        List<Person> sortedByAge = people.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .toList();
        System.out.println("People sorted by age: " + sortedByAge);

        // Find first active person from Stockholm using Stream API
        Person firstActiveInStockholm = people.stream()
                .filter(person -> person.isActive() && "Stockholm".equals(person.getCity()))
                .findFirst()
                .orElse(null);
        System.out.println("First active person in Stockholm: " + firstActiveInStockholm);

        // Multiple Filters: using Stream API
        List<Person> activeAdultsInStockholm = people.stream()
                .filter(Person::isActive)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> "Stockholm".equals(person.getCity()))
                .toList();
        System.out.println("Active Adults in Stockholm: " + activeAdultsInStockholm);

        // Distinct and Soting:
        List<String> distinctCities = people.stream()
                .map(Person::getCity)
                .distinct()
                .sorted()
                .toList();

        // Mapping and Formatting:
        List<String> formattedNames = people.stream()
                .map(person -> "Name: " + person.getName() + ", Age: " + person.getAge())
                .toList();
        System.out.println("Formatted Names: " + formattedNames);



    }
}
