package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final static int CHANCE = 3; // 25% chance
    Random random = new Random();

    public Connection getConnection() {
        return random.nextInt(CHANCE) == 0 ? new FaultyConnection() : new StableConnection();
    }
}
