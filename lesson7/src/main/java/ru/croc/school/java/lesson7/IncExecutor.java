package ru.croc.school.java.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IncExecutor {
    static Object lock = new Object();
    static int a = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final List<Future<?>> futures = new ArrayList<>();
        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            final Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100_000; i++) {
                        synchronized (lock) {
                            a++;
                        }
                    }
                }
            };
            futures.add(executorService.submit(task));
        }

        for (Future future : futures) {
            future.get();
        }
        executorService.shutdown();
        System.out.println(a);
    }

}
