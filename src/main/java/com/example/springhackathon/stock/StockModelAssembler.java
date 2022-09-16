package com.example.springhackathon.stock;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class StockModelAssembler implements RepresentationModelAssembler<Stock, EntityModel<Stock>> {

    @Override
    public EntityModel<Stock> toModel(Stock Stock) {

        return EntityModel.of(Stock, //
                linkTo(methodOn(StockController.class).findById(Stock.getId())).withSelfRel(),
                linkTo(methodOn(StockController.class).findAll()).withRel("Stocks"));
    }
}