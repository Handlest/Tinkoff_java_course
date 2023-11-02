package edu.hw3.task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StockMarketDefault implements StockMarket {
    private final PriorityQueue<Stock> stockPriorityQueue =
        new PriorityQueue<>(Comparator.comparingDouble(Stock::getPrice).reversed());

    @Override
    public void add(Stock stock) {
        stockPriorityQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockPriorityQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockPriorityQueue.peek();
    }
}
