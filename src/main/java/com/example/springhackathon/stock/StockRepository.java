package com.example.springhackathon.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface StockRepository extends JpaRepository<Stock, Long>,QueryByExampleExecutor<Stock>{
}

