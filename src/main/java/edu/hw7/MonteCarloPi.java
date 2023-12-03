package edu.hw7;

import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MonteCarloPi {

    private MonteCarloPi() {

    }

    private static final int NUM_SIMULATIONS = 10_000_000;
    private static final int ONE_HUNDRED_MILLION = 100_000_000;
    private static final int ONE_BILLION = 1_000_000_000;
    private static final int CORES_AMOUNT = 8;

    private static final double FOUR_FOR_FORMULA = 4.0;
    private final static Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("MultipleStringLiterals")
    public static void countPi() {
        long startTime = System.currentTimeMillis();
        double piSingleThread = calculatePiSingleThread(NUM_SIMULATIONS);
        long endTime = System.currentTimeMillis();
        LOGGER.info("Однопоточная версия: pi = " + piSingleThread);
        LOGGER.info("Время выполнения: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        double piMultiThread = calculatePiMultiThread(NUM_SIMULATIONS, CORES_AMOUNT);
        endTime = System.currentTimeMillis();
        LOGGER.info("Однопоточная версия: pi = " + piMultiThread);
        LOGGER.info("Время выполнения: " + (endTime - startTime) + " мс\n");

        double speedup = (double) (endTime - startTime) / (endTime - startTime);
        LOGGER.info("Выполнилось быстрее на: " + speedup);

        printError(NUM_SIMULATIONS);
        printError(ONE_HUNDRED_MILLION);
        printError(ONE_BILLION);
    }

    private static void printError(int numSimulations) {
        double actualPi = Math.PI;
        double piSingleThread = calculatePiSingleThread(numSimulations);
        double piMultiThread = calculatePiMultiThread(numSimulations, Runtime.getRuntime().availableProcessors());

        double errorSingleThread = Math.abs(actualPi - piSingleThread);
        double errorMultiThread = Math.abs(actualPi - piMultiThread);

        LOGGER.info("\nПогрешность для " + numSimulations + " симуляций:");
        LOGGER.info("Однопоточная версия: " + errorSingleThread);
        LOGGER.info("Многопоточная версия: " + errorMultiThread);
    }

    private static double calculatePiSingleThread(int numSimulations) {
        int circleCount = 0;
        for (int i = 0; i < numSimulations; i++) {
            double x = ThreadLocalRandom.current().nextDouble(-1, 1);
            double y = ThreadLocalRandom.current().nextDouble(-1, 1);
            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }
        return FOUR_FOR_FORMULA * circleCount / numSimulations;
    }

    private static double calculatePiMultiThread(int numSimulations, int numThreads) {
        int simulationsPerThread = numSimulations / numThreads;
        PiCalculationThread[] threads = new PiCalculationThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new PiCalculationThread(simulationsPerThread);
            threads[i].start();
        }
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                LOGGER.info("Поток прерван: " + e.getMessage());
            }
        }

        int totalCircleCount = 0;
        for (int i = 0; i < numThreads; i++) {
            totalCircleCount += threads[i].getCircleCount();
        }

        return FOUR_FOR_FORMULA * totalCircleCount / numSimulations;
    }

    private static class PiCalculationThread extends Thread {
        private final int numSimulations;
        private int circleCount;

        private PiCalculationThread(int numSimulations) {
            this.numSimulations = numSimulations;
        }

        @Override
        public void run() {
            for (int i = 0; i < numSimulations; i++) {
                double x = ThreadLocalRandom.current().nextDouble(-1, 1);
                double y = ThreadLocalRandom.current().nextDouble(-1, 1);
                if (x * x + y * y <= 1) {
                    circleCount++;
                }
            }
        }

        public int getCircleCount() {
            return circleCount;
        }
    }
}
