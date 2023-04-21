package ru.croc.school.java.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IncLock {
    static Lock lock = new ReentrantLock();
    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        final List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100_000; i++) {
                        try {
                            lock.lock();
                            a++;
                        } finally {
                            lock.unlock();
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
