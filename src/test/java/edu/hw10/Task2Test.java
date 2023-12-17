package edu.hw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Task2Test {
    private final static Logger LOGGER = LogManager.getLogger();
    @Test
    @DisplayName("Работоспособность классов")
        void Test1(){
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class, true);

        long result = proxy.fib(5);
        LOGGER.info("Result: " + result);
    }

    @Test
    @DisplayName("Вычисления калькулятора чисел фиббоначи")
    void testFibonacciCalculation() {
        FibCalculator fibCalculator = new FibCalculatorImpl();

        assertEquals(2, fibCalculator.fib(3));
        assertEquals(3, fibCalculator.fib(4));
        assertEquals(5, fibCalculator.fib(5));
        assertEquals(8, fibCalculator.fib(6));
        assertEquals(13, fibCalculator.fib(7));
    }

    @Test
    @DisplayName("Сохранение значений в кэше")
    void testCaching() {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class);

        // Расчёт и добавление в кэш
        long result1 = proxy.fib(3);
        assertEquals(2, result1);

        // Второй вызов со значением из кэша
        long result2 = proxy.fib(3);
        assertEquals(result1, result2);

        // Проверка для другого значения
        long result3 = proxy.fib(5);
        assertNotEquals(result1, result3);

        long result4 = proxy.fib(5);
        assertEquals(result3, result4);
    }

    @Test
    @DisplayName("Тестирование с persist = true")
    void testPersisting() {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class, true);

        // Вызов, который должен сохранить результат на диск (если persist=true)
        long result1 = proxy.fib(4);

        // Пересоздаем прокси, чтобы удостовериться, что результат можно получить из кэша на диске
        FibCalculator proxy2 = CacheProxy.create(fibCalculator, FibCalculator.class, true);

        // Второй вызов с теми же аргументами должен возвращать сохраненное значение из кэша
        long result2 = proxy2.fib(4);
        assertEquals(result1, result2);
    }
}
