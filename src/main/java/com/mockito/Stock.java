package com.mockito;

public class Stock {

    private String stockId;
    private String stockName;
    private int quantity;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }


    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Stock(String stockId, String stockName, int quantity) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.quantity = quantity;
    }

}
