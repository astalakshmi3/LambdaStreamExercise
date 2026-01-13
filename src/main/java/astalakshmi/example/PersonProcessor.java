package astalakshmi.example;

import java.util.List;
import java.util.function.Consumer;

public class PersonProcessor {
    // Custom Interface Method
    List<Person> findPeople (List<Person> people, PersonRule rule) {
        List<Person> result = new java.util.ArrayList<>();
        for (Person person : people) {
            if (rule.apply(person)) {
                result.add(person);
            }
        }
        return result;
    }
    // Custom Interface Method: apply action to matching
    List <Person> applyToMatching(List<Person> people, PersonRule rule) {
        List<Person> result = new java.util.ArrayList<>();
        for (Person person : people) {
            if (rule.apply(person)) {
                result.add(person);
            }
        }
        return result;
    }
    // Prebuilt Functional Interface Method: Predicate
    List<Person> findPeoplePredicate (List<Person> people, java.util.function.Predicate<Person> predicate) {
        List<Person> result = new java.util.ArrayList<>();
        for (Person person : people) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
    // Prebuilt Functional Interface Method: Consumer
    void findPeopleConsumer (List<Person> people, Consumer<Person> consumer) {
        List<Person> result = new java.util.ArrayList<>();
        for (Person person : people) {
            consumer.accept(person);
        }
    }
}
