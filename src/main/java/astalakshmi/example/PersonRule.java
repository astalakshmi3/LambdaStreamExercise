package astalakshmi.example;
@FunctionalInterface
public interface PersonRule {
    boolean apply(Person person);

   /* static PersonRule isActive() {
        return Person::isActive;
    }
    static PersonRule isAdult() {
        return person -> person.getAge() >= 18;
    }
    static PersonRule livesInStockholm(String city) {
        return person -> city.equals(person.getCity());
    }

    static PersonRule activeAndAdult() {
        return person -> person.isActive() && person.getAge() >= 18;
    }
    static PersonRule adultOrLivesStockholm() {
        return person -> person.getAge() >= 18 || "Stockholm".equals(person.getCity());
    }
    static PersonRule notActive() {
        return person -> !person.isActive();
    }*/

}
