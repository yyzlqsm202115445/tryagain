package com.example.springhackathon.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;


    @GetMapping("/stocks/findAll")
    CollectionModel<EntityModel<Stock>> findAll(){
        return stockService.findAll();
    }
    @GetMapping("/stocks/findById/{id}")
    EntityModel<Stock> findById(@PathVariable Long id){
        return stockService.findById(id);
    }

    @PostMapping("/stocks/save")
    ResponseEntity<?> newStock(@RequestBody Stock stock) {
        return stockService.newStock(stock);
    }


    @PostMapping("/stocks/findallbyid")
    List<Stock> findAllById(@RequestBody List<Long> id){
        return stockService.findAllById(id);
    }

    @GetMapping("/stocks/count")
    long count(){return stockService.count();}

    @DeleteMapping("/stocks/deleteByID/{id}")
    public void deleteByID(@PathVariable Long id) {
        stockService. deleteById(id);
    }

    @DeleteMapping("/stocks/DeleteAllBatch")
    public void deleteAllBatch() {
        stockService.deleteAllBatch();
    }
    @PutMapping("/stocks/update/{id}")
    public ResponseEntity<?> updateStock(@RequestBody Stock newStock, @PathVariable Long id){
        return stockService.updateStock(newStock,id);
    }


}
