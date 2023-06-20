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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String productName;
    private String price;
    private String manufacturer;
    private String SKU;
    @ManyToOne
    private ProductCategory productCategory;
    @ManyToOne
    private Address storageLocation;
    private Date dateOfManufacture;
    private boolean hasWarranty;

    public Product(String productName, String price, String manufacturer, String sku, ProductCategory productCategory, Address storageLocation, Date dateOfManufacture, boolean hasWarranty) {
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.SKU = sku;
        this.productCategory = productCategory;
        this.storageLocation = storageLocation;
        this.dateOfManufacture = dateOfManufacture;
        this.hasWarranty = hasWarranty;
    }
}
