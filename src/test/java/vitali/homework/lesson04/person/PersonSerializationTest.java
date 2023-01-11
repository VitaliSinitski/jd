package vitali.homework.lesson04.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonSerializationTest {

    @Test
    void serializationAndDeserialization() {
        List<Person> expectedList = new ArrayList<>();
        Collections.addAll(expectedList,
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

        Path path = Path.of("src/test/resources", "person.txt");
        PersonSerialization.serializeListOfPersons(path, expectedList);

        List<Person> actualList = new ArrayList<>();
        PersonSerialization.deserializeListOfPersons(path, actualList);

        Assertions.assertEquals(expectedList, actualList);


    }
}
