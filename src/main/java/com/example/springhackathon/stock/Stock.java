package com.example.springhackathon.stock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {
    /*int id;
    String stockTicker;
    double price;
    int volume;
    String buyOrSell;
    int statusCode;*/
    // Id - needed with @Entity
    @Id
    // Generate primary keys
    @GeneratedValue
    private Long id;
    private String stockTicker;
    private double price;
    private int volume;
    private String buyOrSell;
    private int statusCode;


    public Stock() {
    }

    public Stock(Long id, String stockTicker, double price, int volume, String buyOrSell, int statusCode) {
        this.id = id;
        this.stockTicker = stockTicker;
        this.price = price;
        this.volume = volume;
        this.buyOrSell = buyOrSell;
        this.statusCode = statusCode;
    }

    public Long getId() {
        return id;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public String getBuyOrSell() {
        return buyOrSell;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
