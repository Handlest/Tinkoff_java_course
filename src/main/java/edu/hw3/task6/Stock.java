package edu.hw3.task6;

public class Stock {
    private double price;
    private final String stockName;

    public Stock(double price, String stockName) {
        this.price = price;
        this.stockName = stockName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStockName() {
        return stockName;
    }
}
