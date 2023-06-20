package com.hci.hcionlineshop.service;

import com.hci.hcionlineshop.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listAllCategories();

    Category findById(Long id);
    Category findByName(String name);
}
