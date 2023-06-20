package com.hci.hcionlineshop.web;

import com.hci.hcionlineshop.model.Address;
import com.hci.hcionlineshop.model.Product;
import com.hci.hcionlineshop.repository.CategoryRepository;
import com.hci.hcionlineshop.repository.ProductRepository;
import com.hci.hcionlineshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductsController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductsController(ProductService productService, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> showProductsByCategory(@PathVariable String categoryName) {
        return ResponseEntity.ok(productService.listByCategory(categoryName));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> showAllProducts() {
        return  ResponseEntity.ok(productService.listAllProducts());
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("/add")
    public String addNewProduct(@RequestParam(required = false) String productName,
                                @RequestParam(required = false) String manufacturer,
                                @RequestParam(required = false) String SKU,
                                @RequestParam(required = false) String category,
                                @RequestParam(required = false) Address storageLocation,
                                @RequestParam(required = false) Date dateOfManufacture,
                                @RequestParam(required = false) boolean hasWarranty) {
        this.productService.create(productName, manufacturer, SKU, category, storageLocation, dateOfManufacture, hasWarranty);
        return "redirect:/all";
    }
    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable Long id,
                                @RequestParam(required = false) String productName,
                                @RequestParam(required = false) String manufacturer,
                                @RequestParam(required = false) String SKU,
                                @RequestParam(required = false) String category,
                                @RequestParam(required = false) Address storageLocation,
                                @RequestParam(required = false) Date dateOfManufacture,
                                @RequestParam(required = false) boolean hasWarranty) {
        this.productService.update(id, productName, manufacturer, SKU, category, storageLocation, dateOfManufacture, hasWarranty);
        return "redirect:/all";
    }

    @GetMapping("/search/{searchQuery}")
    public ResponseEntity<Product> searchProduct(@PathVariable String searchQuery) {
        return ResponseEntity.ok(productService.findByName(searchQuery));
    }



}
