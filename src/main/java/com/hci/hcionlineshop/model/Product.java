package com.hci.hcionlineshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    public Long id;
    private String productName;
    private String manufacturer;
    private String SKU;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Address storageLocation;
    private Date dateOfManufacture;
    private boolean hasWarranty;

    public Product(String productName, String manufacturer, String sku, Category category, Address storageLocation, Date dateOfManufacture, boolean hasWarranty) {
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.SKU = sku;
        this.category = category;
        this.storageLocation = storageLocation;
        this.dateOfManufacture = dateOfManufacture;
        this.hasWarranty = hasWarranty;
    }
}
