package edu.hw2.Task3;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int MAX_CONNECTION_ERRORS = 7;
    private static final int SOME_CONNECTION_MESSAGE_AMOUNT = 10;

    private final Random random = new Random();

    @Override
    public void execute(String command) {
        int dataTransmitted = random.nextInt(SOME_CONNECTION_MESSAGE_AMOUNT);
        LOGGER.trace("dataTransmitted:  " + dataTransmitted + " <= " + "MAX_CONNECTION_ERRORS");
        if (dataTransmitted <= MAX_CONNECTION_ERRORS) {
            throw new ConnectionException("Can`t connect to server due to faulty connection");
        }
        LOGGER.trace("Faulty connection called successfully. executed command " + command);
    }

    @Override
    public void close() {
        LOGGER.trace("Close method of faulty connection called. Ending connection");
    }
}
