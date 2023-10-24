package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int SUCCESS_CODE = 1;
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public int updatePackages() {
        return tryExecute("apt update && apt upgrade -y");
    }

    private int tryExecute(String command) {
        int attemptsCount = 0;
        while (true) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                LOGGER.trace("Connection established. Command completed successfully");
                return SUCCESS_CODE;
            } catch (Exception ex) {
                if (++attemptsCount >= maxAttempts) {
                    LOGGER.trace("Exceeded attempts limit...");
                    throw new ConnectionException(ex);
                }
            }
        }
    }
}
