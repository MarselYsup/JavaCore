package io.ylab.task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    @Test
    void checkTrueResult() {
        assertTrue(Main.fuzzySearch("abc", "ahbdgc"));
    }


    @Test
    void checkFalseResult() {
        assertFalse(Main.fuzzySearch("axc", "ahbgdc"));
    }

    @Test
    void checkIfSeqIsEmpty() {
        assertTrue(Main.fuzzySearch("", "sagfsafas"));
    }

    @Test
    void checkTrueWithLongString() {
        assertTrue(Main.fuzzySearch("hello", "fasfashsadjfajsdnenjnasjcnjalcasjcalcasjcasocsa"));
    }

    @Test
    void checkIfOriginalLineIsEmpty() {
        assertFalse(Main.fuzzySearch("fsafas", ""));
    }

    @Test
    void checkIfSeqIsNull() {
        assertFalse(Main.fuzzySearch(null, "Hello"));
    }

    @Test
    void checkIfOriginalLineIsNull() {
        assertFalse(Main.fuzzySearch("cat", null));
    }

}
