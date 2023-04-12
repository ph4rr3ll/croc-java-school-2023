package ru.croc.java.school.task2.parking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.croc.java.school.task2.auto.Car;
import ru.croc.java.school.task2.parking.event.FailEnterEvent;

import java.time.LocalDateTime;

/**
 * Проверки {@link Parking}.
 */
public class ParkingTest {
    Enter enterA;
    Enter enterB;
    Exit exitA;
    Exit exitB;

    Parking parking;

    Car carX001;
    Car carX002;
    Car carX003;

    @BeforeEach
    public void init() {
        enterA = new Enter(1, "Описание 1");
        enterB = new Enter(2, "Описание 2");
        exitA = new Exit(1, "Описание 1");
        exitB = new Exit(2, "Описание 2");

        parking = new Parking(2, new Enter[]{enterA, enterB}, new Exit[]{exitA, exitB});

        carX001 = new Car("X001");
        carX002 = new Car("X002");
        carX003 = new Car("X003");
    }

    @Test
    public void testEnter() {
        // въезжает 1-й автомобиль
        Assertions.assertTrue(parking.canEnter(enterA, carX001));
        Assertions.assertTrue(parking.enter(enterA, carX001));
        Assertions.assertArrayEquals(new Car[]{carX001}, parking.getCars());
        Assertions.assertEquals(0, parking.getFailEnterEvents().length);

        // въезжает 2-й автомобиль
        Assertions.assertTrue(parking.enter(enterB, carX002));
        Assertions.assertArrayEquals(new Car[]{carX001, carX002}, parking.getCars());
        Assertions.assertEquals(0, parking.getFailEnterEvents().length);

        // 3-й автомобиль въехать не может
        {
            final LocalDateTime t0 = LocalDateTime.now();
            Assertions.assertFalse(parking.canEnter(enterA, carX003));
            Assertions.assertFalse(parking.enter(enterA, carX003));
            Assertions.assertArrayEquals(new Car[]{carX001, carX002}, parking.getCars());

            final FailEnterEvent[] actualFailsEvents = parking.getFailEnterEvents();
            Assertions.assertEquals(1, actualFailsEvents.length);
            Assertions.assertEquals(carX003, actualFailsEvents[0].getCar());
            Assertions.assertEquals(enterA, actualFailsEvents[0].getEnter());
            Assertions.assertTrue(t0.isBefore(actualFailsEvents[0].getTime()));
            Assertions.assertTrue(LocalDateTime.now().plusSeconds(1).isAfter(actualFailsEvents[0].getTime()));
        }
    }

    /**
     * Попытка въезда через несуществующий въезд.
     */
    @Test
    public void testFailNotExistEnter() {
        // въезжает 1-й автомобиль
        Assertions.assertFalse(parking.enter(new Enter(3, ""), carX001));
        Assertions.assertArrayEquals(new Car[]{}, parking.getCars());
        Assertions.assertEquals(1, parking.getFailEnterEvents().length);
    }

    /**
     * Выезд автомобиля.
     */
    @Test
    public void testExit() {
        parking.enter(enterA, carX001);
        parking.enter(enterA, carX002);
        Assertions.assertArrayEquals(new Car[]{carX001, carX002}, parking.getCars());

        Assertions.assertTrue(parking.exit(exitA, carX001));
        Assertions.assertArrayEquals(new Car[]{carX002}, parking.getCars());

        Assertions.assertFalse(parking.exit(new Exit(3, ""), carX002));
        Assertions.assertArrayEquals(new Car[]{carX002}, parking.getCars());

        Assertions.assertTrue(parking.exit(exitB, carX002));
        Assertions.assertArrayEquals(new Car[]{}, parking.getCars());

        Assertions.assertFalse(parking.exit(exitA, carX001));
    }

    /**
     * Выезд автомобиля.
     */
    @Test
    public void testNumberFreeSpaces() {
        Assertions.assertEquals(2, parking.numberFreeSpaces());
        parking.enter(enterA, carX001);
        Assertions.assertEquals(1, parking.numberFreeSpaces());
        parking.enter(enterB, carX002);
        Assertions.assertEquals(0, parking.numberFreeSpaces());
        parking.exit(exitA, carX001);
        Assertions.assertEquals(1, parking.numberFreeSpaces());
        parking.exit(exitB, carX002);
        Assertions.assertEquals(2, parking.numberFreeSpaces());
        parking.exit(exitB, carX002);
        Assertions.assertEquals(2, parking.numberFreeSpaces());
    }

    /**
     * Списки машин проехавших через въезд/выезд.
     */
    @Test
    public void testEnterAndExitLists() {
        parking.enter(enterA, carX001);
        parking.enter(enterB, carX002);
        parking.exit(exitA, carX001);
        parking.exit(exitB, carX002);
        parking.exit(exitB, carX002);
        parking.enter(enterA, carX002);

        Assertions.assertArrayEquals(new Car[] {carX001, carX002}, enterA.getCars());
        Assertions.assertArrayEquals(new Car[] {carX002}, enterB.getCars());
        Assertions.assertArrayEquals(new Car[] {carX001}, exitA.getCars());
        Assertions.assertArrayEquals(new Car[] {carX002}, exitB.getCars());
    }
}
