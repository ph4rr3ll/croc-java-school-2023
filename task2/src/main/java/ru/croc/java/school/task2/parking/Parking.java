package ru.croc.java.school.task2.parking;

import ru.croc.java.school.task2.auto.Car;
import ru.croc.java.school.task2.parking.event.FailEnterEvent;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Парковака.
 */
public class Parking {
    /** Количество свободных мест. */
    private final int size;
    /** Въезды. */
    private final Enter[] enters;
    /** Выезды. */
    private final Exit[] exits;
    /** Автомобили. */
    private Car[] cars;
    /** Неудачные попытки въезда. */
    private FailEnterEvent[] failEnterEvents;

    /**
     * Конструктор.
     *
     * @param size максимальное количество мест
     * @param enters выъезды
     * @param exits выезды
     */
    public Parking(int size, Enter[] enters, Exit[] exits) {
        this.size = size;
        this.enters = enters;
        this.exits = exits;
        this.cars = new Car[] {};
        this.failEnterEvents = new FailEnterEvent[] {};
    }


    /**
     * Въезд переданного автомобиля на переданную парковку.
     *
     * @param enter въезд
     * @param car автобиль
     * @return true, если заехать получилось
     */
    public boolean enter(Enter enter, Car car) {
        if (!canEnter(enter, car)) {
            failEnterEvents = Arrays.copyOf(failEnterEvents, failEnterEvents.length + 1);
            failEnterEvents[failEnterEvents.length - 1] = new FailEnterEvent(car, enter, LocalDateTime.now());
            return false;
        }

        cars = Arrays.copyOf(cars, cars.length + 1);
        cars[cars.length - 1] = car;
        enter.addCar(car);
        return true;
    }

    /**
     * Все въезды.
     * @return въезды
     */
    public Enter[] getEnters() {
        return enters.clone();
    }

    /**
     * Все выезда.
     * @return выезды
     */
    public Exit[] getExits() {
        return exits.clone();
    }

    /**
     * Автомобили находящиеся на парковке.
     * @return автомобили
     */
    public Car[] getCars() {
        return cars.clone();
    }

    public int getSize() {
        return size;
    }

    /**
     * Все неудачные попытки въезда.
     * @return неудачные попытки въезда
     */
    public FailEnterEvent[] getFailEnterEvents() {
        return failEnterEvents.clone();
    }

    /**
     * Выезд автомобиля через указанный выезд.
     *
     * @param exit выезд
     * @param car автомобиль
     * @return true, если выезд прошел успешно
     */
    public boolean exit(Exit exit, Car car) {
        final boolean exitsIsExist = Arrays.stream(exits).anyMatch(parkingExit -> parkingExit == exit);
        final boolean carInParking = Arrays.stream(cars).anyMatch(parkedCar -> parkedCar == car);
        if (!carInParking || !exitsIsExist) {
            return false;
        }
        // удалили автомобиль из массива
        cars = Arrays.asList(cars).stream()
                .filter(x -> x != car)
                .collect(Collectors.toList())
                .toArray(new Car[cars.length - 1]);
        exit.addCar(car);

        return true;
    }

    /**
     * Определяет сможет ли автомобиль заехать на парковку.
     *
     * @param enter въезд
     * @param car автомобиль
     * @return true, если да
     */
    public boolean canEnter(Enter enter, Car car) {
        final boolean carInParking = Arrays.stream(cars).anyMatch(parkedCar -> parkedCar == car);
        final boolean enterIsExist = Arrays.stream(enters).anyMatch(parkingEnter -> parkingEnter == enter);
        return cars.length < size && enterIsExist && !carInParking;
    }

    /**
     * Количество свободных мест.
     * @return количетсво мест
     */
    public int numberFreeSpaces() {
        return size - cars.length;
    }
}
