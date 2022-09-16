package com.example.springhackathon.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockModelAssembler assembler;

    public CollectionModel<EntityModel<Stock>> findAll() {
        List<EntityModel<Stock>> stocks = stockRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(stocks,
                linkTo(methodOn(StockService.class).findAll()).withSelfRel());
    }

    public List<Stock> findAllById(List<Long> id) {
        return stockRepository.findAllById(id);
    }
    public EntityModel<Stock> findById(Long id){
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException(id));
        return assembler.toModel(stock);
    }

    public ResponseEntity<?> newStock(Stock newStock) {
        EntityModel<Stock> entityModel = assembler.toModel(stockRepository.save(newStock));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    
    }

    long count(){
        return stockRepository.count();
    }

    public void deleteById(Long id) {
        stockRepository.deleteById(id);
    }

    public void deleteAllBatch() {
        stockRepository.deleteAllInBatch();
    }
    public ResponseEntity<?> updateStock(Stock newStock, Long id) {
        Stock updatedStock = stockRepository.findById(id)//
                .map(stock -> {
                    stock.setStockTicker(newStock.getStockTicker());
                    stock.setPrice(newStock.getPrice());
                    stock.setVolume(newStock.getVolume());
                    stock.setBuyOrSell(newStock.getBuyOrSell());
                    stock.setStatusCode(newStock.getStatusCode());
                    return stockRepository.save(stock);
                })
                .orElseGet(() -> {
                    newStock.setId(id);
                    return stockRepository.save(newStock);
                });
        EntityModel<Stock> entityModel = assembler.toModel(updatedStock);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())//
                .body(entityModel);
    }



}
