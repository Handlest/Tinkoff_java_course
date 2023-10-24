package edu.hw2.task3;

import java.util.Random;

public class FaultyConnectionManager implements ConnectionManager {

    private Random random;

    FaultyConnectionManager() {
        this.random = new Random();
    }

    FaultyConnectionManager(int seed) {
        this.random = new Random(seed);
    }

    public Connection getConnection() {
        return new FaultyConnection(this.random);
    }
}
