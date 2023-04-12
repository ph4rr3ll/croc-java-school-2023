package ru.croc.java.school.task2.parking;

import ru.croc.java.school.task2.auto.Car;

import java.util.Arrays;

/**
 * Въезд.
 */
public class Enter {
    /** Номер. */
    private int number;
    /** Описание. */
    private String definition;
    /** Проехавшие машины. */
    private Car[] cars;

    /**
     * Конструктор.
     *
     * @param number номер
     * @param definition описание
     */
    public Enter(int number, String definition) {
        this.number = number;
        this.definition = definition;
        this.cars = new Car[] {};
    }

    /**
     * Добавляет автомобиль в списко проехавших.
     * @param car автомобиль
     */
    public void addCar(Car car) {
        cars = Arrays.copyOf(cars, cars.length + 1);
        cars[cars.length - 1] = car;
    }

    public int getNumber() {
        return number;
    }

    public String getDefinition() {
        return definition;
    }

    public Car[] getCars() {
        return cars;
    }
}
