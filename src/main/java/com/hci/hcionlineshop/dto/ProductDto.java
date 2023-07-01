package com.hci.hcionlineshop.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private long id;
    private int quantity;
    private long price;

    public ProductDto(long id, int quantity, long price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}
