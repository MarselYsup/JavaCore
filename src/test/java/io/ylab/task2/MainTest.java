package io.ylab.task2;

import io.ylab.task2.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {

    private static int [] arrayWithDuplicates;

    private static int [] arrayAlreadySorted;

    private static int [] arrayNotSorted;

    @BeforeAll
    static void fillArrayWithDuplicates() {
        arrayWithDuplicates = new int[5];

        for (int i = 0; i < 5; i++) {
            arrayWithDuplicates[i] = 1;
        }
    }


    @BeforeAll
    static void fillArrayAlreadySorted() {
        arrayAlreadySorted = new int[10];

        for (int i = 0; i < 10; i++) {
            arrayAlreadySorted[i] = i;
        }
    }

    @BeforeAll
    static void fillArrayNotSorted() {
        arrayNotSorted = new int[] {32, 42, 12, 4, 54, 312, 22, 42, 11, 0};
    }

    @Test
    void checkDuplicateSort() {
        int [] oldArray = new int[arrayWithDuplicates.length];
        for (int i = 0; i < arrayWithDuplicates.length; i++) {
            oldArray[i] = arrayWithDuplicates[i];
        }
        Main.bubbleSort(arrayWithDuplicates);
        assertArrayEquals(oldArray, arrayWithDuplicates);
    }


    @Test
    void checkAlreadySortedArraySort() {
        int [] oldArray = new int[arrayAlreadySorted.length];
        for (int i = 0; i < arrayAlreadySorted.length; i++) {
            oldArray[i] = arrayAlreadySorted[i];
        }
        Main.bubbleSort(arrayAlreadySorted);
        assertArrayEquals(oldArray, arrayAlreadySorted);
    }

    @Test
    void checkNotSortedArraySort() {
        int [] sortedArray = {0, 4, 11, 12, 22, 32, 42, 42, 54, 312};

        Main.bubbleSort(arrayNotSorted);
        assertArrayEquals(sortedArray, arrayNotSorted);
    }

    @Test
    void checkArrayWithOneElement() {
        int [] arr = {1};
        Main.bubbleSort(arr);
        assertArrayEquals(arr, new int[]{1});
    }

    @Test
    void checkArrayWithNoElements() {
        int [] arr = new int[0];
        Main.bubbleSort(arr);
        assertArrayEquals(arr, new int[0]);
    }
}
