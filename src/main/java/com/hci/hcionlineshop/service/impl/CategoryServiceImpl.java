package com.hci.hcionlineshop.service.impl;

import com.hci.hcionlineshop.model.ProductCategory;
import com.hci.hcionlineshop.model.exceptions.InvalidCategoryIdException;
import com.hci.hcionlineshop.repository.CategoryRepository;
import com.hci.hcionlineshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductCategory> listAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public ProductCategory findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(InvalidCategoryIdException::new);
    }

    @Override
    public ProductCategory findByName(String name) {
        return this.categoryRepository.findByCategoryName(name);
    }
}
