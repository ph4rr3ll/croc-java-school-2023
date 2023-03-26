package ru.croc.javaschool.lesson3.oop.example;

/**
 * Геометрическая фигура.
 */
public abstract class Shape {

    /**
     * Цвет.
     */
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public Shape() {
        this(Color.BLACK);
    }

    public String getColor() {
        return color;
    }

    public abstract double calculateArea();

    protected abstract double calculatePerimeter();

    public Shape getItself() {
        return this;
    }
}




