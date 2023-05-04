package ru.croc.school.java.lesson7;

public class MyRunnable implements Runnable {
    private int param;

    public MyRunnable(int param) {
        this.param = param;
    }

    public MyRunnable() {
    }

    @Override
    public void run() {
        System.out.println("Поток через runnable  " + param);
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
    }
}
