package edu.hw3.task6;

public class Stock {
    private double price;
    private final String stockName;

    public Stock(float price, String stockName) {
        this.price = price;
        this.stockName = stockName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStockName() {
        return stockName;
    }
}
