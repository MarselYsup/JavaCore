package io.ylab.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.printf("Initial list of people: %s \n",Arrays.toString(RAW_DATA));
        System.out.println("Result:");
        getPersonMapWithoutDuplicatesGroupedByName(RAW_DATA)
                .forEach((k, v) -> System.out.printf("Key: %s\nValue: %d\n", k, v));
    }
    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person)  o;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return String.format("%d - %s", this.id, this.name);
        }
    }
    /**
     * Убирает дубликаты, отсортировывает по идентификатору
     * и сгрупировывает по именам обекты Person
     * @return map, где ключ - имена, а value - кол-во людей с данным именем
     * */
    public static Map<String, Long> getPersonMapWithoutDuplicatesGroupedByName(Person[] people) {

        return Arrays.stream(Optional.ofNullable(people).orElse(new Person[0]))
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.comparing(Person::getId))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
    }

}
