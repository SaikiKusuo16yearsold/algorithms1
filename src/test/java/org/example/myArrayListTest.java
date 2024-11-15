package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class myArrayListTest {
    private final myArrayList out = new myArrayList(4);
    private final myArrayList out1 = new myArrayList(0);

    @BeforeEach
    void setUp() {
        out.clear();
    }

    @Test
    public void isEmptyTest() {
        boolean result = out.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void addTest() {
        out.add("for_test");
        assertEquals(out.get(0), "for_test");
        out.add("for_test1");
        assertEquals(out.get(1), "for_test1");
    }

    @Test
    public void removeTest1() {
        out.add("for_test");
        out.add("for_test1");
        out.add("for_test");
        out.add("for_test1");
        out.remove("for_test1");
        Assertions.assertThrows(RuntimeException.class, () -> out.get(3));
        out.remove("for_test");
        Assertions.assertEquals(out.get(0), "for_test");

    }


    @Test
    public void removeTest2() {
        out.add("for_test");
        out.add("for_test1");
        out.add("for_test");
        out.add("for_test");
        out.remove(2);
        Assertions.assertThrows(RuntimeException.class, () -> out.get(3));
        out.remove(0);
        Assertions.assertEquals(out.get(0), "for_test1");


    }

    @Test
    public void containsTest() {
        out.add("for_test");
        out.add("for_test1");
        assertTrue(out.contains("for_test1"));
        assertFalse(out.contains("for_test245"));
    }

    @Test
    public void getTest() {
        assertThrows(RuntimeException.class, () -> out.get(0));
        out.add("for_test1");
        assertEquals("for_test1", out.get(0));
        assertThrows(RuntimeException.class, () -> out.get(3));
    }

    @Test
    public void sizeTest() {
        out.add("for_test1");
        assertEquals(out.size(), 1);

    }

    @Test
    public void setTest() throws IllegalAccessException {
        out.add("for_test1");
        out.add("for_test2");
        out.set(1, "new_value");
        assertEquals("new_value", out.get(1));
        assertThrows(IllegalAccessException.class, () -> out.set(2, "new_value"));
    }

    @Test
    public void indexOfTest() {
        out.add("for_test1");
        out.add("for_test2");
        out.add("for_test3");
        out.add("for_test3");
        assertEquals(out.indexOf("for_test8"), -1);
        assertEquals(out.indexOf("for_test3"), 2);
    }


    @Test
    public void lastIndexOfTest() {
        out.add("for_test1");
        out.add("for_test2");
        out.add("for_test3");
        out.add("for_test3");
        assertEquals(out.lastIndexOf("for_test3"), 3);
        assertEquals(out.lastIndexOf("for_test8"), -1);
    }

    @Test
    void testToArrayModifiesOriginalArray() {

        out.add("one");
        out.add("two");


        String[] result = out.toArray();


        assertEquals("one", result[0]);
    }

    @Test
    public void addTest1() {
        out.add("for_test1");
        out.add("for_test2");
        out.add("for_test4");
        out.add("for_test5");
        out.add(0, "for_test3");
        assertEquals(out.get(3), "for_test4");
    }

    @Test
    public void equalsTest() {
        out.add("for_test1");
        out1.add("for_test1");
        Assertions.assertTrue(out.equals(out1));
    }


}
