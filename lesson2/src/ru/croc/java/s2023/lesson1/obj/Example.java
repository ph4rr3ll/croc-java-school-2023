package ru.croc.java.s2023.lesson1.obj;

class Example {
    {
        System.out.println("3");
    }
    static {
        System.out.println("1");
    }

    public Example() {
        System.out.println("4");
    }

    public static void main(String[] args) {
        System.out.println("2");
        new Example();
        System.out.println("5");
    }
}