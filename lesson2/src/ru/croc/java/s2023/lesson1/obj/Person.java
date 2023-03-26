package ru.croc.java.s2023.lesson1.obj;

import java.lang.Object;

/**
 * Человек.
 *
 * @author Alexander Golovin
 */
public class Person extends Object {
    /** Имя. */
    private String name = "Bob";
    /** Возраст. */
    private int age = 19;
//    Person person;


    /**
     * Создает {@link Person}.
     *
     * @param name имя
     * @param age возраст
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Создает {@link Person}.
     *
     * @param name имя
     */
    public Person(String name) {
//        this(name, 18);
    }



    /**
     * Выводит в консоль сообщение, если в системе
     * больше двух процессоров.
     */
    public static void f() {
        if (Runtime.getRuntime().availableProcessors() < 2) {
            return;
        }
        System.out.println("Процессоров >= 2");
    }

    /**
     * Выводит в консоль сообщение, если в системе
     * больше заданного числа процессоров.
     *
     * @param processorsNumber число процессоров
     */
    public static void f(int processorsNumber) {
        if (Runtime.getRuntime().availableProcessors() < processorsNumber) {
            return;
        }
        System.out.println("Процессоров >= " + processorsNumber);
    }

    /**
     * Выводит в консоль сообщение, если в системе
     * больше заданного числа процессоров.
     *
     * @param processorsNumber число процессоров
     */
    public static void f(long processorsNumber) {
        if (Runtime.getRuntime().availableProcessors() < processorsNumber) {
            return;
        }
        System.out.println("Процессоров >= " + processorsNumber);
    }

    /**
     * Имя.
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя.
     *
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возраст.
     *
     * @return возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Устанавливает возраст.
     *
     * @param age возраст.
     */
    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person("Alex", 99);
        System.out.println(person.name + " => " + person.age);


        Person.f(5);
    }
}
