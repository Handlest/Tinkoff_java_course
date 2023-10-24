package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    private final static int CHANCE = 3; // 25% chance

    private final Random random;

    DefaultConnectionManager(long seed) {
        random = new Random(seed);
    }

    DefaultConnectionManager() {
        random = new Random();
    }

    public Connection getConnection() {
        return random.nextInt(CHANCE) == 0 ? new FaultyConnection(random) : new StableConnection();
    }
}
