package com.hci.hcionlineshop.service;

import com.hci.hcionlineshop.model.Address;
import com.hci.hcionlineshop.model.Category;
import com.hci.hcionlineshop.model.Product;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();
    List<Product> listByCategory(String category);
    Product findById(Long id);

    Product findByName(String name);

    Product create(String productName, String manufacturer, String SKU, String category, Address storageLocation, Date dateOfManufacture, boolean hasWarranty);

    Product update(Long id, String productName, String manufacturer, String SKU, String category, Address storageLocation, Date dateOfManufacture, boolean hasWarranty);

    Product delete(Long id);
}
