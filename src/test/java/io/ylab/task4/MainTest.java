package io.ylab.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void checkSimpleExample() {
        assertArrayEquals(Main.findCoupleWithCurrentSum(new int[]{1,2,3,4,5,6,7,8,9,10}, 10), new int[] {4,6});
    }

    @Test
    void checkIfNoAnswer() {
        assertArrayEquals(Main.findCoupleWithCurrentSum(new int[] {1, 2, 3, 4, 5}, 20), new int[0]);
    }

    @Test
    void checkIfArrayEmpty() {
        assertArrayEquals(Main.findCoupleWithCurrentSum(new int[0], 10), new int[0]);
    }

    @Test
    void checkIfArrayNull() {
        assertArrayEquals(Main.findCoupleWithCurrentSum(null, 10), new int[0]);
    }

    @Test
    void checkFirstCoupleOfCurrentSum() {
        assertArrayEquals(Main.findCoupleWithCurrentSum(new int[]{1, 3, 5, 5, 7, 2, 10}, 10), new int[]{5, 5});
    }
}
