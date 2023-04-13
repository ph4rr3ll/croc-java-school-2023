package ru.croc.java.school.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Проверяем аннотацию {@link UpperCaseAnnotation}.
 */
public class UpperCaseAnnotationTest {
    @Test
    public void testWithUpperCaseLengthDefault() {
        final Convertable convertable = new TestConvertableWithUpperCaseAnnotation();
        final String actual = new StringConverter().convert(convertable);
        Assertions.assertEquals("AaAaa", actual);
    }

    @Test
    public void testWithUpperCaseLength4() {
        final Convertable convertable = new TestConvertableWithUpperCaseAnnotationLength4();
        final String actual = new StringConverter().convert(convertable);
        Assertions.assertEquals("AAAAa", actual);
    }

    @Test
    public void testWithUpperCaseLength6() {
        final Convertable convertable = new TestConvertableWithUpperCaseAnnotationLength6();
        final String actual = new StringConverter().convert(convertable);
        Assertions.assertEquals("AAAAA", actual);
    }

    @Test
    public void testWithoutUpperCase() {
        final Convertable convertable = new TestConvertableWithoutUpperCaseAnnotation();
        final String actual = new StringConverter().convert(convertable);
        Assertions.assertEquals("aaAaa", actual);
    }


    @UpperCaseAnnotation
    static class TestConvertableWithUpperCaseAnnotation implements Convertable {

        @Override
        public String getValue() {
            return "aaAaa";
        }
    }


    @UpperCaseAnnotation(length = 4)
    static class TestConvertableWithUpperCaseAnnotationLength4 implements Convertable {

        @Override
        public String getValue() {
            return "aaAaa";
        }
    }


    @UpperCaseAnnotation(length = 6)
    static class TestConvertableWithUpperCaseAnnotationLength6 implements Convertable {

        @Override
        public String getValue() {
            return "aaAaa";
        }
    }

    static class TestConvertableWithoutUpperCaseAnnotation implements Convertable {

        @Override
        public String getValue() {
            return "aaAaa";
        }
    }
}
