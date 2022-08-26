package io.ylab.task1;

import io.ylab.task1.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainTest {

    private static int[][] duplicateArray;

    private static int[][] negativeArray;

    private static int[][] regularArray;

    private static int[][] bigNumberArray;

    @BeforeAll
    static void fillDuplicateArray() {
        duplicateArray = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                duplicateArray [i][j] = 2;
            }
        }
    }

    @BeforeAll
    static void fillNegativeArray() {
        negativeArray = new int [5] [5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
              negativeArray[i][j] = -1 * j;
            }
        }
    }

    @BeforeAll
    static void fillRegularArray() {
        regularArray = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                regularArray[i][j] = j;
            }
        }
    }

    @BeforeAll
    static void fillBigNumberArray() {
        bigNumberArray = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bigNumberArray [i][j] = Integer.MAX_VALUE;
            }
        }
    }

    @Test
    void checkMaxWithDuplicateValue() {
        assertEquals(Main.maxValueInArray(duplicateArray), 2);
    }

    @Test
    void checkMinWithDuplicateValue() {
        assertEquals(Main.minValueInArray(duplicateArray), 2);
    }

    @Test
    void checkAverageWithDuplicateValue() {
        assertEquals(Main.averageInArray(duplicateArray), 2);
    }


    @Test
    void checkMaxWithNegativeValue() {
        assertEquals(Main.maxValueInArray(negativeArray), 0);
    }

    @Test
    void checkMinWithNegativeValue() {
        assertEquals(Main.minValueInArray(negativeArray), -4);
    }

    @Test
    void checkAverageWithNegativeValue() {
        assertEquals(Main.averageInArray(negativeArray), -2);
    }


    @Test
    void checkMaxWithRegularValue() {
        assertEquals(Main.maxValueInArray(regularArray), 4);
    }

    @Test
    void checkMinWithRegularValue() {
        assertEquals(Main.minValueInArray(regularArray), 0);
    }

    @Test
    void checkAverageWithRegularValue() {
        assertEquals(Main.averageInArray(regularArray), 2);
    }

    @Test
    void checkNotNullRandomArray() {
        assertNotNull(Main.getRandomArray());
    }

    @Test
    void checkNotOverflowWithBigNumbersAverage() {
        assertEquals(Main.averageInArray(bigNumberArray), Integer.MAX_VALUE);
    }

    @Test
    void checkMaxWithBigValue() {
        assertEquals(Main.maxValueInArray(bigNumberArray), Integer.MAX_VALUE);
    }

    @Test
    void checkMinWithBigValue() {
        assertEquals(Main.minValueInArray(bigNumberArray), Integer.MAX_VALUE);
    }
}
