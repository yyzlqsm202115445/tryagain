package com.example.springhackathon.stock;

public class StockNotFoundException extends RuntimeException{
    StockNotFoundException(Long id){
        super("Could not find stock " + id);
    }
}
