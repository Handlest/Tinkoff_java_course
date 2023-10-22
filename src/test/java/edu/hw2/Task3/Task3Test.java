package edu.hw2.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    @Test
    @DisplayName("Проверка Faulty connection manager")
    public void Test1WithFaultyConnectionManager() {
        PopularCommandExecutor pce = new PopularCommandExecutor(new FaultyConnectionManager(), 4);
        assertThrows(ConnectionException.class, pce::updatePackages);
    }

    @Test
    @DisplayName("Проверка Default connection manager")
    public void Test2WithDefaultConnectionManager() {
        PopularCommandExecutor pce = new PopularCommandExecutor(new DefaultConnectionManager(), 4);
        assertThat(pce.updatePackages()).isEqualTo(1);
    }

    // Как лучше всего тестировать такие случайные значения? Иногда эти тесты падают из-за рандома

    @Test
    @DisplayName("Тип возвращаемого значения всегда FaultyConnection")
    public void Test3FaulyConnectionManagerReturnValue() {
        Connection connection = new FaultyConnectionManager().getConnection();
        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }
}
