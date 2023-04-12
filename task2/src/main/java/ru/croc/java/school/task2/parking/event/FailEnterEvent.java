package ru.croc.java.school.task2.parking.event;

import ru.croc.java.school.task2.auto.Car;
import ru.croc.java.school.task2.parking.Enter;

import java.time.LocalDateTime;

/**
 * Событие неудачного въезда.
 */
public class FailEnterEvent {
    /** Автомобиль. */
    private final Car car;
    /** Въезд. */
    private final Enter enter;
    /** Время попытки. */
    private final LocalDateTime time;

    public FailEnterEvent(Car car, Enter enter, LocalDateTime time) {
        this.car = car;
        this.enter = enter;
        this.time = time;
    }

    public Car getCar() {
        return car;
    }

    public Enter getEnter() {
        return enter;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
