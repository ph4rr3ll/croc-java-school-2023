package ru.croc.javaschool.lesson3.oop.example;

/**
 * Квадрат.
 */
public class Square extends Shape implements Drawable {

    public Square(double sideSize,
                  String color) {
        super(color);
        this.sideSize = sideSize;
    }

    public Square(double sideSize) {
        this.sideSize = sideSize;
    }

    private double sideSize;

    public double getSideSize() {
        return sideSize;
    }

    @Override
    public double calculateArea() {
        return sideSize * sideSize;
    }

    @Override
    public double calculatePerimeter() {
        return sideSize * 4;
    }

    @Override
    public Square getItself() {
        return this;
    }

    @Override
    public void draw() {
        System.out.println("Drawn!");
    }
}







