package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class myArrayListTest {
    private final myArrayList out = new myArrayList(4);

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
    public void removeTest1(){
        out.add("for_test");
        out.add("for_test1");
        out.add("for_test");
        out.add("for_test1");
//        out.remove("for_test");
        out.remove("for_test1");
        Assertions.assertThrows(RuntimeException.class,() -> out.get(3));
//        out.remove("for_test");
        Assertions.assertEquals(out.get(0), "for_test1");
//        Assertions.assertTrue(out.isEmpty());
    }


    @Test
    public void removeTest2(){
        out.add("for_test");
        out.add("for_test1");
        out.add("for_test");
        out.add("for_test");
        out.remove(3);
        Assertions.assertThrows(RuntimeException.class,() -> out.get(3));
        out.remove(0);
        Assertions.assertEquals(out.get(0), "for_test1");


    }


}
