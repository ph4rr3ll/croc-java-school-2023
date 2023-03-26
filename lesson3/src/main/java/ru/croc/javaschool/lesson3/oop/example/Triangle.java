package ru.croc.javaschool.lesson3.oop.example;

/**
 * Треугольник.
 */
public class Triangle extends Shape {

    public Triangle(double firstSideSize,
                    double secondSideSize,
                    double thirdSideSize,
                    String color) {
        super(color);
        this.firstSideSize = firstSideSize;
        this.secondSideSize = secondSideSize;
        this.thirdSideSize = thirdSideSize;
    }

    public Triangle(double firstSideSize,
                    double secondSideSize,
                    double thirdSideSize) {
        this.firstSideSize = firstSideSize;
        this.secondSideSize = secondSideSize;
        this.thirdSideSize = thirdSideSize;
    }

    private double firstSideSize;

    private double secondSideSize;

    private double thirdSideSize;

    public double getFirstSideSize() {
        return firstSideSize;
    }

    public double getSecondSideSize() {
        return secondSideSize;
    }

    public double getThirdSideSize() {
        return thirdSideSize;
    }

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    protected double calculatePerimeter() {
        return 0;
    }
}
