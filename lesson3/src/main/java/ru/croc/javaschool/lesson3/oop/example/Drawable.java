package ru.croc.javaschool.lesson3.oop.example;

import java.io.Serializable;

public interface Drawable extends Serializable {

    /**
     * Пример абстрактного метода.
     */
    void draw();

    default void drawByDefault() {
        System.out.println("Default drawing");
    }

    private void drawInPrivate() {
        System.out.println("Private drawing");
    }
}




