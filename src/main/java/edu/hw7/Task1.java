package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();
    private static final AtomicInteger COUNTER = new AtomicInteger();
    private static final int GOAL = 1000;

    private Task1() {

    }

    public static int twoThreadsOneCounter() {
        Thread thread1 = new Thread(() -> {
            while (COUNTER.incrementAndGet() < GOAL - 1) {
                LOGGER.info("first thread");
            }
        });

        Thread thread2 = new Thread(() -> {
            while (COUNTER.incrementAndGet() < GOAL - 1) {
                LOGGER.info("second thread");
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            LOGGER.error("Thread interrupted", e);
        }

        return COUNTER.get();
    }
}
