package com.hci.hcionlineshop.service.impl;

import com.hci.hcionlineshop.model.Category;
import com.hci.hcionlineshop.model.exceptions.InvalidCategoryIdException;
import com.hci.hcionlineshop.repository.CategoryRepository;
import com.hci.hcionlineshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(InvalidCategoryIdException::new);
    }

    @Override
    public Category findByName(String name) {
        return this.categoryRepository.findByName(name);
    }
}
