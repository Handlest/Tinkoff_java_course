package edu.hw8;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Task1Test {
    @Test
    void testClientLogic() {
        ClientInterface mockClient = mock(ClientInterface.class);
        when(mockClient.sendRequest("личности")).thenReturn("Не переходи на личности там, где их нет");
    }
}
