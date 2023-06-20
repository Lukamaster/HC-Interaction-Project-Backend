package com.hci.hcionlineshop.repository;

import com.hci.hcionlineshop.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {

    public ProductCategory findByCategoryName(String name);
}
