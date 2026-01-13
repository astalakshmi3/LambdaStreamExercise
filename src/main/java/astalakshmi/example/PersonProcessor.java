package astalakshmi.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PersonProcessor {

    // create findPeople list and rule and action as parameters
    public List<Person> findPeople(List<Person> people, PersonRule rule, PersonAction action) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (rule.apply(person)) {
                action.execute(person);
                result.add(person);
            }
        }
        return result;
    }

    // create applyToMatching list,rule,action as parameters
    public void applyToMatching(List<Person> people, PersonRule rule, PersonAction action) {
        for (Person person : people) {
            if (rule.apply(person)) {
                action.execute(person);
            }
        }
    }
}