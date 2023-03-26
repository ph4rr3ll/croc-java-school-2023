package ru.croc.javaschool.lesson3.var;

/**
 * Класс для демонстрации работы автоматического определения
 * типа переменной.
 *
 * @author vkhlybov
 */
public class VarExample {

    // Не скомпилируется
    /* var someString = "String"; */

    public void visualBenefitDemo() {
        SomeClassWithVeryVeryLongTitleButUselessAtAll objectWithVeryVeryLongTitleButUselessAtAll = new SomeClassWithVeryVeryLongTitleButUselessAtAll();
        var anotherObjectWithVeryVeryLongTitleButUselessAtAll = new SomeClassWithVeryVeryLongTitleButUselessAtAll();
        var thirdObjectWithVeryVeryLongTitleButUselessAtAll = SomeClassWithVeryVeryLongTitleButUselessAtAll.createEmptyObject();
    }

    public void usageDemo() {
        var intNumber = 1;
        var longNumber = 1;
        var floatNumber = 1;
        var doubleNumber = 1;

        var anotherIntNumber = 1;
        var anotherLongNumber = 1L;
        var anotherFloatNumber = 1F;
        var anotherDoubleNumber = 1D;

        var someString = "Some String";

        var nullString = (Object) null;

        nullString = "Some";
        ((String) nullString).toLowerCase();

        if (nullString instanceof String) {
            ((String) nullString).toLowerCase();
        }

        var letters = new String[] {"A", "B", "C", "D"};
        for (var letter : letters) {
            System.out.println(letter);
        }
    }
}

class SomeClassWithVeryVeryLongTitleButUselessAtAll {

    public static SomeClassWithVeryVeryLongTitleButUselessAtAll createEmptyObject() {
        return new SomeClassWithVeryVeryLongTitleButUselessAtAll();
    }

}
