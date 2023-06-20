package com.hci.hcionlineshop.service;

import com.hci.hcionlineshop.model.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> listAllCategories();

    ProductCategory findById(Long id);
    ProductCategory findByName(String name);
}
