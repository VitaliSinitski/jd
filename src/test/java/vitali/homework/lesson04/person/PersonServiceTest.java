package vitali.homework.lesson04.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.util.*;

public class PersonServiceTest {
    public static final int PEOPLE_AMOUNT = 100;
    public static final int MAX_AGE_ALLOWED = 20;
    public static final int MIN_AGE_OF_GROUP = 15;
    public static final int MAX_AGE_OF_GROUP = 30;
    private PersonService personService = new PersonService();
    static List<Person> personListFromPersonService = new ArrayList<>();


    @BeforeAll
    static void generateListOfPerson() {
        PersonService.peopleGenerator(personListFromPersonService);
    }

    @Test
    void amountOfPersons() {
        Assertions.assertEquals(PEOPLE_AMOUNT, personListFromPersonService.size());
    }

    @Test
    void peopleGeneratorCheckMinAge() {
        int age = MAX_AGE_OF_GROUP;
        for (Person person : personListFromPersonService) {
            int personAge = person.getAge();
            if (personAge < age) {
                age = personAge;
            }
        }
        Assertions.assertTrue(MIN_AGE_OF_GROUP <= age);
    }

    @Test
    void peopleGeneratorCheckMaxAge() {
        int age = MIN_AGE_OF_GROUP;
        for (Person person : personListFromPersonService) {
            int personAge = person.getAge();
            if (personAge > age) {
                age = personAge;
            }
        }
        Assertions.assertTrue(MAX_AGE_OF_GROUP >= age);
    }

    @Test
    void removeIfOlder() {
        List<Person> testList = new ArrayList<>();
        Collections.addAll(testList,
                new Person("John", "Smith", 28),
                new Person("Jesica", "Parker", 16),
                new Person("Billy", "Tornton", 30),
                new Person("Abby", "Black", 22),
                new Person("Sara", "Oconor", 17),
                new Person("Billy", "Tornton", 30),
                new Person("Jesica", "Parker", 16),
                new Person("Matt", "Daemon", 20),
                new Person("John", "Smith", 28),
                new Person("Sara", "Oconor", 17),
                new Person("Duck", "Stone", 24));
        PersonService.removeIfOlder(testList);
        int min = testList.stream()
                .map(Person::getAge)
                .min(Comparator.comparing(Integer::valueOf))
                .get();
        int max = testList.stream()
                .map(Person::getAge)
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        Assertions.assertAll(
                () -> Assertions.assertTrue(MIN_AGE_OF_GROUP <= min),
                () -> Assertions.assertTrue(MAX_AGE_OF_GROUP >= max)
        );
    }

    @Test
    void removeDuplicates() {
        List<Person> testList = new ArrayList<>();
        Collections.addAll(testList,
                new Person("John", "Smith", 28),
                new Person("Jesica", "Parker", 16),
                new Person("Billy", "Tornton", 30),
                new Person("Abby", "Black", 22),
                new Person("Sara", "Oconor", 17),
                new Person("Billy", "Tornton", 30),
                new Person("Jesica", "Parker", 16),
                new Person("Matt", "Daemon", 20),
                new Person("John", "Smith", 28),
                new Person("Sara", "Oconor", 17),
                new Person("Duck", "Stone", 24));
        PersonService.removingDuplicates(testList);
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList,
                new Person("John", "Smith", 28),
                new Person("Jesica", "Parker", 16),
                new Person("Billy", "Tornton", 30),
                new Person("Abby", "Black", 22),
                new Person("Sara", "Oconor", 17),
                new Person("Matt", "Daemon", 20),
                new Person("Duck", "Stone", 24));
        Assertions.assertEquals(expectedList, testList);
    }
}


