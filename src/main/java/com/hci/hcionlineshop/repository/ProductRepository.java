package com.hci.hcionlineshop.repository;

import com.hci.hcionlineshop.model.ProductCategory;
import com.hci.hcionlineshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByProductCategory(ProductCategory productCategory);

    Product findProductByProductName(String name);


}
