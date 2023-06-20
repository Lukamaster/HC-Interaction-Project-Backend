package com.hci.hcionlineshop.service.impl;

import com.hci.hcionlineshop.model.Address;
import com.hci.hcionlineshop.model.ProductCategory;
import com.hci.hcionlineshop.model.Product;
import com.hci.hcionlineshop.model.exceptions.InvalidProductIdException;
import com.hci.hcionlineshop.repository.CategoryRepository;
import com.hci.hcionlineshop.repository.ProductRepository;
import com.hci.hcionlineshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> listByCategory(String category) {
        //return productRepository.findAll().stream().filter(product -> product.getCategory().getName().equals(category)).collect(Collectors.toList());
        ProductCategory productCategoryObj = categoryRepository.findByCategoryName(category);
        return productRepository.findProductByProductCategory(productCategoryObj);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(InvalidProductIdException::new);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findProductByProductName(name);
    }

    @Override
    public Product create(String productName, String price, String manufacturer, String SKU, String category, Address storageLocation, Date dateOfManufacture, boolean hasWarranty) {
        ProductCategory productCategoryObj = categoryRepository.findByCategoryName(category);
        Product newProduct = new Product(productName, price, manufacturer, SKU, productCategoryObj, storageLocation, dateOfManufacture, hasWarranty);
        return this.productRepository.save(newProduct);
    }

    @Override
    public Product update(Long id, String productName, String price, String manufacturer, String SKU, String category, Address storageLocation, Date dateOfManufacture, boolean hasWarranty) {
        ProductCategory productCategoryObj = categoryRepository.findByCategoryName(category);
        Product product = this.findById(id);
        product.setProductName(productName);
        product.setPrice(price);
        product.setManufacturer(manufacturer);
        product.setSKU(SKU);
        product.setProductCategory(productCategoryObj);
        product.setStorageLocation(storageLocation);
        product.setDateOfManufacture(dateOfManufacture);
        product.setHasWarranty(hasWarranty);
        return this.productRepository.save(product);
    }

    @Override
    public Product delete(Long id) {
        Product product = this.findById(id);
        this.productRepository.delete(product);
        return product;
    }
}
