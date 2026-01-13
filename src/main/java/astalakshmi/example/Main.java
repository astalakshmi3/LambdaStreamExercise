package astalakshmi.example;


import java.util.List;

public class Main {
    List<Person> people = List.of(new Person("Amina", 22, "Stockholm", true),
            new Person("Erik", 17, "Uppsala", true),
            new Person("Noah", 34, "Stockholm", false),
            new Person("Sara", 29, "Gothenburg", true),
            new Person("Lina", 41, "Malmö", false),
            new Person("Omar", 19, "Stockholm", true));



    public static void main(String[] args) {
        Main main = new Main();

        // Example usage of filterPeople method using lambda expressions
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

}
