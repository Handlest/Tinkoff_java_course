package edu.hw8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;

public class Task2Test {
    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    public void test1() throws InterruptedException {
        int numThreads = 4;
        CountDownLatch latch = new CountDownLatch(10);

        try (FixedThreadPool threadPool = FixedThreadPool.create(numThreads)) {
            threadPool.start();

            for (int i = 0; i < 10; i++) {
                final int n = i;
                threadPool.execute(() -> {
                    long result = calculateFibonacci(n);
                    LOGGER.info("Fibonacci(" + n + ") = " + result);
                    latch.countDown();
                });
            }
            latch.await();
        }
    }

    private static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }
}
