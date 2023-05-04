package ru.croc.school.java.lesson7;

import java.util.Random;

public class MyThread extends Thread {
    private String name;
    private int param;

    public MyThread(String name) {
        super(name);
        this.name = name;
    }public MyThread(int param) {
        this.param = param;
    }

    public MyThread() {
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Math.abs(new Random().nextInt() % 10000));
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("Новый поток! Thread:" + Thread.currentThread().getName() + "  Параметр: " + param);
    }

    public static void main(String[] args) {
        System.out.println("Основной поток! Thread:" + Thread.currentThread().getName());
        new MyThread("").start();
        new MyThread("").start();
        new MyThread(5).start();
        new MyThread("Alex Thread").start();
        new MyThread().start();
        new MyThread().start();
        new MyThread(7).start();
        new MyThread().start();
    }
}
