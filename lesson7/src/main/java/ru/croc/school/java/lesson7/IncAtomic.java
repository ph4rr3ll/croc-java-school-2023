package ru.croc.school.java.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IncAtomic {
    static AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int errorsNum = 0;
                    for (int i = 0; i < 100_000; i++) {
//                        a.incrementAndGet();
                        boolean casRes = false;
                        do {
                            int oldValue = a.intValue();
                            int newValue = oldValue + 1;
                            casRes = a.compareAndSet(oldValue, oldValue + 1);
                            if (!casRes) {
                                errorsNum++;
                            }
                        } while (!casRes);
                    }
                    System.out.println("Errors: " + errorsNum + " for Thread: " + Thread.currentThread().getName());
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
