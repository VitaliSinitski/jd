package vitali.homework.lesson04.person;

import java.util.*;

public class PersonService {
    public static final int PEOPLE_AMOUNT = 100;
    public static final int MAX_AGE = 21;
    public static final int MIN_AGE_ALLOWED = 15;
    public static final int MAX_AGE_ALLOWED = 30;

    public static void peopleGenerator(List<Person> personList) {
        Random random = new Random();
        String[] names = new String[]{"Liam", "Olivia", "Emma", "Oliver", "Charlotte", "Amelia", "James", "William", "Sophia", "Benjamin", "Isabella", "Lucas", "Mia", "Henry", "Evelyn"};
        String[] surnames = new String[]{"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "White", "Harris", "Clark"};
        for (int i = 0; i < PersonService.PEOPLE_AMOUNT; i++) {
            personList.add(new Person(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], random.nextInt(PersonService.MIN_AGE_ALLOWED, PersonService.MAX_AGE_ALLOWED + 1)));
        }
    }

    public static void removeIfOlder(List<Person> personList) {
        personList.removeIf(person -> person.getAge() >= PersonService.MAX_AGE);
    }

    public static void compareByName(List<Person> personList) {
        Comparator<Person> compareByName = Comparator.comparing(Person::getName);
    }

    public static void removingDuplicates(List<Person> personList) {
        Set<Person> personSet = new HashSet<>(personList.size());
        personList.removeIf(person -> !personSet.add(person));
    }
}
