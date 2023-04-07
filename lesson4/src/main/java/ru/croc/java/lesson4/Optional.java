package ru.croc.java.lesson4;

public class Optional<T> {
    private T value;

    public void f() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        new Optional<String>();
    }
}
