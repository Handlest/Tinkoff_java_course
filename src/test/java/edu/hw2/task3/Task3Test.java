package edu.hw2.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    private static final int SEED = 12;
    private static final int SEED_FOR_TEST_4 = 1;

    private static final int SEED_FOR_TEST_5 = 2;

    @Test
    @DisplayName("Проверка исключения PopularCommandExecutor с Faulty connection manager")
    public void Test1WithFaultyConnectionManager() {
        PopularCommandExecutor pce = new PopularCommandExecutor(new FaultyConnectionManager(SEED), 4);
        assertThrows(ConnectionException.class, pce::updatePackages);
    }

    @Test
    @DisplayName("Проверка успешной работы PopularCommandExecutor Default connection manager")
    public void Test2WithDefaultConnectionManager() {

        PopularCommandExecutor pce = new PopularCommandExecutor(new DefaultConnectionManager(SEED), 4);
        assertThat(pce.updatePackages()).isEqualTo(1);
    }

    @Test
    @DisplayName("Тип возвращаемого значения FaulyConnectionManager всегда FaultyConnection")
    public void Test3FaultyConnectionManagerReturnValue() {
        Connection connection = new FaultyConnectionManager().getConnection();
        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }

    @Test
    @DisplayName("Тип возвращаемого значения DefaultConnectionManager может быть FaultyConnection")
    public void Test4FaultyConnectionWithDefaultManagerReturnValue() {
        Connection connection = new DefaultConnectionManager(SEED_FOR_TEST_4).getConnection();
        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }

    @Test
    @DisplayName("Тип возвращаемого значения DefaultConnectionManager может быть DefaultConnection")
    public void Test5StableConnectionWithDefaultManagerReturnValue() {
        Connection connection = new DefaultConnectionManager(SEED_FOR_TEST_5).getConnection();
        assertThat(connection).isInstanceOf(StableConnection.class);
    }
}
