package ru.croc.school.java.lesson7;

import java.util.ArrayList;
import java.util.List;

public class Inc {
    static Object lock = new Object();
    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        final List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100_000; i++) {
                        synchronized (lock) {
                            a++;
                        }
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(a);
    }

}
