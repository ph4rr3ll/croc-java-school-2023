package ru.croc.javaschool.lesson3.oop.inheritance;

public class ConstructorExamples {
}

class Parent {

    public Parent(String stringProperty) {
        this.stringProperty = stringProperty;
    }

    private String stringProperty;
}

class Child extends Parent {

    public Child(String stringProperty,
                 Integer intProperty) {
        super(stringProperty);
        this.intProperty = intProperty;
    }

    private Integer intProperty;
}