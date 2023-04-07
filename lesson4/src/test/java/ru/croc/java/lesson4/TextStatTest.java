package ru.croc.java.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TextStatTest {

    @Test
    public void test() {
        Map<String, Integer> stat = new TextStat().countWords("c bb c aaa bb c");
        Assertions.assertEquals(1, stat.get("aaa"));
        Assertions.assertEquals(2, stat.get("bb"));
        Assertions.assertEquals(3, stat.get("c"));
    }
}

