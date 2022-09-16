package io.ylab.task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

import static io.ylab.task3.Main.*;

public class MainTest {

    private static Person [] peopleDuplicates;

    private static Person [] peopleWithSameName;

    private static Person [] peopleWithoutDuplicates;

    private static Person [] emptyArrayOfPeople;

    private static Person [] nullArray;

    private static Person [] peopleWithNullObject;

    @BeforeAll
    static void fillPeopleDuplicates() {
        peopleDuplicates = new Person[10];
        Person person  = new Person(1, "Igor");
        for (int i = 0; i < 10; i++) {
            peopleDuplicates[i] = person;
        }
    }

    @BeforeAll
    static void fillPeopleWithSameName() {
        peopleWithSameName = new Person[10];
        for (int i = 0; i < 10; i++) {
            peopleWithSameName[i] = new Person(i+1, "Ivan");
        }
    }

    @BeforeAll
    static void fillPeopleWithoutDuplicates() {
        peopleWithoutDuplicates = new Person[10];
        peopleWithoutDuplicates[0] = new Person(1, "Ivan");
        peopleWithoutDuplicates[1] = new Person(2, "Igor");
        peopleWithoutDuplicates[2] = new Person(3, "Igor");
        peopleWithoutDuplicates[3] = new Person(4, "Andrew");
        peopleWithoutDuplicates[4] = new Person(5, "Andrew");
        peopleWithoutDuplicates[5] = new Person(6, "Andrew");
        peopleWithoutDuplicates[6] = new Person(7, "Marsel");
        peopleWithoutDuplicates[7] = new Person(8, "Fedor");
        peopleWithoutDuplicates[8] = new Person(9, "Olga");
        peopleWithoutDuplicates[9] = new Person(10, "Marat");
    }

    @BeforeAll
    static void fillEmptyArrayOfPeople() {
        emptyArrayOfPeople = new Person[0];
    }

    @BeforeAll
    static void fillNullArray() {
        nullArray = null;
    }

    @BeforeAll
    static void fillPeopleWithNullObject() {
        peopleWithNullObject = new Person[10];
        peopleWithNullObject[0] = new Person(1, "Ivan");
        peopleWithNullObject[1] = new Person(2, "Igor");
        peopleWithNullObject[2] = new Person(3, "Igor");
        peopleWithNullObject[3] = new Person(4, "Andrew");
        peopleWithNullObject[4] = new Person(5, "Andrew");
        peopleWithNullObject[5] = new Person(6, "Andrew");
        peopleWithNullObject[6] = new Person(7, "Marsel");
        peopleWithNullObject[7] = null;
        peopleWithNullObject[8] = null;
        peopleWithNullObject[9] = null;
    }

    @Test
    void checkPeopleWithDuplicates() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("Igor", 1L);
        assertTrue(Main.getPersonMapWithoutDuplicatesGroupedByName(peopleDuplicates).equals(map));
    }

    @Test
    void checkPeopleWithSameName() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("Ivan", 10L);
        assertTrue(Main.getPersonMapWithoutDuplicatesGroupedByName(peopleWithSameName).equals(map));
    }

    @Test
    void checkPeopleWithoutDuplicates() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("Ivan", 1L);
        map.put("Igor", 2L);
        map.put("Andrew", 3L);
        map.put("Marsel", 1L);
        map.put("Fedor", 1L);
        map.put("Olga", 1L);
        map.put("Marat", 1L);

        assertTrue(Main.getPersonMapWithoutDuplicatesGroupedByName(peopleWithoutDuplicates).equals(map));
    }

    @Test
    void checkEmptyArray() {
        HashMap<String, Long> map = new HashMap<>();

        assertTrue(Main.getPersonMapWithoutDuplicatesGroupedByName(emptyArrayOfPeople).equals(map));
    }

    @Test
    void checkNullArray() {
        HashMap<String, Long> map = new HashMap<>();

        assertTrue(Main.getPersonMapWithoutDuplicatesGroupedByName(nullArray).equals(map));
    }

    @Test
    void checkPeopleWithNullObject() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("Ivan", 1L);
        map.put("Igor", 2L);
        map.put("Andrew", 3L);
        map.put("Marsel", 1L);

        assertTrue(Main.getPersonMapWithoutDuplicatesGroupedByName(peopleWithNullObject).equals(map));

    }
}
