package vitali.homework.lesson04.person;

import java.io.Serial;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.*;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1059337677584733230L;

    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return name + " : " + surname + " : " + age;
    }
}