package edu.hw3.task6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {

    @Test
    @DisplayName("Add and get mostValuableStock methods test")
    public void test1() {

        Stock newStock = new Stock(4345435.44, "Tinkoff");
        StockMarket market = new StockMarketDefault();

        market.add(newStock);

        Assertions.assertThat(market.mostValuableStock()).isEqualTo(newStock);
    }

    @Test
    @DisplayName("Add multiple and get mostValuableStock methods test")
    public void test2() {

        Stock newStock1 = new Stock(44, "Tinkoff");
        Stock newStock2 = new Stock(45.444, "Tinkoff");
        Stock newStock3 = new Stock(4345.44, "Tinkoff");
        Stock newStock4 = new Stock(4344, "Tinkoff");
        Stock newStock5 = new Stock(43.44, "Tinkoff");
        StockMarket market = new StockMarketDefault();

        market.add(newStock1);
        market.add(newStock2);
        market.add(newStock3);
        market.add(newStock4);
        market.add(newStock5);

        Assertions.assertThat(market.mostValuableStock()).isEqualTo(newStock3);
    }

    @Test
    @DisplayName("Remove and add multiple and get mostValuableStock methods test")
    public void test3() {

        Stock newStock1 = new Stock(44, "Tinkoff");
        Stock newStock2 = new Stock(45.444, "Tinkoff");
        Stock newStock3 = new Stock(4345.44, "Tinkoff");
        Stock newStock4 = new Stock(4344, "Tinkoff");
        Stock newStock5 = new Stock(43.44, "Tinkoff");
        StockMarket market = new StockMarketDefault();

        market.add(newStock1);
        market.add(newStock2);
        market.add(newStock3);
        market.add(newStock4);
        market.add(newStock5);

        Assertions.assertThat(market.mostValuableStock()).isEqualTo(newStock3);
        market.remove(newStock3);
        Assertions.assertThat(market.mostValuableStock()).isEqualTo(newStock4);
        market.remove(newStock4);
        Assertions.assertThat(market.mostValuableStock()).isEqualTo(newStock2);
    }
}
