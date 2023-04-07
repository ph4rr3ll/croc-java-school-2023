package ru.croc.java.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathTest {
    private Math math;

    @BeforeAll
    public static void initAll() {
        System.out.println("hello");
    }

    @BeforeEach
    public void init() {
        math = new Math();
    }

    @Test
    public void testSumTwoPlusTwo() {
        Assertions.assertEquals(4, math.sum(2, 2));
    }

    @Test
    public void testSumTwoPlusZero() {
        Assertions.assertEquals(2, math.sum(2, 0));
        Assertions.assertTrue(math instanceof Math);
    }
}
